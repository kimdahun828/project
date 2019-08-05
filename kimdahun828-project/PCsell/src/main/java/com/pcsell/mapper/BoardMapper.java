package com.pcsell.mapper;

import java.util.List;

import com.pcsell.vo.Board;

public interface BoardMapper {

	List<Board> findList();
	
	Board boardDetail();
}