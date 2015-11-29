package com.rail.injilaislam.railways;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Train_number_parser extends AsyncTask<Void, Void, List<Number_list>> {
    String url, result;
    InputStream is = null;
    List<Number_list> route = new ArrayList<Number_list>();

    @Override
    protected List<Number_list> doInBackground(Void... params) {
        try {
            URL train_url = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) train_url.openConnection();
            conn.setReadTimeout(20000 /* milliseconds */);
            conn.setConnectTimeout(20000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            int response = conn.getResponseCode();
            Log.e("Response Code", ""+response);
            if (response == 200) {
                is = conn.getInputStream();
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(is, "iso-8859-1"), 8);
                    StringBuilder sb = new StringBuilder();
                    sb.append(reader.readLine() + "\n");
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                    Log.e("Value result", result);


                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    String day, arr, dept, name, state, code;
                    Double lat, lng;
                    JSONObject json_data = new JSONObject(result);
                    JSONArray jarray = json_data.getJSONArray("route");

                    JSONObject json_location = null;
                    String resp = json_data.getString("response_code");
                    Log.e("Response code", resp);

                    if (!resp.equals("200")) {
                        Number_list tlist = new Number_list();
                        tlist.setResponse(resp);
                        route.add(tlist);
                        return route;
                    }

                    for (int i = 0; i < jarray.length(); i++) {
                        Number_list tlist = new Number_list();
                        json_location = jarray.getJSONObject(i);

                        day = json_location.getString("day");
                        lng = json_location.getDouble("lng");
                        arr = json_location.getString("scharr");
                        state = json_location.getString("state");
                        dept = json_location.getString("schdep");
                        lat = json_location.getDouble("lat");
                        name = json_location.getString("fullname");
                        code = json_location.getString("code");
                        tlist.set_list(day, lat, lng, arr, dept, name, state, code);
                        route.add(tlist);

                    }
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
            }catch(MalformedURLException e){
                e.printStackTrace();
            }catch(ProtocolException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return route;

    }

    public Train_number_parser(String t_num) {
        this.url = "http://api.railwayapi.com/route/train/"+t_num+"/apikey/lxeqx8167/";
        Log.e("URL",url);
    }
}
