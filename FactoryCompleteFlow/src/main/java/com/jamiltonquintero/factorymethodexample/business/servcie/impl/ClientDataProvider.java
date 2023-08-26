package com.jamiltonquintero.factorymethodexample.business.servcie.impl;

import com.jamiltonquintero.factorymethodexample.business.servcie.DataProvider;
import com.jamiltonquintero.factorymethodexample.domain.entity.Client;
import com.jamiltonquintero.factorymethodexample.persistance.ClientRepository;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientDataProvider implements DataProvider<Client> {


    private final ClientRepository clientRepository;

    public ClientDataProvider(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ReportTypeEnum getType() {
        return ReportTypeEnum.CLIENT;
    }

    @Override
    public List<Client> getData() {
        return clientRepository.findAll();
    }
}
