package com.pinal.patternbullet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtxtt;
    TextView start;
    int iii = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxtt = findViewById(R.id.edtxtt);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtxtt.getText().toString().isEmpty()){
                    iii = Integer.parseInt(edtxtt.getText().toString());
                    if (iii >= 4 && iii<=10){
                        Intent intent = new Intent(MainActivity.this,SecondScreen.class);
                        intent.putExtra("ssss",edtxtt.getText().toString());
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "please enter the value 4 to 10", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}