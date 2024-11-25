package org.example.simulador_restaurante.controllers;

import org.example.simulador_restaurante.components.ChefComponent;
import org.example.simulador_restaurante.components.ClientComponent;
import org.example.simulador_restaurante.components.ReceptionistComponent;
import org.example.simulador_restaurante.components.WaiterComponent;
import org.example.simulador_restaurante.models.ChefModel;
import org.example.simulador_restaurante.models.ReceptionistModel;
import org.example.simulador_restaurante.models.WaiterModel;

public class ManagerController {
    public static void initController() {
        // Modelos
        ReceptionistModel receptionistModel = new ReceptionistModel(10); // 3 mesas disponibles
        ChefModel chefModel = new ChefModel();
        WaiterModel waiterModel = new WaiterModel(chefModel);

        // Vistas
        ReceptionistComponent receptionistComponent = new ReceptionistComponent();
        ChefComponent chefComponent = new ChefComponent();
        WaiterComponent waiterComponent = new WaiterComponent();

        // Controladores
        ReceptionistController receptionistController = new ReceptionistController(receptionistModel, receptionistComponent);
        ChefController chefController = new ChefController(chefModel, chefComponent);
        WaiterController waiterController = new WaiterController(waiterModel, waiterComponent, receptionistModel);

        chefController.cook();
        waiterController.atendCLient();

        new Thread(() -> {
            try {
                int clienteId = 1;
                while (true) {
                    ClientComponent cliente = new ClientComponent();
                    // cliente.spawnClient(900, 650);
                    receptionistController.manageEntrance(cliente);

                    Thread.sleep((int) (Math.random() * 2000)); // Tiempo aleatorio entre llegadas (Hay que cambiarlo por poison)
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
