package application;

import java.sql.SQLException;

import DAO.RequestDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Request;

public class EditRequestController {

    @FXML
    private TextField requestIDField;

    @FXML
    private TextField newStatusField;

    @FXML
    private TextArea newProblemDescriptionArea;

    @FXML
    private TextField newResponsibleField;

    // Метод обработки нажатия кнопки для сохранения изменений в заявке
    @FXML
    private void handleSaveChangesButtonAction() {
        // Создаем объект Request с новыми данными для заявки
        Request request = new Request();
        request.setId(Integer.parseInt(requestIDField.getText()));
        request.setRequestStatus(newStatusField.getText());
        request.setProblemDescription(newProblemDescriptionArea.getText());
        // Предположим, что newResponsibleField содержит ID нового ответственного
        request.setMasterID(Integer.parseInt(newResponsibleField.getText()));
        // Обновляем заявку в базе данных
        try {
            RequestDAO requestDAO = new RequestDAO();
            requestDAO.editRequest(request);
            System.out.println("Заявка успешно отредактирована!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
