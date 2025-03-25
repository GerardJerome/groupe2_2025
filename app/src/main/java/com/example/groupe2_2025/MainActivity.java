package com.example.groupe2_2025;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button boutonCalculatrice;
    private Button boutonHistorique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        boutonCalculatrice = findViewById(R.id.bouton_calculatrice);
        boutonCalculatrice.setOnClickListener(v -> {
            Intent intent = new Intent(this, CalculatriceActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this,"ceci est un toast",Toast.LENGTH_LONG).show();
        });
    }
}