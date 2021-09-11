package com.example.libratica;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Navigation_drawer extends AppCompatActivity {

    Button btnCaptureImage;
    ImageView imageDisplay;



    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }




        });
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        final AutoCompleteTextView actv1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ImageView image = (ImageView) findViewById(R.id.image_arrow);
        btnCaptureImage = (Button) findViewById(R.id.btn_capture_img);
        imageDisplay = (ImageView) findViewById(R.id.Image_capture);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,type_of_item);
        actv1.setAdapter(adapter);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actv1.showDropDown();
            }
        });


        //NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()== R.id.nav_logout){
                   // Toast.makeText(Navigation_drawer.this,"Logout",Toast.LENGTH_LONG).show();
                   // Intent intent = new Intent(Navigation_drawer.this,activity_3.class);
                    //startActivity(intent);

                    AlertDialog.Builder builder = new AlertDialog.Builder(Navigation_drawer.this);
                    builder.setTitle("Logout");
                    builder.setMessage("Are you sure You want to logout?" ).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Toast.makeText(Navigation_drawer.this,"Logout",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Navigation_drawer.this,MainActivity.class);
                            startActivity(intent);


                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            drawer.closeDrawer(GravityCompat.START);
                        }
                    });






                    AlertDialog alert = builder.create();
                    alert.show();






                }

               else if (item.getItemId()==R.id.nav_search){
                    Intent intent_1 = new Intent(Navigation_drawer.this,search_activity.class);
                    startActivity(intent_1);
                }


               else if (item.getItemId()==R.id.nav_borrow){
                   Intent intent_2 = new Intent(Navigation_drawer.this,borrow_activity.class);
                   startActivity(intent_2);
                }

               else if (item.getItemId()==R.id.search_map){

                   Intent intent_3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr"));

                   startActivity(intent_3);

                }

                    drawer.closeDrawer(GravityCompat.START);

                return true;


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

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}