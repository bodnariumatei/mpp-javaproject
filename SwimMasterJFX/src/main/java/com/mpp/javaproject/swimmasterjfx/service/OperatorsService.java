package com.mpp.javaproject.swimmasterjfx.service;

import com.mpp.javaproject.swimmasterjfx.domain.Operator;
import com.mpp.javaproject.swimmasterjfx.repository.OperatorsDbRepository;

public class OperatorsService {
    private OperatorsDbRepository repo;

    public OperatorsService(OperatorsDbRepository repo) {
        this.repo = repo;
    }

    public Operator get_operator_by_username(String username){
        return repo.getOneByUsername(username);
    }
}
