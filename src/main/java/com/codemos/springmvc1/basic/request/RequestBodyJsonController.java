package com.codemos.springmvc1.basic.request;

import com.codemos.springmvc1.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@Controller
public class RequestBodyJsonController {
	private ObjectMapper objectMapper = new ObjectMapper();

	@PostMapping("/request-body-json-v1")
	public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, java.nio.charset.StandardCharsets.UTF_8);

		log.info("messageBody = {}", messageBody);
		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());

		response.getWriter().write("ok");
	}

	@ResponseBody
	@PostMapping("/request-body-json-v2")
	public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {
		log.info("messageBody = {}", messageBody);
		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());

		return "ok";
	}

	@ResponseBody
	@PostMapping("/request-body-json-v3")
	public String requestBodyJsonV3(@RequestBody HelloData helloData) throws IOException {
		log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());

		return "ok";
	}
}
