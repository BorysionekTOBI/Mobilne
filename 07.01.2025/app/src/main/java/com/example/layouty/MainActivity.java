package com.example.layouty;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja widżetów
        EditText editText = findViewById(R.id.editText);
        Button sendButton = findViewById(R.id.sendButton);

        // Obsługa kliknięcia przycisku "Wyślij"
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pobranie tekstu z EditText
                String userInput = editText.getText().toString();

                // Sprawdzenie, czy wprowadzono jakiś tekst
                if (userInput.isEmpty()) {
                    // Wyświetlenie komunikatu, jeśli pole jest puste
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić tekst!", Toast.LENGTH_SHORT).show();
                } else {
                    // Wyświetlenie Toast z wprowadzonym tekstem
                    Toast.makeText(MainActivity.this, "Wprowadzono: " + userInput, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
