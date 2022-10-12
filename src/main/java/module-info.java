module com.code.db {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.code.db to javafx.fxml;
    exports com.code.db;
}