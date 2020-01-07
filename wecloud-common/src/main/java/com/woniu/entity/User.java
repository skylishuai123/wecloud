package com.woniu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String account;
    private String password;
    private String email;
    private String name;
    private String premession;
    private String role;
    private String phone;
    private String idcard;
}
