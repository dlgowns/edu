package com.empmanage.sawon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empmanage.sawon.service.LoginService;
import com.empmanage.sawon.vo.TelLoginVO;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping(value = "/start.do")
	public String start() {
		return "sawonLogin";
	}
	
	@GetMapping(value = "/sawonJoinStart.do")
	public String sawonJoinStart() {
		return "sawonJoin";
	}
	
	@GetMapping(value = "/sawonLoginViewStart.do")
	public String sawonLoginViewStart() {
		return "sawonLoginView";
	}
	
	@PostMapping(value="/memberInsert.do")
	String memberInsert(TelLoginVO telLoginVO, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		boolean flag = loginService.memberInsert(telLoginVO);
		if(flag==true) {
			out.println("<script>alert(\"회원가입이 되셨습니다.\")</script>");
		} else {
			out.println("<script>alert(\"실패.\")</script>");
		}
		out.flush();
		return "sawonLogin";
	}
	
	@PostMapping(value="/memberLogin.do")
	String memberLogin(TelLoginVO telLoginVO, HttpSession session, HttpServletResponse res) throws Exception {
		TelLoginVO vo2= loginService.memberLogin(telLoginVO);
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out= res.getWriter();
		if(vo2.getId()==null || vo2.getPw()==null) {
			out.println("<script>alert(\"아이디나 비밀번호가 틀렸습니다.\")</script>");
			out.flush();
			return"sawonLogin";
		} else {
			out.println("<script>alert(\"로그인되었습니다.\")</script>");
			session.setAttribute("loginVO", vo2);
		}
		out.flush();
		return "sawonLoginView";
		
	}
	@GetMapping(value="/memberLogout.do")
	String memberLogout(TelLoginVO telLoginVO, HttpSession session, HttpServletResponse res) throws Exception {
		session.removeAttribute("loginVO");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out= res.getWriter();
		out.println("<script>alert(\"로그아웃되었습니다.\")</script>");
		out.flush();
		return "sawonLogin";
	}
	
	@GetMapping(value="/memberMypage.do")
	String memberMypage(TelLoginVO telLoginVO, Model model) throws Exception {
		model.addAttribute("mMypage", loginService.memberMypage(telLoginVO));
		return "sawonMypage";
	}
	
	@GetMapping(value="/memberDelete.do")
	String memberDelete(TelLoginVO telLoginVO, HttpSession session, HttpServletResponse res) throws Exception {
		session.removeAttribute("loginVO");
		boolean flag=loginService.memberDelete(telLoginVO);
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out=res.getWriter();
		if(flag==true) {
			out.println("<script>alert(\"탈퇴 되었습니다.\")</script>");
		} else {
			out.println("<script>alert(\"실패.\")</script>");
			out.flush();
			return "redirect:memberMypage.do";
		}
		out.flush();
		return "sawonLogin";
	}
	
	@PostMapping(value="/memberUpdate.do")
	public String memberUpdate(Model model, TelLoginVO telLoginVO, HttpSession session, HttpServletResponse res) throws Exception {
		boolean flag = loginService.memberUpdate(telLoginVO);
		model.addAttribute("mMypage",session.getAttribute("loginVO"));
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		if(flag==true) {
			out.println("<script>alert(\"수정 되었습니다.\")</script>");
		} else {
			out.println("<script>alert(\"실패.\")</script>");
		}
		out.flush();
		return "sawonLoginView";
	}
	
}
