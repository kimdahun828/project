package com.pcsell.vo;

import java.sql.Date;
import java.util.ArrayList;

import com.pcsell.vo.UploadFile;

import lombok.Data;

@Data //generator getter/setter를 대신할 수 있음.
public class Upload {

	private String pcCode;
	private String name;
	private int price;
	private int sum;
	private int count;
	private int discount;
	private Date cartdate;
	private boolean remove;

	//Upload Table과 UploadFile Table 사이의 1:M 관계를 구현하는 필드
	private ArrayList<UploadFile> files;
}