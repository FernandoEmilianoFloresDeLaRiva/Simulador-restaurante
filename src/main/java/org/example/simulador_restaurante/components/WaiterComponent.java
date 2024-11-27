package org.example.simulador_restaurante.components;

import com.almasb.fxgl.entity.Entity;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.utils.EntityUtils;

public class WaiterComponent {
    private Entity waiterEntity;
    private static final EntityManager _entityManager = new EntityManager();
    public void spawnWaiter(double x, double y){
        this.waiterEntity = _entityManager.spawnWaiter(x, y);
    }
    public void moveToPosition(double x, double y, int duration) {
        EntityUtils.moveTo(this.waiterEntity, x, y, duration);
    }
}
