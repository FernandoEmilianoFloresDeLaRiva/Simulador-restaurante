package org.example.simulador_restaurante.controllers;

import org.example.simulador_restaurante.components.ChefComponent;
import org.example.simulador_restaurante.components.FoodComponent;
import org.example.simulador_restaurante.models.ChefModel;

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
                    FoodComponent foodComponent = chefModel.takeOrder();
                    //chefComponent.mostrarCocinando(orden);
                    Thread.sleep(500); // Simula tiempo de cocción
                    chefModel.notifyFoodReady(foodComponent);
                    //chefComponent.mostrarComidaLista(orden);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

