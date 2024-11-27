package org.example.simulador_restaurante.controllers;

import javafx.application.Platform;
import javafx.util.Duration;
import org.example.simulador_restaurante.components.ChefComponent;
import org.example.simulador_restaurante.components.FoodComponent;
import org.example.simulador_restaurante.models.ChefModel;

import static com.almasb.fxgl.dsl.FXGLForKtKt.run;

public class ChefController {
    private final ChefModel chefModel;
    private final ChefComponent chefComponent;

    public ChefController(ChefModel model, ChefComponent view) {
        this.chefModel = model;
        this.chefComponent = view;
    }

    public void cook() {
        new Thread(() -> {
            try {
                while (true) {
                    if (!chefModel.areOrdersEmpty()){
                        FoodComponent foodComponent = chefModel.takeOrder();
                        run(() -> {
                            double currentProgress = chefComponent.getProgress().get() + 10;
                            chefComponent.updateProgress(Math.min(currentProgress, 100));
                            if(currentProgress == 100){
                                chefComponent.updateProgress(0);
                            }
                            return null;
                        }, Duration.seconds(2));
                        Platform.runLater(() -> foodComponent.spawnFood(40, -50));
                        System.out.println(foodComponent);
                        chefModel.notifyFoodReady(foodComponent);
                    }
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

