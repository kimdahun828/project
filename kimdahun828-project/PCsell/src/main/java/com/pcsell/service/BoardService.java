package com.pcsell.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.pcsell.common.Pagination;
import com.pcsell.vo.Board;
import com.pcsell.vo.BoardFile;
import com.pcsell.vo.Review;



public interface BoardService<Borad> {

	Integer registerBoardTx(Board board);
	
	List<Board> boardList();
	
	List<BoardFile> findBoardFileByBoardNo(int boardNo);

	void boardDelete(int boardNo);
	
	Board boardDetail(int boardNo);

	Board findBoardByBoardNo(int boardNo);

	void updateBoardUpdate(HashMap<String, Object> params);

	List<BoardFile> findBoardFilesByBoardNo(int boardNo);

	List<Board> searchboardalist(String value);

	int findBoardListCnt();

	List<Board> findBoardList(Pagination pagination);

	List<Board> title();
	
	List<Board> content();
	
	List<Board> ID();
	
	List<Board> boardNo();
	
	List<Board> boardDate();

	List<Board> boardDate(Date boardDate);

	List<Board> boardNo(int boardNo);

	Object findBoardFile(int boardNo);
	
	///////////////////////////////////////////////////////////////
	
	void writeReview(Review review);

	List<Review> findReviewListByBoardNo(int boardNo);

	void deleteReview(int reviewNo);

	void updateReview(Review review);

	void writeComment(Review review);

}
