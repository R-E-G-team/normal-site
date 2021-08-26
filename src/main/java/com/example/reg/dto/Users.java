package com.example.reg.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_no_seq")
    @SequenceGenerator(sequenceName = "user_no_seq", allocationSize = 1, name = "user_no_seq" )
    private Long userNo;
    private String userId;
    private String userPassword;
    private String userName;
    private String roleName;

    public Long getUserNo() {
        return userNo;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
