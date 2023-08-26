package com.jamiltonquintero.factorymethodexample.business.servcie.impl;

import com.jamiltonquintero.factorymethodexample.domain.entity.User;
import com.jamiltonquintero.factorymethodexample.persistance.UserRepository;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import com.jamiltonquintero.factorymethodexample.business.servcie.DataProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataProvider implements DataProvider<User> {

    private final UserRepository userRepository;

    public UserDataProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ReportTypeEnum getType() {
        return ReportTypeEnum.USER;
    }

    @Override
    public List<User> getData() {
        return userRepository.findAll();
    }
}
