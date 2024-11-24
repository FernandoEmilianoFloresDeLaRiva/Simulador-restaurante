package org.example.simulador_restaurante.entities;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.simulador_restaurante.config.ConstantsConfig;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class GameEntityFactory implements EntityFactory {
    @Spawns(ConstantsConfig.CLIENT_CONSTANT)
    public Entity newClient(SpawnData data) {
        return entityBuilder(data)
                .at(data.getX(), data.getY())
                .viewWithBBox("client.png")
                .build();
    }

    @Spawns(ConstantsConfig.CHEF_CONSTANT)
    public Entity newChef(SpawnData data){
        return entityBuilder(data)
                .at(data.getX(), data.getY())
                .viewWithBBox("chef.png")
                .build();
    }

    @Spawns(ConstantsConfig.FOOD_CONSTANT)
    public Entity newFood(SpawnData data){
        return entityBuilder(data)
                .at(data.getX(), data.getY())
                .viewWithBBox("food.png")
                .build();
    }

    @Spawns(ConstantsConfig.RECEPTIONIST_CONSTANT)
    public Entity newReceptionist(SpawnData data){
        return entityBuilder(data)
                .at(data.getX(), data.getY())
                .viewWithBBox("receptionist.png")
                .build();
    }

    @Spawns(ConstantsConfig.TABLE_CONSTANT)
    public Entity newTable(SpawnData data){
        return entityBuilder(data)
                .at(data.getX(), data.getY())
                .viewWithBBox("table.png")
                .build();
    }

    @Spawns(ConstantsConfig.WAITER_CONSTANT)
    public Entity newWaiter(SpawnData data){
        return entityBuilder(data)
                .at(data.getX(), data.getY())
                .viewWithBBox("waiter.png")
                .build();
    }

    @Spawns(ConstantsConfig.WALL_CONSTANT)
    public Entity newWall(SpawnData data){
        double width = data.get("width");
        double height = data.get("height");
        Color color = data.get("color");
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setFill(color);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);
        return entityBuilder(data)
                .viewWithBBox(rectangle)
                .build();
    }
}
