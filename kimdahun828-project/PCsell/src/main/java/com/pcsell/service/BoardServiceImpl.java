package com.pcsell.service;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pcsell.repository.BoardRepository;
import com.pcsell.vo.board;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	private BoardRepository boardRepository;
	public BoardRepository getBoardRepository() {
		return boardRepository;
	}
	public void setBoardRepository(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	@Override
	public List<board> boardList() {
		List<board> loses = boardRepository.boardList();
		return loses;
	}
}
