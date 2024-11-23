package org.example.simulador_restaurante.entities;

import com.almasb.fxgl.entity.Entity;
import javafx.animation.Interpolator;
import javafx.geometry.Point2D;
import javafx.util.Duration;
import org.example.simulador_restaurante.config.ConstantsConfig;

import static com.almasb.fxgl.dsl.FXGLForKtKt.animationBuilder;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class EntityManager {
    public EntityManager(){}

    public Entity spawnClient(double x, double y){
        return getGameWorld().spawn(ConstantsConfig.CLIENT_CONSTANT, x, y);
    }

    public Entity spawnChef(double x, double y){
        return getGameWorld().spawn(ConstantsConfig.CHEF_CONSTANT, x, y);
    }

    public Entity spawnFood(double x, double y){
        return getGameWorld().spawn(ConstantsConfig.FOOD_CONSTANT, x, y);
    }

    public Entity spawnReceptionist(double x, double y){
        return getGameWorld().spawn(ConstantsConfig.RECEPTIONIST_CONSTANT, x, y);
    }

    public Entity spawnTable(double x, double y){
        return getGameWorld().spawn(ConstantsConfig.TABLE_CONSTANT, x, y);
    }

    public Entity spawnWaiter(double x, double y){
        return getGameWorld().spawn(ConstantsConfig.WAITER_CONSTANT, x, y);
    }

    public void moveTo(Entity entity, double targetX, double targetY) {
        Point2D targetPosition = new Point2D(targetX, targetY);
        animationBuilder()
                .duration(Duration.seconds(2))
                .interpolator(Interpolator.LINEAR)
                .translate(entity)
                .to(targetPosition)
                .buildAndPlay();
    }
}
