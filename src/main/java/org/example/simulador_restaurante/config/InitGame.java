package org.example.simulador_restaurante.config;

import com.almasb.fxgl.entity.Entity;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.entities.GameEntityFactory;
import org.example.simulador_restaurante.utils.EntityUtils;

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
        this.generateSomething();
    }

    // method to check the correct functioning of the ui and the utilities
    private void generateSomething(){
        Entity something = this._entityManager.spawnWaiter(Math.random() * 600, Math.random() * 400);
        EntityUtils.scaleEntity(something,0.5, 0.5);
        EntityUtils.rotateEntity(something, -45);
        EntityUtils.moveTo(something,Math.random() * 600, Math.random() * 400 );
    }



}
