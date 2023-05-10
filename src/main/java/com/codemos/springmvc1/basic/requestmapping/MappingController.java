package com.codemos.springmvc1.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class MappingController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/hello-basic")
	public String helloBasic() {
		log.info("helloBasic");
		return "ok";
	}

	@RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
	public String mappingGetV1() {
		log.info("mappingGetV1");
		return "ok";
	}

	/**
	 * Convenient mapping annotation
	 * @GetMapping
	 * @PostMapping
	 * @PutMapping
	 * @DeleteMapping
	 * @PatchMapping
	 */
	@GetMapping(value = "/mapping-get-v2")
	public String mappingGetV2() {
		log.info("mapping-get-v2");
		return "ok";
	}

	/**
	 * PathVariable example
	 * Can be omitted if the variable name is the same
	 * @PathVariable("userId") String userId -> @PathVariable userId
	 * /mapping/userA
	 */
	@GetMapping("/mapping/{userId}")
	public String mappingPath(@PathVariable("userId") String data) {
		log.info("mappingPath userId = {}", data);
		return "ok";
	}

	/**
	 * @PathVariable Multiple example
	 */
	@GetMapping("/mapping/users/{userId}/orders/{orderId}")
	public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
		log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
		return "ok";
	}

	/**
	 * Additional Mapping by Parameters
	 * params="mode"
	 * params="!mode"
	 * params="mode=debug"
	 * params="mode!=debug"
	 * params={"mode=debug", "data=good"}
	 */
	@GetMapping(value = "/mapping-param", params = "mode=debug")
	public String mappingParam() {
		log.info("mappingParam");
		return "ok";
	}

	/**
	 * Additional Mapping by Specific Headers
	 * headers="mode"
	 * headers="!mode"
	 * headers="mode=debug"
	 * headers="mode!=debug"
	 * headers={"mode=debug", "data=good"}
	 */
	@GetMapping(value = "/mapping-header", headers = "mode=debug")
	public String mappingHeader() {
		log.info("mappingHeader");
		return "ok";
	}

	/**
	 * Additional Mapping Media Type based onContent-Type Header
	 * consumes="application/json"
	 * consumes="!application/json"
	 * consumes="application/*"
	 * consumes="*\/*"
	 * MediaType.APPLICATION_JSON_VALUE
	 */
	@PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String mappingConsumes() {
		log.info("mappingConsumes");
		return "ok";
	}

	/**
	 * Media Type based on Accept Header
	 * produces="text/html"
	 * produces="!text/html"
	 * produces="text/*"
	 * produces="*\/*"
	 */
	@PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
	public String mappingProduces() {
		log.info("mappingProduces");
		return "ok";
	}
}
