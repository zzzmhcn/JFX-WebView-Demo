module com.zzzmh.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires jdk.jsobject;

    opens com.zzzmh.jfx.controller to javafx.web;
    exports com.zzzmh.jfx;
}