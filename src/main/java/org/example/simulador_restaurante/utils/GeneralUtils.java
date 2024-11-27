package org.example.simulador_restaurante.utils;

public class GeneralUtils {

    public static int generateDistPoisson(double lambda){
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;
        do{
            k++;
            p *= Math.random();
        } while (p > L);
        return k-1;
    }
}
