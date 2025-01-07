package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView myImageView;
    private Button selectImageButton;
    private Button resetButton;
    private Button filterButton;
    private Button resetFilterButton;
    private Button btnSkaluj;
    private Button btnSkalujReset;
    private Bitmap bitmapa;

    private Bitmap scaleBitmap(Bitmap bitmap, int width, int height) {
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicjacja
        myImageView = findViewById(R.id.myImageView);
        selectImageButton = findViewById(R.id.selectImageButton);
        resetButton = findViewById(R.id.resetButton);
        filterButton = findViewById(R.id.filterButton);
        resetFilterButton = findViewById(R.id.resetFilterButton);
        btnSkaluj = findViewById(R.id.btnSkaluj);
        btnSkalujReset = findViewById(R.id.btnSkalujReset);

        ActivityResultLauncher<Intent> pickImageLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            Uri imageUri = data.getData();
                            try {
                                bitmapa = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                                myImageView.setImageBitmap(bitmapa);  // Ustawiamy bitmapę w ImageView
                            } catch (IOException e) {
                                Toast.makeText(this, "Błąd wczytywania obrazka", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
        );


        selectImageButton.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            pickImageLauncher.launch(intent);
        });


        resetButton.setOnClickListener(view -> {
            myImageView.setImageBitmap(null);
        });


        filterButton.setOnClickListener(view -> {
            myImageView.setColorFilter(Color.argb(150, 0, 0, 0));
        });


        resetFilterButton.setOnClickListener(view -> {
            myImageView.setColorFilter(Color.argb(0, 0, 0, 0));
        });


        btnSkaluj.setOnClickListener(view -> {

            Bitmap scaledBitmap = scaleBitmap(bitmapa, 70, 50);
            myImageView.setImageBitmap(scaledBitmap);


        });


        btnSkalujReset.setOnClickListener(view -> {

            myImageView.setImageBitmap(bitmapa);
        });
    }
}