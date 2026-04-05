package com.mobile.conversordemoneda.view;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.mobile.conversordemoneda.R;
import com.mobile.conversordemoneda.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    private EditText etDolares, etEuros, etNuevoCambio;
    private RadioButton rbAEuros, rbADolares;
    private TextView tvTipoCambio;
    private Button btnConvertir, btnCambiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        etDolares = findViewById(R.id.etDolares);
        etEuros = findViewById(R.id.etEuros);
        etNuevoCambio = findViewById(R.id.etNuevoCambio);
        rbAEuros = findViewById(R.id.rbAEuros);
        rbADolares = findViewById(R.id.rbADolares);
        tvTipoCambio = findViewById(R.id.tvTipoCambio);
        btnConvertir = findViewById(R.id.btnConvertir);
        btnCambiar = findViewById(R.id.btnCambiar);

        viewModel.getValorDolares().observe(this, valor -> {
            if (valor != null) etDolares.setText(valor);
        });

        viewModel.getValorEuros().observe(this, valor -> {
            if (valor != null) etEuros.setText(valor);
        });

        viewModel.getTipoCambio().observe(this, texto -> {
            tvTipoCambio.setText(texto);
        });

        viewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
            }
        });

        btnConvertir.setOnClickListener(v -> {
            boolean convertirAEuros = rbAEuros.isChecked();
            String input;

            if (convertirAEuros) {
                input = etDolares.getText().toString().trim();
            } else {
                input = etEuros.getText().toString().trim();
            }

            viewModel.convertir(input, convertirAEuros);
        });

        btnCambiar.setOnClickListener(v -> {
            String nuevaTasa = etNuevoCambio.getText().toString().trim();
            viewModel.actualizarTasa(nuevaTasa);
        });
    }
}