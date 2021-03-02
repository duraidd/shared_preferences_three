package com.netcom.shared_preferences_three;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class homepage extends AppCompatActivity {
    TextView txt1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        txt1 = findViewById(R.id.username_homepage);
        SharedPreferences sharedPreferences = getSharedPreferences("user_name", MODE_PRIVATE);
        String value = sharedPreferences.getString("user_name_value","");
        txt1.setText(value);
        btn = findViewById(R.id.logout_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().remove("user_name_value").apply();
                Intent i = new Intent(homepage.this,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                homepage.this.finish();
            }
        });
    }
}