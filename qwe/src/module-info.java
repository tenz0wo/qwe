module qwe {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires org.junit.jupiter.api;

	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
