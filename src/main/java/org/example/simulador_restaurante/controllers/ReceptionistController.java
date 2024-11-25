package org.example.simulador_restaurante.controllers;

import org.example.simulador_restaurante.components.ClientComponent;
import org.example.simulador_restaurante.components.ReceptionistComponent;
import org.example.simulador_restaurante.models.ReceptionistModel;

public class ReceptionistController {
    private final ReceptionistModel receptionistModel;
    private final ReceptionistComponent receptionistComponent;

    public ReceptionistController(ReceptionistModel receptionistModel, ReceptionistComponent receptionistComponent) {
        this.receptionistModel = receptionistModel;
        this.receptionistComponent = receptionistComponent;
    }

    public void manageEntrance(ClientComponent clientComponent) {
        new Thread(() -> {
            if (receptionistModel.tryToSit(clientComponent)) {
                //receptionistComponent.mostrarEntradaCliente(clientComponent);
            } else {
                //receptionistComponent.mostrarClienteEnCola(clientComponent);
            }
        }).start();
    }

    public void setFreeTable(ClientComponent clientComponent) {
        receptionistModel.removeSeatedClient(clientComponent);
        receptionistModel.releaseTable();
        //clientComponent.moveToPosition();
    }
}
