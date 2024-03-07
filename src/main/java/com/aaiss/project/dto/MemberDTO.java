package com.aaiss.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    private Long manage_id;
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberEmail;
    private String memberTel;
    private String memberSex;
    private int memberPoint;
    private String memberZip;
    private String memberAddr1;
    private String memberAddr2;
    private String memberIsAdmin;
}