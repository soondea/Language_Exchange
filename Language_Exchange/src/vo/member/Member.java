package vo.member;

public class Member {

	private int memberId;
	private String memberName;
	private String memberPw;
	private String memberEmail;
	private String motherLanguage;
	private String targetLanguage;
	private String intro;



	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int memberId, String memberName, String memberPw,
			String memberEmail, String motherLanguage, String targetLanguage,
			String intro) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPw = memberPw;
		this.memberEmail = memberEmail;
		this.motherLanguage = motherLanguage;
		this.targetLanguage = targetLanguage;
		this.intro = intro;
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
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

	//암호 맞는지 확인하는 메서드
	public boolean matchPassword(String pwd) {
		return memberPw.equals(pwd);
	}
	//암호변경 메서드
	public void changePassword(String newPwd) {
		this.memberPw = newPwd;
	}
}