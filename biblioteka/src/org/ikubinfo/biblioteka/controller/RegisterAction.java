package org.ikubinfo.biblioteka.controller;

import org.ikubinfo.biblioteka.model.Member;
import org.ikubinfo.biblioteka.model.MemberModel;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 4112458247060327922L;

	private Member memberBean;
	private MemberModel memberModel = new MemberModel();
	/**
	 * URL param Kodi i verifikimit i derguar ne emailin e perdoruesit.
	 */
	private String confirmID;
	/**
	 * URL param Emaili prej te cilit
	 */
	private String emailID;

	/**
	 * Shton te dhenat e nje anetari te ri ne databaze pasi heton nese emaili
	 * eshte perdorur me pare apo jo. Njofton user-in nepermjet email-it.
	 */
	@Override
	public String execute() {

		String result = ERROR;

		if (memberModel.doesEmailExists(memberBean.getEmail())) {

			addActionError(getText("error.registration.email.exists"));

		} else if (!(memberModel.addNewMember(memberBean))) {

			addActionError(getText("error.registration.generic"));

		} else {
			addActionMessage(getText("success.registration"));
			result = SUCCESS;
		}

		return result;

	}


	public Member getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(Member memberBean) {
		this.memberBean = memberBean;
	}

	public MemberModel getMemberModel() {
		return memberModel;
	}

	public void setMemberModel(MemberModel memberModel) {
		this.memberModel = memberModel;
	}

	public String getConfirmID() {
		return confirmID;
	}

	public void setConfirmID(String confirmID) {
		this.confirmID = confirmID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

}
