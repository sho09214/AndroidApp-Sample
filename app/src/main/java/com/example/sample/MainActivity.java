package com.example.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void onButton(View view){
        //Editの取得
        EditText eT1 = (EditText) findViewById(R.id.eT1);
        EditText eT2 = (EditText) findViewById(R.id.eT2);

        //Edit→String
        String str1 = eT1.getText().toString();
        String str2 = eT2.getText().toString();

        //数値に変換
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);

        //足し算
        int sum = num1 + num2;

        ((TextView)findViewById(R.id.tvAns)).setText(String.valueOf(sum));
    }

    public void onClear(View view){
        ((EditText)findViewById(R.id.eT1)).getText().clear();
        ((EditText)findViewById(R.id.eT2)).getText().clear();
        ((TextView)findViewById(R.id.tvAns)).setText("Answer");
    }
}