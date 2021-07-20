package com.kh.spring.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

//Mybatis에서 사용하는 typeHandler로 사용하려면
//interface 구현 필요함 : TypeHandler<T>
public class StringArrayTypeHandler implements TypeHandler<String[]>{

	//
	
	@Override
	public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		// setInt / setString할때 쓰려고 ps 매개변수가 있음
		// int i 는 index번호 String배열은 인덱스에 위치한 ?값에 넣어줄 값 parameter
		if(parameter!=null) {
			ps.setString(i, String.join(",", parameter));
		}else {
			ps.setString(i, "");
		}
	}

	@Override
	public String[] getResult(ResultSet rs, String columnName) throws SQLException {
		return rs.getString(columnName).split(",");
	}

	@Override
	public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
		return rs.getString(columnIndex).split(",");
	}

	@Override
	public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
		//db에 저장되어있는 함수를 jdbc에서 호출해서 실행시키고 결과값을 반환할 때 사용함
		return cs.getString(columnIndex).split(",");
	}
	
	
	
}
