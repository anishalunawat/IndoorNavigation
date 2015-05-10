package com.example.piyush.indoornevigateion.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.piyush.indoornevigateion.R;

import java.util.ArrayList;

import controller.GPSTracker;
import controller.List;
import controller.Point;
import controller.WifiFinder;


public class MainActivity extends Activity implements View.OnClickListener {

    int mypos;
    ImageButton imgbutton1, imgbutton2;
    String city, building, address;
    double latitude,   longitude;
    ArrayList<String> listItem;
    String pos="A";
    public static WifiManager wifiManager;
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gpsFinder();

        WifiFinder wifi = new WifiFinder();
        wifiManager = (WifiManager) getSystemService(Service.WIFI_SERVICE);
        pos = wifi.getPosition(this);
        Log.e("main Activity","hello my position is" + pos);
        //TextView view= (TextView)findViewById(R.id.test);
      //  view.setText(pos);
        imgbutton1=(ImageButton)findViewById(R.id.source);

        //imgbutton2=(ImageButton)findViewById(R.id.destination);



        List list= new List();

        Point[] point = list.entry();
        int size = list.point.length;

        Log.e("main Activity",String.valueOf(size));
         listItem = new ArrayList<String>();
        for(int i=0;i<size;i++){

            if(point[i].p.length()!=1 && !(point[i].p.equalsIgnoreCase("Near Reception")))
                    listItem.add(list.point[i].p);

        }




        if(android.os.Build.VERSION.SDK_INT>9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            System.out.println("Success");
        }
//        if(!pos.equals("none")){
//
//        }
        imgbutton1.setOnClickListener(this);
//       // imgbutton2.setOnClickListener(this);
    }

    private void  gpsFinder(){
        GPSTracker gps;
        gps=new GPSTracker(MainActivity.this);

        if(gps.canGetLocation()) {
            latitude  = gps.getLatitude();
            longitude = gps.getLongitude();
           // Toast.makeText(getApplicationContext(), "Your Location is -\nLatitude: " + latitude + "\nLongitude: " + longitude, Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Your Location is IIIT Bangalore", Toast.LENGTH_LONG).show();
          /*  try {
                String localityString=null,city=null,region_code=null,zipcode=null;
                Log.e("geocoder","before geocoder");
                Geocoder geocoder = new Geocoder(MainActivity.this, Locale.ENGLISH);
                Log.e("geocoder","after geocoder object");
             /*   List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
                String str = "";
                if (geocoder.isPresent()) {
                    Address returnAddress=addresses.get(0);
                    str=returnAddress.toString();
                       Log.e("GPS output", str);
                    Toast.makeText(getApplicationContext(), str,
                            Toast.LENGTH_SHORT).show();

                    //
                } else {
                    gps.showSettingsAlert();
                }
                return(str);
           }
            catch(IOException e){
                e.printStackTrace();
                Log.e("message","error");
            }*/
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id;
       Intent i =null;
        id=v.getId();
        switch (id){
            case R.id.source:
                                i= new Intent(MainActivity.this,DestinationList.class);
                                if(pos.equalsIgnoreCase("none")){

                                    i.putExtra("latitude",latitude);
                                    i.putExtra("longitude",longitude);
                                    i.putExtra("listItem",listItem);
                                    i.putExtra("source",1);
                                }

                                else{
                                    mypos = listItem.indexOf(pos);
                                    i.putExtra("listItem",listItem);
                                    i.putExtra("position", mypos);
                                    Log.e("Main Activity", "hello i m in  "+ pos);

                                }
                                Log.e("Main Activity","i m here");
                                Log.e("error", "error is here");
                                startActivity(i);
                                break;

          // case R.id.destination:
      /*         GPSTracker gps;
               gps=new GPSTracker(MainActivity.this);

               if(gps.canGetLocation()) {
                   double latitude = gps.getLatitude();
                   double longitude = gps.getLongitude();
                   try {
                       String localityString=null, city=null,region_code=null,zipcode=null;
                       Log.e("geocoder","before geocoder");
                       Geocoder geocoder = new Geocoder(MainActivity.this, Locale.ENGLISH);
                       Log.e("geocoder","after geocoder object");
                       Log.e("message", "latitude "+ latitude+"   longitude"+longitude);
                      /* List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 3);
                       String str = "";
                       if (geocoder.isPresent()) {
                           Address returnAddress=addresses.get(0);
                           str=returnAddress.toString();




                           //Toast.makeText(getApplicationContext(), "Your Location is -\nLatitude: " + latitude + "\nLongitude: " + longitude, Toast.LENGTH_LONG).show();
                       } else {
                           gps.showSettingsAlert();
                       }
                   }
                   catch(IOException e){
                        Log.e("message","error");
                       e.printStackTrace();
                   }
               }/**/
//              i=new Intent(this, ImageRetrieve.class);
//               i.putExtra("address",address);
//               startActivity(i);

               //break;
        }
    }
}
