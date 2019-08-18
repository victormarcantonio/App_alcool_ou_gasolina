package com.example.alcool_gasolina;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editPrecoAlcool = findViewById(R.id.editAlcool);
        editPrecoGasolina=findViewById(R.id.editGasolina);
        textresultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){

        //recupera valores digitados
      String precoAlcool =   editPrecoAlcool.getText().toString();
      String precoGasolina =   editPrecoGasolina.getText().toString();

      //validar os campos digitados
        Boolean camposValidados = this.validarCampos(precoAlcool,precoGasolina);
        if(camposValidados){
             this.calcularMelhorPreco(precoAlcool,precoGasolina);

        }else{
            textresultado.setText("Preencha os campos primeiro!");
        }


    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina){

        //Converter valores String para números

        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        Double resultado = precoAlcool/precoGasolina;
        if(resultado>=0.7){
            textresultado.setText("Melhor utilizar Gasolina!");
        }else{
            textresultado.setText("Melhor utilizar Álcool!");
        }
        ConstraintLayout mainLayout;

// Get your layout set up, this is just an example
        mainLayout = (ConstraintLayout)findViewById(R.id.myLayout);

        // Then just use the following:
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        //Validar campos
        if(pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
        }
        else if(pGasolina == null || pGasolina.equals("") ) {
           camposValidados = false;
        }

        return camposValidados;
    }
}
