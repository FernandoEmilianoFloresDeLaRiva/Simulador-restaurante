package org.example.simulador_restaurante.models;

import org.example.simulador_restaurante.components.FoodComponent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ChefModel {
    private final BlockingQueue<FoodComponent> queueOrders = new LinkedBlockingQueue<>();
    private final BlockingQueue<FoodComponent> queueFoodDone = new LinkedBlockingQueue<>();

    public void addOrder(FoodComponent order) throws InterruptedException {
        queueOrders.put(order);
    }

    public FoodComponent takeOrder() throws InterruptedException {
        return queueOrders.take();
    }

    public void notifyFoodReady(FoodComponent order) throws InterruptedException {
        queueFoodDone.put(order);
    }

    public FoodComponent getFoodDone() throws InterruptedException {
        return queueFoodDone.take();
    }
}
