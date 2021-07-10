package com.narpavi.finance.karma.util;

public class StringUtils {
	
	public static boolean isBlank(String value) {
		
		if (null != value && value.trim().length() > 0) {
			return false;
		}
		return true;
	}
}
