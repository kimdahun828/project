package com.pcsell.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pcsell.repository.BoardRepository;
import com.pcsell.vo.Board;


public class BoardServiceImpl implements BoardService {

	private BoardRepository boardRepository;
	public BoardRepository getBoardRepository() {
		return boardRepository;
	}
	public void setBoardRepository(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	@Override
	public List<Board> boardList() {
		List<Board> loses = boardRepository.boardList();
		return loses;
	}
}
