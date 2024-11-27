package org.example.simulador_restaurante.utils;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.TransformComponent;
import javafx.animation.Interpolator;
import javafx.geometry.Point2D;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.animationBuilder;

public class EntityUtils {
    public static void moveTo(Entity entity, double targetX, double targetY, int duration) {
        Point2D targetPosition = new Point2D(targetX, targetY);
        animationBuilder()
                .duration(Duration.seconds(duration))
                .interpolator(Interpolator.LINEAR)
                .translate(entity)
                .to(targetPosition)
                .buildAndPlay();
    }

    public static void rotateWithAnimation(Entity entity, double angle) {
        animationBuilder()
                .duration(Duration.seconds(1))
                .rotate(entity)
                .from(entity.getRotation())
                .to(angle)
                .buildAndPlay();
    }

    public static void rotateEntity(Entity entity, double angle){
        TransformComponent transform = entity.getTransformComponent();
        transform.setRotationZ(angle);
    }

    public static void scaleEntity(Entity entity, double scaleX, double scaleY){
        TransformComponent transform = entity.getTransformComponent();
        transform.setScaleX(scaleX);
        transform.setScaleY(scaleY);
    }
}
