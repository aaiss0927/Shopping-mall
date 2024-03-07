package com.aaiss.project.repository;

import com.aaiss.project.dto.BoardDTO;
import com.aaiss.project.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;
    public int signup(MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        return sql.insert("Member.signup", memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login", memberDTO);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findById(Long manage_id) {
        return sql.selectOne("Member.findById", manage_id);
    }

    public void delete(Long manage_id) {
        sql.delete("Member.delete", manage_id);
    }

    public MemberDTO findByMemberId(String loginId) {
        return sql.selectOne("Member.findByMemberId", loginId);
    }

    public int update(MemberDTO memberDTO) {
        return sql.update("Member.update", memberDTO);
    }

    public List<MemberDTO> pagingList(Map<String, Integer> pagingParams) {
        return sql.selectList("Member.pagingList", pagingParams);
    }

    public int memberCount() {
        return sql.selectOne("Member.memberCount");
    }

}