package org.example.simulador_restaurante.config;

import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.example.simulador_restaurante.components.ChefComponent;
import org.example.simulador_restaurante.components.ClientComponent;
import org.example.simulador_restaurante.components.ReceptionistComponent;
import org.example.simulador_restaurante.components.TableComponent;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.entities.GameEntityFactory;

import java.util.List;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class InitGame {
    EntityManager _entityManager;
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

        List<double[]> positions = List.of(
                new double[]{-20, 20},
                new double[]{-20, 130},
                new double[]{-20, 240},
                new double[]{-20, 350},
                new double[]{-20, 460},
                new double[]{440, 20},
                new double[]{440, 130},
                new double[]{440, 240},
                new double[]{440, 350},
                new double[]{440, 460}
        );
        for (double[] pos : positions) {
            TableComponent table = new TableComponent();
            table.spawnTable(pos[0], pos[1]);
        }

        ChefComponent chef = new ChefComponent();
        chef.spawnChef(100, -50);

        // Funcion que simula progreso, mover a controlador de chef
        run(() -> {
            double currentProgress = chef.getProgress().get() + 10;
            chef.updateProgress(Math.min(currentProgress, 100));
            if(currentProgress == 100){
                chef.updateProgress(0);
            }
            return null;
        }, Duration.seconds(1));

    }

    private void registerFactory(){
        getGameWorld().addEntityFactory(new GameEntityFactory());
    }

    public void runGame(){
        this.registerFactory();
        this.initializeBackground();
    }

}
