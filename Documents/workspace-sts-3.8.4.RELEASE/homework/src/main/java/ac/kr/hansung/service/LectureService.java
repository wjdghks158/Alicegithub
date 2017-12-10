package ac.kr.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.kr.hansung.dao.LectureDAO;
import ac.kr.hansung.model.Lecture;


@Service
public class LectureService {

	@Autowired
	private LectureDAO lectureDAO;
	
	public List<Lecture> getCurrent() {
		
		
		return lectureDAO.getOffers();
	}

	public void insert(Lecture lecture) {
		lectureDAO.insert(lecture); 
		
	}
	
	
}
