package Utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

/**
 * DB커넥션 생성
 * 
 * <pre>
 * <b>History:</b>
 *    yu, 버전점 , 2016.08.24 초기작성
 * </pre>
 *
 * @author yu
 * @version 버전관리는 팀장님이 만들어 주셈여 생성
 */
public class DatabaseUtil {
	/**
	 * Construct - 객체 생성 불가
	 * 
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.24 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여 생성
	 */
	private DatabaseUtil() {
	}

	/**
	 * DB 커넥션을 생성
	 * 
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.24 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여 생성
	 * @return DB 커넥션
	 * @throws NamingException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws NamingException, SQLException {
		Connection conn;

		Context initCtx;
		initCtx = new InitialContext();

		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/shinguprojectdb");

		conn = dataSource.getConnection();

		return conn;
	}
}
