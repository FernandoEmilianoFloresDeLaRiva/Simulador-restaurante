package org.example.simulador_restaurante.models;

import org.example.simulador_restaurante.components.ClientComponent;
import org.example.simulador_restaurante.components.FoodComponent;

public class WaiterModel {
    private final ChefModel chefModel;
    private boolean isBusy = false;

    public WaiterModel(ChefModel chefModel) {
        this.chefModel = chefModel;
    }

    public synchronized boolean isBusy() {
        return isBusy;
    }

    public synchronized void setIsBuzy(boolean ocupado) {
        isBusy = ocupado;
    }

    public void takeOrder(ClientComponent client) throws InterruptedException {
        FoodComponent order = new FoodComponent();
        System.out.println("Mesero toma la orden del cliente: " + client.getId());
        chefModel.addOrder(order);
    }

    public FoodComponent pickupFood() throws InterruptedException {
        return chefModel.getFoodDone();
    }
}

