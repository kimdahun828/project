package com.pcsell.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pcsell.mapper.BoardMapper;
import com.pcsell.vo.Board;

public class BoardRepositoryImpl implements BoardRepository {
	
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private SqlSessionTemplate sessionTemplate;
	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	private BoardMapper BoardMapper;
	public BoardMapper getBoardMapper() {
		return BoardMapper;
	}

	public void setBoardMapper(BoardMapper boardMapper) {
		this.BoardMapper = boardMapper;
	}
	@Override
	public List<Board> boardList() {
		List<Board> boards = BoardMapper.findList();
		return boards;
	}


}
