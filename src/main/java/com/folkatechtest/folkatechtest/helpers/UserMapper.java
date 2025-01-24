package com.folkatechtest.folkatechtest.helpers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.folkatechtest.folkatechtest.models.User;
import com.folkatechtest.folkatechtest.models.dtos.UserDto;

public class UserMapper {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhone(user.getPhone());
        return userDto;
    }
}
