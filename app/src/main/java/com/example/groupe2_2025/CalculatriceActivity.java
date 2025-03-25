package com.example.groupe2_2025;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatriceActivity extends AppCompatActivity {

    private Button boutonPlus;
    private Button boutonMoins;
    private Button boutonMultiplier;
    private Button boutonDiviser;
    private Button bouton1;
    private Button bouton0;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private Integer premierElement=0;
    private Integer deuxiemeElement=0;
    private TypeOperationEnum typeOperation;
    private TextView textViewCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculatrice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewCalcul = findViewById(R.id.textView_calcul);
        boutonMultiplier = findViewById(R.id.bouton_multiplier);
        boutonDiviser = findViewById(R.id.bouton_diviser);
        boutonMoins = findViewById(R.id.bouton_moins);
        boutonPlus = findViewById(R.id.bouton_plus);
        bouton0=findViewById(R.id.bouton_0);
        bouton1=findViewById(R.id.bouton_1);
        bouton2=findViewById(R.id.bouton_2);
        bouton3=findViewById(R.id.bouton_3);
        bouton4=findViewById(R.id.bouton_4);
        bouton5=findViewById(R.id.bouton_5);
        bouton6=findViewById(R.id.bouton_6);
        bouton7=findViewById(R.id.bouton_7);
        bouton8=findViewById(R.id.bouton_8);
        bouton9=findViewById(R.id.bouton_9);
        bouton0.setOnClickListener(view -> {
            appuieChiffre(0);
        });
        bouton1.setOnClickListener(view -> {
            appuieChiffre(1);
        });
        bouton2.setOnClickListener(view -> {
            appuieChiffre(2);
        });
        bouton3.setOnClickListener(view -> {
            appuieChiffre(3);
        });
        bouton4.setOnClickListener(view -> {
            appuieChiffre(4);
        });
        bouton5.setOnClickListener(view -> {
            appuieChiffre(5);
        });
        bouton6.setOnClickListener(view -> {
            appuieChiffre(6);
        });
        bouton7.setOnClickListener(view -> {
            appuieChiffre(7);
        });
        bouton8.setOnClickListener(view -> {
            appuieChiffre(8);
        });
        bouton9.setOnClickListener(view -> {
            appuieChiffre(9);
        });

        boutonPlus.setOnClickListener(v -> appuieTypeOperation(TypeOperationEnum.ADD));
        boutonMoins.setOnClickListener(v -> appuieTypeOperation(TypeOperationEnum.MOINS));
        boutonMultiplier.setOnClickListener(v -> appuieTypeOperation(TypeOperationEnum.MULTIPLIER));
        boutonDiviser.setOnClickListener(v -> appuieTypeOperation(TypeOperationEnum.DIVISER));
    }

    private void appuieChiffre(Integer chiffre){
        textViewCalcul.setText(textViewCalcul.getText()+chiffre.toString());
        if(typeOperation==null){
            premierElement = 10*premierElement+chiffre;
        }else{
            deuxiemeElement = 10*deuxiemeElement+chiffre;
        }
    }
    private void appuieTypeOperation(TypeOperationEnum typeOperation){
        if(this.typeOperation==null){
            //solution 2
            textViewCalcul.setText(textViewCalcul.getText()+typeOperation.getSymbole());
            this.typeOperation = typeOperation;
        }else{
            Toast.makeText(this,"OPERATION DEJA SAISI",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.mon_menu,menu);
        MenuItem menuReset = menu.findItem(R.id.menu_reset);
        MenuItem menuCalcul = menu.findItem(R.id.menu_calcul);
        menuReset.setOnMenuItemClickListener(view -> reset());
        menuCalcul.setOnMenuItemClickListener(view->{
           Toast
                   .makeText(CalculatriceActivity.this,TypeOperationEnum.calcul(typeOperation,premierElement,deuxiemeElement).toString(),Toast.LENGTH_LONG).show(); ;
           return true;
        });
        return super.onCreateOptionsMenu(menu);
    }

    private Boolean reset(){
        premierElement=0;
        deuxiemeElement=0;
        typeOperation=null;
        textViewCalcul.setText("");
        return true;
    }
}