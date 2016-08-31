package member.service;

import java.sql.SQLException;

import Exception.handler.DuplicateIdException;
import utils.manager.DatabaseManager;
import vo.member.Member;
import dao.member.MemberDao;

public class JoinService {

	DatabaseManager databaseManager;

	private MemberDao memberDao = new MemberDao();

	public void join(JoinRequest joinReq) {
		try {

			Member member = memberDao.selectById(joinReq.getMemberEmail());
			if (member != null) {
				throw new DuplicateIdException();
			}
			memberDao.InsertMember(new Member(1 , joinReq
					.getMemberName(), joinReq.getMemberPw(), joinReq
					.getMemberEmail(), joinReq.getMotherLanguage(), joinReq
					.getTargetLanguage(), joinReq.getIntro()));

		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {

		}
	}
}
