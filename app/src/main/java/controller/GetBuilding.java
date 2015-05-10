package controller;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import model.DBConnection;

/**
 * Created by Piyush on 25-02-2015.
 */
public class GetBuilding {
    JSONArray jArray=null;
    String result=null;
    ArrayList<String> final_data=null;
    String[] data=null;
    int size;
    JSONObject json_data=null;

    public ArrayList<String> retrieveBuilding(String city) {
        DBConnection db = new DBConnection();
        result = db.urlFormEntity("getbuilding.php", city);
        try {
            jArray = new JSONArray(result);
            size = jArray.length();
            data = new String[size];
            for (int i = 0; i < jArray.length(); i++) {
                json_data = jArray.getJSONObject(i);
                data[i] = (json_data.getString("building"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i;
        try {
            final_data = new ArrayList<String>();
            final_data.add("none");
            for (i = 0; i < size; i++) {
                final_data.add(data[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("building ", "write till end");
        return final_data;
    }
}

