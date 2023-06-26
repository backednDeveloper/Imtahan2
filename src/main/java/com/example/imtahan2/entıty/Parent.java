package com.example.imtahan2.entıty;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
@Getter
@Setter
public class Parent {
    private BigInteger id;
    private String name;
    private String surname;
    private Date birth_date;
    private String job_name;
}
