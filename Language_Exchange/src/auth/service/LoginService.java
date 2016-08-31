package auth.service;

import dao.member.MemberDao;

public class LoginService {

	private static MemberDao memberDao = new MemberDao();

	public static boolean login(String memberEmail, String memberPw) {

		return memberDao.login(memberEmail, memberPw);

	}

	public static User memberDao(String memberEmail, String memberPw) {
		// TODO Auto-generated method stub
		return null;
	}

}
