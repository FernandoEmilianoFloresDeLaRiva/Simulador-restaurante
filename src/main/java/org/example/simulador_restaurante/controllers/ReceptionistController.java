package org.example.simulador_restaurante.controllers;

import javafx.application.Platform;
import org.example.simulador_restaurante.components.ClientComponent;
import org.example.simulador_restaurante.components.ReceptionistComponent;
import org.example.simulador_restaurante.models.ReceptionistModel;
import org.example.simulador_restaurante.models.TableModel;

import java.util.Optional;

public class ReceptionistController {
    private final ReceptionistModel receptionistModel;
    private final ReceptionistComponent receptionistComponent;
    private final TableModel tableModel;

    public ReceptionistController(ReceptionistModel receptionistModel, ReceptionistComponent receptionistComponent) {
        this.receptionistModel = receptionistModel;
        this.receptionistComponent = receptionistComponent;
        this.tableModel = new TableModel();
    }

    public void manageEntrance(ClientComponent clientComponent) {
        new Thread(() -> {
            if (receptionistModel.tryToSit(clientComponent)) {
                double[] freeTable = tableModel.searchTable();
                if (freeTable != null) {
                    Platform.runLater(() -> {
                        clientComponent.moveToPosition(freeTable[0], freeTable[1], 0, 5);
                        int x = clientComponent.getX()-50;
                        clientComponent.setX(x);
                    });
                }
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
