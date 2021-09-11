package com.example.libratica;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public Button button_2;
    public Button button_3;
    EditText username,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.angry_btn);
        button_2 = (Button) findViewById(R.id.angry_btn3) ;
        button_3 = (Button) findViewById(R.id.angry_btn2);
        username = findViewById(R.id.editTextTextPersonName2);
        pass = findViewById(R.id.editTextTextPassword);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,activity_2_2.class);
                startActivity(intent);
            }
        });

       button_2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent_2 = new Intent(MainActivity.this,activity_3.class);
               startActivity(intent_2);

           }
       });




        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.length()==0)
                {
                    username.setError("Enter Username");
                }

                else if (pass.length()==0){
                    pass.setError("Enter password");
                }

                else {
                    button_3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent_3 = new Intent(MainActivity.this, Navigation_drawer.class);
                            startActivity(intent_3);

                        }
                    });
                }
            }
        });


    }


    }
