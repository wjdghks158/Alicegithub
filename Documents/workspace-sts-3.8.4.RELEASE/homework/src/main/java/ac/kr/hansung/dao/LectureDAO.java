package ac.kr.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ac.kr.hansung.model.Lecture;


@Repository
public class LectureDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from tb_lecture";
				return jdbcTemplate.queryForObject(sqlStatement, Integer.class);			
	}
	
	//조회 하는 메소드 query and return a single object
	public Lecture getLecture(String code) {
		String sqlStatement = "select * from tb_lecture where code=?";
		
		//RowMapper의 역할은  인터페이스에 보면 mapRow()가 있다. DB에서 읽은 결과 셋 실제 객체에다가 매핑을 해주는 역할
		return jdbcTemplate.queryForObject(sqlStatement,new Object[]{code}, new RowMapper<Lecture>(){

			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Lecture lecture = new Lecture();
				
				
				lecture.setCode(rs.getString("code"));
				lecture.setCourse(rs.getString("course"));
				lecture.setDivision(rs.getString("division"));
				lecture.setGrades(rs.getInt("grades"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setYear(rs.getInt("year"));
				
				return lecture;
			}
		});
	}
	
	//조회 하는 메소드 query and return a single object
	public List<Lecture> getOffers() {
		String sqlStatement = "select * from tb_lecture order by year asc, semester asc";
		
		//RowMapper의 역할은  인터페이스에 보면 mapRow()가 있다. DB에서 읽은 결과 셋 실제 객체에다가 매핑을 해주는 역할
		return jdbcTemplate.query(sqlStatement, 
				new RowMapper<Lecture>(){
			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Lecture lecture = new Lecture();
				
				lecture.setCode(rs.getString("code"));
				lecture.setCourse(rs.getString("course"));
				lecture.setDivision(rs.getString("division"));
				lecture.setGrades(rs.getInt("grades"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setYear(rs.getInt("year"));
				
				return lecture;
			}
		});
	}
	
	public boolean insert(Lecture lecture) {
		 int year = lecture.getYear();
		 int semester = lecture.getSemester();
		 String code = lecture.getCode();
		 String course = lecture.getCourse();
		 String division = lecture.getDivision();
		 int grades = lecture.getGrades();
		 
		 String sqlStatement = "insert into tb_lecture (year, semester, code, course, division, grades) values (?, ?, ?, ?, ?, ?)";
		 
		 
		 
		return (jdbcTemplate.update(sqlStatement, new Object[]{year, semester, code, course, division, grades}) ==1); 
	}
	
	public boolean update(Lecture lecture) {
		
		 int year = lecture.getYear();
		 int semester = lecture.getSemester();
		 String code = lecture.getCode();
		 String course = lecture.getCourse();
		 String division = lecture.getDivision();
		 int grades = lecture.getGrades();
		 String sqlStatement = "update tb_lecture set year=?, semester=?, code=? course=?, division=?, grades=? where code=? ";
		 
		 
		 
		return (jdbcTemplate.update(sqlStatement, new Object[]{year, semester, code, course, division, grades}) ==1); 
	}
	
	
	public boolean delete(String code) {
		
		 String sqlStatement = "delete from tb_lecture where code=?";
		return (jdbcTemplate.update(sqlStatement, new Object[]{code}) ==1); 
	}
	
	
	
	

}