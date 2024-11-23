package org.example.simulador_restaurante.config;

import com.almasb.fxgl.app.GameSettings;

public class GameConfig {
    public static void applySettings(GameSettings settings) {
        settings.setWidth(ConstantsConfig.WINDOW_WIDTH);
        settings.setHeight(ConstantsConfig.WINDOW_HEIGTH);
        settings.setTitle("Simulador Restaurante :D");
    }
}
