package org.example.simulador_restaurante.models;

import static org.example.simulador_restaurante.config.ConstantsConfig.TABLE_LIST_CONSTANT;

public class TableModel {

    public TableModel() {
    }

    public synchronized double[] searchTable(){
        return TABLE_LIST_CONSTANT.stream()
                .filter(table -> table[2] == 0)
                .findFirst()
                .map(table -> {
                    table[2] = 1;
                    return table;
                })
                .orElse(null);
    }
}
