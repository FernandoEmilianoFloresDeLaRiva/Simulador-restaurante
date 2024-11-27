package org.example.simulador_restaurante.controllers;

import javafx.application.Platform;
import org.example.simulador_restaurante.components.ClientComponent;
import org.example.simulador_restaurante.components.FoodComponent;
import org.example.simulador_restaurante.components.FoodComponent;
import org.example.simulador_restaurante.components.WaiterComponent;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.models.ReceptionistModel;
import org.example.simulador_restaurante.models.TableModel;
import org.example.simulador_restaurante.models.WaiterModel;
import org.example.simulador_restaurante.utils.EntityUtils;

public class WaiterController {
    private final WaiterModel waiterModel;
    private final WaiterComponent waiterComponent;
    private final ReceptionistModel recepcionistModel;
    private final TableModel tableModel;

    public WaiterController(WaiterModel model, WaiterComponent view, ReceptionistModel recepcionistModel, TableModel tableModel) {
        this.waiterModel = model;
        this.waiterComponent = view;
        this.recepcionistModel = recepcionistModel;
        this.tableModel = tableModel;
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

                        double[] tablePosition = tableModel.searchTableByClient(clientComponent.getId());

                        Platform.runLater(() -> waiterComponent.moveToPosition(tablePosition[0]+100, tablePosition[1], 5));
                        Thread.sleep(5000);

                        waiterModel.takeOrder(clientComponent);

                        Platform.runLater(() -> waiterComponent.moveToPosition(200, 130, 2));
                        Thread.sleep(5000);

                        FoodComponent foodComponent = waiterModel.pickupFood();

                        Platform.runLater(() -> {
                            waiterComponent.moveToPosition(tablePosition[0] + 100, tablePosition[1], 5);
                            foodComponent.moveToPosition(tablePosition[0]-100 + 100, tablePosition[1]-100, 5);
                        });
                        Thread.sleep(5000);

                        Platform.runLater(() -> {
                            EntityManager.deleteEntity(clientComponent.getClientEntity());
                            EntityManager.deleteEntity(foodComponent.getFoodEntity());
                        });

                        recepcionistModel.removeSeatedClient(clientComponent);
                        tableModel.setFreeTable(clientComponent.getId());
                        ClientComponent nextClient = recepcionistModel.releaseTable();
                        if(nextClient != null){
                        System.out.println(nextClient.getId());
                            double[] freeTable = tableModel.searchFreeTable(nextClient.getId());
                            System.out.println(freeTable);
                            nextClient.moveToPosition(freeTable[0], freeTable[1], 0, 5);
                            int x = nextClient.getX()-50;
                            nextClient.setX(x);
                        }
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

