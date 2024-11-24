package org.example.simulador_restaurante.components;

import com.almasb.fxgl.entity.Entity;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.utils.EntityUtils;

public class TableComponent {
    private Entity tableEntity;
    private static final EntityManager _entityManager = new EntityManager();
    public void spawnTable(double x, double y){
        this.tableEntity = _entityManager.spawnTable(x, y);
        EntityUtils.scaleEntity(this.tableEntity, 0.2, 0.2);
    }
}
