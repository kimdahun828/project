package com.pcsell.vo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import lombok.Data;

@Data
public class Cart {
	private String id;
	private String pcCode;
	private String name;
	private int sum;
	private int dc; // 할인율 있는 상품에 한해
	private Date cartDate;
	private int price;
} 

