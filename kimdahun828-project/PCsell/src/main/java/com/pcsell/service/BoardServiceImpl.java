package com.pcsell.service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pcsell.common.Pagination;
import com.pcsell.repository.BoardRepository;
import com.pcsell.vo.Board;
import com.pcsell.vo.BoardFile;
import com.pcsell.vo.Review;


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
	public List<Board> boardList() {
		List<Board> boards = boardRepository.boardList();
		return boards;
	}

	@Override
	public void boardDelete(int boardNo) {
		boardRepository.boardDelete(boardNo);
		
	}

	@Override
	public Board boardDetail(int boardNo) {
		Board board = boardRepository.boarddetail(boardNo);
		return board;
	}
	
	@Override
	public Integer registerBoardTx(Board board) {
		int newboardNo = boardRepository.registerboard(board);
		
		for (BoardFile file : board.getFiles()) {
			file.setBoardNo(newboardNo);
			boardRepository.registerboardFile(file);
		}
		
		return newboardNo;

	}
	@Override
	public Board findBoardByBoardNo(int boardNo) {
		Board find = boardRepository.findboardByBoardNo(boardNo);
		return find;
	}

	@Override
	public void updateBoardUpdate(HashMap params) {
		boardRepository.updateBoardUpdate(params);
		
	}
	@Override
	public List<BoardFile> findBoardFilesByBoardNo(int boardNo) {
		List<BoardFile> files = boardRepository.selectBoardFilesByBoardNo(boardNo);
		return files;
	}
	@Override
	public List findBoardFileByBoardNo(int boardNo) {
		List<BoardFile> files = boardRepository.selectBoardFilesByBoardNo(boardNo);
		return files;
	}
	@Override
	public List<Board> searchboardalist(String value) {
		ArrayList<Board> boards = boardRepository.searchboardaList(value);
		return boards;
	}
	@Override
	public int findBoardListCnt() {
		int boardCnt = boardRepository.selectBoardListCnt();
		return boardCnt;
	}
	@Override
	public List<Board> findBoardList(Pagination pagination) {
		List<Board> boards = boardRepository.selectBoard(pagination);
		return boards;
	}
	@Override
	public List<Board> title() {
		ArrayList<Board> board = boardRepository.searchtitleList();
		return board;
	}
	@Override
	public List<Board> content() {
		ArrayList<Board> board = boardRepository.searchcontentList();
		return board;
	}
	@Override
	public List<Board> ID() {
		ArrayList<Board> board = boardRepository.searchIDList();
		return board;
	}
	@Override
	public List<Board> boardNo(int boardNo) {
		ArrayList<Board> board = boardRepository.searchboardNoList(boardNo);
		return board;
	}
	@Override
	public List<Board> boardDate(Date boardDate) {
		ArrayList<Board> board = boardRepository.searchboardDateList(boardDate);
		return board;
	}
	@Override
	public List boardNo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List boardDate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object findBoardFile(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//////////////////////////////////////////////////////
	
	@Override
	public void writeReview(Review review) {
		boardRepository.insertReview(review);
		
	}
	
	@Override
	public List<Review> findReviewListByBoardNo(int boardNo) {
		List<Review> reviews = boardRepository.selectReviewsBoardNo(boardNo);
		return reviews;
	}
	
	@Override
	public void deleteReview(int reviewNo) {
		boardRepository.deleteReview(reviewNo);
		
	}
	
	@Override
	public void updateReview(Review review) {
		boardRepository.updateReview(review);
		
	}
	
	@Override
	public void writeComment(Review review) {
		
		Review parent = boardRepository.selectReviewByReviewNo(review.getReviewNo());
		boardRepository.updateReviewStep(parent);
		
		review.setGroupNo(parent.getGroupNo());
		review.setDepth(parent.getDepth() + 1);
		review.setStep(parent.getStep() + 1);		
		
		boardRepository.insertComment(review);
		
	}

}
