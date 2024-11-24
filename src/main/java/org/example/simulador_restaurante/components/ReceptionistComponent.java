package org.example.simulador_restaurante.components;

import com.almasb.fxgl.entity.Entity;
import org.example.simulador_restaurante.entities.EntityManager;
import org.example.simulador_restaurante.utils.EntityUtils;

public class ReceptionistComponent {
    private Entity receptionistEntity;
    private static final EntityManager _entityManager = new EntityManager();
    public void spawnReceptionist(double x, double y){
        this.receptionistEntity = _entityManager.spawnReceptionist(x, y);
        EntityUtils.scaleEntity(this.receptionistEntity, 0.7, 0.7);
        EntityUtils.rotateEntity(this.receptionistEntity, -45);

    }

}
