package org.example.simulador_restaurante.config;

import com.almasb.fxgl.entity.Entity;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.entities.GameEntityFactory;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class InitGame {
    EntityManager _entityManager;
    public InitGame (){
       this._entityManager = new EntityManager();
    }
    private void initializeBackground() {
        getGameScene().setBackgroundRepeat("wood_floor.jpg");
    }

    private void registerFactory(){
        getGameWorld().addEntityFactory(new GameEntityFactory());
    }

    public void runGame(){
        this.registerFactory();
        this.initializeBackground();
        this.generateClients();
    }

    // method to check the correct functioning of the ui and the movement
    private void generateClients(){
        Entity client = this._entityManager.spawnClient(Math.random() * 600, Math.random() * 400);
        this._entityManager.moveTo(client,Math.random() * 600, Math.random() * 400 );
    }

}
