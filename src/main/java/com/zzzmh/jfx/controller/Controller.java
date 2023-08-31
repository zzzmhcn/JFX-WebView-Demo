package com.zzzmh.jfx.controller;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Controller {

    /**
     * 获取后端数据
     */
    public String getData() {
        // 这里假装去数据库查询了一套json数据
        return "{\"name\":\"张三\",\"age\":9}";
    }

    /**
     * 新开一个窗口
     */
    public void open() {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.load(Controller.class.getResource(
                "/com/zzzmh/jfx/html/new.html").toExternalForm());

        Scene scene = new Scene(webView, 400, 280);
        Stage stage = new Stage();
        stage.setTitle("新开页面");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * 彻底退出程序
     */
    public void exit(){
        Platform.exit();
    }
}