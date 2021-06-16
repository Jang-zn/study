package com.common;

import java.sql.*;
import java.util.*;

import com.board.model.vo.Test;

public class TestDao {
	
	public TestDao() {
	
	}
	
	public List<Test> selectList(){
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		List<Test> list = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.3:1521:xe","kh","kh");
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM TEST";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Test t = new Test();
				t.setSeq(rs.getInt("SEQ"));
				t.setWriter(rs.getString("WRITER"));
				t.setTitle(rs.getString("TITLE"));
				t.setContent(rs.getString("CONTENT"));
				t.setRegdate(rs.getDate("REGDATE"));
				list.add(t);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
				return list;
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
