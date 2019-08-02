package com.pcsell.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pcsell.mapper.BoardMapper;
import com.pcsell.vo.board;

@Service("boardRepository")
public class BoardRepositoryImpl implements BoardRepository {

	
	private BoardMapper BoardMapper;
	public BoardMapper getBoardMapper() {
		return BoardMapper;
	}

	public void setBoardMapper(BoardMapper boardMapper) {
		this.BoardMapper = boardMapper;
	}

	@Override
	public List<board> boardList() {
		List<board> boards = BoardMapper.findList();
		return boards;
	}


}
