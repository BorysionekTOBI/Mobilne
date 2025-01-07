package com.example.alertdialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView txtView;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        txtView = findViewById(R.id.txtView);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_layout,null);

                final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Alert z mikolajem")
                        .setView(dialogView)
                        .setCancelable(true)
                        .create();
                ImageView dialogImageView = dialogView.findViewById(R.id.dialogImageView);
                TextView dialogTextView = dialogView.findViewById(R.id.dialogTextView);
                Button btnCLose = dialogView.findViewById(R.id.btnClose);

                btnCLose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

                dialogImageView.setImageDrawable(imageView.getDrawable());
                dialogTextView.setText(txtView.getText());

                alertDialog.show();
            }
        });

    }
}