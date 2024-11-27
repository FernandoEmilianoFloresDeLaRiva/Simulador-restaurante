package org.example.simulador_restaurante.config;

import java.util.ArrayList;
import java.util.List;

public class ConstantsConfig {
    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGTH = 760;
    public static final String CLIENT_CONSTANT = "client";
    public static final String TABLE_CONSTANT = "table";
    public static final String CHEF_CONSTANT = "chef";
    public static final String FOOD_CONSTANT = "food";
    public static final String RECEPTIONIST_CONSTANT = "receptionist";
    public static final String WAITER_CONSTANT = "waiter";
    public static final String WALL_CONSTANT = "wall";
    public static List<double[]> TABLE_LIST_CONSTANT = new ArrayList<>(List.of(
            new double[]{40, 130, 0},
            new double[]{40, 240, 0},
            new double[]{40, 350, 0},
            new double[]{40, 460, 0},
            new double[]{40, 570, 0},
            new double[]{440, 130, 0},
            new double[]{440, 240, 0},
            new double[]{440, 350, 0},
            new double[]{440, 460, 0},
            new double[]{440, 570, 0}
        ));
}
