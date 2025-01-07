package com.example.a0312a;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private ToggleButton toggleButton;
    private Switch switchButton;
    private TextView textViewToggle;
    private TextView textViewSwitch;
    private Switch btnSwitchButtons;
    private Button btn1;
    private Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        switchButton = findViewById(R.id.switchButton);
        textViewToggle = findViewById(R.id.textViewToggle);
        textViewSwitch = findViewById(R.id.textViewSwitch);
        btnSwitchButtons = findViewById(R.id.btnSwitchButtons);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        toggleButton.setOnCheckedChangeListener((buttonView,isChecked) ->{

            if(isChecked){
                textViewToggle.setText("ToggleButton is ON");
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            }
            else{
                textViewToggle.setText("ToggleButton is OFF");
                getWindow().getDecorView().setBackgroundColor(Color.BLACK);
            }
        });


        switchButton.setOnCheckedChangeListener((buttonView,isChecked) ->{

            if(isChecked){
                textViewSwitch.setText("SwitchButton is ON");
            }
            else{
                textViewSwitch.setText("SwitchButton is OFF");
            }
        });

        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btnSwitchButtons.setOnCheckedChangeListener((buttonView,isChecked) ->{

            if(isChecked){
                btn1.setEnabled(true);
                btn2.setEnabled(true);
            }
            else{
                btn1.setEnabled(false);
                btn2.setEnabled(false);
            }
        });
    }
}