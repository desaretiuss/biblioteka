package org.ikubinfo.biblioteka.controller;

import org.ikubinfo.biblioteka.model.MemberModel;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmAction extends ActionSupport {

	private static final long serialVersionUID = 5404577608828957465L;

	private MemberModel memberModel = new MemberModel();
	/**
	 * URL param Kodi i verifikimit i derguar ne emailin e perdoruesit.
	 */
	private String confirmID;
	/**
	 * URL param Emaili prej te cilit
	 */
	private String emailID;

	public String execute() {

		String result = ERROR;

		if (memberModel.activateAccount(getConfirmID(), getEmailID())) {

			result = SUCCESS;
			addActionMessage(getText("success.confirm.activation.succeeded"));

		} else {

			addActionError(getText("error.confirm.activation.failed"));

		}

		return result;
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
