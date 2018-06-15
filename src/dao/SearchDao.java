package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Queue;

import bean.Message;
import util.DButil;

public class SearchDao {
	public void Search(Queue<Message> msgqueue,String submessage) {
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
				if(message.getName().indexOf(submessage)!=-1) {
					msgqueue.offer(message);
				}else if(message.getSay().indexOf(submessage)!=-1) {
					msgqueue.offer(message);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeJDBC(null, pstmt, conn);
		}
	}
}
