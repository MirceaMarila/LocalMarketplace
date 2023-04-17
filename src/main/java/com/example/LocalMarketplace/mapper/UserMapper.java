package com.example.LocalMarketplace.mapper;

import com.example.LocalMarketplace.dto.UserDto;
import com.example.LocalMarketplace.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User UserDtoToUserMapper(UserDto userDto){
        User user = new User();

        user.setEmail(userDto.getEmail());
        user.setFarmer(userDto.getFarmer());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());

        return user;
    }
}
