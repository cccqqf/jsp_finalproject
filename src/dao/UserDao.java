package dao;

import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.User;
import bean.forbidbean;

public class UserDao {
	public boolean create(User user) {
		Connection conn=DButil.getConnection();
		PreparedStatement pstmt =null;
		String sql="INSERT INTO userinfo (name,username,password,sex) VALUES(?,?,?,?)";
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2,user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getSex());
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
				user=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeJDBC(null, pstmt, conn);
		}
		return user;
		
	}
	
	public forbidbean queryforbid(String name) {
		Connection conn=DButil.getConnection();
		PreparedStatement pstmt=null;
		String sql="SELECT * FROM forbiddenlist WHERE name=?";
		ResultSet rs=null;
		forbidbean forbid=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				 String datestr=rs.getString(3);
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 
				 try {
					forbid=new forbidbean(rs.getString(2),sdf.parse(datestr));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeJDBC(null, pstmt, conn);
		}
		return forbid;
		
	}
	
	public boolean addForbidden(String name) {
		Connection conn=DButil.getConnection();
		PreparedStatement pstmt=null;
		String sql="INSERT INTO forbiddenlist (name) VALUES(?)";
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeJDBC(null, pstmt, conn);
		}
		return result==1;
		
	}
	public boolean removeForbidden(String name) {
		Connection conn=DButil.getConnection();
		PreparedStatement pstmt=null;
		String sql="DELETE FROM forbiddenlist WHERE name=?";
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeJDBC(null, pstmt, conn);
		}
		return result==1;
	}
	
}
