package com.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;


	private String email;


	private String password;


	private Set<RoleVO> roles = new HashSet<>();


	public UserVO(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}


}
