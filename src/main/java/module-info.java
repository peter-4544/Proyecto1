module mx.utng {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;          //<-----

    opens mx.utng.controller to javafx.fxml;
    opens mx.utng.model to javafx.base;
          //<---
    exports mx.utng;
    exports mx.utng.controller;             //<---
    exports mx.utng.model;  
}
