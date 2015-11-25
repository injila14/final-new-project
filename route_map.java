package com.rail.injilaislam.railways;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Route_map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    List<Number_list> route = new ArrayList<Number_list>();
    String train_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        train_number = getIntent().getExtras().getString("Train_Number");
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        PolylineOptions route_line = new PolylineOptions();
        LatLng sydney = new LatLng(21, 78);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        try {
            route = new Train_number_parser(train_number).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if(route.isEmpty()){
            Toast.makeText(getApplicationContext(),
                    "Unable to connect to Server, Please try again", Toast.LENGTH_SHORT).show();
            Intent intentMain = new Intent(Route_map.this,Train_number.class);

            Route_map.this.startActivity(intentMain);
        }
        for (Number_list tlist: route){
            LatLng dest_latlng;
            if(!tlist.getResp().equals("200")){
                Toast.makeText(getApplicationContext(),
                        "Please check your Train Number", Toast.LENGTH_SHORT).show();
                Intent intentMain = new Intent(Route_map.this,Train_number.class);
                Route_map.this.startActivity(intentMain);
            }
            else {

                if(!((tlist.getLatitude() < 37.6 && tlist.getLatitude() >8.4)&&
                        (tlist.getLongitude()<97.25 && tlist.getLongitude()>68.7))) {
                    SD_Database db = new SD_Database(this);
                    dest_latlng = db.station_latlng(tlist.getCode());
                    if (dest_latlng == null){
                        continue;
                    }
                }
                else {
                    dest_latlng = new LatLng(tlist.getLatitude(),
                            tlist.getLongitude());
                }

                if(tlist.getState().equals("Baghd\u0101d")){
                    tlist.setState("");
                }
                if (tlist.getArrival().equals("Source")) {
                    MarkerOptions marker_destination = new MarkerOptions().
                            position(dest_latlng).title("Source Position " + tlist.getName() + ", " + tlist.getState()).
                            snippet("Departure Time " + tlist.getDeparture() + "\nDay " + tlist.getDay());
                    mMap.addMarker(marker_destination).setIcon(BitmapDescriptorFactory.defaultMarker
                            (BitmapDescriptorFactory.HUE_YELLOW));
                }
                if (tlist.getDeparture().equals("Destination")) {
                    MarkerOptions marker_destination = new MarkerOptions().
                            position(dest_latlng).title("Destination Position " + tlist.getName() + ", " + tlist.getState()).
                            snippet("Arrival Time " + tlist.getArrival() + "\nDay " + tlist.getDay());
                    mMap.addMarker(marker_destination).setIcon(BitmapDescriptorFactory.defaultMarker
                            (BitmapDescriptorFactory.HUE_VIOLET));
                }
                MarkerOptions marker_destination = new MarkerOptions().
                        position(dest_latlng).title("Route " + tlist.getName() + ", " + tlist.getState()).
                        snippet("Arrival Time " + tlist.getArrival() + "\nDeparture Time " + tlist.getDeparture() + "\nDay " + tlist.getDay());
                mMap.addMarker(marker_destination).setIcon(BitmapDescriptorFactory.defaultMarker
                        (BitmapDescriptorFactory.HUE_RED));
                route_line.add(dest_latlng);
            }
        }
        Polyline line = mMap.addPolyline(route_line);
        line.setWidth(5);
        line.setColor(Color.DKGRAY);
        line.setGeodesic(true);

    }
}
