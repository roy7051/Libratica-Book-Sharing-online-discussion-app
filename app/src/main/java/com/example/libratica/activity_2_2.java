package com.example.libratica;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class activity_2_2 extends AppCompatActivity {

    ImageButton btnCaptureImage_2;
    ImageView imageDisplay_2;
    Button btn2,btn3;
    EditText name,location,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2_2);

        name = findViewById(R.id.editTextTextPersonName5);
        location = findViewById(R.id.editTextTextPersonName7);
        email=findViewById(R.id.editTextTextPersonName6);


        btnCaptureImage_2 = (ImageButton) findViewById(R.id.imageButton);
        imageDisplay_2 = (ImageView) findViewById(R.id.profile_image);
        btn2 = (Button) findViewById(R.id.act2button);
        final LoadingDialog loadingDialog = new LoadingDialog(activity_2_2.this);



        btnCaptureImage_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent_4, 0);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.length()==0)
                {
                    name.setError("Enter Name");
                }

                else if (location.length()==0)
                {
                    location.setError("Enter location");
                }

                else if (email.length()==0)
                {
                    email.setError("Enter email");
                }

                else {
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            loadingDialog.startLoadingDialog();
                            Intent intent = new Intent(activity_2_2.this,Navigation_drawer.class);
                            startActivity(intent);


                        }


                    });
                }
            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap  bitmap_2 = (Bitmap)data.getExtras().get("data");
        imageDisplay_2.setImageBitmap(bitmap_2);
    }

}