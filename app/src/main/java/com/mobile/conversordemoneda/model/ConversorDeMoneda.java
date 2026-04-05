package com.mobile.conversordemoneda.model;

public class ConversorDeMoneda {

    private double cambio = 0.87;

    public double convertirAEuros(double dolares){
        return dolares * cambio;
    }

    public double convertirADolares(double euros){
        return euros / cambio;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
}