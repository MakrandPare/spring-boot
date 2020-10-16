package org.osi.swinerton.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.osi.swinerton.exception.SwinException;
import org.osi.swinerton.service.SwinEmployeeJobTitleProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SwinEmployeeJobTitleProcessServiceImpl implements SwinEmployeeJobTitleProcessService {
	@Value("${swinerton.rest.url}")
	private String url;
	@Value("${swin.username}")
	private String userName;
	@Value("${swin.password}")
	private String password;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String getJobDetails(String p_wd_employee_type, String p_wd_job_profile, String p_wd_job_group,
			String p_wd_unionized, String p_wd_union_name) throws SwinException {

		String l_wd_employee_type = (p_wd_employee_type.toUpperCase()).trim();
		String l_wd_job_profile = (p_wd_job_profile.toUpperCase()).trim();
		String l_wd_job_group = (p_wd_job_group.toUpperCase()).trim();
		String l_wd_unionized = (p_wd_unionized.toUpperCase()).trim();
		String l_wd_union_name = (p_wd_union_name.toUpperCase()).trim();

		String l_lc_job_group = "";
		String l_lc_job_title = "";

		String temp = "STCKSC - Stocker Scrapper";
		if (l_wd_unionized.equals("TRUE") && l_wd_employee_type.equals("CRAFT") && !l_wd_job_profile .equals(temp.toUpperCase())) {
			l_wd_job_profile = l_wd_union_name;
		}

		if (l_wd_employee_type.equals("CRAFT")) {
			if (l_wd_job_profile.contains("OPERATOR")) {
				l_lc_job_group = "OPERATOR";
				l_lc_job_title = "OPERATOR";
			} else if (l_wd_job_profile.contains("STOCKER") || l_wd_job_profile.contains("SCRAPPER")) {
				l_lc_job_group = "STOCKER SCRAPPER";
				l_lc_job_title = "STOCKER SCRAPPER";
			} else if (l_wd_job_profile.contains("JOURNEYMAN")) {
				l_lc_job_group = "JOURNEYMAN";
				String temp1 = "3254 AGC Southern California Drywall San Diego County";
				String temp2 = "0125 International Union Of Bricklayers & Allied Craftsmen Local 1";
				if (l_wd_job_profile.contains("OPERATOR") || l_wd_job_profile.contains("OPERATING")) {
					l_lc_job_title = l_lc_job_group + " - OPERATOR";
				} else if (l_wd_job_profile.contains("DRYWALL CARPENTER")
						|| l_wd_job_profile.contains(temp1.toUpperCase())
						|| l_wd_job_profile.contains("DRYWALL LATHERS")
						|| l_wd_job_profile.contains("DRYWALL/LATHING")) {
					l_lc_job_title = l_lc_job_group + " - DRYWALL CARPENTER";
				} else if (l_wd_job_profile.contains("CARPENTER")) {
					l_lc_job_title = l_lc_job_group + " - CARPENTER";
				} else if (l_wd_job_profile.contains("CONCRETE FINISHER")) {
					l_lc_job_title = l_lc_job_group + " - CONCRETE FINISHER";
				} else if (l_wd_job_profile.contains("CONCRETE MASON") || l_wd_job_profile.contains("CEMENT MASON")
						|| l_wd_job_profile.contains(temp2.toUpperCase())) {
					l_lc_job_title = l_lc_job_group + " - CONCRETE MASON";
				} else if (l_wd_job_profile.contains("DEMOLITION")) {
					l_lc_job_title = l_lc_job_group + " - DEMOLITION";
				} else if (l_wd_job_profile.contains("DRYWALL FINISHER")
						|| l_wd_job_profile.contains("DRYWALLER FINISHER")) {
					l_lc_job_title = l_lc_job_group + " - DRYWALL FINISHER";
				} else if (l_wd_job_profile.contains("DRYWALL FRAMER")) {
					l_lc_job_title = l_lc_job_group + " - DRYWALL FRAMER";
				} else if (l_wd_job_profile.contains("ELECT")) {
					l_lc_job_title = l_lc_job_group + " - ELECTRICIAN";
				} else if (l_wd_job_profile.contains("LABORER")) {
					l_lc_job_title = l_lc_job_group + " - LABORER";
				} else {
					l_lc_job_title = l_lc_job_group;
				}
			} else if (l_wd_job_profile.contains("FOREMAN")) {
				l_lc_job_group = "FOREMAN";
				String temp1 = "3254 AGC Southern California Drywall San Diego County";
				String temp2 = "0125 International Union Of Bricklayers & Allied Craftsmen Local 1";
				if (l_wd_job_profile.contains("OPERATOR") || l_wd_job_profile.contains("OPERATING")) {
					l_lc_job_title = l_lc_job_group + " - OPERATOR";
				} else if (l_wd_job_profile.contains("DRYWALL CARPENTER")
						|| l_wd_job_profile.contains(temp1.toUpperCase())
						|| l_wd_job_profile.contains("DRYWALL LATHERS")
						|| l_wd_job_profile.contains("DRYWALL/LATHING")) {
					l_lc_job_title = l_lc_job_group + " - DRYWALL CARPENTER";
				} else if (l_wd_job_profile.contains("CARPENTER")) {
					l_lc_job_title = l_lc_job_group + " - CARPENTER";
				} else if (l_wd_job_profile.contains("CONCRETE FINISHER")) {
					l_lc_job_title = l_lc_job_group + " - CONCRETE FINISHER";
				} else if (l_wd_job_profile.contains("CONCRETE MASON") || l_wd_job_profile.contains("CEMENT MASON")
						|| l_wd_job_profile.contains(temp2.toUpperCase())) {
					l_lc_job_title = l_lc_job_group + " - CONCRETE MASON";
				} else if (l_wd_job_profile.contains("DEMOLITION")) {
					l_lc_job_title = l_lc_job_group + " - DEMOLITION";
				} else if (l_wd_job_profile.contains("DRYWALL FINISHER")
						|| l_wd_job_profile.contains("DRYWALLER FINISHER")) {
					l_lc_job_title = l_lc_job_group + " - DRYWALL FINISHER";
				} else if (l_wd_job_profile.contains("DRYWALL FRAMER")) {
					l_lc_job_title = l_lc_job_group + " - DRYWALL FRAMER";
				} else if (l_wd_job_profile.contains("ELECT")) {
					l_lc_job_title = l_lc_job_group + " - ELECTRICIAN";
				} else if (l_wd_job_profile.contains("LABORER")) {
					l_lc_job_title = l_lc_job_group + " - LABORER";
				} else {
					l_lc_job_title = l_lc_job_group;
				}
			} else if (l_wd_job_profile.contains("APPRENTICE")) {
				l_lc_job_group = "APPRENTICE";
				String temp1 = "3254 AGC Southern California Drywall San Diego County";
				String temp2 = "0125 International Union Of Bricklayers & Allied Craftsmen Local 1";
				if (l_wd_job_profile.contains("OPERATOR") || l_wd_job_profile.contains("OPERATING")) {
					l_lc_job_title = l_lc_job_group + " - OPERATOR";
				} else if (l_wd_job_profile.contains("DRYWALL CARPENTER")
						|| l_wd_job_profile.contains(temp1.toUpperCase())
						|| l_wd_job_profile.contains("DRYWALL LATHERS")
						|| l_wd_job_profile.contains("DRYWALL/LATHING")) {
					l_lc_job_title = l_lc_job_group + " - DRYWALL CARPENTER";
				} else if (l_wd_job_profile.contains("CARPENTER")) {
					l_lc_job_title = l_lc_job_group + " - CARPENTER";
				} else if (l_wd_job_profile.contains("CONCRETE FINISHER")) {
					l_lc_job_title = l_lc_job_group + " - CONCRETE FINISHER";
				} else if (l_wd_job_profile.contains("CONCRETE MASON") || l_wd_job_profile.contains("CEMENT MASON")
						|| l_wd_job_profile.contains(temp2.toUpperCase())) {
					l_lc_job_title = l_lc_job_group + " - CONCRETE MASON";
				} else if (l_wd_job_profile.contains("DEMOLITION")) {
					l_lc_job_title = l_lc_job_group + " - DEMOLITION";
				} else if (l_wd_job_profile.contains("DRYWALL FINISHER")
						|| l_wd_job_profile.contains("DRYWALLER FINISHER")) {
					l_lc_job_title = l_lc_job_group + " - DRYWALL FINISHER";
				} else if (l_wd_job_profile.contains("DRYWALL FRAMER")) {
					l_lc_job_title = l_lc_job_group + " - DRYWALL FRAMER";
				} else if (l_wd_job_profile.contains("ELECT")) {
					l_lc_job_title = l_lc_job_group + " - ELECTRICIAN";
				} else if (l_wd_job_profile.contains("LABORER")) {
					l_lc_job_title = l_lc_job_group + " - LABORER";
				} else {
					l_lc_job_title = l_lc_job_group;
				}
			} else {
				l_lc_job_group = "GENERAL CRAFT";
				l_lc_job_title = "GENERAL CRAFT";
			}
		} else if (l_wd_employee_type.equals("ADMINISTRATIVE")) {
			if (l_wd_job_profile.contains("BIM") || l_wd_job_profile.contains("VD&C")
					|| l_wd_job_profile.contains("VDC")) {
				l_lc_job_group = "BIM; VDC";
				l_lc_job_title = "VD&C";
			} else if (l_wd_job_group.contains("MEP") || l_wd_job_profile.contains("MEP")) {
				l_lc_job_group = "MEP";
				l_lc_job_title = "MEP";
			} else if (l_wd_job_group.contains("CRAFT SERVICES") || l_wd_job_group.contains("CRAFT TALENT")
					|| l_wd_job_profile.contains("CRAFT SERVICES") || l_wd_job_profile.contains("CRAFT TALENT")) {
				l_lc_job_group = "CRAFT";
				l_lc_job_title = "CRAFT SERVICES";
			} else if (l_wd_job_group.contains("ACCOUNTING") || l_wd_job_group.contains("ACCOUNTANT")
					|| l_wd_job_group.contains("PAYROLL") || l_wd_job_group.contains("ACCTNT")
					|| l_wd_job_profile.contains("ACCOUNTING") || l_wd_job_profile.contains("ACCOUNTANT")
					|| l_wd_job_profile.contains("PAYROLL") || l_wd_job_profile.contains("ACCTNT")) {
				l_lc_job_group = "ACCOUNTANT";
				l_lc_job_title = "ACCOUNTANT";
			} else if (l_wd_job_group.contains("SUPERINTENDENT")) {
				l_lc_job_group = "SUPERINTENDENT";
				l_lc_job_title = "SUPERINTENDENT";
			} else if (l_wd_job_group.contains("ADMINISTRATIVE") || l_wd_job_group.contains("PROJECT COORDINATOR")
					|| l_wd_job_profile.contains("ADMINISTRATIVE")
					|| l_wd_job_profile.contains("PROJECT COORDINATOR")) {
				l_lc_job_group = "ADMINISTRATIVE; PROJECT COORDINATOR";
				l_lc_job_title = "ADMIN ASST-MGR";
			} else if (l_wd_job_group.contains("OPERATIONS MANAGER") || l_wd_job_group.contains("OPERATIONS MGR")
					|| l_wd_job_group.contains("DIVISION MANAGER") || l_wd_job_group.contains("DIVISION MGR")
					|| l_wd_job_profile.contains("OPERATIONS MANAGER") || l_wd_job_profile.contains("OPERATIONS MGR")
					|| l_wd_job_profile.contains("DIVISION MANAGER") || l_wd_job_profile.contains("DIVISION MGR")) {
				l_lc_job_group = "DIVISION MANAGER; OPERATIONS MANAGER";
				l_lc_job_title = "ADMIN STAFFER";
			} else if (l_wd_job_group.contains("PROJECT EXECUTIVE") || l_wd_job_profile.contains("PROJECT EXECUTIVE")) {
				l_lc_job_group = "PROJECT EXECUTIVE";
				l_lc_job_title = "PROJECT EXECUTIVE";
			} else if (l_wd_job_group.contains("PROJECT ENGINEER") || l_wd_job_profile.contains("PROJECT ENGINEER")) {
				l_lc_job_group = "PROJECT ENGINEER";
				l_lc_job_title = "PROJECT ENGINEER";
			} else if (l_wd_job_group.contains("PROJECT MANAGER") || l_wd_job_group.contains("PROJECT MGR")) {
				l_lc_job_group = "PROJECT MANAGER";
				l_lc_job_title = "PROJECT MANAGER";
			} else if (l_wd_job_group.contains("PROJECT ASSISTANT") || l_wd_job_group.contains("FIELD ADMINISTRATOR")) {
				l_lc_job_group = "PROJECT ASSISTANT";
				l_lc_job_title = "PROJECT ASSISTANT";
			} else if (l_wd_job_group.contains("SAFETY") || l_wd_job_group.contains("SFTY")
					|| l_wd_job_profile.contains("SAFETY") || l_wd_job_profile.contains("SFTY")) {
				l_lc_job_group = "EHS; SAFETY";
				l_lc_job_title = "SAFETY";
			} else if (l_wd_job_group.contains("SCHEDULER") || l_wd_job_group.contains("SCHEDULING")
					|| l_wd_job_group.contains("CLAIMS")) {
				l_lc_job_group = "SCHEDULER";
				l_lc_job_title = "SCHEDULER";
			} else if (l_wd_job_group.contains("TECHNICIAN") || l_wd_job_profile.contains("TECHNICIAN")) {
				l_lc_job_group = "TECHNICIAN";
				l_lc_job_title = "TECHNICIAN";
			} else if (l_wd_job_group.contains("ESTIMATOR") || l_wd_job_group.contains("ESTIMATING")
					|| l_wd_job_group.contains("DETAILER") || l_wd_job_profile.contains("ESTIMATOR")
					|| l_wd_job_profile.contains("ESTIMATING") || l_wd_job_profile.contains("DETAILER")) {
				l_lc_job_group = "DETAILER; ESTIMATOR";
				l_lc_job_title = "ESTIMATOR";
			} else if (l_wd_job_group.contains("OPERATOR") || l_wd_job_profile.contains("OPERATOR")) {
				l_lc_job_group = "OPERATOR";
				l_lc_job_title = "OPERATOR";
			} else {
				l_lc_job_group = "GENERAL ADMIN";
				l_lc_job_title = "GENERAL ADMIN STAFF";
			}
		}

		l_lc_job_group = "%" + l_lc_job_group + "%";
		l_lc_job_title = "%" + l_lc_job_title + "%";
		l_lc_job_group = l_lc_job_group.toUpperCase();
		l_lc_job_title = l_lc_job_title.toUpperCase();

		String result = postCall(l_wd_employee_type, l_lc_job_group, l_lc_job_title);

		return result;

	}

	private String postCall(String l_wd_employee_type, String l_lc_job_group, String l_lc_job_title)
			throws SwinException {
		String str = null;
		try {
			String plainCreds = userName + ":" + password;
			byte[] plainCredsBytes = plainCreds.getBytes();
			byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
			String base64Creds = new String(base64CredsBytes);
			Map<String, String> map = new HashMap<>();
			map.put("employeeType", l_wd_employee_type);
			map.put("jobGroup", l_lc_job_group);
			map.put("jobTitle", l_lc_job_title);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.add("Authorization", "Basic " + base64Creds);
			HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(map, headers);
			str = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();

		} catch (Exception e) {
			throw new SwinException(e);
		}
		return str;
	}

}
