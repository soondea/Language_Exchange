package dao.member;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import utils.manager.DatabaseManager;
import utils.manager.QueryManager;
import vo.member.Member;

public class MemberDao {

	private String memberCheckSql = "SELECT * FROM member WHERE member_email = ? ;";
	private String updatePassSql = "UPDATE member SET member_pw = ? WHERE member_email = ? ;";
	private String loginCheckSql = "SELECT * FROM member WHERE member_email = ? AND member_pw = ? ; ";
	private String updateInfoSql = "UPDATE member set memberName = ?, memberPw = ?, motherLanguage = ?,"
			+ " targetLanguage = ?, intro = ?, ability = ? WHERE member_email = ?;";

	public void InsertMember(Member dto) throws SQLException {
		String sql = "insert into member values(null,?,?,?,?,?,?)";
		QueryManager queryManager = new QueryManager(sql);

		String query = queryManager.getQuery(dto.getMemberName(),
				dto.getMemberPw(), dto.getMemberEmail(),
				dto.getMotherLanguage(), dto.getTargetLanguage(),
				dto.getIntro());

		DatabaseManager dbManager;
		try {
			dbManager = new DatabaseManager();
			dbManager.executeUpdate(query);
			dbManager.transactionCommit();
			dbManager.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void SelectMember(Member dto) throws SQLException {
		String sql2 = "select * from member";

		List<Member> memberList;
		try {
			DatabaseManager databaseManager;
			databaseManager = new DatabaseManager();
			memberList = databaseManager.getRecords(sql2, Member.class);

			databaseManager.transactionCommit();
			databaseManager.close();

			for (Member m : memberList) {
				m.getMemberId();
				m.getMemberName();
				m.getMemberPw();
				m.getMemberEmail();
				m.getMotherLanguage();
				m.getTargetLanguage();
				m.getIntro();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public Member selectById(String id) throws SQLException {

		QueryManager queryManager = new QueryManager(memberCheckSql);
		DatabaseManager databaseManager;
		try {
			databaseManager = new DatabaseManager();

			List<Member> memberList;
			memberList = databaseManager.getRecords(queryManager.getQuery(id),
					Member.class);

			databaseManager.close();
			if (memberList.size() > 0)
				return memberList.get(0);

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO: handle exception
		}
		return null;

	}
	//
	//	public void update(Member member) throws SQLException {
	//		QueryManager queryManager = new QueryManager(updateSql);
	//		DatabaseManager databaseManager;
	//		String sql = queryManager.getQuery(member.getMemberName(),
	//				member.getMemberPw(), member.getMotherLanguage(),
	//				member.getTargetLanguage(), member.getIntro(),
	//				member.getAbility());
	//
	//		try {
	//			databaseManager = new DatabaseManager();
	//
	//			databaseManager.executeUpdate(sql);
	//
	//			databaseManager.transactionCommit();
	//
	//			databaseManager.close();
	//
	//		} catch (NamingException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * 회원의 정보를 수정합니다.
	 * @param member 회원 객체
	 * @param updateType true - 모든 정보 수정 false - 비밀번호만 수정
	 * @throws SQLException
	 */
	public void update(Member member, boolean updateType) throws SQLException {
		QueryManager queryManager;
		DatabaseManager databaseManager;

		String sql = "";
		// true면 비번제외 모든정보 false면 비
		if (updateType) {
			queryManager = new QueryManager(updateInfoSql);
			sql = queryManager.getQuery(member.getMemberName(),
					member.getMemberPw(), member.getMotherLanguage(),
					member.getTargetLanguage(), member.getIntro());
		} else {
			queryManager = new QueryManager(updatePassSql);
			sql = queryManager.getQuery(member.getMemberPw(), member.getMemberEmail());
		}

		try {
			databaseManager = new DatabaseManager();

			databaseManager.executeUpdate(sql);
			databaseManager.transactionCommit();
			databaseManager.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void updateMemberInfomation(Member member, boolean updateType) throws SQLException {
		QueryManager queryManager;
		DatabaseManager databaseManager;

		String updateSqlHead = "UPDATE member set ";
		String memberNameSql = " member_name ='%s' ";
		String memberMotherLanguageSql = " mother_language = '%s' ";
		String memberTargetLanguageSql = " target_language = '%s' ";
		String memberIntroSql = " intro ='%s' ";
		String memberAbilitySql = " ability ='%s' ";
		String updateSqlTail = "WHERE member_email = ? ; ";
		String updateQuery = "";
		//회원정보가 몽땅 업데이트되는 것이 아닌 각각 업데이트되는 경우를 위하여 쿼리를 각각 분리시킴

		try{
			databaseManager = new DatabaseManager();
			Member member2 = (Member)databaseManager.getFirstRecord(memberCheckSql, Member.class);

			boolean trig = false;

			if(!member2.getMemberName().equals(member.getMemberName())){
				if(!member.getMemberName().equals("")){	
					updateSqlHead += String.format(memberNameSql , member.getMemberName());
					if(trig)
						updateInfoSql += " , ";
					trig = true;
				}
			} if (!member2.getMotherLanguage().equals(member.getMotherLanguage())){
				if(!member.getMotherLanguage().equals("")){
					updateSqlHead += String.format(memberNameSql , member.getMotherLanguage());
					if(trig)
						updateInfoSql += " , ";
					trig = true;
				}
			} if (!member2.getTargetLanguage().equals(member.getTargetLanguage())){
				if(!member.getTargetLanguage().equals("")){
					updateSqlHead += String.format(memberNameSql, member.getTargetLanguage());
					if(trig)
						updateInfoSql += " , ";
					trig = true;
				}
			} if(!member2.getIntro().equals(member.getIntro())) {
				if(!member.getIntro().equals("")){
					updateSqlHead += String.format(memberNameSql, member.getIntro());
					if(trig)
						updateInfoSql += " , ";
					trig = true;
				}
			}
			

			//.....

			updateSqlHead += updateSqlTail;


		}catch(Exception e){}





		String sql = "";
		// true면 비밀번호만 false면 모든 데이터
		if (updateType) {
			queryManager = new QueryManager(updatePassSql);
			sql = queryManager.getQuery(member.getMemberName(),
					member.getMemberPw(), member.getMotherLanguage(),
					member.getTargetLanguage(), member.getIntro());
		} else {
			queryManager = new QueryManager(updateInfoSql);
			sql = queryManager.getQuery(member.getMemberEmail(), member.getMemberPw());
		}

		try {
			databaseManager = new DatabaseManager();

			databaseManager.executeUpdate(sql);

			databaseManager.transactionCommit();

			databaseManager.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






	//	private void updateSimpleQuery(String sql) {
	//		DatabaseManager databaseManager;
	//		try {
	//			databaseManager = new DatabaseManager();
	//
	//			databaseManager.executeUpdate(sql);
	//
	//			databaseManager.transactionCommit();
	//
	//			databaseManager.close();
	//		} catch (NamingException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//	}

	public boolean login(String memberEmail, String memberPw) {

		// 쿼리 생성
		QueryManager queryManager = new QueryManager(memberCheckSql);
		String sql = queryManager.getQuery(memberEmail, memberPw);

		// DB메니저 생성
		DatabaseManager databaseManager;

		try {

			databaseManager = new DatabaseManager();

			boolean loginCheck = databaseManager.getExistRecord(sql);

			databaseManager.transactionCommit();

			databaseManager.close();

			return loginCheck;

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return false;
	}

}
