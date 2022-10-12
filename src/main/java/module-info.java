module com.code.db {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.postgresql.jdbc;
    requires java.sql;

    opens com.code.db to javafx.fxml;
    exports com.code.db;
}