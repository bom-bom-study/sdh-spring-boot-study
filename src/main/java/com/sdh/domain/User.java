package com.sdh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private int userId;

	private String id;

	private String password;

	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

}
