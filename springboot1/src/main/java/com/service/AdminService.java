package com.service;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.Utils.encodes.PsdEncodes;
import com.mapper.AdminMapper;
import com.model.Admin;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liyongjie
 * @date 2018年5月18日
 */
@Slf4j
@Service
@Cacheable
public class AdminService {
	
	@Autowired
	private AdminMapper mapper;
	
	public Admin getByName(String name,String password){
		return mapper.selectByAdminInfo(name,password);
	}

	/**
	 * @param admin
	 * @return
	 */
	public int insert(Admin admin) {
		/*String password = admin.getPassword();
		password = PsdEncodes.entryptPassword(password);
		log.info("password------->"+password);
		admin.setPassword(password);*/
		return mapper.insert(admin);
	}
	
	public Admin selectByID(Integer id){
		for(Method s : mapper.getClass().getDeclaredMethods()){
			log.info("--------->"+s.getName());
		}
		return mapper.selectByPrimaryKey(id);
	}
	
	public Admin getByName(String username){
		return mapper.getByName(username);
	}

	/**
	 * @param name
	 * @param password
	 * @return
	 */
	public Admin getUserVailPassWord(String name, String password) {
		Admin admin = mapper.getByName(name);
		return admin !=null && PsdEncodes.validatePassword(password, admin.getPassword())?admin:null;
	}
}
