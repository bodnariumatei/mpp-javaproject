package com.mpp.javaproject.swimmasterjfx.controller;

import com.mpp.javaproject.swimmasterjfx.repository.competition.CompetitionDbRepository;
import com.mpp.javaproject.swimmasterjfx.repository.participant.ParticipantDbRepository;
import com.mpp.javaproject.swimmasterjfx.service.ContestService;
import com.mpp.javaproject.swimmasterjfx.utils.tableview_items.CompetionTableItem;
import com.mpp.javaproject.swimmasterjfx.utils.tableview_items.ParticipantTableItem;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainAppController {
    ContestService srv;

    @FXML
    private TableView<CompetionTableItem> competitionsTableView;
    private TableView.TableViewSelectionModel<CompetionTableItem> selectionModel;
    @FXML
    private TableColumn<CompetionTableItem, String> styleColumn;
    @FXML
    private TableColumn<CompetionTableItem, String> distanceColumn;
    @FXML
    private TableColumn<CompetionTableItem, String> noParticipantsColumn;

    @FXML
    private TableView<ParticipantTableItem> participantsTableView;
    @FXML
    private TableColumn<ParticipantTableItem, String> nameColumn;
    @FXML
    private TableColumn<ParticipantTableItem, String> ageColumn;
    @FXML
    private TableColumn<ParticipantTableItem, String> competitionsColumn;


    @FXML
    public void initialize() {
        Properties props=new Properties();
        try {
            props.load(new FileReader("db.properties"));
        } catch (IOException e) {
            System.out.println("Cannot find db.properties "+e);
        }
        ParticipantDbRepository pRepo = new ParticipantDbRepository(props);
        CompetitionDbRepository cRepo = new CompetitionDbRepository(props);
        this.srv = new ContestService(pRepo, cRepo);

        setUpCompetitionsTable();
        loadCompetitionsTable();
    }

    private void setUpCompetitionsTable(){
        competitionsTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        styleColumn.setCellValueFactory(new PropertyValueFactory<>("style"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<>("distance"));
        noParticipantsColumn.setCellValueFactory(new PropertyValueFactory<>("noParticipants"));

        selectionModel = competitionsTableView.getSelectionModel();

        ObservableList<CompetionTableItem> selectedItems = selectionModel.getSelectedItems();

        selectedItems.addListener(
                (ListChangeListener<? super CompetionTableItem>) change -> {
                    loadParticipantsTable();
                });

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        competitionsColumn.setCellValueFactory(new PropertyValueFactory<>("competitions"));
    }

    private void loadCompetitionsTable(){
        competitionsTableView.getItems().clear();
        Iterable<CompetionTableItem> tableItems = srv.getCompetitionTableItems();
        for(CompetionTableItem cti : tableItems){
            competitionsTableView.getItems().add(cti);
        }
    }

    private void loadParticipantsTable() {
        CompetionTableItem cti = selectionModel.getSelectedItem();
        if(cti != null) {
            participantsTableView.getItems().clear();
            Iterable<ParticipantTableItem> tableItems = srv.getParticipantsFromCompetition(cti.getId());
            for(ParticipantTableItem pti : tableItems){
                participantsTableView.getItems().add(pti);
            }
        }
    }



}
