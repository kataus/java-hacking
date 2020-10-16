package ru.itvitality.education.jh.sqlinj.dto;

import lombok.Value;

@Value
public class User {
    private Integer id;
    private String name;
    private String password;
}
