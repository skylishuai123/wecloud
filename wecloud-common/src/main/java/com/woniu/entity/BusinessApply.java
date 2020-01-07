package com.woniu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessApply implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    @Pattern(regexp = "\\w{2,3}",message = "账号需2到3")
    private String account;
    private String password;
    private String name;
    private String jointime;
    private int state;
    @Pattern(regexp = "\\d{11}",message = "请输入11位的1手机号")
    private String phone;

}
