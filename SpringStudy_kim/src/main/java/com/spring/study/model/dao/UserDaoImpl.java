package com.spring.study.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.study.db.DBConnectionMgr;
import com.spring.study.model.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession session;
	
	private static final String NAME_SPACE = "com.spring.study.model.dao.UserDao.";
	
	@Override
	public UserDto getUser(String email) {
		/* 
		 * UserMapper.xml의 namespace를 가져온다.
		 * namespace.select중에 실행시킬 쿼리의 id값 / email이라는 매개변수 전달
		 * 매개변수는 mapper의 #{email}에 들어갈 매개변수 
		 * 매개변수는 한개밖에 전달이 안된다. String값 하나만 전달할경우는 무방함
		 * 앞으로는 객체로 전달한다.
		 * 만약 String email이 아닌 UserDto dto로 전달할 경우 -> mapper에서 parameterType를 지정해준다.
		 * 
		 * mapper의 namespace를 찾아가라 => "com.spring.study.model.dao.UserDao => namespace
		 */
		return session.selectOne(NAME_SPACE + "getUser", email);
		/*
		 * 이 결과의 return은 UserMapper.xml의 resultType에 맞게끔 결과가 들어간다.
		 * --------------------------------------------------------------------
		 * UserMapping에서 끝난 결과를 return한다.
		 */
	}

	@Override
	public int login(UserDto userDto) {
		return session.selectOne(NAME_SPACE + "login", userDto);
	}
	
	@Override
	public int idCheck(String user_email) {
		return session.selectOne(NAME_SPACE + "idCheck", user_email);
	}
	
	@Override
	public int signUp(UserDto userdto) {
		System.out.println(userdto);
		return session.insert(NAME_SPACE + "signUp", userdto);
	}
	
	/*
	private DBConnectionMgr pool = null;
 		
 	싱글톤은 객체 생성이 되지 않기 때문에 DBConnectionMgr은 @Autowired 할 수가 없다.
 	
	public UserDaoImpl() {
		pool = DBConnectionMgr.getInstance();
	}

	@Override
	public UserDto getUser(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		UserDto userDto = null;

		try {
			con = pool.getConnection();
			sql = "select * from user_mst where user_email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			rs.next();

			userDto = new UserDto();
			userDto.setEmail(rs.getString(1));
			userDto.setPassword(rs.getString(2));
			userDto.setName(rs.getString(3));
			userDto.setPhoneNumber(rs.getString(4));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}

		return userDto;
	}
	 */
}
