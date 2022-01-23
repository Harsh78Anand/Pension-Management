package com.mfpe.pension.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mfpe.pension.model.PensionerDetail;

@FeignClient(name="pensioner-detail", url = "${PENSIONER_DETAIL:http://localhost:8082}")
public interface PensionerDetailClient {
	
	
	@GetMapping("/details/PensionDetailByAadhaar")
	public PensionerDetail getPensionDetailByAadhaar(@RequestHeader(name = "Authorization") String token, @RequestParam String aadhaarNumber);
	
}
