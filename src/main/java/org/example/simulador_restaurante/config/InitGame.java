package org.example.simulador_restaurante.config;

import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.example.simulador_restaurante.components.ChefComponent;
import org.example.simulador_restaurante.components.ReceptionistComponent;
import org.example.simulador_restaurante.components.TableComponent;
import org.example.simulador_restaurante.components.WaiterComponent;
import org.example.simulador_restaurante.controllers.ManagerController;
import org.example.simulador_restaurante.controllers.WaiterController;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.entities.GameEntityFactory;

import java.util.List;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;
import static org.example.simulador_restaurante.config.ConstantsConfig.TABLE_LIST_CONSTANT;

public class InitGame {
    EntityManager _entityManager;
    private List<TableComponent> tables;

    public InitGame (){
       this._entityManager = new EntityManager();
    }
    private void initializeBackground() {
        getGameScene().setBackgroundRepeat("wood_floor.jpg");
        // Rectangle for chef's
        this._entityManager.spawnWall(900, 100, Color.CHOCOLATE, 30, 100);
        // Large wall
        this._entityManager.spawnWall(20, 600, Color.BLACK, 960, 0);
        // Short wall
        this._entityManager.spawnWall(20, 100, Color.BLACK, 960, 700);
        ReceptionistComponent receptionistComponent = new ReceptionistComponent();
        receptionistComponent.spawnReceptionist(870, 540);

        TABLE_LIST_CONSTANT.forEach(pos ->
        {
            TableComponent table = new TableComponent();
            table.spawnTable(pos[0], pos[1]);
        });
    }

    private void registerFactory(){
        getGameWorld().addEntityFactory(new GameEntityFactory());
    }

    private void startSoundtrack(){
        loopBGM("soundtrack.mp3");
    }

    public void runGame(){
        this.registerFactory();
        this.startSoundtrack();
        this.initializeBackground();
        ManagerController.initController();
    }

}
