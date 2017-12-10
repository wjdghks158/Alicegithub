package ac.kr.hansung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ac.kr.hansung.model.Division;
import ac.kr.hansung.model.Lecture;
import ac.kr.hansung.model.SemesterInfo;
import ac.kr.hansung.service.LectureService;

@Controller
public class HistoryController {
	
	@Autowired
	private LectureService lectureService;
	
	@RequestMapping("/history")
	public String showHistory(Model model, HttpServletRequest request) {
		List<Lecture> lectures = lectureService.getCurrent();
		System.out.println("������ ����"+lectures.size());
		
		Division division = new Division();
		
		
		 int year = Integer.parseInt(request.getParameter("year"));
		 int semester = Integer.parseInt(request.getParameter("semester"));
		 
		 for( int i=0; i<lectures.size(); i++) {
			 if(lectures.get(i).getYear() == year && lectures.get(i).getSemester() == semester) {
				 if(lectures.get(i).getDivision().equals("����")) {
					 division.setA(division.getA()+lectures.get(i).getGrades());
					 division.setSum(division.getSum()+lectures.get(i).getGrades());
					 
				 }
				 else if (lectures.get(i).getDivision().equals("���")){
					 division.setB(division.getB()+lectures.get(i).getGrades());
					 division.setSum(division.getSum()+lectures.get(i).getGrades());
				 }
				 else if (lectures.get(i).getDivision().equals("����")){
					 division.setC(division.getC()+lectures.get(i).getGrades());
					 division.setSum(division.getSum()+lectures.get(i).getGrades());
				 }
				 else if (lectures.get(i).getDivision().equals("�ٱ�A")){
					 division.setD(division.getD()+lectures.get(i).getGrades());
					 division.setSum(division.getSum()+lectures.get(i).getGrades());
				 }
				 else if (lectures.get(i).getDivision().equals("�ٱ�B")){
					 division.setE(division.getE()+lectures.get(i).getGrades());
					 division.setSum(division.getSum()+lectures.get(i).getGrades());
				 }
				 else if (lectures.get(i).getDivision().equals("����")){
					 division.setF(division.getF()+lectures.get(i).getGrades());
					 division.setSum(division.getSum()+lectures.get(i).getGrades());
				 }
				 else if (lectures.get(i).getDivision().equals("����")){
					 division.setG(division.getG()+lectures.get(i).getGrades());
					 division.setSum(division.getSum()+lectures.get(i).getGrades());
				 }
				 else if (lectures.get(i).getDivision().equals("����")){
					 division.setH(division.getH()+lectures.get(i).getGrades());
					 division.setSum(division.getSum()+lectures.get(i).getGrades());
				 }
				 else if (lectures.get(i).getDivision().equals("�ϱ�")){
					 division.setI(division.getI()+lectures.get(i).getGrades());
					 division.setSum(division.getSum()+lectures.get(i).getGrades());
				 }
				 else if (lectures.get(i).getDivision().equals("����")){
					 division.setJ(division.getJ()+lectures.get(i).getGrades());
					 division.setSum(division.getSum()+lectures.get(i).getGrades());
				 }
				 else if (lectures.get(i).getDivision().equals("����")){
					 division.setK(division.getK()+lectures.get(i).getGrades());
					 division.setSum(division.getSum()+lectures.get(i).getGrades());
				 }
				 }
			 
		 }
		 model.addAttribute("division", division);
			 

				return "history";		
	}

}
