package com.pcsell.vo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import lombok.Data;

@Data
public class Cart {
	private String id;
	private String name;
	private int price;
	private Date cartDate;
	private boolean remove;
	private int count;	
}