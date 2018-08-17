package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.common.Result;
import com.model.Admin;
import com.service.AdminService;

/**
 * @author liyongjie
 * @date 2018年5月22日
 */
@RestController
@RequestMapping("/Token")
public class TokenController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login")
	public Result login(@RequestParam String name,@RequestParam String password){
		Admin admin = adminService.getUserVailPassWord(name,password);
		if(admin == null){
			return Result.ok("name or password error!!");
		}
		return Result.ok(admin.initToken());
	}
	
}
