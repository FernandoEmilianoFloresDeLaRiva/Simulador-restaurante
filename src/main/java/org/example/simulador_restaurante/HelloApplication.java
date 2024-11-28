package org.example.simulador_restaurante;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import org.example.simulador_restaurante.config.InitGame;
import org.example.simulador_restaurante.config.GameConfig;
import org.example.simulador_restaurante.controllers.ManagerController;

public class HelloApplication extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
        GameConfig.applySettings(settings);
    }

    @Override
    protected void initGame() {
        InitGame _initGame = new InitGame();
        _initGame.runGame();
    }

    public static void main(String[] args) {
        launch(args);
    }

}