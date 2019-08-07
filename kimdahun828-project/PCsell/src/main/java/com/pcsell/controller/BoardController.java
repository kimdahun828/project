package com.pcsell.controller;

import java.io.File;
import java.lang.reflect.Member;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pcsell.service.BoardService;
import com.pcsell.vo.Board;
import com.pcsell.vo.BoardFile;
import com.pcsell.vo.Review;
import com.pcsell.common.Pagination;
import com.pcsell.common.Util;
import com.pcsell.vo.BoardFile;
import com.pcsell.service.MemberService;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;

	@RequestMapping(path = "/boardlist", method = RequestMethod.GET)
	public String board(Model model, HttpSession session
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range) {

		// Member loginuser = (Member) session.getAttribute("loginuser");	
		// model.addAttribute("loginuser", loginuser);
		
		List<Board> board = boardService.boardList();
		
		model.addAttribute("boards", board);

		// 전체 게시글 개수
		int listCnt = boardService.findBoardListCnt();
		
		// Pagination 객체생성
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);
		
		model.addAttribute("pagination", pagination);
		
		
		// 전체리스트
		List<Board> boards = boardService.findBoardList(pagination);
		if(boards == null) {
			return "redirect:/";
		}		 
		
		model.addAttribute("boards", boards);
		model.addAttribute("listCnt", listCnt);


	return"boardlist";
	}

	@RequestMapping(path = "/boardwrite", method = RequestMethod.GET)
	public String writeForm(Model model, HttpSession session) {
		// Member loginuser = (Member) session.getAttribute("loginuser");
		
//		if(loginuser == null) {
//			return "redirect:/boarlist";
//		}
//		
//		model.addAttribute("loginuser",loginuser);

		return "boardwrite";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	@RequestMapping(path = "/boardwrite", method = RequestMethod.POST)
	public String boardWrite(MultipartHttpServletRequest req, Board board, HttpSession session) {
		
		// Member loginuser = (Member) session.getAttribute("loginuser");
		// board.setID(loginuser.getId);
		
		MultipartFile mf = req.getFile("attach");
		
		ServletContext application = req.getServletContext();		
		String path = application.getRealPath("/resources/files/board-files");
		
		String userFileName = mf.getOriginalFilename();
		if (userFileName.contains("\\")) { // iexplore 경우
			// C:\AAA\BBB\CCC.png -> CCC.png
			userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
		}
		
		String savedFileName = Util.makeUniqueFileName(userFileName);
		
		
		try {
			mf.transferTo(new File(path, savedFileName)); // 파일 저장

			BoardFile boardFile = new BoardFile();
			boardFile.setUserFileName(userFileName);
			boardFile.setSavedFileName(savedFileName);
			ArrayList<BoardFile> files = new ArrayList<BoardFile>();
			files.add(boardFile);
			board.setFiles(files);
		
			
		// 데이터 저장
		boardService.registerBoardTx(board);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		
		return "redirect:boardlist";
		
	}

	@RequestMapping(path = "/boarddetail/{boardNo}", method = RequestMethod.GET)
	public String boarddetail(Model model, @PathVariable int boardNo, HttpSession session) {

		// Member loginuser = (Member) session.getAttribute("loginuser");
		Board board = boardService.boardDetail(boardNo);
		
		if (board == null) {
			return "redirect:boardlist";
		}
		List<BoardFile> files = boardService.findBoardFilesByBoardNo(boardNo);
		
		board.setReviews((ArrayList<Review>) boardService.findReviewListByBoardNo(board.getBoardNo()));
		
		Date date = board.getBoardDate();
		String d = date.toString();
		
		model.addAttribute("d",d);
		model.addAttribute("Board", board);
		board.setFiles((ArrayList<BoardFile>)files);
		// model.addAttribute("loginuser",loginuser);
		return "boarddetail";
	}

	// update text불러오기
	@RequestMapping(path = "/boardupdate/{boardNo}", method = RequestMethod.GET)
		public String boardUpdateForm(@PathVariable int boardNo, Model model) {

			Board board = boardService.findBoardByBoardNo(boardNo);
			model.addAttribute("Board", board);

			return "boardupdate";
		}

	// update 실행
	@RequestMapping(path = "/boardupdate", method = RequestMethod.POST)
		public String boardUpdate(@RequestParam(value = "content") String content, @RequestParam(value = "title") 
			String title, @RequestParam(value = "boardNo") int boardNo, @RequestParam(value = "boardDate") Date boardDate, Model model, HttpSession session) {
			
//			System.out.println(content);
//			System.out.println(title);
			
			//Board board = new Board();
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("content",content);
			params.put("title",title);
			params.put("boardNo",boardNo);
			params.put("boardDate",boardDate);
			
			boardService.updateBoardUpdate(params); 
			
			
			return "redirect:/boardlist";
		}

	// delete 실행
	@RequestMapping(path = "/boarddelete/{boardNo}", method = RequestMethod.GET)
		public String boardDeleteFirm(@PathVariable int boardNo, Model model) {

			boardService.boardDelete(boardNo);

			return "redirect:/boardlist";
		}

	@RequestMapping(path = "/boardsearch", method = RequestMethod.GET)
		 public String boardasearch(@RequestParam(name="value") String value, Model model) {
			
		/*
		 * System.out.println(select); System.out.println(title);
		 * if(select.equals("title")) { title = select; }
		 * 
		 * HashMap<String, Object> params = new HashMap<String, Object>();
		 * 
		 * params.put("title", title);
		 */
			
		 List<Board> Boardd = boardService.searchboardalist(value);
		 model.addAttribute("boards", Boardd);
		 
		 return "boardlist";
		 }
}