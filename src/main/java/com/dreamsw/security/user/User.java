package com.dreamsw.security.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Daniel
 * @Date 06/04/2023
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

}
