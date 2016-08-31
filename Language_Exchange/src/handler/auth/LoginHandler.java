package handler.auth;

import handler.command.CommandHandler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.handler.LoginFailException;
import auth.service.LoginService;

public class LoginHandler implements CommandHandler {

	private static final String FORM_VIEW = "/loginForm.jsp";
	private LoginService loginService = new LoginService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String memberEmail = trim(req.getParameter("email"));
		String memberPw = trim(req.getParameter("password"));
		
		Map<String, Boolean>errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if(memberEmail == null || memberEmail.isEmpty())
			errors.put("email", Boolean.TRUE);
		if(memberPw == null || memberPw.isEmpty())
			errors.put("password", Boolean.TRUE);
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			boolean user = LoginService.login(memberEmail, memberPw);
			
			if(user){
				req.getSession().setAttribute("UserEmail", memberEmail);
				res.sendRedirect(req.getContextPath() + "/loginMainPage.jsp");
			}
			else{
				return FORM_VIEW;
			}
						
			
			return null;
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
		private String trim(String str) {
			return str == null ? null : str.trim();
		}
}
