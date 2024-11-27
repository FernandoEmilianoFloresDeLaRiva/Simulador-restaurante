package org.example.simulador_restaurante.components;

import com.almasb.fxgl.entity.Entity;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.utils.EntityUtils;

public class ClientComponent {
    private Entity clientEntity;
    private static final EntityManager _entityManager = new EntityManager();
    private static int x = 1100;
    private static int y = 600;
    private double ownX;
    private double ownY;

    public void spawnClient(){
        this.clientEntity = _entityManager.spawnClient(x, y);
        EntityUtils.scaleEntity(this.clientEntity, 0.8, 0.8);
        setOwnX(x);
        setOwnY(y);
        x += 50;
        moveToPosition(ownX - 180, ownY, 0, 2);
    }

    public void moveToPosition(double x, double y, double angle, int duration){
        EntityUtils.rotateWithAnimation(this.clientEntity, angle);
        EntityUtils.moveTo(this.clientEntity, x, y, duration);
        setOwnX(x);
        setOwnY(y);
    }

    public Entity getClientEntity() {
        return clientEntity;
    }

    public double getOwnX() {
        return ownX;
    }

    public void setOwnX(double ownX) {
        this.ownX = ownX;
    }

    public double getOwnY() {
        return ownY;
    }

    public void setOwnY(double ownY) {
        this.ownY = ownY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public Entity getClientEntity(){
        return this.clientEntity;
    }
}
