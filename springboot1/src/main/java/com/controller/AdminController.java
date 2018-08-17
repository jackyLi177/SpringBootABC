package com.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.common.Result;
import com.model.Admin;
import com.service.AdminService;

/**
 * @author liyongjie
 * @date 2018年5月18日
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
/*	@GetMapping("/login")
	public Result login(@RequestParam String name,@RequestParam String password){
		return Result.ok(adminService.getByName(name,password)==null?"error username or password":"login successful!");
	}*/
	
	@PostMapping("/add")
	public Result addAdmin(@RequestBody Admin admin){
		return Result.ok(adminService.insert(admin.encodePsd()));
	}
	
	@RequiresAuthentication
	@GetMapping("/getByID")
	public Result getByID(@RequestParam Integer id){
		return Result.ok(adminService.selectByID(id));
	}
	
}
