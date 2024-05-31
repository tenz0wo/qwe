package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Database;
import models.Request;

public class RequestDAO {
    public void addRequest(Request request) throws SQLException {
        String query = "INSERT \r\n"
        		+ "    INTO zayavki (requestID, startDate, homeTechType, problemDescryption, requestStatus, clientID) \r\n"
        		+ "    SELECT ?, ?, ?, ?, ?, u.userID\r\n"
        		+ "        FROM users u \r\n"
        		+ "    WHERE u.userID= ?\r\n"
        		+ "";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, request.getRequestID());
            stmt.setDate(2, request.getStartDate());
            stmt.setString(3, request.getHomeTechType());
            stmt.setString(4, request.getProblemDescryption());
            stmt.setString(5, request.getRequestStatus());
            stmt.setString(6, request.getClientID());

            stmt.executeUpdate();
        }
    }
    
    public void deleteData(int id) throws SQLException {
        String query = "DELETE FROM your_table_name WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    public List<Request> getAllRequests() throws SQLException {
        List<Request> requests = new ArrayList<>();
        String query = "select id, startDate, homeTechType, problemDescryption, requestStatus\n"
        		+ "from zayavki";
        try (Connection conn = Database.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while(rs.next()) {
                Request request = new Request();
                request.setRequestID(rs.getInt("id"));
                request.setStartDate(rs.getDate("startDate"));
                request.setHomeTechType(rs.getString("homeTechType"));
                request.setProblemDescription(rs.getString("problemDescryption"));
                request.setRequestStatus(rs.getString("requestStatus"));
                requests.add(request);
            }
        }
        return requests;
    }


    // Метод для редактирования существующей заявки в базе данных
    public void editRequest(Request request) throws SQLException {
        String query = "UPDATE zayavki SET requestStatus = ?, problemDescryption = ?, masterID = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, request.getRequestStatus());
            stmt.setString(2, request.getProblemDescryption());
            stmt.setInt(3, request.getMasterID());
            stmt.setInt(4, request.getId());
            stmt.executeUpdate();
        }
    }

}
