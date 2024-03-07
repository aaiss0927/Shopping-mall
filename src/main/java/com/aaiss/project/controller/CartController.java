package com.aaiss.project.controller;

import com.aaiss.project.dto.BoardDTO;
import com.aaiss.project.dto.MemberDTO;
import com.aaiss.project.dto.ProductDTO;
import com.aaiss.project.dto.CartDTO;
import com.aaiss.project.service.CartService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/cart/add")
    public String save(@ModelAttribute CartDTO cartDTO) {
        int saveResult = cartService.save(cartDTO);
        if (saveResult > 0) {
            return "redirect:/cart";
        } else {
            return "redirect:/project/main";
        }
    }

    @GetMapping("/cart/delete")
    public String delete(@RequestParam("id") Long id) {
        cartService.delete(id);
        return "redirect:/cart/";
    }


    @GetMapping("/cart")
    public String findByLoginId(HttpSession session, Model model) {
        String loginId = (String) session.getAttribute("loginId");
        List<CartDTO> cartDTOList = cartService.findByLoginId(loginId);
        model.addAttribute("cartList", cartDTOList);
        return "cart";
    }
}