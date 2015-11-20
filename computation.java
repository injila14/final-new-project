package com.rail.injilaislam.railways;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Computation extends AppCompatActivity {
    List<Train_list> train_schedule_list = new ArrayList<Train_list>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computation);
        double source_lat = getIntent().getExtras().getDouble("Source_lat");
        double source_lng = getIntent().getExtras().getDouble("Source_lng");
        double destination_lat = getIntent().getExtras().getDouble("Destination_lat");
        double destination_lng = getIntent().getExtras().getDouble("Destination_lng");
        Log.e("Source Location ", ""+source_lat+"  "+source_lng);
        Log.e("Destination Location ", "" + destination_lat + "  " + destination_lng);
        SD_Database db = new SD_Database(this);
        db.insert();
        String source_stn_code = db.distance_calc(source_lat,source_lng);
        String destination_stn_code = db.distance_calc(destination_lat,destination_lng);
        String source_stn_name= db.station_name(source_stn_code);
        String dest_stn_name = db.station_name(destination_stn_code);
        try {
            train_schedule_list = new Html_parser(source_stn_code,destination_stn_code)
                    .execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for (Train_list tlist : train_schedule_list) {
            if(tlist.get_train_number() == "999"){
                Toast.makeText(getApplicationContext(),
                        tlist.get_train_name(), Toast.LENGTH_SHORT).show();
                Intent intentMain = new Intent(Computation.this,MapDestination.class);

                Computation.this.startActivity(intentMain);
            }
            else{
                break;
            }
        }

            final ViewGroup trains = (ViewGroup) findViewById(R.id.schedule_list);
        if(train_schedule_list.isEmpty()){

            final TextView stn_name = new TextView(this);
            final TextView red_view = new TextView(this);


            stn_name.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            stn_name.setPadding(0, 7, 0, 3);
            stn_name.setBackgroundColor(getResources().getColor(
                    android.R.color.holo_blue_bright));
            stn_name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
            stn_name.setText("Source Station "+source_stn_name+" To Destination Station "+dest_stn_name);
            trains.addView(stn_name);

            red_view.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            red_view.setPadding(0, 7, 0, 3);
            red_view.setBackgroundColor(getResources().getColor(
                    android.R.color.holo_red_light));
            red_view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
            red_view.setText("*No Direct Train/s Found");
            trains.addView(red_view);

        }
        else {
            final TextView stn_name = new TextView(this);
            stn_name.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            stn_name.setPadding(0, 7, 0, 3);
            stn_name.setBackgroundColor(getResources().getColor(
                    android.R.color.holo_blue_bright));
            stn_name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
            stn_name.setText("Source Station " + source_stn_name + " To Destination Station " + dest_stn_name);
            trains.addView(stn_name);


            for (Train_list tlist : train_schedule_list) {
                String train_name = tlist.get_train_name();
                String train_num = tlist.get_train_number();

                final TextView comp_view = new TextView(this);
                final TextView red_view = new TextView(this);
                final TextView white_view = new TextView(this);



                red_view.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                red_view.setPadding(0, 7, 0, 3);
                red_view.setBackgroundColor(getResources().getColor(
                        android.R.color.holo_green_light));

                red_view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
                red_view.setText("Train Number " + train_num);
                trains.addView(red_view);

                comp_view.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                comp_view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                comp_view.setTextColor(getResources()
                        .getColor(android.R.color.holo_green_dark));
                comp_view.setText("Train Name " + train_name);
                trains.addView(comp_view);

                white_view.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                white_view.setBackgroundColor(getResources().getColor(
                        android.R.color.transparent));

                white_view.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                white_view.setBackgroundColor(getResources().getColor(
                        android.R.color.transparent));
                trains.addView(white_view);

            }
        }
    }
}
