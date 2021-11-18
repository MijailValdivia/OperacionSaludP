package com.example.operacionsaludp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Salud extends AppCompatActivity {
    EditText etNombre, etPeso, etAltura;
    Button btnCalcular, btnLimpiar, btnRecomendar;
    RadioButton rbVaron, rbMujer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);

        etNombre = (EditText) findViewById(R.id.txtNombre);
        etPeso = (EditText) findViewById(R.id.txtPeso);
        etAltura = (EditText) findViewById(R.id.txtAltura);
        btnCalcular = (Button) findViewById(R.id.bCalcular);
        btnLimpiar = (Button) findViewById(R.id.bLimpiar);
        btnRecomendar = (Button) findViewById(R.id.bRecomendar);
        rbVaron = (RadioButton) findViewById(R.id.rHombre);
        rbMujer = (RadioButton) findViewById(R.id.rMujer);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Limpiar();}
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalcularIMC();
            }
        });


    }

    private void Limpiar()
    {
        etNombre.setText("");
        etAltura.setText("");
        etPeso.setText("");
    }

    private String MensajeIMC (double IMC)
    {
        String mensaje = "";
        if (IMC < 16)
            mensaje =" Para su estatura, un peso bien bajo variaría en kilogramos.  ";
        else if (IMC >= 16 & IMC < 17)
            mensaje = " Peso muy bajo ";
        else if (IMC >=17 & IMC < 18.49)
            mensaje = " Peso Bajo ";
        else if (IMC >=18.50 & IMC < 24.99)
            mensaje = " Peso Ideal ";
        else if (IMC >=25 & IMC < 29.99)
            mensaje = " Su IMC es 26.5, lo que indica que su peso está en la categoría Normal para adultos de su misma estatura. ";
        else if (IMC >=30 & IMC < 34.99)
            mensaje = " Mantener un peso saludable puede reducir el riesgo de enfermedades crónicas asociadas al sobrepeso y la obesidad. ";
        else if (IMC <40)
            mensaje = " Toda persona que tenga sobrepeso debería tratar de evitar ganar más peso. Además, si usted tiene sobrepeso junto con otros factores de riesgo (como niveles altos de colesterol LDL, niveles bajos de colesterol HDL o hipertensión arterial), debería tratar de perder peso. Incluso una pequeña disminución (tan solo 10 % de su peso actual) puede ayudar a disminuir el riesgo de enfermedades. Hable con su proveedor de atención médica para establecer maneras adecuadas de perder peso. ";
        else
            mensaje = " Otro tipo de IMC ";
        return mensaje;


    }
private void  CalcularIMC()
{
    String nombre = etNombre.getText().toString();
    Double altura = Double.valueOf(etAltura.getText().toString());
    Double peso = Double.valueOf(etAltura.getText().toString());
    double IMC = peso / Math.pow(altura, 2);

    Toast.makeText(this, "Tu IMC es" + String.format("%.2f",IMC)+MensajeIMC(IMC), Toast.LENGTH_LONG).show();
    if(rbMujer.isChecked() == true)
        Toast.makeText(this, "ERES MUJER", Toast.LENGTH_LONG).show();
    else if(rbVaron.isChecked() == true)
        Toast.makeText(this, "ERES VARON", Toast.LENGTH_LONG).show();
    else
        Toast.makeText(this, "No eligio gènero", Toast.LENGTH_LONG).show();
    }

    public void rec(View view) {startActivity(new Intent(this, Recomendacion.class));
    }

}
