package co.jeongeun.dbPrj.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import co.jeongeun.dbPrj.DataSource;

public class DevSerivceImpl extends DataSource{
	private PreparedStatement psmt;
	private ResultSet rs;
	
//	public List<DevVO> selectList(){
//		DevVO vo;
//		List<DevVO> list = new ArrayList<DevVO>();
//		
//		return list;
//	}
	
	public void selectList() {
		String sql = "select * from dev";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //select구문은 무조건 executeQuerty야
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("address"));
				System.out.println(rs.getInt("age"));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
