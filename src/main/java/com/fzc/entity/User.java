package com.fzc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author fzc
 * @since 2020-05-09 09:20:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -57581102239328827L;

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String sex;

    private String perm;

    private String role;



}