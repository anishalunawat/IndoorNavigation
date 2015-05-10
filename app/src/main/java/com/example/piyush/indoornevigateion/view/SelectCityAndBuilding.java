package com.example.piyush.indoornevigateion.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.piyush.indoornevigateion.R;

import java.util.ArrayList;

import controller.GetBuilding;
import controller.GetCity;

/**
 * Created by Piyush on 15-02-2015.
 */
    public class SelectCityAndBuilding extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    ArrayList<String> scity,sbuilding;
    Spinner city,building;
    ImageButton submit;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectcityandbuilding);
        submit=(ImageButton)findViewById(R.id.submit);
        if(android.os.Build.VERSION.SDK_INT>9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            System.out.println("Success");
        }

        GetCity gcity=new GetCity();
        scity= gcity.retrieveCity("getcity.php");
        sbuilding = new ArrayList<String>();
        sbuilding.add("none");
        ArrayAdapter<String> adaptercity= new ArrayAdapter<String>(SelectCityAndBuilding.this, android.R.layout.simple_spinner_item, scity);
        city = (Spinner)findViewById(R.id.spinnercity);
        city.setAdapter(adaptercity);
        city.setOnItemSelectedListener(this);


       Log.e("selectbuildingandcity", "after city");
        entryInBuilding();


         submit.setOnClickListener(this);


    }

    void entryInBuilding(){
        ArrayAdapter<String> adapterbuilding= new ArrayAdapter<String>(SelectCityAndBuilding.this, android.R.layout.simple_spinner_item, sbuilding);
        building= (Spinner)findViewById(R.id.spinnerbuilding);
        building.setAdapter(adapterbuilding);
    }
    @Override
    public void onClick(View v) {
        Intent i;
        int selectedCity,selectedBuild;
        selectedCity=city.getSelectedItemPosition();
        selectedBuild=building.getSelectedItemPosition();
        //if(scity.get(selectedCity)!="none"  && sbuilding.get(selectedBuild)!="none") {
            i = new Intent(SelectCityAndBuilding.this, MainActivity.class);
            i.putExtra("city", scity.get(selectedCity));
            i.putExtra("building", sbuilding.get(selectedBuild));
            startActivity(i);
       // }
        //else
          //  Toast.makeText(getBaseContext(), "Please select city and building first",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedCity = scity.get(position);
        Log.e("building", "hello i m in itemselected ");
        if (city.getSelectedItemPosition()!=0) {
            Log.e("building", "position ="+selectedCity);
            GetBuilding getBuilding = new GetBuilding();
            sbuilding = getBuilding.retrieveBuilding((selectedCity));
            int s=sbuilding.size();
            Log.e("building size","size="+s);
            entryInBuilding();
        }
        else {
            sbuilding.add("none");
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
