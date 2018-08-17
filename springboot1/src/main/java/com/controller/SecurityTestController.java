package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.Result;
import com.mapper.AdminMapper;
import com.model.Admin;
import com.service.AdminService;

/**
 * @author liyongjie
 * @date 2018年5月18日
 */
@Controller
@RequestMapping("/security")
public class SecurityTestController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/login")
	public Result login(@RequestParam String name,@RequestParam String password){
		return Result.ok(adminService.getByName(name,password)==null?"error username or password":"login successful!");
	}
	
	@PostMapping("/add")
	public Result addAdmin(@RequestBody Admin admin){
		return Result.ok(adminService.insert(admin));
	}
}
