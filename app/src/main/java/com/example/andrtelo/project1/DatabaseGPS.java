package com.example.andrtelo.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import static android.support.constraint.Constraints.TAG;

public class DatabaseGPS {

    private static final String KEY_ROWID = "_id";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_LATITUDE = "latitude";
    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME_GPS = "GPSdb";
    private static final String DATABASE_TABLE_GPS = "GPS";
    private static final int DATABASE_VERSION = 1;

    //criaçao da tabela para as cordenadas GPS
    private static final String DATABASE_CREATE_LATLNG =
            "create table GPS (_id integer primary key autoincrement," +
                    "longitude text not null, " +
                    "latitude text not null);";

    private Context context = null;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public DatabaseGPS(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME_GPS, null, 1);

        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_LATLNG);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS GPS");
            onCreate(db);
        }
    }


    public void open() throws SQLException {
        db = DBHelper.getWritableDatabase();
    }

    public void close() {
        DBHelper.close();
    }

    public long AddGPS(double lat, double log) {
        db = DBHelper.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_LATITUDE, lat);
        initialValues.put(KEY_LONGITUDE, log);

        long b = db.insert(DATABASE_TABLE_GPS, null, initialValues);

        Toast.makeText(context, "guardou", Toast.LENGTH_SHORT).show();
        return b;
    }


    public double getlat() {
        double teste;

        db = DBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DATABASE_TABLE_GPS, null);//" WHERE longitude=? and latitude = ?" , new String[]{});
        String lat_ = "";

        if (cursor.getCount() > 0) {
            // means search has returned data

            if (cursor.moveToFirst()) {
                do {
                    lat_ = cursor.getString(cursor.getColumnIndex(KEY_LATITUDE));
                    //String longi = cursor.getString(cursor.getColumnIndex(KEY_LONGITUDE));
                    Toast.makeText(context, "latti" + lat_, Toast.LENGTH_SHORT).show();
                } while (cursor.moveToNext());
            }

        } else {
            Toast.makeText(context, "No data was found in the system!", Toast.LENGTH_SHORT).show();
        }
        teste =  Double.valueOf(lat_);

        Toast.makeText(context, "vai enviar testelat_:" + lat_, Toast.LENGTH_SHORT).show();

        return teste;
    }

    public double getlong() {
        double teste;
        db = DBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DATABASE_TABLE_GPS, null);//" WHERE longitude=? and latitude = ?" , new String[]{});
        String long_ = "";

        if (cursor.getCount() > 0) {
            // means search has returned data

            if (cursor.moveToFirst()) {
                do {
                    long_ = cursor.getString(cursor.getColumnIndex(KEY_LONGITUDE));
                    Toast.makeText(context, "latti" + long_, Toast.LENGTH_SHORT).show();
                } while (cursor.moveToNext());
            }

        } else {
            Toast.makeText(context, "No data was found in the system!", Toast.LENGTH_SHORT).show();
        }

        teste =  Double.valueOf(long_);

        Toast.makeText(context, "vai enviar teste:" + long_, Toast.LENGTH_SHORT).show();

        return teste;
    }


}