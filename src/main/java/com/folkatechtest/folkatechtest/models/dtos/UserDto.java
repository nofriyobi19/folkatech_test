package com.folkatechtest.folkatechtest.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}
