package org.example.simulador_restaurante.controllers;

import org.example.simulador_restaurante.components.ClientComponent;
import org.example.simulador_restaurante.components.FoodComponent;
import org.example.simulador_restaurante.components.WaiterComponent;
import org.example.simulador_restaurante.models.ReceptionistModel;
import org.example.simulador_restaurante.models.WaiterModel;

public class WaiterController {
    private final WaiterModel waiterModel;
    private final WaiterComponent waiterComponent;
    private final ReceptionistModel recepcionistModel;

    public WaiterController(WaiterModel model, WaiterComponent view, ReceptionistModel recepcionistModel) {
        this.waiterModel = model;
        this.waiterComponent = view;
        this.recepcionistModel = recepcionistModel;
    }

    public void atendCLient() {
        new Thread(() -> {
            while (true) {
                synchronized (waiterModel) {
                    try {
                        if (waiterModel.isBusy() || recepcionistModel.getSeatedCustomers().isEmpty()) {
                            Thread.sleep(100); // Espera si no hay ClientComponents
                            continue;
                        }

                        waiterModel.setIsBuzy(true);

                        ClientComponent clientComponent = recepcionistModel.getSeatedCustomers().get(0);

                        //waiterComponent.mostrarMovimiento("Atendiendo al clientComponent: " + clientComponent.getNombre());
                        waiterModel.takeOrder(clientComponent);

                        FoodComponent foodComponent = waiterModel.pickupFood();
                        //waiterComponent.mostrarMovimiento("Sirviendo foodComponent al clientComponent: " + clientComponent.getNombre());
                        //waiterComponent.mostrarComidaServida(foodComponent);

                        recepcionistModel.removeSeatedClient(clientComponent);
                        recepcionistModel.releaseTable();

                        Thread.sleep(500); // Simula tiempo de servir
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        waiterModel.setIsBuzy(false);
                        waiterModel.notifyAll();
                    }
                }
            }
        }).start();
    }
}

