package com.pinal.patternbullet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SecondScreen extends AppCompatActivity {
    RecyclerView rec;
    String ssss;
    int spanCount;
    List<UserModel> userModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        rec = findViewById(R.id.rec);

        ssss = getIntent().getStringExtra("ssss");
        spanCount = Integer.parseInt(ssss);
        int countAbc = spanCount * spanCount;

        for (int i = 0; i < countAbc; i++) {
            userModelList.add(new UserModel(i));
        }

        rec.setLayoutManager(new GridLayoutManager(SecondScreen.this,spanCount));
        rec.setAdapter(new UserAdapter(this,userModelList));
    }
}