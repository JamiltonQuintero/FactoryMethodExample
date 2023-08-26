package com.jamiltonquintero.factorymethodexample.business.service;

import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;

import java.util.List;

public interface DataProvider<T> {
    ReportTypeEnum getType();
    List<T> getData();
}
