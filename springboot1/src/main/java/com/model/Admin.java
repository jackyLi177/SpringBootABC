package com.model;

import java.io.Serializable;

import com.Utils.JWTUtil;
import com.Utils.encodes.PsdEncodes;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//@Data
@Accessors(chain=true)
@NoArgsConstructor
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String roles;

    private String password;
    
    private String token;

    public Admin(Integer id, String name, String roles, String password, String token) {
        this.id = id;
        this.name = name;
        this.roles = roles;
        this.password = password;
        this.token = token;
    }

    public Admin initToken() {
        this.token = JWTUtil.createJWT(this.name, this.password);
        return this;
      }

      public Admin encodePsd(){
        this.password= PsdEncodes.entryptPassword(this.password);
        return this;
      }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles='" + roles + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}