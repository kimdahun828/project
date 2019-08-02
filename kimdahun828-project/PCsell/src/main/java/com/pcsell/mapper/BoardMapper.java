package com.pcsell.mapper;

import java.util.List;

import com.pcsell.vo.board;

public interface BoardMapper {

	List<board> findList();
	
	board boardDetail();
}