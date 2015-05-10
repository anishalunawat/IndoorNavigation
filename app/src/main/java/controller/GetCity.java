package controller;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import model.DBConnection;

/**
 * Created by Piyush on 18-02-2015.
 */
public class GetCity {
    JSONArray jArray=null;
    String result=null;
    ArrayList<String> final_data=null;
    String[] data=null;
    int size;
    JSONObject json_data=null;
    public ArrayList<String> retrieveCity(String city)
    {
        DBConnection db=new DBConnection();
        result =db.setupConnection(city);
        try{
            jArray= new JSONArray(result);
            Log.e("city", "write here");
            size=jArray.length();

            data =new String[size];
            Log.e("city","write untill here");
            for(int i=0;i<size;i++)
            {
                json_data =  jArray.getJSONObject(i);
                data[i]=(json_data.getString("city"));
            }
        }
        catch(Exception e )
        {
            e.printStackTrace();
        }
        int i;
        try {
            final_data=new ArrayList<String>();
            final_data.add("none");
            for (i = 0; i < size; i++) {
                final_data.add(data[i]);
            }
            Log.e("city","write till end");
         }
        catch (Exception e) {
            e.printStackTrace();
        }
        return final_data;
    }

}