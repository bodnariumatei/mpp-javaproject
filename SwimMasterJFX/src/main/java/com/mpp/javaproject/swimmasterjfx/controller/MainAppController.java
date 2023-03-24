package com.mpp.javaproject.swimmasterjfx.controller;

import com.mpp.javaproject.swimmasterjfx.repository.ParticipantDbRepository;
import com.mpp.javaproject.swimmasterjfx.service.ContestService;
import javafx.fxml.FXML;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainAppController {
    ContestService srv;

    @FXML
    public void initialize() {
        Properties props=new Properties();
        try {
            props.load(new FileReader("db.properties"));
        } catch (IOException e) {
            System.out.println("Cannot find db.properties "+e);
        }
        ParticipantDbRepository pRepo=new ParticipantDbRepository(props);
        this.srv = new ContestService(pRepo);
    }
}
