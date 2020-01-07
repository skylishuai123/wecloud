package com.woniu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bussiness implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String account;
    private String name;
    private String password;
    private String role;
    private String premession;
    public String phone;
    public String jointime;
    private int state;

}
