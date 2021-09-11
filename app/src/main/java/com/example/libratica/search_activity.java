package com.example.libratica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class search_activity extends AppCompatActivity {

    SearchView mySearchView;
    ListView myList;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activity);

        mySearchView = (SearchView) findViewById(R.id.searchView);
        myList = (ListView) findViewById(R.id.my_list_for_search);

        list = new ArrayList<String>();

        list.add("The Alchemist");
        list.add("The Zahir");
        list.add("The Kite Runner");
        list.add("To kill a Mockingbird");

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);

        myList.setAdapter(adapter);

       mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String s) {
                     return false;
           }

           @Override
           public boolean onQueryTextChange(String s) {
               adapter.getFilter().filter(s);

               return false;
           }
       });



    }
}