package ac.kr.hansung.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import ac.kr.hansung.model.Lecture;
import ac.kr.hansung.model.Offer;
import ac.kr.hansung.model.SemesterInfo;
import ac.kr.hansung.service.LectureService;

@Controller
public class OfferController {
	@Autowired
	private LectureService lectureService;
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Lecture> lectures = lectureService.getCurrent();
		System.out.println("사이즈 측정"+lectures.size());
		model.addAttribute("lectures", lectures);
		List<SemesterInfo> semesters = new ArrayList<SemesterInfo>();
		System.out.println("asd");
		//HashMap<String, Integer> grades = new HashMap<String, Integer>();
		semesters.clear();
		semesters.add(new SemesterInfo());
		int j = 0;
		for(int i=0; i<lectures.size(); i++) {
			
			int year= lectures.get(i).getYear();
			int semester = lectures.get(i).getSemester();
			int grades = lectures.get(i).getGrades();
			if(semesters.get(j).getYear()==0 &&
					semesters.get(j).getSemester()== 0) {
				semesters.get(j).setGrades(grades);
				semesters.get(j).setSemester(semester);
				semesters.get(j).setYear(year);
				
				
			}
			else if(semesters.get(j).getYear()==year &&
					semesters.get(j).getSemester()== semester) {
				
				semesters.get(j).setGrades(semesters.get(j).getGrades()+grades);
				
				
			}
			else {
				SemesterInfo semesterInfo = new SemesterInfo();
				semesterInfo.setGrades(grades);
				semesterInfo.setSemester(semester);
				semesterInfo.setYear(year);
				semesters.add(semesterInfo);
				j++;
				
			}
	
		}
		model.addAttribute("semesters", semesters);
		
		
		return "offers";
	}	
	
	//어플라이 화면
	@RequestMapping("/apply")
	public String createOffer(Model model) {
		model.addAttribute("offers", new Offer());
		System.out.println("apply돈다");
		
		return "apply";
	}
	
	//신청하는 컨트롤러
	@RequestMapping("/doapply")
	public String doApply(Model model, @Valid Lecture lecture, BindingResult result ) {
		model.addAttribute("offers", new Offer());
		System.out.println("신청하러 간다.");
		
		if(result.hasErrors()) {
			System.out.println("doapply 에러 남");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors ) {
				System.out.println(error.getDefaultMessage());
			}
			return "apply";
			
		}
		
		lectureService.insert(lecture);
		
		return "applyed";
	}
	
	
	
	
	
}
