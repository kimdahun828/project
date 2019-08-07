package com.pcsell.vo;

import java.util.Date;
import java.util.List;

import com.pcsell.vo.BoardFile;
import com.pcsell.vo.Review;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String title;
	private String content;
	private String ID;
	private Date boardDate;
	
	private ArrayList<BoardFile> files;

	private ArrayList<Review> reviews;
	
	}
	
