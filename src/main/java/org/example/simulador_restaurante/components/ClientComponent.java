package org.example.simulador_restaurante.components;

import com.almasb.fxgl.entity.Entity;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.utils.EntityUtils;

public class ClientComponent {
    private Entity clientEntity;
    private static final EntityManager _entityManager = new EntityManager();
    public void spawnClient(double x, double y){
        this.clientEntity = _entityManager.spawnClient(x, y);
    }
    public void moveToPosition(double x, double y) {
        EntityUtils.moveTo(this.clientEntity, x, y);
    }
}
