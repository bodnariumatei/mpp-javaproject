module com.mpp.javaproject.swimmasterjfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.apache.logging.log4j;

    opens com.mpp.javaproject.swimmasterjfx to javafx.fxml;
    exports com.mpp.javaproject.swimmasterjfx;
    exports com.mpp.javaproject.swimmasterjfx.controller;
    opens com.mpp.javaproject.swimmasterjfx.controller to javafx.fxml;
}