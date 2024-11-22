package org.example.simulador_restaurante.config;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;

public class BackgroundInit {
    public static void initializeBackground() {
        getGameScene().setBackgroundRepeat("wood_floor.jpg");
    }
}
