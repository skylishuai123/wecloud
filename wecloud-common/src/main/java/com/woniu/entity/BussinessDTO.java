package com.woniu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BussinessDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Bussiness> bussiness;
    private int totcount;
    private int page;
}
