module io.sanctusfides.todojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;


    opens io.sanctusfides.todojavafx to javafx.fxml;
    exports io.sanctusfides.todojavafx;
    exports io.sanctusfides.todojavafx.Controller;
    opens io.sanctusfides.todojavafx.Controller to javafx.fxml;
}