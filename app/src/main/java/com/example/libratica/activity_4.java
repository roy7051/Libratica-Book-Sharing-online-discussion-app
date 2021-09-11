package com.example.libratica;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class activity_4 extends AppCompatActivity {

    Button btnCaptureImage;
    ImageView imageDisplay;

    DrawerLayout drawerLayout;

    AppBarConfiguration mAppBarConfiguration2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
      //  setContentView(R.layout.activity_navigation_drawer);

       // drawerLayout = findViewById(R.id.drawer_layout);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()== R.id.nav_logout){
                    Toast.makeText(activity_4.this,"Logout",Toast.LENGTH_LONG).show();
                }
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;


            }
        });











        final AutoCompleteTextView actv1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ImageView image = (ImageView) findViewById(R.id.image_arrow);
        btnCaptureImage = (Button) findViewById(R.id.btn_capture_img);
        imageDisplay = (ImageView) findViewById(R.id.Image_capture);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,type_of_item);
        actv1.setAdapter(adapter);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actv1.showDropDown();
            }
        });







        btnCaptureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

            }
        });



    }
    private static final String[] type_of_item = new String[]{"Stationery","Books"};



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageDisplay.setImageBitmap(bitmap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }







}

