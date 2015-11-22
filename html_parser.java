package com.rail.injilaislam.railways;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Html_parser extends AsyncTask<Void, Void, List<Train_list>> {
    InputStream is = null;
    String result;
    String url;
    List<Train_list> schedule_list = new ArrayList<Train_list>();


    public Html_parser(String source_code, String destination_code) {
        this.url = "http://erail.in/rail/getTrains.aspx?Station_From=" + source_code +
                "&Station_To=" + destination_code + "&DataSource=0&Language=0";
        Log.e("Url  ",url);
    }

    @Override
    protected List<Train_list> doInBackground(Void... params) {

            try {
                URL train_url = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) train_url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                int response = conn.getResponseCode();
                if(response == 200) {
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
                        Matcher matcher = Pattern.compile("(\\^[A-Za-z0-9 ]+\\~[A-Za-z 0-9]+\\~)+")
                                .matcher(result);
                        if (matcher.find()) {
                            while (matcher.find()) {
                                Train_list t_list = new Train_list();
                                result = matcher.group().replaceAll("\\~", " ");
                                result = result.replaceAll("\\^", "");
                                String[] value = result.split(" ");
                                String train_num = value[0];
                                String train_name = "";
                                for (int i = 1; i < value.length; i++) {
                                    train_name = train_name + value[i] + " ";
                                }
                                Log.e("Train_Number", train_num);
                                Log.e("Train_Name", train_name);
                                t_list.set_list(train_name, train_num);
                                schedule_list.add(t_list);
                            }
                        }
                        else{
                            Train_list t_list = new Train_list();
                            t_list.set_list("Not able to connect, Please try again","999");
                            schedule_list.add(t_list);

                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
                else{
                    Train_list t_list = new Train_list();
                    t_list.set_list("Not able to connect, Please try again","999");
                    schedule_list.add(t_list);

                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        return schedule_list;

    }

}
