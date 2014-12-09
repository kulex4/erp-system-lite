package com.erpsystem.controller;

import com.erpsystem.dao.*;
import com.erpsystem.model.Company;
import com.erpsystem.model.Competence;
import com.erpsystem.model.Education;
import com.erpsystem.model.Specialist;
import com.erpsystem.utils.TableViewObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created on 07.12.2014.
 */
public class SpecialistController implements Initializable {

    private CompanyDao companyDao;
    private SpecialistDao specialistDao;
    private EducationDao educationDao;
    private CompetenceDao competenceDao;

    private boolean selected = false;

    private Company currentCompany;
    private ObservableList<TableViewObject> specialistsData = FXCollections.observableArrayList();

    @FXML
    private Button backButton;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button modifyButton;

    @FXML
    private Button moreInfoButton;

    @FXML
    private TableView<TableViewObject> tableSpecialists;

    @FXML
    private TableColumn<TableViewObject, String> fioColumn;

    @FXML
    private TableColumn<TableViewObject, String> educationColumn;

    @FXML
    private TableColumn<TableViewObject, Integer> responsibilityColumn;

    @FXML
    private TableColumn<TableViewObject, Integer> competenceColumn;

    @FXML
    private TableColumn<TableViewObject, Integer> communicabilityColumn;

    public SpecialistController() {
        companyDao = new CompanyDaoImpl();
        specialistDao = new SpecialistDaoImpl();
        educationDao = new EducationDaoImpl();
        competenceDao = new CompetenceDaoImpl();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTableData();

        if(!selected) {
            deleteButton.setDisable(true);
            modifyButton.setDisable(true);
            moreInfoButton.setDisable(true);
        }

        fioColumn.setCellValueFactory(new PropertyValueFactory<TableViewObject, String>("fio"));
        educationColumn.setCellValueFactory(new PropertyValueFactory<TableViewObject, String>("education"));
        responsibilityColumn.setCellValueFactory(new PropertyValueFactory<TableViewObject, Integer>("responsibility"));
        competenceColumn.setCellValueFactory(new PropertyValueFactory<TableViewObject, Integer>("competence"));
        communicabilityColumn.setCellValueFactory(new PropertyValueFactory<TableViewObject, Integer>("communicability"));

        tableSpecialists.setItems(specialistsData);
    }

    private void initTableData() {
        currentCompany = companyDao.findByName("ОАО \"НЛМК\"");
        List<Specialist> specialists = specialistDao.findAllByCompanyId(currentCompany.getIdCompany());

        for(Specialist specialist : specialists) {
            Education education = educationDao.findById(specialist.getIdEducation());
            Competence competence = competenceDao.findById(specialist.getIdEducation());

            TableViewObject tableViewObject = new TableViewObject(
                    specialist.getFio(),
                    education.getName(),
                    competence.getResponsibility(),
                    competence.getCompetence(),
                    competence.getCommunicability());
            specialistsData.add(tableViewObject);
        }
    }

    @FXML
    private void addButtonClick(ActionEvent event) {

    }

    @FXML
    private void deleteButtonClick(ActionEvent event) {

    }

    @FXML
    private void modifyButtonClick(ActionEvent event) {

    }

    @FXML
    private void moreInfoButtonClick(ActionEvent event) {

    }

    @FXML
    private void backButtonClick(ActionEvent event) {
        SceneNavigator.loadScene(SceneNavigator.START_SCENE);
    }
}
