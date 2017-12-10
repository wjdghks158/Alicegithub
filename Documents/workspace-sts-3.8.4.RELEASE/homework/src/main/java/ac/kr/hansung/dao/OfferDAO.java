package ac.kr.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ac.kr.hansung.model.Offer;


@Repository
public class OfferDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from users";
				return jdbcTemplate.queryForObject(sqlStatement, Integer.class);			
	}
	
	//��ȸ �ϴ� �޼ҵ� query and return a single object
	public Offer getOffer(String userID) {
		String sqlStatement = "select * from users where userID=?";
		
		//RowMapper�� ������  �������̽��� ���� mapRow()�� �ִ�. DB���� ���� ��� �� ���� ��ü���ٰ� ������ ���ִ� ����
		return jdbcTemplate.queryForObject(sqlStatement,new Object[]{userID}, new RowMapper<Offer>(){

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();
				
				offer.setId(rs.getString("userID"));
				offer.setPassword(rs.getString("userPassword"));
				offer.setEmail(rs.getString("userEmail"));
				offer.setName(rs.getString("userName"));
				
				
				return offer;
			}
		});
	}
	
	//��ȸ �ϴ� �޼ҵ� query and return a single object
	public List<Offer> getOffers() {
		String sqlStatement = "select * from users";
		
		//RowMapper�� ������  �������̽��� ���� mapRow()�� �ִ�. DB���� ���� ��� �� ���� ��ü���ٰ� ������ ���ִ� ����
		return jdbcTemplate.query(sqlStatement, 
				new RowMapper<Offer>(){
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();
				
				offer.setId(rs.getString("userID"));
				offer.setPassword(rs.getString("userPassword"));
				offer.setEmail(rs.getString("userEmail"));
				offer.setName(rs.getString("userName"));
				return offer;
			}
		});
	}
	
	public boolean insert(Offer offer) {
		 String userID = offer.getId();
		 String userPassword = offer.getPassword();
		 String userName = offer.getName();
		 String userEmail = offer.getEmail();
		 
		 String sqlStatement = "insert into users (userID, userPassword, userName, userEmail) values (?, ?, ?, ?)";
		 
		 
		 
		return (jdbcTemplate.update(sqlStatement, new Object[]{userID, userPassword, userName, userEmail}) ==1); 
	}
	
	public boolean update(Offer offer) {
		 String userID = offer.getId();
		 String userPassword = offer.getPassword();
		 String userName = offer.getName();
		 String userEmail = offer.getEmail();
		 
		 String sqlStatement = "update users set userPassword=?, userName=?, userEmail=? where userId=?";
		 
		 
		 
		return (jdbcTemplate.update(sqlStatement, new Object[]{userID, userPassword, userName, userEmail}) ==1); 
	}
	
	
	public boolean delete(int userID) {
		
		 String sqlStatement = "delete from offers where userID=?";
		return (jdbcTemplate.update(sqlStatement, new Object[]{userID}) ==1); 
	}
	
	
	
	

}

