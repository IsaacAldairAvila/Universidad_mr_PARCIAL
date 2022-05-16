package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double resultados = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button registrar = (Button)findViewById(R.id.button);
        TextView registro = (TextView) findViewById(R.id.total);
        CheckBox rojo = (CheckBox) findViewById(R.id.rojo);
        TextView textogranorojo = (TextView) findViewById(R.id.prcRojo);

        rojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rojo.isChecked()){
                    textogranorojo.setEnabled(true);
                }
                else{
                    textogranorojo.setEnabled(false);
                }
            }
        });
        CheckBox verde = (CheckBox) findViewById(R.id.verde);
        TextView textogranoverde = (TextView) findViewById(R.id.prcVerde);
        verde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verde.isChecked()){
                    textogranoverde.setEnabled(true);
                }
                else{
                    textogranoverde.setEnabled(false);
                }
            }
        });
         CheckBox medio = (CheckBox) findViewById(R.id.medio);
        TextView textogranomedio = (TextView) findViewById(R.id.prcMedio);
        medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (medio.isChecked()){
                    textogranomedio.setEnabled(true);
                }
                else{
                    textogranomedio.setEnabled(false);
                }
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean pase = true;
                double num1=0.00;
                if(!textogranorojo.getText().toString().isEmpty()){
                  num1 = Double.parseDouble(textogranorojo.getText().toString());
                }else {
                    if(rojo.isChecked()){
                        pase = false;
                    }
                }
                double num2=0.00;
                if(!textogranoverde.getText().toString().isEmpty()){
                    num2 = Double.parseDouble(textogranoverde.getText().toString());
                }else {
                    if(verde.isChecked()){
                        pase = false;
                    }
                }
                double num3=0.00;
                if(!textogranomedio.getText().toString().isEmpty()){
                    num3 = Double.parseDouble(textogranomedio.getText().toString());
                }else {
                    if(medio.isChecked()){
                        pase = false;
                    }
                }
                if (pase == false){
                    Context context = getApplicationContext();
                    CharSequence text = "Llene espacios";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    double suma = num1 + num2 + num3;
                    if (suma != 100){
                        Context context = getApplicationContext();
                        CharSequence text = "La suma de porcentajes debe dar 100";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else{
                        EditText kilos = (EditText) findViewById(R.id.kilos);
                        EditText valor = (EditText) findViewById(R.id.valor);
                        Double kg = Double.parseDouble(kilos.getText().toString());
                        Double val = Double.parseDouble(valor.getText().toString());

                        Double kilosR = kg * num1 / 100;
                        Double kilosV = kg * num2 / 100;
                        Double kilosM = kg * num3 / 100;

                        Double totalR = kilosR * val;
                        Double totalV = kilosV * (val * 0.8);
                        Double totalM = kilosM * (val * 0.4);
                        Double totalRecolector = totalR + totalM + totalV;

                        if (kg > 10 && num1 > 80) {
                            totalRecolector += (kg - 10) * (val * 0.5);
                        }

                        EditText cedula = (EditText)findViewById(R.id.cedula);
                        EditText nombre = (EditText)findViewById(R.id.nombre);
                        EditText apellido = (EditText)findViewById(R.id.apellido);
                        cedula.getText().clear();
                        nombre.getText().clear();
                        apellido.getText().clear();
                        kilos.getText().clear();
                        valor.getText().clear();
                        textogranomedio.setText(null);
                        textogranorojo.setText(null);
                        textogranoverde.setText(null);
                        Context context = getApplicationContext();
                        CharSequence text = " + "+ totalRecolector.toString();
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        resultados = resultados + totalRecolector;

                    registro.setText(String.valueOf(resultados));
                    }
                }
            }
        });
    }
}