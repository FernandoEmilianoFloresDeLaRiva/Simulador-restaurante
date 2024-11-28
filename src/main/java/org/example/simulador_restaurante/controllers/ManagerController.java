package org.example.simulador_restaurante.controllers;

import javafx.application.Platform;
import org.example.simulador_restaurante.components.ChefComponent;
import org.example.simulador_restaurante.components.ClientComponent;
import org.example.simulador_restaurante.components.ReceptionistComponent;
import org.example.simulador_restaurante.components.WaiterComponent;
import org.example.simulador_restaurante.models.ChefModel;
import org.example.simulador_restaurante.models.ReceptionistModel;
import org.example.simulador_restaurante.models.TableModel;
import org.example.simulador_restaurante.models.WaiterModel;
import org.example.simulador_restaurante.utils.GeneralUtils;

public class ManagerController {
    public static void initController() {
        // Modelos
        ReceptionistModel receptionistModel = new ReceptionistModel(10); // 3 mesas disponibles
        ChefModel chefModel = new ChefModel();
        WaiterModel waiterModel = new WaiterModel(chefModel);
        TableModel tableModel = new TableModel();

        // Vistas
        ReceptionistComponent receptionistComponent = new ReceptionistComponent();
        ChefComponent chefComponent = new ChefComponent();
        WaiterComponent waiterComponent = new WaiterComponent();

        // Controladores
        ReceptionistController receptionistController = new ReceptionistController(receptionistModel, receptionistComponent, tableModel);
        ChefController chefController = new ChefController(chefModel, chefComponent);
        WaiterController waiterController = new WaiterController(waiterModel, waiterComponent, receptionistModel, tableModel);

        chefComponent.spawnChef(100, -50);
        waiterComponent.spawnWaiter(870, 440);
        chefController.cook();
        waiterController.atendCLient();

        new Thread(() -> {
            int id = 1;
            try {
                while (true) {
                    int poissonRes = GeneralUtils.generateDistPoisson(5);
                    ClientComponent clientComponent = new ClientComponent(id);
                    receptionistController.manageEntrance(clientComponent);
                    Platform.runLater(clientComponent::spawnClient);
                    Thread.sleep(poissonRes * 1000L);
                    id++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
