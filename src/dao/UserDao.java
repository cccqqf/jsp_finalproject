package dao;

import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class UserDao {
	public boolean create(User user) {
		Connection conn=DButil.getConnection();
		PreparedStatement pstmt =null;
		String sql="INSERT INTO userinfo (name,username,password) VALUES(?,?,?)";
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2,user.getUsername());
			pstmt.setString(3, user.getPassword());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeJDBC(null, pstmt, conn);
		}
		return result==1;
	}
	
	public User query(String username) {
		Connection conn=DButil.getConnection();
		PreparedStatement pstmt=null;
		String sql="SELECT * FROM userinfo WHERE username=?";
		ResultSet rs=null;
		User user=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				user=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeJDBC(null, pstmt, conn);
		}
		return user;
		
	}
}
