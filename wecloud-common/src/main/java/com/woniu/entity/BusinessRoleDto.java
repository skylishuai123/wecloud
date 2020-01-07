package com.woniu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRoleDto {
    private List<Bussiness> bussiness;
    private int  totpage;
    private int nowpage;
    private int totcount;
}
