package member.service;

import java.util.Map;

public class JoinRequest {
	private String memberName;
	private String memberPw;
	private String memberEmail;
	private String motherLanguage;
	private String intro;
	private String ability;
	private String mempasswordCheck;
	private String targetLanguage;
	
	
	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMotherLanguage() {
		return motherLanguage;
	}

	public void setMotherLanguage(String motherLanguage) {
		this.motherLanguage = motherLanguage;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getMempasswordCheck() {
		return mempasswordCheck;
	}

	public void setMempasswordCheck(String passwordCheck) {
		this.mempasswordCheck = passwordCheck;
	}

	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, memberName, "memberName");
		checkEmpty(errors, memberPw, "memberPw");
		checkEmpty(errors, memberEmail, "memberEmail");
		checkEmpty(errors, motherLanguage, "motherLanguage");
		checkEmpty(errors, intro, "intro");
		checkEmpty(errors, ability, "ability");		
		checkEmpty(errors, mempasswordCheck, "passwordCheck");
		if (!errors.containsKey("passwordCheck")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}

	private boolean isPasswordEqualToConfirm() {
		// TODO Auto-generated method stub
		return memberPw != null && memberPw.equals(mempasswordCheck);
	}

	private void checkEmpty(Map<String, Boolean> errors, String value,
			String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
}
