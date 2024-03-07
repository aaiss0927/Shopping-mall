package com.aaiss.project.controller;

import com.aaiss.project.dto.MemberDTO;
import com.aaiss.project.dto.PageDTO;
import com.aaiss.project.dto.ProductDTO;
import com.aaiss.project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product/product_csv")
    public String findCsv(Model model) {
        List<ProductDTO> productDTOList = productService.findCsv();
        model.addAttribute("productList", productDTOList);
        return "product_csv";
    }

    @GetMapping("/product/product_mod")
    public String findMod(Model model) {
        List<ProductDTO> productDTOList = productService.findMod();
        model.addAttribute("productList", productDTOList);
        return "product_mod";
    }

    @GetMapping("/product/product_liquid")
    public String findLiquid(Model model) {
        List<ProductDTO> productDTOList = productService.findLiquid();
        model.addAttribute("productList", productDTOList);
        return "product_liquid";
    }

    @GetMapping("/product/subscribe")
    public String findSub(Model model) {
        List<ProductDTO> productDTOList = productService.findSub();
        model.addAttribute("productList", productDTOList);
        return "subscribe";
    }

    // /member?id=1
    @GetMapping("/product")
    public String findBySku(@RequestParam("productSku") int productSku, Model model) {
        ProductDTO productDTO = productService.findBySku(productSku);
        model.addAttribute("product", productDTO);
        return "product_detail";
    }

    @GetMapping("/product/product_all_1")
    public String findAll(Model model) {
        List<ProductDTO> productDTOList = productService.findAll();
        model.addAttribute("productList", productDTOList);
        return "product_all_1";
    }

    @GetMapping("/product/delete")
    public String delete(@RequestParam("productSku") Long productSku) {
        productService.delete(productSku);
        return "redirect:/admin/product/paging";
    }

    @GetMapping("/product/product_detail")
    public String detail() {
        return "product_detail";
    }

    @GetMapping("/admin/product/paging")
    public String paging(Model model,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        List<ProductDTO> pagingList = productService.pagingList(page);
        PageDTO pageDTO = productService.pagingParam(page);
        model.addAttribute("productList", pagingList);
        model.addAttribute("paging", pageDTO);
        return "admin_product";
    }
}