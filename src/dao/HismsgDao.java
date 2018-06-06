package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Queue;

import bean.Message;
import util.DButil;

public class HismsgDao {
	public boolean create(Message message) {
		Connection conn=DButil.getConnection();
		PreparedStatement pstmt=null;
		String sql="INSERT INTO hismsg (username,message) VALUES(?,?)";
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, message.getUsername());
			pstmt.setString(2, message.getSay());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeJDBC(null, pstmt, conn);
		}
		return result==1;
	}
	
	public void loadhismsg(Queue<Message> msgqueue) {
		Connection conn=DButil.getConnection();
		PreparedStatement pstmt=null;
		String sql="SELECT name,message FROM hismsg h,userinfo u WHERE h.username=u.username";
		ResultSet rs=null;
		Message message=null;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				message=new Message();
				message.setName(rs.getString(1));
				message.setSay(rs.getString(2));
				msgqueue.offer(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeJDBC(null, pstmt, conn);
		}
		
		
	}
}
