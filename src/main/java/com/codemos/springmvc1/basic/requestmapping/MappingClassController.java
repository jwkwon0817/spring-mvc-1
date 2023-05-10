package com.codemos.springmvc1.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
	/**
	 * Injury member list: GET `/users`
	 * Add a member: POST `/users`
	 * Get a specific member: GET `/users/{id}`
	 * Modify a member: PATCH `/users/{id}`
	 * Delete a member: DELETE `/users/{id}`
	 */

	@GetMapping
	public String user() {
		return "get users";
	}

	@PostMapping
	public String addUser() {
		return "post user";
	}

	@GetMapping("/{userId}")
	public String findUser(@PathVariable String userId) {
		return "get userId = " + userId;
	}

	@PatchMapping("/{userId}")
	public String updateUser(@PathVariable String userId) {
		return "update userId = " + userId;
	}

	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable String userId) {
		return "delete userId = " + userId;
	}
}
