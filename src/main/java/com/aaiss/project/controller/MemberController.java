package com.aaiss.project.controller;

import com.aaiss.project.dto.BoardDTO;
import com.aaiss.project.dto.MemberDTO;
import com.aaiss.project.dto.PageDTO;
import com.aaiss.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @GetMapping("/member/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/member/signup")
    public String signup(@ModelAttribute MemberDTO memberDTO) {
        int saveResult = memberService.signup(memberDTO);
        if (saveResult > 0) {
            return "redirect:/project/main";
        } else {
            return "signup";
        }
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO,
                        HttpSession session) {
        int loginResult = memberService.login(memberDTO);
        if (loginResult != 0) {
            session.setAttribute("loginId", memberDTO.getMemberId());
            if (loginResult == 2) {
                session.setAttribute("isAdmin", true);
                return "redirect:/admin";
            }
            return "redirect:/project/main";
        }

        else {
            return "login";
        }
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    //회원목록 조회 <- 관리자 페이지

    @GetMapping("/admin/member/paging")
    public String paging(Model model,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        List<MemberDTO> pagingList = memberService.pagingList(page);
        PageDTO pageDTO = memberService.pagingParam(page);
        model.addAttribute("memberList", pagingList);
        model.addAttribute("paging", pageDTO);
        return "admin_member";
    }

    //회원정보 조회 <- 관리자 페이지
    // /member?id=1


    @GetMapping("/member/delete")
    public String delete(@RequestParam("manage_id") Long manage_id) {
        memberService.delete(manage_id);
        return "redirect:/project/main";
    }

    @GetMapping("/admin/member/delete")
    public String delete_(@RequestParam("manage_id") Long manage_id) {
        memberService.delete(manage_id);
        return "redirect:/admin/member/paging";
    }

    //회원정보 수정 <- 마이페이지
    // 수정화면 요청
    @GetMapping("/member/update")
    public String updateForm(HttpSession session, Model model) {
        // 세션에 저장된 나의 이메일 가져오기
        String loginId = (String) session.getAttribute("loginId");
        MemberDTO memberDTO = memberService.findByMemberId(loginId);
        model.addAttribute("member", memberDTO);
        return "update";
    }

    // 수정 처리
    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        boolean result = memberService.update(memberDTO);
        if (result) {
            return "redirect:/member?id=" + memberDTO.getManage_id();
        } else {
            return "index";
        }
    }

    @PostMapping("/member/email-check")
    public @ResponseBody String emailCheck(@RequestParam("memberId") String memberId) {
        System.out.println("memberId = " + memberId);
        String checkResult = memberService.idCheck(memberId);
        return checkResult;
    }

    @GetMapping("/member/mypage")
    public String myPage() {
        return "mypage";
    }

}