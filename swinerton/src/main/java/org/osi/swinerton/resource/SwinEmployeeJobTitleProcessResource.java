package org.osi.swinerton.resource;

import org.osi.swinerton.dto.SwinertonRequestDTO;
import org.osi.swinerton.service.SwinEmployeeJobTitleProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/empJob")
public class SwinEmployeeJobTitleProcessResource {
	@Autowired
	private SwinEmployeeJobTitleProcessService swinEmployeeJobTitleProcessService;

	@PostMapping(value = "/title", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getJobDetails(@RequestBody SwinertonRequestDTO swinReqDto) {
		String result = null;
		if (swinReqDto != null) {
			result = swinEmployeeJobTitleProcessService.getJobDetails(swinReqDto.getP_wd_employee_type(),
					swinReqDto.getP_wd_job_profile(), swinReqDto.getP_wd_job_group(), swinReqDto.getP_wd_unionized(),
					swinReqDto.getP_wd_union_name());
		}
		return result;
	}

}
