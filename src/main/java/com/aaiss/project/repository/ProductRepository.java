package com.aaiss.project.repository;

import com.aaiss.project.dto.MemberDTO;
import com.aaiss.project.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final SqlSessionTemplate sql;

    public List<ProductDTO> findCsv() {
        return sql.selectList("Product.findCsv");
    }

    public List<ProductDTO> findMod() {
        return sql.selectList("Product.findMod");
    }

    public List<ProductDTO> findLiquid() {
        return sql.selectList("Product.findLiquid");
    }

    public List<ProductDTO> findSub() {
        return sql.selectList("Product.findSub");
    }

    public ProductDTO findBySku(int productSku) {
        return sql.selectOne("Product.findBySku", productSku);
    }

    public List<ProductDTO> findAll() {
        return sql.selectList("Product.findAll");
    }

    public void delete(Long productSku) {
        sql.delete("Product.delete", productSku);
    }

    public List<ProductDTO> pagingList(Map<String, Integer> pagingParams) {
        return sql.selectList("Product.pagingList", pagingParams);
    }

    public int productCount() {
        return sql.selectOne("Product.productCount");
    }

}