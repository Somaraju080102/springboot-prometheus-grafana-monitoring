package com.spring.monitoring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	
	@GetMapping("/hello")
	public String hello() {
		
		return "Hello welcome to Springboot Monitoring Application using Prometheus and Grafana";
	}

}
