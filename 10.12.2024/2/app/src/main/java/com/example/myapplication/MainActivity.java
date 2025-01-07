package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView txtWynik;
    private Spinner spinner;
    private ListView ListView;

    private List<String> spinnerItem;
    private List<String> listViewItems;
    private ArrayAdapter<String> listAdapter;
    private Boolean isSpinnerSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        ListView = findViewById(R.id.ListView);
        txtWynik = findViewById(R.id.txtWynik);

        // Obsługa spinnera
        // itemy
        spinnerItem = new ArrayList<>();
        spinnerItem.add("Mleko za zeta");
        spinnerItem.add("Masło za dyszku");
        spinnerItem.add("Piwo za darmo");

        // Adapter spinnera
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItem);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);

        // Obsługa zdarzenia na spinerze
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedItem = spinnerItem.get(position);
                isSpinnerSelected = true;
                spinnerAdapter.notifyDataSetChanged();
                listViewItem.add(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                isSpinnerSelected = false;
            }
        });

        // Obsługa listView
        listViewItems = new ArrayList<>();
        listAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1, listViewItems);
        ListView.setAdapter(listAdapter);

        // Obsługa nasłuchu
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (isSpinnerSelected){
                    String selected = listViewItems.get(position);
                    txtWynik.setText("Wybrałes: " + selected);
                }else{
                    Toast.makeText(MainActivity.this, "Wybierz najpierw opcje", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}