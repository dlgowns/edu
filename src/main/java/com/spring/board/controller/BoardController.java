package com.spring.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.board.HomeController;
import com.spring.board.service.boardService;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.PageVo;
import com.spring.common.CommonUtil;


@Controller
public class BoardController {
	
	@Autowired 
	boardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/board/boardList.do", method = RequestMethod.GET)
	public String boardList(Locale locale, Model model,PageVo pageVo) throws Exception{
		
		System.out.println("boardList.do 圾青 1/3");
		
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		int page = 1;
		int totalCnt = 0;
		
		if(pageVo.getPageNo() == 0){
			pageVo.setPageNo(page);;
		}
		System.out.println("boardList.do 圾青 2/5");
		
		boardList = boardService.SelectBoardList(pageVo);
		System.out.println("boardList.do 圾青 3/5");
		
		totalCnt = boardService.selectBoardCnt();
		
		System.out.println("boardList.do 圾青 4/5");
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("pageNo", page);
		
		System.out.println("boardList.do 圾青 5/5");
		
		return "board/boardList";
	}
	
	@RequestMapping(value = "/board/{boardType}/{boardNum}/boardView.do", method = RequestMethod.GET)
	public String boardView(Locale locale, Model model
			,@PathVariable("boardType")String boardType
			,@PathVariable("boardNum")int boardNum) throws Exception{
		
		System.out.println("boardView.do 圾青");
		
		BoardVo boardVo = new BoardVo();
		
		
		boardVo = boardService.selectBoard(boardType,boardNum);
		
		model.addAttribute("boardType", boardType);
		model.addAttribute("boardNum", boardNum);
		model.addAttribute("board", boardVo);
		
		return "board/boardView";
	}
	
	@RequestMapping(value = "/board/boardWrite.do", method = RequestMethod.GET)
	public String boardWrite(Locale locale, Model model) throws Exception{
		
		System.out.println("boardWrite.do 圾青");
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "/board/boardWriteAction.do", method = RequestMethod.POST)
	@ResponseBody
	public String boardWriteAction(Locale locale,BoardVo boardVo) throws Exception{
		
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		
		int resultCnt = boardService.boardInsert(boardVo);
		
		result.put("success", (resultCnt > 0)?"Y":"N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ",result);
		
		System.out.println("callbackMsg::"+callbackMsg);
		
		return callbackMsg;
	}
	
	@RequestMapping(value = "/board/{boardType}/{boardNum}/boardUpdateForm.do", method = RequestMethod.GET)
	public String boardUpdateForm(Locale locale, Model model,
								  @PathVariable("boardType")String boardType,
								  @PathVariable("boardNum")int boardNum) throws Exception {
		
		BoardVo boardVo2 = new BoardVo();
		
		boardVo2 = boardService.selectBoard(boardType, boardNum);
		
		model.addAttribute("boardType", boardType);
		model.addAttribute("boardNum", boardNum);
		model.addAttribute("board", boardVo2);
		
		
		return "board/boardUpdateForm";
		
	}
	
	@RequestMapping(value = "/board/boardUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public String boardUpdate(BoardVo boardVo, Model model) throws Exception{
		
		HashMap<String, String> result = new HashMap<String, String>(); 
		CommonUtil commonUtil = new CommonUtil();
		
		int resultCnt= boardService.boardUpdate(boardVo);
		
		result.put("success", (resultCnt > 0)?"Y":"N"); 
		String callbackMsg = CommonUtil.getJsonCallBackString(" ", result);
		  
		System.out.println("callbackMsg::" + callbackMsg); 
		return callbackMsg;
		
	}
	
	
	@RequestMapping(value = "/board/boardDelete.do", method = RequestMethod.GET)
	@ResponseBody
	public String boardDelete(Locale locale,BoardVo boardVo, Model model) throws Exception{
		
		logger.info("delete");
		
	
		
		
		  HashMap<String, String> result = new HashMap<String, String>(); 
		  CommonUtil commonUtil = new CommonUtil();
		 
		  
		  int resultCnt = boardService.boardDelete(boardVo.getBoardNum());
		  
		 System.out.println("rscnt "+resultCnt);
			
			  result.put("success", (resultCnt > 0)?"Y":"N"); 
			  String callbackMsg = CommonUtil.getJsonCallBackString(" ", result);
			  
			  System.out.println("callbackMsg::" + callbackMsg); 
			  return callbackMsg;
			 
		 	
			/*
			 * if(resultCnt>0) { return "success"; } else { return "fail"; }
			 */
		
		
		
	}
	

	
	
}
