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
	
	// ����ȭ�� ��û
//	  @GetMapping("/update")
//	  public String updateFrom(HttpSession session, Model model){
//	    //���ǿ� ����� ���� ���̵� ��������
//		Long loginId = (Long) session.getAttribute("loginId");
//	    MemberDTO memberDTO = memberSerivce.findByMemberId(loginId);
//	    model.addAttribute("member", memberDTO);
//	    return "update";
//	  }
	
	@GetMapping("/update")
	public String updateFrom(HttpSession session, Model model) {
	    // ���ǿ��� "loginId" ���� ��������, �̸� Long Ÿ������ ��ȯ
	    String loginIdStr = (String) session.getAttribute("loginId");
	    
	    if (loginIdStr == null) {
	        return "redirect:/member/login"; // �α������� �ʾҴٸ� �α��� �������� �����̷�Ʈ
	    }

	    try {
	        Long loginId = Long.parseLong(loginIdStr);  // String�� Long���� ��ȯ
	        MemberDTO memberDTO = memberSerivce.findByMemberId(loginId);
	        model.addAttribute("member", memberDTO);
	        return "update";
	    } catch (NumberFormatException e) {
	        // loginId ���� ���ڷ� ��ȯ���� ������ �α��� �������� �����̷�Ʈ
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
