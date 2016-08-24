package Manager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import Utils.ClassUtil;
import Utils.DatabaseUtil;

/**
 * DB 커넥션 및 명령 수행
 * <pre>
 * <b>History:</b>
 *    yu, 버전점 , 2016.08.22 초기작성
 *    yu  2016.08.24 DB유틸 사용토록 변경
 * </pre>
 *
 * @author yu
 * @version 버전관리는 팀장님이 만들어 주셈여  생성
 */
public class DatabaseManager {

	/**
	 * DB 커넥션 객체
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 *    yu  2016.08.24 DB유틸 사용토록 변경
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여  생성
	 */
	private Connection conn = null;


	/**
	 * Construct - DB커넥션 생성
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 *    yu  2016.08.22 DB유틸 사용토록 변경
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여  생성
	 * @throws NamingException
	 * @throws SQLException
	 */
	public DatabaseManager() throws NamingException, SQLException {
		
		conn = DatabaseUtil.getConnection();
	}

	/**
	 * 커넥션 클로즈
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여  생성 
	 * @throws SQLException
	 */
	public void close() throws SQLException {

		conn.close();
	}

	/**
	 * Insert, Update ,Delete 등  executeUpdate 쿼리 동작 실행
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여  생성
	 * @param sql DB동작 쿼리
	 * @return 동작 실행 후 성공 카운트

	 * @throws SQLException
	 */
	public int insertData(String sql) throws SQLException {

		Statement stmt = conn.createStatement();
		
		int sucCount = stmt.executeUpdate(sql);
		
		stmt.close();
		
		return sucCount;
	}


	/**
	 * sql과 클래스를 이용하여 클래스에 맵핑하여 로딩한다.
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여  생성
	 * @param sql DB동작 쿼리
	 * @param cls 매핑 클래스
	 * @return DB수행 결과를 클래스와 매핑하여 리스트 형태로 반환
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("rawtypes")
	public List getRecords(String sql, Class<?> cls)
			throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		List<Object> list = new ArrayList<Object>();

		Map<Field, Method> setterMap = ClassUtil.getSetterMethodMap(cls);

		while (rs.next()) {
			Object obj = cls.newInstance();
			list.add(obj);

			for (Field field : ClassUtil.getUsefullFields(cls)) {
				Method m = setterMap.get(field);

				m.invoke(obj, getValue(field.getType(), field.getName(), rs));
			}
		}

		stmt.close();

		return list;
	}
	
	/**
	 * 쿼리 수행 결과 반환이 있을 경우 true
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여  생성 
	 * @param sql DB 동작 쿼리
	 * @return 레코드 Exist 여부
	 * @throws SQLException
	 */
	public boolean getExistRecord(String sql) throws SQLException{
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		stmt.close();
		
		if(rs.next())
			return true;
		return false;
	}

	/**
	 * 클래스의 타입, 필드 명으로 ResultSet의 데이타 반환 
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여  생성
	 * @param type 필드 타입
	 * @param fieldName 필드명
	 * @param ResultSet
	 * @return ResultSet 데이타
	 * @throws SQLException
	 */
	private Object getValue(Type type, String fieldName, ResultSet rs) throws SQLException {

		Object result = null;

		// String Format
		if (type.equals(String.class)) {
			result = rs.getString(fieldName);
		}
		// Boolean Format
		else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
			result = rs.getBoolean(fieldName);
		} else if (type.equals(Byte.class)) {
			result = rs.getByte(fieldName);
		} else if (type.equals(Short.class)) {
			result = rs.getShort(fieldName);
		} else if (type.equals(Integer.class)) {
			result = rs.getInt(fieldName);
		} else if (type.equals(Long.class)) {
			result = rs.getLong(fieldName);
		} else if (type.equals(Float.class)) {
			result = rs.getFloat(fieldName);
		} else if (type.equals(Double.class)) {
			result = rs.getDouble(fieldName);
		} else if (type.equals(BigDecimal.class)) {
			result = rs.getBigDecimal(fieldName);
		}

		return result;
	}
}