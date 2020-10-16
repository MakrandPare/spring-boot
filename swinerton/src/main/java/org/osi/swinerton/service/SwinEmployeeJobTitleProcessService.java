package org.osi.swinerton.service;

import org.osi.swinerton.exception.SwinException;

public interface SwinEmployeeJobTitleProcessService {
	public String getJobDetails(String p_wd_employee_type, String p_wd_job_profile, String p_wd_job_group,
			String p_wd_unionized, String p_wd_union_name) throws SwinException;

}
