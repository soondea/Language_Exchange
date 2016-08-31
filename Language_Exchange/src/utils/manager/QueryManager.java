package utils.manager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import utils.ClassUtil;

public class QueryManager {

	private String queryFormat;
	
	private final String nullText = "null";
	private final String sqlErrMsg = "so what";
	private final String regexQuestionMark = "\\?";
	
	public QueryManager() {	}

	public QueryManager(String queryFormat) {
		this.queryFormat = queryFormat;
	}

	public String getQuery(Object... args) {

		String query = queryFormat;
		
		for (Object obj : args) {
			if (obj instanceof String) 
				query = query.replaceFirst(regexQuestionMark, "'" +obj+"'");				
			else 
				
				query = query.replaceFirst(regexQuestionMark, obj+"");
		}
		return query;
	}

	public void clear() {
		queryFormat = "";
	}

}
