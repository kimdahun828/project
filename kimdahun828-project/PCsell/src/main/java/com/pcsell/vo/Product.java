package com.pcsell.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Product {

	private String pcCode;
	private String name;
	private String division;	// 분류
	private String companyName; // 제조사
	private String generation; 	// 세대
	private String core;		// 코어 갯수
	private String thread;			// 쓰레드 갯수
	private String capacity;	// 용량
	private String clock;		// 기본 클럭
	private String chipSet;		// 칩셋 종류
	private String socket;		// 소켓
	private String Interface;	// 인터페이스
	private String buffer;		// 버퍼 용량
	private String type;		// 타입
	private String outPut;		// 출력
	private int price;			// 가격
	private int count;			// 수량
	private int discount;
	private String category;
	 
	private List<Photo> files;
}
