package com.zzzmh.jfx;

import com.zzzmh.jfx.controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        Controller controller = new Controller();
        // 注入方法
        engine.getLoadWorker().stateProperty().addListener(
                (ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) -> {
                    if (newState == Worker.State.SUCCEEDED) {
                        // 获取JS的window对象
                        JSObject window = (JSObject) engine.executeScript("window");
                        // 讲controller注入到window对象中
                        window.setMember("controller", controller);
                    }
                });
        // 加载页面
        engine.load(Controller.class.getResource(
                "/com/zzzmh/jfx/html/index.html").toExternalForm());

        pane.setCenter(webView);
        Scene scene = new Scene(pane, 600, 400);
        stage.setTitle("JavaFX WebView Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}