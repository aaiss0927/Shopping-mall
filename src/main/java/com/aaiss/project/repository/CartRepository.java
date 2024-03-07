package com.aaiss.project.repository;

import com.aaiss.project.dto.BoardDTO;
import com.aaiss.project.dto.MemberDTO;
import com.aaiss.project.dto.ProductDTO;
import com.aaiss.project.dto.CartDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CartRepository {
    private final SqlSessionTemplate sql;

    public int save(CartDTO cartDTO) {
        return sql.insert("Cart.save", cartDTO);
    }

    public void delete(Long id) {
        sql.delete("Cart.delete", id);
    }

    public List<CartDTO> findByLoginId(String loginId) {
        return sql.selectList("Cart.findByLoginId", loginId);
    }
}