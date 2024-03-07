package com.aaiss.project.service;

import com.aaiss.project.dto.MemberDTO;
import com.aaiss.project.dto.PageDTO;
import com.aaiss.project.dto.ProductDTO;
import com.aaiss.project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository ProductRepository;

    public List<ProductDTO> findCsv() {
        return ProductRepository.findCsv();
    }

    public List<ProductDTO> findMod() {
        return ProductRepository.findMod();
    }

    public List<ProductDTO> findLiquid() {
        return ProductRepository.findLiquid();
    }

    public List<ProductDTO> findSub() {
        return ProductRepository.findSub();
    }

    public ProductDTO findBySku(int productSku) {
        return ProductRepository.findBySku(productSku);
    }

    public List<ProductDTO> findAll() {
        return ProductRepository.findAll();
    }

    public void delete(Long productSku) {
        ProductRepository.delete(productSku);
    }

    int pageLimit = 10; // 한 페이지당 보여줄 글 갯수
    int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수
    public List<ProductDTO> pagingList(int page) {
        int pagingStart = (page - 1) * pageLimit;
        Map<String, Integer> pagingParams = new HashMap<>();
        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", pageLimit);
        List<ProductDTO> pagingList = ProductRepository.pagingList(pagingParams);

        return pagingList;
    }

    public PageDTO pagingParam(int page) {
        // 전체 글 갯수 조회
        int productCount = ProductRepository.productCount();
        // 전체 페이지 갯수 계산(10/3=3.33333 => 4)
        int maxPage = (int) (Math.ceil((double) productCount / pageLimit));
        // 시작 페이지 값 계산(1, 4, 7, 10, ~~~~)
        int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;
        // 끝 페이지 값 계산(3, 6, 9, 12, ~~~~)
        int endPage = startPage + blockLimit - 1;
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartPage(startPage);
        pageDTO.setEndPage(endPage);
        return pageDTO;
    }
}









