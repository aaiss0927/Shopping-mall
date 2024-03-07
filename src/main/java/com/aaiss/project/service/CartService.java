package com.aaiss.project.service;

import com.aaiss.project.dto.BoardDTO;
import com.aaiss.project.dto.MemberDTO;
import com.aaiss.project.dto.CartDTO;
import com.aaiss.project.dto.ProductDTO;
import com.aaiss.project.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public int save(CartDTO cartDTO) {
        return cartRepository.save(cartDTO);
    }

    public void delete(Long id) {
        cartRepository.delete(id);
    }

    public List<CartDTO> findByLoginId(String loginId) {
        return cartRepository.findByLoginId(loginId);
    }
}