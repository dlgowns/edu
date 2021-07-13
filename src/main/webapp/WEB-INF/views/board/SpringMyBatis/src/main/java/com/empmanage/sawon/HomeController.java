package com.empmanage.sawon;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.empmanage.sawon.service.SawonService;
import com.empmanage.sawon.vo.SawonVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SawonService service;
	
	/*
	  @ModelAttribute가 하는일
	  sawonVO bean객체가 만들어지고, 넘어오는 값은 자동으로 받아
	  sawonVO객체가 Model을 통해 jsp로 전달됨
	  jsp에서는 @ModelAttribute("SawonVO")의 sawonVO를 사용하여
	  jstl의 ${sawonVO.id}로 출력해서 사용함
	 */
	
	@GetMapping("/sawonAll.do")
	public String sawonAll(Model model) throws Exception {
		ArrayList<SawonVO> list = service.getAllSawon();
		model.addAttribute("alist",list);
		return "sawonAll";
	}
	
	@GetMapping("/getTelinfo.do")
	public String sawonGetTelinfo(SawonVO sawonVO, Model model) {
		SawonVO vo1 = service.getOneSawon(sawonVO);
		model.addAttribute("sawonVO", vo1);
		return "sawonOne";
	}
	
	@GetMapping("/sawonInsertForm.do")
	public String sawonInsertForm(@ModelAttribute("sawonVO") SawonVO sawonVO, Model model) throws Exception{
		return "sawonInsertForm";
	}
	
	@PostMapping("/sawonInsert.do")
	public String sawonInsert(@ModelAttribute("sawonVO") SawonVO sawonVO, Model model) {
		service.insertSawon(sawonVO);
		return "redirect:/sawonAll.do";
	}
	
	
	@PostMapping("/updateTelinfo.do")
	public String sawonUpdateTelinfo(SawonVO sawonVO, Model model) throws Exception{
		service.updateSawon(sawonVO);
		return "redirect:/sawonAll.do";
	}
	
	@GetMapping("/deleteTelinfo.do")
	public String sawonDeleteTelinfo(SawonVO sawonVO, Model model) throws Exception{
		service.deleteSawon(sawonVO);
		return "redirect:/sawonAll.do";
	}
}
