package com.rail.injilaislam.railways;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapDestination extends FragmentActivity implements OnMapReadyCallback {

    Boolean source = true, destination = true;
    Button reset_button, next_button;
    private GoogleMap mMap;
    MarkerOptions marker_source, marker_destination;
    LatLng source_point_latlng, destination_latlng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_destination);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        reset_button = (Button) findViewById(R.id.reset);
        next_button = (Button) findViewById(R.id.next);
        mapFragment.getMapAsync(this);
        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                source = true;
                destination = true;
                mMap.clear();
            }
        });
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (source == false && destination == false) {

                    Intent intentMain = new Intent(MapDestination.this,
                            Computation.class);

                    intentMain.putExtra("Source_lat", source_point_latlng.latitude);
                    intentMain.putExtra("Source_lng",source_point_latlng.longitude);
                    intentMain.putExtra("Destination_lat", destination_latlng.latitude);
                    intentMain.putExtra("Destination_lng", destination_latlng.longitude);
                    MapDestination.this.startActivity(intentMain);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "First Select Source and Destination", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        ConnectionCheck chk = new ConnectionCheck(this);
        if (!(chk.isConnectingToInternet())) {
            Toast.makeText(getApplicationContext(),
                    "First Connect to Internet", Toast.LENGTH_SHORT).show();

        } else {
            mMap = googleMap;
            LatLng India = new LatLng(21, 78);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(India));

                mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                    @Override
                    public void onMapLongClick(LatLng source_point) {
                        if (source) {
                            source_point_latlng = new LatLng(source_point.latitude,
                                    source_point.longitude);
                            marker_source = new MarkerOptions().position
                                    (source_point_latlng).title("Source Position");
                            mMap.addMarker(marker_source).setIcon(BitmapDescriptorFactory.defaultMarker
                                    (BitmapDescriptorFactory.HUE_YELLOW));
                            Log.e("Source Position",""+source_point_latlng.toString());
                            source = false;

                        }
                    }
                });



                mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng dest_point) {
                        if (destination) {
                            destination_latlng = new LatLng(dest_point.latitude,
                                    dest_point.longitude);
                            marker_destination = new MarkerOptions().
                                    position(destination_latlng).title("Destination Position");
                            mMap.addMarker(marker_destination).setIcon(BitmapDescriptorFactory.defaultMarker
                                    (BitmapDescriptorFactory.HUE_VIOLET));
                            Log.e("Destination Position", "" + destination_latlng.toString());
                            destination = false;
                        }

                        }
                    });
        }
    }


}
