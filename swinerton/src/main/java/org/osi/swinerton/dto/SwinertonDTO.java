package org.osi.swinerton.dto;

import java.io.Serializable;

public class SwinertonDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String jobTitleUuid;
	private String jobTitle;
	private String status;
	private String isUser;
	private String isAssignable;
	private String permission;
	private String permissionLevelId;
	private String canReceiveSms;
	private String canReceiveEmail;
	private String noInvite;
	private String success;
	private String message;

	public String getJobTitleUuid() {
		return jobTitleUuid;
	}

	public void setJobTitleUuid(String jobTitleUuid) {
		this.jobTitleUuid = jobTitleUuid;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsUser() {
		return isUser;
	}

	public void setIsUser(String isUser) {
		this.isUser = isUser;
	}

	public String getIsAssignable() {
		return isAssignable;
	}

	public void setIsAssignable(String isAssignable) {
		this.isAssignable = isAssignable;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getPermissionLevelId() {
		return permissionLevelId;
	}

	public void setPermissionLevelId(String permissionLevelId) {
		this.permissionLevelId = permissionLevelId;
	}

	public String getCanReceiveSms() {
		return canReceiveSms;
	}

	public void setCanReceiveSms(String canReceiveSms) {
		this.canReceiveSms = canReceiveSms;
	}

	public String getCanReceiveEmail() {
		return canReceiveEmail;
	}

	public void setCanReceiveEmail(String canReceiveEmail) {
		this.canReceiveEmail = canReceiveEmail;
	}

	public String getNoInvite() {
		return noInvite;
	}

	public void setNoInvite(String noInvite) {
		this.noInvite = noInvite;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
