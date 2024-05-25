package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Request;

import java.sql.Date;
import java.sql.SQLException;

import DAO.RequestDAO;

public class AddRequestController {

    @FXML
    private TextField requestIDField;

    @FXML
    private TextField startDateField;
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;

    @FXML
    private TextField homeTechTypeField;

    @FXML
    private TextArea problemDescriptionArea;

    @FXML
    private TextField requestStatusField;
    
    @FXML
    private TextField clientId;

    private RequestDAO requestDAO = new RequestDAO();

    // Метод обработки нажатия кнопки для добавления заявки
    @FXML
    private void handleAddRequestButtonAction() {
        // Создаем объект Request с данными из полей формы
        Request request = new Request();
        request.setRequestID(Integer.parseInt(requestIDField.getText()));
        // Преобразование строки с датой в объект java.sql.Date, предполагается, что у вас есть метод для этого в классе Request
        request.setStartDate(Date.valueOf(startDateField.getText()));
        request.setHomeTechType(homeTechTypeField.getText());
        request.setProblemDescription(problemDescriptionArea.getText());
        request.setRequestStatus(requestStatusField.getText());
        request.setClientID(clientId.getText());
        // Ваш клиент может быть найден из базы данных по имени и номеру телефона
        // После этого можно установить ID клиента для заявки
        // Например:
        // int clientID = clientDAO.getClientIDByNameAndPhone(clientNameField.getText(), clientPhoneField.getText());
        // request.setClientID(clientID);
        // После этого добавляем заявку в базу данных
        try {
        	requestDAO.addRequest(request);
            System.out.println("Заявка успешно добавлена!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleEditButtonAction() {
        try {
            Stage currentStage = new Stage();
            currentStage.close();
            
            Parent root = FXMLLoader.load(getClass().getResource("editrequest.fxml"));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root, 400, 400));
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleDeleteButtonAction() {
        try {
            Stage currentStage = new Stage();
            currentStage.close();
            
            Parent root = FXMLLoader.load(getClass().getResource("Sample3.fxml"));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root, 400, 400));
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
