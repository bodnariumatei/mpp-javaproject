package com.mpp.javaproject.swimmasterjfx.service;

import com.mpp.javaproject.swimmasterjfx.domain.Operator;
import com.mpp.javaproject.swimmasterjfx.repository.operator.OperatorsDbRepository;

public class OperatorsService {
    private OperatorsDbRepository repo;

    public OperatorsService(OperatorsDbRepository repo) {
        this.repo = repo;
    }

    public Operator getOperatorByUsername(String username){
        return repo.getOneByUsername(username);
    }
}
