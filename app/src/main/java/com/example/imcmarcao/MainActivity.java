package com.example.imcmarcao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView titleIMC;
    TextView heightLabel;
    TextView weightLabel;
    EditText heightInput;
    EditText weightInput;
    Button btnSubmit;
    TextView resultLabel;
    TextView numIMC;
    TextView infoIMC;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponents();
        submitConfig();
    }

    protected void loadComponents(){

        titleIMC = findViewById(R.id.titleIMC);
        heightLabel = findViewById(R.id.heightLabel);
        weightLabel = findViewById(R.id.weightLabel);
        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        btnSubmit = findViewById(R.id.submitIMC);
        resultLabel = findViewById(R.id.resultLabel);
        numIMC = findViewById(R.id.numIMC);
        infoIMC = findViewById(R.id.infoIMC);


    }

    @SuppressLint("SetTextI18n")
    protected void calcIMC(){

      double heightValue = Double.parseDouble(heightInput.getText().toString());
      double weightValue = Double.parseDouble(weightInput.getText().toString());

      double resultValue = weightValue / (heightValue * heightValue);

      numIMC.setText(String.valueOf(resultValue));


      if(resultValue < 16) infoIMC.setText("Magreza grave");
      else if(resultValue > 16 && resultValue < 17) infoIMC.setText("Magreza moderada");
      else if(resultValue > 17 && resultValue < 18.5) infoIMC.setText("Magreza leve");
      else if(resultValue > 18.5 && resultValue < 25) infoIMC.setText("Saudável");
      else if(resultValue > 25 && resultValue < 30) infoIMC.setText("Sobrepeso");
      else if(resultValue > 30 && resultValue < 35) infoIMC.setText("Obesidade grau I");
      else if(resultValue > 35 && resultValue < 40) infoIMC.setText("Obesidade grau II");
      else if(resultValue >= 40) infoIMC.setText("Obesidade grau III (Mórbida)");

    }

    protected void submitConfig(){
        btnSubmit.setOnClickListener(v -> {

            calcIMC();

        });
    }







}