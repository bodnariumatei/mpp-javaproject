package com.mpp.javaproject.swimmasterjfx;

import com.mpp.javaproject.swimmasterjfx.domain.Participant;
import com.mpp.javaproject.swimmasterjfx.repository.participant.ParticipantDbRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;


public class SwimMasterMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SwimMasterMain.class.getResource("login_scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
