package org.example.simulador_restaurante.controllers;

import javafx.application.Platform;
import org.example.simulador_restaurante.components.ClientComponent;
import org.example.simulador_restaurante.components.ReceptionistComponent;
import org.example.simulador_restaurante.models.ReceptionistModel;
import org.example.simulador_restaurante.models.TableModel;

public class ReceptionistController {
    private final ReceptionistModel receptionistModel;
    private final ReceptionistComponent receptionistComponent;
    private final TableModel tableModel;

    public ReceptionistController(ReceptionistModel receptionistModel, ReceptionistComponent receptionistComponent, TableModel tableModel) {
        this.receptionistModel = receptionistModel;
        this.receptionistComponent = receptionistComponent;
        this.tableModel = tableModel;
    }

    public void manageEntrance(ClientComponent clientComponent) {
        new Thread(() -> {
            if (receptionistModel.tryToSit(clientComponent)) {
                double[] freeTable = tableModel.searchFreeTable(clientComponent.getId());
                if (freeTable != null) {
                    Platform.runLater(() -> {
                        clientComponent.moveToPosition(freeTable[0], freeTable[1], 0, 5);
                        int x = clientComponent.getX()-50;
                        clientComponent.setX(x);
                    });
                }
            }
        }).start();
    }

    public void setFreeTable(ClientComponent clientComponent) {
        receptionistModel.removeSeatedClient(clientComponent);
        receptionistModel.releaseTable();
        //clientComponent.moveToPosition();
    }
}
