package com.mfpe.pension.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.pension.model.ProcessPensionInput;
import com.mfpe.pension.model.ProcessPensionResponse;



@FeignClient(name="pension-disbursement", url = "${PENSIONER_DETAIL:http://localhost:8083}")
public interface PensionDisbursementClient {

	@PostMapping("/disbursement/disbursePension")
	public ProcessPensionResponse disbursePension(@RequestHeader("Authorization") String token,
			ProcessPensionInput processPensionInput);
}
