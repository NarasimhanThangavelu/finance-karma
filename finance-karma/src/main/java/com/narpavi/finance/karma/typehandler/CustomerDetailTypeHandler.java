package com.narpavi.finance.karma.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.google.gson.Gson;
import com.narpavi.finance.karma.model.CustomerDetail;

public class CustomerDetailTypeHandler implements TypeHandler<CustomerDetail>{
	
	@Override
	public void setParameter(PreparedStatement ps, int i, CustomerDetail parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, serialize(parameter));
	}
	@Override
	public CustomerDetail getResult(ResultSet cs, String columnName) throws SQLException {
		return deserialize(cs.getString(columnName));
	}
	@Override
	public CustomerDetail getResult(ResultSet cs, int columnIndex) throws SQLException {
		return deserialize(cs.getString(columnIndex));
	}
	@Override
	public CustomerDetail getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return deserialize(cs.getString(columnIndex));
	}
	
	private String serialize(CustomerDetail customerDetail) {
		Gson gson = new Gson();
		return gson.toJson(customerDetail);
	}
	
	private CustomerDetail deserialize(String value) {
		Gson gson = new Gson();
		return gson.fromJson(value, CustomerDetail.class);
	}

}
