package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Database;
import models.Client;


public class ClientDAO {    
	public boolean userExists(String login) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE login_user = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, login);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

	public void registerUser(Client client) throws SQLException {
	    if (userExists(client.getLogin())) {
	        throw new SQLException("User already exists", "23000", 1062); // Use SQLState and vendorCode for duplicate entry
	    }
	    String query = "INSERT INTO users (fio, phone, login_user, password_user, type_manager) VALUES (?, ?, ?, ?, ?)";
	    try (Connection conn = Database.getConnection(); 
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setString(1, client.getFio());
	        stmt.setString(2, client.getPhone());
	        stmt.setString(3, client.getLogin());
	        stmt.setString(4, client.getPassword());
	        stmt.setString(5, "user"); // Default role for new users
	        stmt.executeUpdate();
	    }
	}
    
    public boolean authenticateUser(Client client) throws SQLException {
        String query = "SELECT * FROM users WHERE login_user = ? AND password_user = ?";
        try (Connection conn = Database.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, client.getLogin());
            stmt.setString(2, client.getPassword());  
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();  
            }
        }
    }

    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM clients";
        try (Connection conn = Database.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query); 
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setLogin(query);
                client.setPassword(rs.getString("password"));
                clients.add(client);
            }
        }
        return clients;
    }

}
