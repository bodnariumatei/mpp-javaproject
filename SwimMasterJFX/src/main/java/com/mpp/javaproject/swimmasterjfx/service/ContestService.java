package com.mpp.javaproject.swimmasterjfx.service;

import com.mpp.javaproject.swimmasterjfx.repository.ParticipantDbRepository;

public class ContestService {
    private ParticipantDbRepository pRepo;

    public ContestService(ParticipantDbRepository pRepo) {
        this.pRepo = pRepo;
    }
}
