package Manager;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import Utils.ClassUtil;

public class DatabaseManager {
	Connection conn = null;	
	//Construct
	public DatabaseManager(){	
        try {
            Context initCtx = new InitialContext();
            //Context envCtx = (Context)initCtx.lookup("java:comp/env");
            //DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mysql");

//			Context context = new InitialContext();
//
//			DataSource source = (DataSource) context.lookup("java:comp/env/jdbc/shinguprojectdb");
            
            
            Context envCtx = (Context)initCtx.lookup("java:comp/env");
            DataSource dataSource = (DataSource)envCtx.lookup("jdbc/shinguprojectdb");
			
            conn = dataSource.getConnection();
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	
	//sql과 클래스를 이용하여 클래스에 맵핑하여 로딩한다
	@SuppressWarnings("rawtypes")
	public List getRecords(String sql, Class<?> cls) throws SQLException, InstantiationException, IllegalAccessException{
		Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    List<Object> list = new ArrayList<Object>();

	    while(rs.next()) {
	    	Object obj=cls.newInstance();
	    	list.add(obj);
	    	for(Field field : ClassUtil.getUsefullFields(cls)){
	    		field.set(obj, getValue(field.getType(),field.getName(), rs));
	    	}
	    	
	    }
	    return list;
	}

	
	
	private Object getValue(Type type, String fieldName,ResultSet rs) throws SQLException{
		
		Object result = null;
		
		//String Format
		if(type.equals(String.class)){
			result = rs.getString(fieldName);
		}
		//Boolean Format
		else if(type.equals(Boolean.class) || type.equals(boolean.class)){
			result = rs.getBoolean(fieldName);
		}else if(type.equals(Byte.class)){
			result = rs.getByte(fieldName);
		}
		else if(type.equals(Short.class)){
			result = rs.getShort(fieldName);
		}
		else if(type.equals(Integer.class)){
			result = rs.getInt(fieldName);
		}
		else if(type.equals(Long.class)){
			result = rs.getLong(fieldName);
		}
		else if(type.equals(Float.class)){
			result = rs.getFloat(fieldName);
		}
		else if(type.equals(Double.class)){
			result = rs.getDouble(fieldName);
		}
		else if(type.equals(BigDecimal.class)){
			result = rs.getBigDecimal(fieldName);
		}
		
		return result;
	}
}