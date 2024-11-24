package org.example.simulador_restaurante.entities;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import javafx.beans.property.DoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.simulador_restaurante.config.ConstantsConfig;
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

    public Entity spawnWall(double width, double height, Color color, double x, double y){
        SpawnData data = new SpawnData(x, y);
        data.put("width", width);
        data.put("height", height);
        data.put("color", color);
        return getGameWorld().spawn(ConstantsConfig.WALL_CONSTANT, data);
    }

    public void spawnProgressBar(double width, double heigth, DoubleProperty progress, Entity entity){
        Rectangle progressBarBackground = new Rectangle(width, heigth, Color.DARKGRAY);
        Rectangle progressBar = new Rectangle(width, heigth, Color.GREEN);

        progressBarBackground.setTranslateY(-20);
        progressBarBackground.setTranslateX(60);
        progressBar.setTranslateY(-20);
        progressBar.setTranslateX(60);

        progressBar.widthProperty().bind(progress.multiply(1));
        progressBarBackground.visibleProperty().bind(progress.greaterThan(0));
        progressBar.visibleProperty().bind(progress.greaterThan(0));

        entity.getViewComponent().addChild(progressBarBackground);
        entity.getViewComponent().addChild(progressBar);
    }
}
