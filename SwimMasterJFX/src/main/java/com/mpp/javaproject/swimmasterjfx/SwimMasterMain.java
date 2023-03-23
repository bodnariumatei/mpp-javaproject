package com.mpp.javaproject.swimmasterjfx;

import com.mpp.javaproject.swimmasterjfx.domain.Operator;
import com.mpp.javaproject.swimmasterjfx.repository.OperatorsDbRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SwimMasterMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Properties props=new Properties();
        try {
            props.load(new FileReader("db.properties"));
        } catch (IOException e) {
            System.out.println("Cannot find db.properties "+e);
        }

        OperatorsDbRepository opRepo=new OperatorsDbRepository(props);
        opRepo.store(new Operator("regeleShaman2002","toates_reale_toates_imaginare"));
        System.out.println("Operatorii aplicatiei: ");
        for(Operator op: opRepo.getAll())
            System.out.println(op);
        Operator operator = opRepo.getOneByUsername("regeleShaman2002");
        opRepo.delete(operator.getId());

        FXMLLoader fxmlLoader = new FXMLLoader(SwimMasterMain.class.getResource("login_scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
