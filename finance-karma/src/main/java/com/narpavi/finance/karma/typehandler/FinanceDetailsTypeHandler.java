package com.narpavi.finance.karma.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.google.gson.Gson;
import com.narpavi.finance.karma.model.FinanceDetails;

public class FinanceDetailsTypeHandler implements TypeHandler<FinanceDetails>{
	
	@Override
	public void setParameter(PreparedStatement ps, int i, FinanceDetails parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, serialize(parameter));
	}
	@Override
	public FinanceDetails getResult(ResultSet cs, String columnName) throws SQLException {
		return deserialize(cs.getString(columnName));
	}
	@Override
	public FinanceDetails getResult(ResultSet cs, int columnIndex) throws SQLException {
		return deserialize(cs.getString(columnIndex));
	}
	@Override
	public FinanceDetails getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return deserialize(cs.getString(columnIndex));
	}
	
	private String serialize(FinanceDetails financeDetails) {
		Gson gson = new Gson();
		return gson.toJson(financeDetails);
	}
	
	private FinanceDetails deserialize(String value) {
		Gson gson = new Gson();
		return gson.fromJson(value, FinanceDetails.class);
	}

}
