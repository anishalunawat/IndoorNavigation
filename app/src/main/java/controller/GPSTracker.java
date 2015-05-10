package controller;


import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;


public class GPSTracker extends Service implements LocationListener {
    private final Context context;

    boolean isGPSEnabled =false;
    boolean isNetworkEnabled=false;
    boolean canGetLocation = false;

    Location location;

    double latitude;
    double longitude;

    private static  final long MIN_DISTANCE_CHANGE_FOR_UPDATES=10;
    private static  final long MIN_TIME_BW_UPTADES=1000*60*1;

    protected LocationManager locationManager;

    public GPSTracker(Context context) {
        this.context = context;
        getLocation();
    }

    public  Location getLocation(){
        try {
            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if(!isGPSEnabled && ! isNetworkEnabled) {
            }else {
                this.canGetLocation = true;
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPTADES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);


                    if (locationManager != null) {
                        location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if(location!=null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }

                if(isGPSEnabled){
                    if(location==null){
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPTADES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES,this);

                        if(locationManager !=null) {
                            location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                            if(location !=null){
                                latitude=location.getLatitude();
                                longitude=location.getLongitude();
                            }
                        }
                    }
                }
            }





        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return location;
    }

//    public void stopUsingGPS(){
//        if(locationManager!=null){
//            locationManager.removeUpdates(GPSTracker.this);
//        }
//    }

    public  double getLatitude(){
        if(location!=null){
            latitude=location.getLatitude();
        }
        return latitude;
    }

    public  double getLongitude(){
        if(location!=null){
            longitude=location.getLongitude();
        }
        return longitude;
    }

    public  boolean canGetLocation(){
        return  this.canGetLocation;
    }

    public  void showSettingsAlert(){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(context);

        alertDialog.setTitle("GPS is setting");
        alertDialog.setMessage("GPS is not enabled. Do you want to go to setting menu");
        alertDialog.setPositiveButton("Setting",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

