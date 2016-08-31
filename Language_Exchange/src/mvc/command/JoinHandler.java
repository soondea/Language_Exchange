package mvc.command;

import handler.command.CommandHandler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.handler.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;

public class JoinHandler implements CommandHandler {

	private static final String FORM_VIEW = "/joinSuccess.jsp";
	private JoinService joinService = new JoinService();


	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;

	}
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {

		String motherLanguage = req.getParameter("choice");
		
		
		JoinRequest joinReq = new JoinRequest();
		joinReq.setMemberName(req.getParameter("name"));
		joinReq.setMemberEmail(req.getParameter("email"));
		joinReq.setMemberPw(req.getParameter("password"));
		joinReq.setMempasswordCheck(req.getParameter("passwordcheck"));
		joinReq.setMotherLanguage(motherLanguage);
		joinReq.setIntro(req.getParameter("intro"));

		
		if(!motherLanguage.equals("")){
			if(motherLanguage.equals("korea")){
				motherLanguage = "japan";
				joinReq.setTargetLanguage(motherLanguage);
				motherLanguage = null;

			}
			if(motherLanguage.equals("japan")){
				motherLanguage = "korea";
				joinReq.setTargetLanguage(motherLanguage);
				motherLanguage = null;

			}
		}


		try {
			joinService.join(joinReq);
			return "/joinSuccess.jsp";
		} catch (DuplicateIdException e) {
			return FORM_VIEW;
		}
	}

}
