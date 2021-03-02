package com.netcom.shared_preferences_three;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user_name,password;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_name = findViewById(R.id.user_name_main_activity);
        password = findViewById(R.id.password_main_activity);
        SharedPreferences settings = getSharedPreferences("user_name", MODE_PRIVATE);
        String valuefromDataStore = settings.getString("user_name_value", "");
        String passwdvaluefromDatastore = settings.getString("user_pwd_value","");
        System.out.println("value stored "+valuefromDataStore);
        System.out.println("pwd value stored "+passwdvaluefromDatastore);
        if(valuefromDataStore!=null && !valuefromDataStore.equals(""))
        {
            Intent i =new Intent(MainActivity.this,homepage.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            MainActivity.this.finish();
        }
        btn = findViewById(R.id.login_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textGotfromUser = user_name.getText().toString();
                String pwdGotfromuser = password.getText().toString();
                if(textGotfromUser.equals("Durai") && pwdGotfromuser.equals("password"))
                {
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("user_name_value",textGotfromUser);
                    editor.putString("user_pwd_value",pwdGotfromuser);
                    editor.apply();
                    Intent h = new Intent(MainActivity.this, homepage.class);
                    startActivity(h);
                }
                else if(textGotfromUser.equals("") && pwdGotfromuser.equals("")) {
                    System.out.println(textGotfromUser+"text from user");
                    Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid User",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}