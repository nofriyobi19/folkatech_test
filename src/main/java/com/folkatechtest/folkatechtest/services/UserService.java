package com.folkatechtest.folkatechtest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.folkatechtest.folkatechtest.helpers.UserMapper;
import com.folkatechtest.folkatechtest.models.User;
import com.folkatechtest.folkatechtest.models.dtos.ApplicationUserDetail;
import com.folkatechtest.folkatechtest.models.dtos.UserDto;
import com.folkatechtest.folkatechtest.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(username);
        if (user == null) throw new UsernameNotFoundException("username or password is wrong");
        return new ApplicationUserDetail(user);
    }

    public UserDto saveUser(UserDto userDto) {
        var user = userRepository.save(UserMapper.toUser(userDto));
        return UserMapper.toUserDto(user);
    }
}
