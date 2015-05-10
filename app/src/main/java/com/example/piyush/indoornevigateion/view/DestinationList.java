package com.example.piyush.indoornevigateion.view;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.piyush.indoornevigateion.R;

import java.util.ArrayList;
import java.util.Collections;


public class DestinationList extends ListActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    ArrayList<String> listItem;
    ListView destinationList;
    String itemSelected;
    int position,flag;
    TextView text;
    String source;
    private String longitude;
    private String latitude;
    LinearLayout linear;
    TextView textSource;
    ImageButton change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.destination_list);
            destinationList=getListView();
            Bundle b = getIntent().getExtras();


            linear = (LinearLayout)findViewById(R.id.linear);
        linear.setOnClickListener(this);
            textSource =(TextView)findViewById(R.id.source);
            change = (ImageButton)findViewById(R.id.change);
            change.setOnClickListener(this);
             text=(TextView)findViewById(R.id.select);
           flag= b.getInt("source");
            if(flag==1) {
                text.setText("Select Source");
                linear.setVisibility(View.INVISIBLE);
                latitude = String.valueOf(b.getDouble("latitude"));
                longitude = String.valueOf(b.getDouble("longitude"));
                listItem=b.getStringArrayList("listItem");
            }
            else{
                text.setText("Select Destination");
                linear.setVisibility(View.VISIBLE);
                listItem=b.getStringArrayList("listItem");
                position=b.getInt("position");
                source = listItem.get(position);
                textSource.setText(source);
                listItem.remove(position);
            }

            Collections.sort(listItem);
            Log.e("destination list","after building");



            for(int i=0;i<listItem.size();i++){
                Log.e("List item",listItem.get(i));
            }



            ArrayAdapter<String> adapter = new ArrayAdapter<String>(DestinationList.this, android.R.layout.simple_list_item_1,android.R.id.text1, listItem)
            {
                @Override
                  public View getView(int position, View convertView, ViewGroup parent) {

                        View view = super.getView(position, convertView, parent);
                        TextView text = (TextView) view.findViewById(android.R.id.text1);

                            text.setTextColor(Color.rgb(130,7,7));


                        return view;
                     }
        };;
            Log.e("destination list  ", "alll izzzz welll");

            destinationList.setAdapter(adapter);
            Log.e("destination list","all is wellllllllll 12");
            destinationList.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("destinationlist","write untill here");

        Intent i=null;
        if(flag==1){
            i= new Intent(DestinationList.this,DestinationList.class);
            i.putExtra("listItem",listItem);
            i.putExtra("position", position);
            startActivity(i);

        }
        else {
            Log.e("destinationList", listItem.get(position));
            String itemSelected =listItem.get(position);
            i = new Intent(DestinationList.this, MapView.class);
            i.putExtra("destination", itemSelected);
            i.putExtra("source",source);
            i.putExtra("flag",0);
            startActivity(i);
        }
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, DestinationList.class);
        i.putExtra("latitude",0.0);
        i.putExtra("longitude",0.0);
        i.putExtra("source",1);
        listItem.add(source);
        i.putExtra("listItem",listItem);
        startActivity(i);
    }
}
