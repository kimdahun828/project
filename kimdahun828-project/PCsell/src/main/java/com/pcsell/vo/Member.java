package com.pcsell.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Member implements Serializable {
	
	private String id;
	private String passwd;
	private String email;
	private String hp;
	private boolean userType;
	

}
