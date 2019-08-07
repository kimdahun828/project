package com.pcsell.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pcsell.common.Pagination;
import com.pcsell.mapper.BoardMapper;
import com.pcsell.vo.Board;
import com.pcsell.vo.BoardFile;
import com.pcsell.vo.Review;



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
	public List<Board> boardList() {
		List<Board> boards = BoardMapper.findList();
		return boards;
	}


	@Override
	public void boardDelete(int boardNo) {
		BoardMapper.boardDelete(boardNo);
		BoardMapper.boardFileDelete(boardNo);
	}

	@Override
	public Board boarddetail(int boardNo) {
		Board board = BoardMapper.boardDetail(boardNo);
		
		return board;
	}

	@Override
	public void insertBoard(Board board) {
		BoardMapper.insertBoard(board);
		
	}

	@Override
	public int registerboard(Board board) {
		BoardMapper.registerboard(board);
		
		return board.getBoardNo();
	}

	@Override
	public Board findboardByBoardNo(int boardNo) {
		Board board = BoardMapper.selectBoardByBoardNo(boardNo);
		
		return board;
	}

	@Override
	public void updateBoardUpdate(HashMap  params) {
		BoardMapper.updateBoardUpdate(params);
		
	}

	@Override
	public void insertBoardFile(BoardFile file) {
		BoardMapper.insertBoardFile(file);
		
	}

	@Override
	public void registerboardFile(BoardFile file) {
		BoardMapper.registerboardFile(file);
		
	}

	@Override
	public List<BoardFile> selectBoardFilesByBoardNo(int boardNo) {
		List<BoardFile> boards = BoardMapper.selectBoardFilesByBoardNo(boardNo);
		return boards;
	}

	@Override
	public ArrayList<Board> searchboardaList(String value) {
		List<Board> boards = BoardMapper.searchboardalist(value);
		return (ArrayList<Board>)boards;
	}

	@Override
	public int selectBoardListCnt() {
		int boardCnt = BoardMapper.selectBoardListCnt();
		return boardCnt;
	}

	@Override
	public List<Board> selectBoard(Pagination pagination) {
		HashMap<String,Object> params = new HashMap<String, Object>();
		params.put("startList", pagination.getStartList());
		params.put("endList", pagination.getEndList());
		
		List<Board> boards = BoardMapper.selectBoard(params);
		return boards;
	}

	@Override
	public ArrayList<Board> searchtitleList(String value) {
		List<Board> board = BoardMapper.searchtitleList();
		return (ArrayList<Board>)board;
	}

	@Override
	public ArrayList<Board> searchcontentList(String value) {
		List<Board> board = BoardMapper.searchcontentList();
		return (ArrayList<Board>)board;
	}

	@Override
	public ArrayList<Board> searchIDList(String value) {
		List<Board> board = BoardMapper.searchIDList();
		return (ArrayList<Board>)board;
	}

	@Override
	public ArrayList<Board> searchboardDateList(String value) {
		List<Board> board = BoardMapper.searchboardDateList();
		return (ArrayList<Board>)board;
	}

	@Override
	public ArrayList<Board> searchboardNoList(int boardNo) {
		List<Board> board = BoardMapper.searchboardNoList(boardNo);
		return (ArrayList<Board>)board;
	}

	@Override
	public ArrayList<Board> searchtitleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Board> searchcontentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Board> searchIDList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Board> searchboardDateList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Board> searchboardDateList(Date boardDate) {
		// TODO Auto-generated method stub
		return null;
	}

	////////////////////////////////////////////////////////////
	
	@Override
	public void insertReview(Review review) {
		BoardMapper.insertReview(review);
	}
	
	@Override
	public void updateReview(Review review) {
		BoardMapper.updateReview(review);
	}
	
	@Override
	public void deleteReview(int reviewNo) {
		BoardMapper.deleteReview(reviewNo);
	}

	@Override
	public ArrayList<Review> selectReviewsByBoardNo(int boardNo) {
		List<Review> reviews =
			BoardMapper.selectReviewsByBoardNo(boardNo);
		return (ArrayList<Review>)reviews;
	}
	
	@Override
	public Review selectReviewByReviewNo(int reviewNo) {
		Review review =
			BoardMapper.selectReviewByReviewNo(reviewNo);
		return review;
	}
	
	@Override
	public void updateReviewStep(Review review) {
		BoardMapper.updateReviewStep(review);
	}
	
	@Override
	public void insertComment(Review review) {
		BoardMapper.insertComment(review);
	}

	@Override
	public List<Review> selectReviewsBoardNo(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}


}
