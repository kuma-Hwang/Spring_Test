package com.company.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.dto.MemberDTO;
import com.company.service.MemberService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberSerivce;
	
	
	 @GetMapping("/")
	  public String findAll(Model model){
	    List<MemberDTO> memberDTOList = memberSerivce.findAll();
	    model.addAttribute("memberList", memberDTOList);
	    return "list";
	  }
	
	@GetMapping("/save")
	public String saveForm() {
		return "save";
	}

	@PostMapping("/save")
	  public String save(@ModelAttribute MemberDTO memberDTO){
	    int saveResult = memberSerivce.save(memberDTO);
	    if(saveResult > 0){
	      return "login";
	    }else{
	      return "save";
	    }
	}
	
	@GetMapping("login")
	  public String loginForm(){
	    return "login";
	  }

		
	@PostMapping("/login") 
	public String login(@ModelAttribute MemberDTO
		memberDTO, HttpSession session){ boolean loginResult =
		memberSerivce.login(memberDTO); if(loginResult){
		session.setAttribute("loginId", memberDTO.getMemberId()); 
		return "main"; }else{ return "login"; } }
	
/*
 * @GetMapping("/detail") public String findById(@RequestParam("id") Long id,
 * Model model){ MemberDTO memberDTO = memberSerivce.findById(id);
 * model.addAttribute("member", memberDTO); return "detail"; }
 */
	@GetMapping
	  public String findById(@RequestParam("id") Long id, Model model){
	    MemberDTO memberDTO = memberSerivce.findById(id);
	    model.addAttribute("member", memberDTO);
	    return "detail";
	  }
	
	@GetMapping("/delete")
	  public String delete(@RequestParam("id") Long id){
	    memberSerivce.delete(id);
	    return "redirect:/member/";
	  }
	
	// 수정화면 요청
//	  @GetMapping("/update")
//	  public String updateFrom(HttpSession session, Model model){
//	    //세션에 저장된 나의 아이디 가져오기
//		Long loginId = (Long) session.getAttribute("loginId");
//	    MemberDTO memberDTO = memberSerivce.findByMemberId(loginId);
//	    model.addAttribute("member", memberDTO);
//	    return "update";
//	  }
	
	@GetMapping("/update")
	public String updateFrom(HttpSession session, Model model) {
	    // 세션에서 "loginId" 값을 가져오고, 이를 Long 타입으로 변환
	    String loginIdStr = (String) session.getAttribute("loginId");
	    
	    if (loginIdStr == null) {
	        return "redirect:/member/login"; // 로그인하지 않았다면 로그인 페이지로 리다이렉트
	    }

	    try {
	        Long loginId = Long.parseLong(loginIdStr);  // String을 Long으로 변환
	        MemberDTO memberDTO = memberSerivce.findByMemberId(loginId);
	        model.addAttribute("member", memberDTO);
	        return "update";
	    } catch (NumberFormatException e) {
	        // loginId 값이 숫자로 변환되지 않으면 로그인 페이지로 리다이렉트
	        return "redirect:/member/login";
	    }
	}
	
	 @PostMapping("/update")
	  public String update(@ModelAttribute MemberDTO memberDTO){
	    boolean result = memberSerivce.update(memberDTO);
	    if(result){
	      return "redirect:/member?id=" + memberDTO.getMemberId();
	    }else{
	      return "index";
	    }
	 }
	 
	 @GetMapping("/logout")
	  public String logout(){
	    return "logout";
	  }	
		 
}
