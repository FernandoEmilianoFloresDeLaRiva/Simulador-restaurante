package org.example.simulador_restaurante.components;

import com.almasb.fxgl.entity.Entity;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.utils.EntityUtils;

public class ChefComponent {
    private Entity chefEntity;
    private DoubleProperty progress = new SimpleDoubleProperty(0);
    private static final EntityManager _entityManager = new EntityManager();
    public void spawnChef(double x, double y){
        this.chefEntity = _entityManager.spawnChef(x, y);
        EntityUtils.scaleEntity(this.chefEntity, 0.3, 0.3);
        _entityManager.spawnProgressBar(100, 20, this.progress, this.chefEntity);

    }

    public void updateProgress(double value) {
        if (value >= 0 && value <= 100) {
            progress.set(value);
        }
    }

    public DoubleProperty getProgress() {
        return progress;
    }

}
