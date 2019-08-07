package com.pcsell.mapper;

import java.util.HashMap;
import java.util.List;

import com.pcsell.vo.Board;
import com.pcsell.vo.BoardFile;
import com.pcsell.vo.Review;

public interface BoardMapper {

	List<Board> findList();
	
	Board boardDetail(int boardNo);
	
	void boardDelete(int boardNo);

	void insertBoard(Board board);
	
	void insertBoardFile(BoardFile file);

	void updateBoardUpdate(HashMap params);

	Board selectBoardByBoardNo(int boardNo);

	void registerboard(Board board);

	void boardFileDelete(int boardNo);

	void registerboardFile(BoardFile file);

	List<BoardFile> selectBoardFilesByBoardNo(int boardNo);

	List<Board> searchboardlist(String value);

	List<Board> searchboardalist(String value);

	int selectBoardListCnt();

	List<Board> selectBoard(HashMap<String, Object> params);


	List<Board> searchboardNoList();

	List<Board> searchboardDateList();

	List<Board> searchIDList();

	List<Board> searchboardNoList(int boardNo);

	List<Board> searchcontentList();

	List<Board> searchtitleList();
	
	/////////////////////////////////////////////////////////////////
	
	void insertReview(Review review);

	void updateReview(Review review);

	void deleteReview(int reviewNo);
	
	List<Review> selectReviewsByBoardNo(int boardNo);

	Review selectReviewByReviewNo(int reviewNo);

	void updateReviewStep(Review review);

	void insertComment(Review review);

}