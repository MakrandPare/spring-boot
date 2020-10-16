package org.osi.swinerton.dto;

import java.io.Serializable;

public class SwinertonRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String p_wd_employee_type;
	private String p_wd_job_profile;
	private String p_wd_job_group;
	private String p_wd_unionized;
	private String p_wd_union_name;

	public String getP_wd_employee_type() {
		return p_wd_employee_type;
	}

	public void setP_wd_employee_type(String p_wd_employee_type) {
		this.p_wd_employee_type = p_wd_employee_type;
	}

	public String getP_wd_job_profile() {
		return p_wd_job_profile;
	}

	public void setP_wd_job_profile(String p_wd_job_profile) {
		this.p_wd_job_profile = p_wd_job_profile;
	}

	public String getP_wd_job_group() {
		return p_wd_job_group;
	}

	public void setP_wd_job_group(String p_wd_job_group) {
		this.p_wd_job_group = p_wd_job_group;
	}

	public String getP_wd_unionized() {
		return p_wd_unionized;
	}

	public void setP_wd_unionized(String p_wd_unionized) {
		this.p_wd_unionized = p_wd_unionized;
	}

	public String getP_wd_union_name() {
		return p_wd_union_name;
	}

	public void setP_wd_union_name(String p_wd_union_name) {
		this.p_wd_union_name = p_wd_union_name;
	}

	@Override
	public String toString() {
		return "SwinertonRequestDTO [p_wd_employee_type=" + p_wd_employee_type + ", p_wd_job_profile="
				+ p_wd_job_profile + ", p_wd_job_group=" + p_wd_job_group + ", p_wd_unionized=" + p_wd_unionized
				+ ", p_wd_union_name=" + p_wd_union_name + "]";
	}

}
