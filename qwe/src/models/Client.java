package models;

public class Client {
    private int id;
    private String fio;
    private String phone;
    private String login;
    private String password;
    private String type;

    // Конструкторы, геттеры и сеттеры

    public Client() {
    }

    public Client(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Client(String login, String password, String fio, String phone, String type) {
        this.fio = fio;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
