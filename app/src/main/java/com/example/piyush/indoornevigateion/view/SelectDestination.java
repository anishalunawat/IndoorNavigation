package com.example.piyush.indoornevigateion.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.piyush.indoornevigateion.R;

/**
 * Created by Piyush on 08-02-2015.
 */
public class SelectDestination extends ActionBarActivity implements View.OnClickListener {

    String city, building;
    ImageButton imgbutton1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectdestination);


        Bundle b = getIntent().getExtras();
        city = b.getString("city");
        building=b.getString("building");


        Log.e("message","everything is write here" );
        imgbutton1=(ImageButton)findViewById(R.id.destinationButton);

        Log.e("message", "alll issss weell");
        imgbutton1.setOnClickListener(this);
        Log.e("message", "alll issss weell 2");
    }

    @Override
    public void onClick(View v) {
        Intent i=null;
        i= new Intent(SelectDestination.this,DestinationList.class);
        Log.e("message", "alll issss weell3");
        i.putExtra("source",2);
        Log.e("message", "alll issss weell4");
        i.putExtra("building",building);
        i.putExtra("city",city);
        startActivity(i);
    }
}
