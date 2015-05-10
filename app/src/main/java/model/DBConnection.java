package model;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piyush on 16-02-2015.
 */
public class DBConnection {
    InputStream is = null;
    String result = null, re = null;
    String[] data;
    ArrayList<String> final_data = null;
    JSONArray jArray = null;
    JSONObject json_data = null;
    int size;
    HttpPost httppost;


    public String setupConnection(String city) {

        String url = "http://194.168.43.94" + city;
        httppost = new HttpPost(url);
        Log.e("city","alll  is welll");
        result = executeQuery();
        return result;
    }


    public String setupConnection(List<NameValuePair> pairs, String file) {
        try {
            String url = "http://192.168.43.94/" + file;

            httppost = new HttpPost(url);
            httppost.setEntity(new UrlEncodedFormEntity(pairs));
            result = executeQuery();

        }
        catch(Exception e){

        }
        return result;
    }


    public String urlFormEntity(String file, String city, String building) {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        try {

            nameValuePairs.add(new BasicNameValuePair("latitude", city));
            nameValuePairs.add(new BasicNameValuePair("longitude", building));
            result = setupConnection(nameValuePairs, file);

        } catch (Exception e) {

        }
        return result;
    }


    public String urlFormEntity(String file, String city) {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        try {

            nameValuePairs.add(new BasicNameValuePair("city", city));
            result = setupConnection(nameValuePairs, file);

        } catch (Exception e) {

        }
        return result;
    }

    String executeQuery(){
        //httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs1));\
        try{
            HttpClient httpclient = new DefaultHttpClient();

            HttpResponse response = httpclient.execute(httppost);
            Log.e("hello 3", "All izzzz well");
            //System.out.println("Response Code : "
            //      + response.getStatusLine().getStatusCode());

            HttpEntity entity = response.getEntity();
            Log.e("hello 4", "All izzzzzzzzzzzzzzzzzzzzzzz well");
            is = entity.getContent();
            Log.e("hello 5", "All izzzzzzzzzzzzzzzzzzzzzzz well");

        }
        catch (Exception e)
        {
            Log.e("Fail 1", e.toString());
            e.printStackTrace();
            // Log.e("Fail 1",);
            //Toast.makeText(getApplicationContext(), "Invalid IP Address", Toast.LENGTH_LONG).show();

         }

        try
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
            Log.e("Hello6", "write until here");
        }
        catch (Exception e)
        {
            Log.e("fail 2", "connection success " + e.toString());
        }

        return result;
    }
}
