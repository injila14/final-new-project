package com.rail.injilaislam.railways;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

public class SD_Database extends SQLiteOpenHelper{

    private static final String Source_table = "SD_table";
    private static String Database_name = "SD_db";
    private static int Database_version = 1;
    private static String table_sql;
    private static String Name = "Station_Name";
    private static String Code = "Station_Code";
    private static String Latitude = "Latitude";
    private static String Longitude = "Longitude";


    public SD_Database(Context context) {
        super(context, Database_name, null, Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        table_sql = "Create table "+ Source_table+" ( "+Name +" text, "+ Code+" text, " +
                Latitude + " Real, "+ Longitude+" Real )";
        db.execSQL(table_sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + Source_table);
        onCreate(db);

    }
        public void insert (){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(Source_table,null,null);
            Log.e("Delete", "Delete if any data");

            ContentValues value1 = new ContentValues();
            value1.put(Name, "Agra");
            value1.put(Code, "AGC");
            value1.put("Latitude", 27.158074);
            value1.put("Longitude", 77.989552);
            db.insert(Source_table, null, value1);

            ContentValues value2 = new ContentValues();
            value2.put(Name, "Ahmedabad");
            value2.put(Code, "ADI");
            value2.put("Latitude", 22.998602);
            value2.put("Longitude", 72.611028);
            db.insert(Source_table, null, value2);

            ContentValues value3 = new ContentValues();
            value3.put(Name, "Ajmer");
            value3.put(Code, "AII");
            value3.put("Latitude", 26.457851);
            value3.put("Longitude", 74.637503);
            db.insert(Source_table, null, value3);

            ContentValues value4 = new ContentValues();
            value4.put(Name, "Ambala");
            value4.put(Code, "UMB");
            value4.put("Latitude", 30.338472);
            value4.put("Longitude", 76.827572);
            db.insert(Source_table, null, value4);

            ContentValues value5 = new ContentValues();
            value5.put(Name, "Amritsar");
            value5.put(Code, "ASR");
            value5.put("Latitude", 31.633369);
            value5.put("Longitude", 74.867110);
            db.insert(Source_table, null, value5);

            ContentValues value6 = new ContentValues();
            value6.put(Name, "Aurangabad");
            value6.put(Code, "AWB");
            value6.put("Latitude",19.860131);
            value6.put("Longitude", 75.311444);
            db.insert(Source_table, null, value6);

            ContentValues value7 = new ContentValues();
            value7.put(Name, "Bangalore");
            value7.put(Code, "SBC");
            value7.put("Latitude",12.978433);
            value7.put("Longitude", 77.569456);
            db.insert(Source_table, null, value7);

            ContentValues value8 = new ContentValues();
            value8.put(Name, "Bareilly");
            value8.put(Code, "BE");
            value8.put("Latitude", 28.337181);
            value8.put("Longitude", 79.411039);
            db.insert(Source_table, null, value8);

            ContentValues value9 = new ContentValues();
            value9.put(Name, "Bhopal");
            value9.put(Code, "BPL");
            value9.put("Latitude", 23.267977);
            value9.put("Longitude", 77.414007);
            db.insert(Source_table, null, value9);

            ContentValues value10 = new ContentValues();
            value10.put(Name, "Bhubaneshwar");
            value10.put(Code, "BBS");
            value10.put("Latitude", 20.266621);
            value10.put("Longitude", 85.843798);
            db.insert(Source_table, null, value10);

            ContentValues value11 = new ContentValues();
            value11.put(Name, "Bhusaval");
            value11.put(Code, "BSL");
            value11.put("Latitude", 21.047001);
            value11.put("Longitude", 75.788382);
            db.insert(Source_table, null, value11);

            ContentValues value12 = new ContentValues();
            value12.put(Name, "Bilaspur");
            value12.put(Code, "BSP");
            value12.put("Latitude",22.054984);
            value12.put("Longitude", 82.171717);
            db.insert(Source_table, null, value12);

            ContentValues value13 = new ContentValues();
            value13.put(Name, "Chandigarh");
            value13.put(Code, "CDG");
            value13.put("Latitude",30.701897);
            value13.put("Longitude", 76.822000);
            db.insert(Source_table, null, value13);

            ContentValues value14 = new ContentValues();
            value14.put(Name, "Coimbatore");
            value14.put(Code, "CBE");
            value14.put("Latitude", 10.996650);
            value14.put("Longitude", 76.967222);
            db.insert(Source_table, null, value14);

            ContentValues value15 = new ContentValues();
            value15.put(Name, "Cuttack");
            value15.put(Code, "CTC");
            value15.put("Latitude", 20.463880);
            value15.put("Longitude", 85.900156);
            db.insert(Source_table, null, value15);

            ContentValues value16 = new ContentValues();
            value16.put(Name, "Dehradun");
            value16.put(Code, "DDN");
            value16.put("Latitude", 30.314184);
            value16.put("Longitude", 78.033430);
            db.insert(Source_table, null, value16);

            ContentValues value17 = new ContentValues();
            value17.put(Name, "Dhanbad");
            value17.put(Code, "DHN");
            value17.put("Latitude", 23.791287);
            value17.put("Longitude", 86.429792);
            db.insert(Source_table, null, value17);

            ContentValues value18 = new ContentValues();
            value18.put(Name, "Ernakulam ");
            value18.put(Code, "ERS");
            value18.put("Latitude",9.969079);
            value18.put("Longitude", 76.290935);
            db.insert(Source_table, null, value18);

            ContentValues value19 = new ContentValues();
            value19.put(Name, "Erode");
            value19.put(Code, "ED");
            value19.put("Latitude",11.327991);
            value19.put("Longitude", 77.726062);
            db.insert(Source_table, null, value19);

            ContentValues value20 = new ContentValues();
            value20.put(Name, "Ghaziabad");
            value20.put(Code, "GZB");
            value20.put("Latitude", 28.653827);
            value20.put("Longitude", 77.427040);
            db.insert(Source_table, null, value20);

            ContentValues value21 = new ContentValues();
            value21.put(Name, "Gorakhpur");
            value21.put(Code, "GKP");
            value21.put("Latitude", 26.759579);
            value21.put("Longitude", 83.382267);
            db.insert(Source_table, null, value21);

            ContentValues value22 = new ContentValues();
            value22.put(Name, "Guwahati");
            value22.put(Code, "GHY");
            value22.put("Latitude", 26.182067);
            value22.put("Longitude", 91.750687);
            db.insert(Source_table, null, value22);

            ContentValues value23 = new ContentValues();
            value23.put(Name, "Haridwar");
            value23.put(Code, "HW");
            value23.put("Latitude", 29.948272);
            value23.put("Longitude", 78.155552);
            db.insert(Source_table, null, value23);

            ContentValues value24 = new ContentValues();
            value24.put(Name, "Howrah");
            value24.put(Code, "HW");
            value24.put("Latitude", 22.583818);
            value24.put("Longitude", 88.342170);
            db.insert(Source_table, null, value24);

            ContentValues value25 = new ContentValues();
            value25.put(Name, "Indore");
            value25.put(Code, "INDB");
            value25.put("Latitude", 22.717471);
            value25.put("Longitude", 75.868272);
            db.insert(Source_table, null, value25);

            ContentValues value26 = new ContentValues();
            value26.put(Name, "Jabalpur");
            value26.put(Code, "JBP");
            value26.put("Latitude", 23.172413);
            value26.put("Longitude", 79.932124);
            db.insert(Source_table, null, value26);

            ContentValues value27 = new ContentValues();
            value27.put(Name, "Jaipur");
            value27.put(Code, "JP");
            value27.put("Latitude", 26.920248);
            value27.put("Longitude", 75.786804);
            db.insert(Source_table, null, value27);

            ContentValues value28 = new ContentValues();
            value28.put(Name, "Jammu");
            value28.put(Code, "JAT");
            value28.put("Latitude", 32.706530);
            value28.put("Longitude", 74.880672);
            db.insert(Source_table, null, value28);

            ContentValues value29 = new ContentValues();
            value29.put(Name, "Jhansi");
            value29.put(Code, "JHS");
            value29.put("Latitude", 25.444845);
            value29.put("Longitude", 78.552577);
            db.insert(Source_table, null, value29);

            ContentValues value30 = new ContentValues();
            value30.put(Name, "Jodhpur");
            value30.put(Code, "JU");
            value30.put("Latitude",26.283627);
            value30.put("Longitude", 73.023007);
            db.insert(Source_table, null, value30);

            ContentValues value31 = new ContentValues();
            value31.put(Name, "Kanpur");
            value31.put(Code, "CNB");
            value31.put("Latitude",26.454948);
            value31.put("Longitude", 80.350436);
            db.insert(Source_table, null, value31);

            ContentValues value32 = new ContentValues();
            value32.put(Name, "Katihar");
            value32.put(Code, "KIR");
            value32.put("Latitude", 25.547953);
            value32.put("Longitude", 87.565122);
            db.insert(Source_table, null, value32);

            ContentValues value33 = new ContentValues();
            value33.put(Name, "Kharagpur");
            value33.put(Code, "KGP");
            value33.put("Latitude", 22.340898);
            value33.put("Longitude", 87.325806);
            db.insert(Source_table, null, value33);

            ContentValues value34 = new ContentValues();
            value34.put(Name, "Kota");
            value34.put(Code, "KOTA");
            value34.put("Latitude", 25.223796);
            value34.put("Longitude", 75.880756);
            db.insert(Source_table, null, value34);

            ContentValues value35 = new ContentValues();
            value35.put(Name, "LUCKNOW");
            value35.put(Code, "LKO");
            value35.put("Latitude", 26.831646);
            value35.put("Longitude", 80.922082);
            db.insert(Source_table, null, value35);

            ContentValues value36 = new ContentValues();
            value36.put(Name, "Madurai");
            value36.put(Code, "MDU");
            value36.put("Latitude", 9.917721);
            value36.put("Longitude", 78.111641);
            db.insert(Source_table, null, value36);

            ContentValues value37 = new ContentValues();
            value37.put(Name, "Moradab");
            value37.put(Code, "MB");
            value37.put("Latitude",28.831296);
            value37.put("Longitude", 78.765830);
            db.insert(Source_table, null, value37);

            ContentValues value38 = new ContentValues();
            value38.put(Name, "Mumbai");
            value38.put(Code, "BCT");
            value38.put("Latitude", 18.970760);
            value38.put("Longitude", 72.819478);
            db.insert(Source_table, null, value38);

            ContentValues value39 = new ContentValues();
            value39.put(Name, "Mysore");
            value39.put(Code, "MYS");
            value39.put("Latitude", 12.316717);
            value39.put("Longitude", 76.646333);
            db.insert(Source_table, null, value39);

            ContentValues value40 = new ContentValues();
            value40.put(Name, "Nagpur");
            value40.put(Code, "NGP");
            value40.put("Latitude", 21.151924);
            value40.put("Longitude", 79.088689);
            db.insert(Source_table, null, value40);

            ContentValues value41 = new ContentValues();
            value41.put(Name, "New Delhi");
            value41.put(Code, "NDLS");
            value41.put("Latitude", 28.642771);
            value41.put("Longitude", 77.220962);
            db.insert(Source_table, null, value41);

            ContentValues value42 = new ContentValues();
            value42.put(Name, "Patna ");
            value42.put(Code, "PNBE");
            value42.put("Latitude",25.602724);
            value42.put("Longitude", 85.137240);
            db.insert(Source_table, null, value42);

            ContentValues value43 = new ContentValues();
            value43.put(Name, "Pune");
            value43.put(Code, "PUNE");
            value43.put("Latitude",18.528887);
            value43.put("Longitude", 73.874388);
            db.insert(Source_table, null, value43);

            ContentValues value44 = new ContentValues();
            value44.put(Name, "Raipur");
            value44.put(Code, "R");
            value44.put("Latitude", 21.256362);
            value44.put("Longitude", 81.629883);
            db.insert(Source_table, null, value44);

            ContentValues value45 = new ContentValues();
            value45.put(Name, "Rajkot");
            value45.put(Code, "RJT");
            value45.put("Latitude", 22.311768);
            value45.put("Longitude", 70.803047);
            db.insert(Source_table, null, value45);

            ContentValues value46 = new ContentValues();
            value46.put(Name, "Ranchi");
            value46.put(Code, "RNC");
            value46.put("Latitude", 23.349483);
            value46.put("Longitude", 85.335677);
            db.insert(Source_table, null, value46);

            ContentValues value47 = new ContentValues();
            value47.put(Name, "Ratlam");
            value47.put(Code, "RTM");
            value47.put("Latitude", 23.340627);
            value47.put("Longitude", 75.050484);
            db.insert(Source_table, null, value47);

            ContentValues value48 = new ContentValues();
            value48.put(Name, "Rourkela");
            value48.put(Code, "ROU");
            value48.put("Latitude", 22.228090);
            value48.put("Longitude", 84.861896);
            db.insert(Source_table, null, value48);

            ContentValues value49 = new ContentValues();
            value49.put(Name, "Siwan");
            value49.put(Code, "SV");
            value49.put("Latitude", 26.211032);
            value49.put("Longitude", 84.358302);
            db.insert(Source_table, null, value49);

            ContentValues value50 = new ContentValues();
            value50.put(Name, "Surat");
            value50.put(Code, "ST");
            value50.put("Latitude", 21.204884);
            value50.put("Longitude", 72.840947);
            db.insert(Source_table, null, value50);

            ContentValues value51 = new ContentValues();
            value51.put(Name, "Tiruchirapalli");
            value51.put(Code, "TPJ");
            value51.put("Latitude", 10.794201);
            value51.put("Longitude", 78.685384);
            db.insert(Source_table, null, value51);

            ContentValues value52 = new ContentValues();
            value52.put(Name, "Tirupati");
            value52.put(Code, "TPTY");
            value52.put("Latitude", 13.627891);
            value52.put("Longitude", 79.419398);
            db.insert(Source_table, null, value52);

            ContentValues value53 = new ContentValues();
            value53.put(Name, "Trichur");
            value53.put(Code, "TCR");
            value53.put("Latitude", 10.514514);
            value53.put("Longitude", 76.207672);
            db.insert(Source_table, null, value53);

            ContentValues value54 = new ContentValues();
            value54.put(Name, "Udaipur");
            value54.put(Code, "UDZ");
            value54.put("Latitude",  24.568357);
            value54.put("Longitude", 73.699800);
            db.insert(Source_table, null, value54);

            ContentValues value55 = new ContentValues();
            value55.put(Name, "Ujjain");
            value55.put(Code, "UJN");
            value55.put("Latitude", 23.178716);
            value55.put("Longitude", 75.781445);
            db.insert(Source_table, null, value55);

            ContentValues value56 = new ContentValues();
            value56.put(Name, "Visakhapatnam");
            value56.put(Code, "VSKP");
            value56.put("Latitude",  17.722048);
            value56.put("Longitude", 83.289731);
            db.insert(Source_table, null, value56);
        }
    public String distance_calc(double latitude, double longitude) {
        String selectQuery = "select * from " + Source_table;
        String closest_station = "";
        double min_distance=0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Log.d("Check", "Get_All");

        if (cursor != null && cursor.moveToFirst()) {

            double first_des_longitude = cursor.getDouble(cursor
                    .getColumnIndex(SD_Database.Longitude));
            double first_des_latitude = cursor.getDouble(cursor
                    .getColumnIndex(SD_Database.Latitude));

            Location first_source_loc = new Location("");
            Location first_destination_loc = new Location("");

            first_source_loc.setLongitude(longitude);
            first_source_loc.setLatitude(latitude);
            first_destination_loc.setLatitude(first_des_latitude);
            first_destination_loc.setLongitude(first_des_longitude);

            min_distance = first_source_loc.distanceTo(first_destination_loc)/1000;

            do {
                double des_longitude = cursor.getDouble(cursor
                        .getColumnIndex(SD_Database.Longitude));
                double des_latitude = cursor.getDouble(cursor
                        .getColumnIndex(SD_Database.Latitude));
                String station = cursor.getString(cursor
                        .getColumnIndex(SD_Database.Code));

                Location source_loc = new Location("");
                Location destination_loc = new Location("");

                source_loc.setLongitude(longitude);
                source_loc.setLatitude(latitude);
                destination_loc.setLatitude(des_latitude);
                destination_loc.setLongitude(des_longitude);

                double distance = source_loc.distanceTo(destination_loc)/1000;
                if(distance < min_distance){
                    min_distance = distance;
                    closest_station = station;
                }


            } while (cursor.moveToNext());
        }
        Log.e("ClosestStation",closest_station);
        Log.e("MinDistance", ""+min_distance);
        return closest_station;

    }
    public String station_name(String station_c){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Source_table
                + " where Station_Code = '" + station_c +"'", null);
        String s_name = "";

        if (cursor != null && cursor.moveToFirst()) {

                 s_name = cursor.getString(cursor
                        .getColumnIndex(SD_Database.Name));


        }

        return s_name;

    }
    public LatLng station_latlng(String station_c){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Source_table
                + " where Station_Code = '" + station_c + "'", null);
        Double lat, lng;

        if (cursor != null && cursor.moveToFirst()) {

            lat = cursor.getDouble(cursor
                    .getColumnIndex(SD_Database.Latitude));

            lng = cursor.getDouble(cursor
                    .getColumnIndex(SD_Database.Longitude));
            return new LatLng(lat,lng);

        }
        else {
            return null;
        }


    }


}
