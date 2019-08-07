package com.pcsell.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.pcsell.common.Pagination;
import com.pcsell.vo.Board;
import com.pcsell.vo.BoardFile;
import com.pcsell.vo.Review;

public interface BoardRepository {

	List<Board> boardList();
	
	void insertBoard(Board board);
	
	void insertBoardFile(BoardFile file);

	void updateBoardUpdate(HashMap<String, Object> params);

	Board boarddetail(int boardNo);

	void boardDelete(int boardNo);

	int registerboard(Board board);

	Board findboardByBoardNo(int boardNo);

	void registerboardFile(BoardFile file);

	List<BoardFile> selectBoardFilesByBoardNo(int boardNo);

	ArrayList<Board> searchboardaList(String value);

	int selectBoardListCnt();

	List<Board> selectBoard(Pagination pagination);

	ArrayList<Board> searchtitleList();

	ArrayList<Board> searchcontentList();

	ArrayList<Board> searchIDList();

	ArrayList<Board> searchboardDateList();

	ArrayList<Board> searchtitleList(String value);

	ArrayList<Board> searchcontentList(String value);

	ArrayList<Board> searchIDList(String value);

	ArrayList<Board> searchboardDateList(String value);

	ArrayList<Board> searchboardNoList(int boardNo);

	ArrayList<Board> searchboardDateList(Date boardDate);
	
	///////////////////////////////////////////////////////
	
	void insertReview(Review review);
	
	void deleteReview(int reviewNo);
	
	void updateReview(Review review);
	
	List<Review> selectReviewsByBoardNo(int boardNo);
	
	Review selectReviewByReviewNo(int reviewNo);
	
	void updateReviewStep(Review parent);
	
	void insertComment(Review review);

	List<Review> selectReviewsBoardNo(int boardNo);

}
