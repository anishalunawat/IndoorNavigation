package controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import model.DBConnection;

/**
 * Created by Piyush on 25-02-2015.
 */
public class GetDestination {
    String result;
    String[] data;
    JSONArray jArray;
    int size;
    JSONObject json_data;
    ArrayList<String> final_data;
    public ArrayList<String> retrieveDestination(String latitude, String longitude){

        DBConnection db=new DBConnection();
        result =db.urlFormEntity("getsource.php", latitude,longitude);
       // Log.e("result",result );
        try{

            jArray= new JSONArray(result);
            size=jArray.length();
            data =new String[size];
            for(int i=0;i<jArray.length();i++)
            {
                json_data =  jArray.getJSONObject(i);
                data[i]=(json_data.getString("place"));
            }
        }
        catch(Exception e )
        {
            e.printStackTrace();
        }
        int i;
        try {
            final_data=new ArrayList<String>();
            for (i = 0; i < size; i++) {
                final_data.add(data[i]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return final_data;
    }

}

