package handler.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.member.ChangeInformation;
import vo.member.Member;
import Exception.handler.InvalidPasswordException;
import Exception.handler.MemberNotFoundException;
import auth.service.User;

public class ChangeInformationHandler implements CommandHandler {

	private static final String FORM_VIEW = "/pwChangeForm.jsp";
	private ChangeInformation changeInfo = new ChangeInformation();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String email = (String)req.getSession().getAttribute("UserEmail");
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);


		String newName = req.getParameter("newName");
		String newMotherLanguage = req.getParameter("newMotherLanguage");
		String newTargetLanguage = req.getParameter("newTargetLanguage");
		String newIntro = req.getParameter("newIntro");
		String newAbility = req.getParameter("newAbility");

		
		//세션에 아이디를 입력 해놧겟죠
		//세션에서 이메일를 가져와요
	
		Member member = new Member();
	
		//member.setMemberEmail(이메일);
		
		member.setMemberEmail(email);
		member.setMemberName(newName);
		member.setMotherLanguage(newMotherLanguage);
		member.setTargetLanguage(newTargetLanguage);
		member.setIntro(newIntro);

				
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		ChangeInformation ca = new ChangeInformation();
		
		ca.changePassword(member, true);

		try {
			changeInfo.changePassword(member, true);
			return "/changePwdSuccess.jsp";
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}



