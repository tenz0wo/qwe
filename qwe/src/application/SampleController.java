package application;

import DAO.ClientDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Client;

public class SampleController {
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;

    @FXML
    private void handleSubmitButtonAction() {
        String login = loginField.getText();
        String password = passwordField.getText();
//
        Client client = new Client(login, password);
        
        ClientDAO clientDAO = new ClientDAO();
        try {
        	System.out.println(login + password);
            if (clientDAO.authenticateUser(client)) {
                System.out.println("Client auth successfully!");
                handleSuccessfullyAuthButtonAction();
            } else {
            System.out.println("bad request");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleRegisterButtonAction() {
        try {
            Stage currentStage = (Stage) loginField.getScene().getWindow();
            currentStage.close();
            
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.setScene(new Scene(root, 400, 400));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleSuccessfullyAuthButtonAction() {
        try {
            Stage currentStage = (Stage) loginField.getScene().getWindow();
            currentStage.close();
            
            Parent root = FXMLLoader.load(getClass().getResource("addrequest.fxml"));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root, 800, 400));
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


