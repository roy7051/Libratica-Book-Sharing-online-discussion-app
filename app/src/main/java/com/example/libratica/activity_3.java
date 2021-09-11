package com.example.libratica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_3 extends AppCompatActivity {

    EditText username,new_pass,confirm_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

       final Button button_5 = findViewById(R.id.angry_btn3);
       username = findViewById(R.id.editTextTextPersonName2);
       new_pass=findViewById(R.id.editTextTextPersonName3);
       confirm_pass=findViewById(R.id.newpass);




        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.length()==0){
                    username.setError("Enter username");
                }
                else if (new_pass.length()==0){
                    new_pass.setError("Enter new password");
                }
                else if (confirm_pass.length()==0){
                    confirm_pass.setError("Confirm password");
                }

                else {
                    button_5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(activity_3.this,MainActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}