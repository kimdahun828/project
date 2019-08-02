package com.pcsell.controller;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcsell.service.BoardService;
import com.pcsell.vo.board;


@Controller
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;

	@RequestMapping(path = "/boardlist", method = RequestMethod.GET)
	public String board(Model model) {

//		Member loginuser = (Member) session.getAttribute("loginuser");	
		List<board> board = boardService.boardList();
		
//		model.addAttribute("loginuser", loginuser);
		
		System.out.println(board);
		model.addAttribute("boards", board);
		
		return "boardlist";
	}

	@RequestMapping(path = "/boardwrite", method = RequestMethod.GET)
	public String writeForm(Model model) {
//		Member loginuser = (Member) session.getAttribute("loginuser");
//		
//		if(loginuser == null) {
//			return "redirect:/views/boarlist";
//		}
//		
//		model.addAttribute("loginuser",loginuser);

		return "boardwrite";
	}

	@RequestMapping(path = "/boarddetail", method = RequestMethod.GET)
	public String losedetail(Model model) {

		// Member loginuser = (Member) session.getAttribute("loginuser");
		// Board board = boardService.findBoardByBoardNo(boardNo);
		//if (board == null) {
		//	return "redirect:boardlist";
		//}

		// List<LoseFile> files = loseService.findLoseFilesByLoseNo(loseNo);
	
		//Date date = lose.getLoseDate();
		//String d = date.toString();
	
		
//		lose.setFiles((ArrayList<LoseFile>)files);
//		model.addAttribute("boards", board);
//		model.addAttribute("d",d);
//		model.addAttribute("loginuser",loginuser);
		return "boarddetail";
	}
}