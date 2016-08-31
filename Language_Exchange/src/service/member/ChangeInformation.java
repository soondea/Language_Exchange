package service.member;

import java.sql.SQLException;

import utils.manager.DatabaseManager;
import utils.manager.QueryManager;
import vo.member.Member;
import dao.member.MemberDao;

public class ChangeInformation {

	private MemberDao memberDao = new MemberDao();
	
	public void changePassword(Member member, boolean updateType) {

		try {
			memberDao.update(member, updateType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
