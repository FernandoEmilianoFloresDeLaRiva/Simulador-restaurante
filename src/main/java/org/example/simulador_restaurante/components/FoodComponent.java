package org.example.simulador_restaurante.components;

import com.almasb.fxgl.entity.Entity;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.utils.EntityUtils;

public class FoodComponent {
    private Entity foodEntity;
    private static final EntityManager _entityManager = new EntityManager();
    public void spawnFood(double x, double y){
        this.foodEntity = _entityManager.spawnFood(x, y);
        EntityUtils.scaleEntity(this.foodEntity, 0.15, 0.15);
    }
    public void moveToPosition(double x, double y, int duration) {
        EntityUtils.moveTo(this.foodEntity, x, y, duration);
    }

    public Entity getFoodEntity() {
        return foodEntity;
    }
}
