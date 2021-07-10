package com.narpavi.finance.karma.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.google.gson.Gson;
import com.narpavi.finance.karma.model.CustomerDetails;

public class CustomerDetailsTypeHandler implements TypeHandler<CustomerDetails>{
	
	@Override
	public void setParameter(PreparedStatement ps, int i, CustomerDetails parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, serialize(parameter));
	}
	@Override
	public CustomerDetails getResult(ResultSet cs, String columnName) throws SQLException {
		return deserialize(cs.getString(columnName));
	}
	@Override
	public CustomerDetails getResult(ResultSet cs, int columnIndex) throws SQLException {
		return deserialize(cs.getString(columnIndex));
	}
	@Override
	public CustomerDetails getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return deserialize(cs.getString(columnIndex));
	}
	
	private String serialize(CustomerDetails customerDetails) {
		Gson gson = new Gson();
		return gson.toJson(customerDetails);
	}
	
	private CustomerDetails deserialize(String value) {
		Gson gson = new Gson();
		return gson.fromJson(value, CustomerDetails.class);
	}

}
