package handler.command;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Alert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.member.ChangeInformation;
import vo.member.Member;
import Exception.handler.InvalidPasswordException;
import Exception.handler.MemberNotFoundException;
import auth.service.User;

public class ChangePasswordHandler implements CommandHandler {

	private static final String FORM_VIEW = "/pwChangeForm.jsp";
	private ChangeInformation changePass = new ChangeInformation();

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
		Member member = new Member();

		String curPwd = req.getParameter("password");
		String newPwd = req.getParameter("newPassword");
		String newPwdCkd = req.getParameter("newPasswordCheck");

		if(!curPwd.equals(newPwd)){
			if(newPwd.equals(newPwdCkd)){
				try {
					member.setMemberEmail(email);
					member.setMemberPw(newPwd);
					changePass.changePassword(member, false);
					return "/changePwdSuccess.jsp";
				} catch (InvalidPasswordException e) {
					return FORM_VIEW;
				} catch (MemberNotFoundException e) {
					return FORM_VIEW;
				}
			}else{
				return "/alert2.jsp";
			}
		}else{
			return "/alert.jsp";
		}
		

	}



}
