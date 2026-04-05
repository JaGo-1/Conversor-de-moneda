package com.mobile.conversordemoneda.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mobile.conversordemoneda.model.ConversorDeMoneda;

import java.util.Locale;

public class MainViewModel extends ViewModel {

    private final ConversorDeMoneda model = new ConversorDeMoneda();

    private final MutableLiveData<String> valorDolares = new MutableLiveData<>("");
    private final MutableLiveData<String> valorEuros = new MutableLiveData<>("");
    private final MutableLiveData<String> tipoCambio = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();

    public MainViewModel() {
        actualizarTextoTipoCambio(model.getCambio());
    }

    public LiveData<String> getValorDolares() { return valorDolares; }
    public LiveData<String> getValorEuros() { return valorEuros; }
    public LiveData<String> getTipoCambio() { return tipoCambio; }
    public LiveData<String> getError() { return error; }

    public void convertir(String input, boolean convertirAEuros) {
        if (input == null || input.isEmpty()) {
            error.setValue("Ingrese un valor");
            return;
        }

        try {
            double monto = Double.parseDouble(input);
            double resultado;

            if (convertirAEuros) {
                resultado = model.convertirAEuros(monto);
                valorEuros.setValue(String.format(Locale.getDefault(), "%.2f", resultado));
            } else {
                resultado = model.convertirADolares(monto);
                valorDolares.setValue(String.format(Locale.getDefault(), "%.2f", resultado));
            }

            error.setValue(null);

        } catch (NumberFormatException e) {
            error.setValue("Número inválido");
        }
    }

    public void actualizarTasa(String nuevaTasa) {
        if (nuevaTasa == null || nuevaTasa.isEmpty()) {
            error.setValue("Ingrese una tasa");
            return;
        }

        try {
            double tasa = Double.parseDouble(nuevaTasa);

            if (tasa <= 0) {
                error.setValue("Debe ser mayor a 0");
                return;
            }

            model.setCambio(tasa);
            actualizarTextoTipoCambio(tasa);
            error.setValue(null);

        } catch (NumberFormatException e) {
            error.setValue("Tasa inválida");
        }
    }

    private void actualizarTextoTipoCambio(double tasa) {
        tipoCambio.setValue(String.format(Locale.getDefault(), "1 USD = %.2f EUR", tasa));
    }
}