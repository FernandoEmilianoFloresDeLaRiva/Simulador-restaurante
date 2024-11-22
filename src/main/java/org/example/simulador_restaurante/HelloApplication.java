package org.example.simulador_restaurante;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import org.example.simulador_restaurante.config.BackgroundInit;
import org.example.simulador_restaurante.config.GameConfig;

public class HelloApplication extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
        GameConfig.applySettings(settings);
    }

    @Override
    protected void initGame() {
        BackgroundInit.initializeBackground();
    }

    public static void main(String[] args) {
        launch(args);
    }


}