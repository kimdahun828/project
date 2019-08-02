package com.pcsell.vo;

import lombok.Data;

@Data
public class UploadFile {
	
	private String pccode;
	private String savedFileName;
	private String userFileName;

	//UploadFile Table을 기준으로 Upload Table과의 1:1 관계를 구현하는 필드
	private Upload upload;
}
