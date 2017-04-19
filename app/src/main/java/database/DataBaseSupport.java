package database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ikurek.pwr.R;

import java.util.ArrayList;
import java.util.Objects;

import structure.Building;

/**
 * Created by igor on 19.04.17.
 */

public class DataBaseSupport extends SQLiteOpenHelper {

    private static final String TAG = "DataBaseSupport";
    private static final String DATABASE_NAME = "pwr.db";
    private static final Integer DATABASE_VERSION = 2;
    public Boolean isOverwriteRequired = false;
    private Context context;

    public DataBaseSupport(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e(TAG, "Database object created");
        db.execSQL("CREATE TABLE IF NOT EXISTS buildings (name TEXT, address TEXT, lat TEXT, lon TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        isOverwriteRequired = true;
    }

    //Checks if tables have values inside
    public Boolean areTablesEmpty() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT count(*) FROM buildings", null);
        cursor.moveToFirst();
        int ammountOfElements = cursor.getInt(0);
        cursor.close();
        if (ammountOfElements != 0) return false;
        else return true;
    }

    //Does a complete overwrite of database using data from XML file
    public void overwriteDatabase() {
        SQLiteDatabase db = getWritableDatabase();
        //Overwrite buildings
        db.execSQL("DROP TABLE IF EXISTS buildings");
        db.execSQL("CREATE TABLE IF NOT EXISTS buildings (name TEXT, address TEXT, lat DOUBLE, lon DOUBLE);");
        fillBuildingDatabase();
        isOverwriteRequired = false;

    }

    //Fills buildings table with data from XML
    private void fillBuildingDatabase() {

        SQLiteDatabase db = getWritableDatabase();

        Log.i(TAG, "Copying building data from array to SQL");

        ArrayList<Building> listOfBuildings = new ArrayList<>();


            //A
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.A_1)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.A_2)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.A_3)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.A_4)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.A_5)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.A_6)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.A_7)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.A_8)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.A_9)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.A_10)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.A_11)));

        //B
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.B_1)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.B_2)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.B_4)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.B_5)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.B_6)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.B_7)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.B_8)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.B_9)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.B_11)));

        //C
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_1)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_2)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_3)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_4)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_5)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_6)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_7)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_8)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_11)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_13)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_14)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_15)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_16)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.C_18)));

        //D
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.D_1)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.D_2)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.D_3)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.D_20)));
            listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.D_21)));

        //E
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.E_1)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.E_3)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.E_5)));

        //F
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.F_1)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.F_2)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.F_3)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.F_4)));

        //H
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_3)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_4)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_5)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_3)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_6)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_7)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_8)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_9)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_10)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_12)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_13)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.H_14)));

        //L
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.L_1)));

        //M
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.M_3)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.M_4)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.M_6)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.M_11)));

        //P
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.P_2)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.P_4)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.P_14)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.P_20)));

        //T
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_2)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_3)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_4)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_6)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_7)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_9)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_14)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_15)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_16)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_17)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_19)));
        listOfBuildings.add(new Building(context.getResources().getStringArray(R.array.T_22)));


        for(Building building : listOfBuildings) {
            db.execSQL("INSERT INTO buildings VALUES(" + DatabaseUtils.sqlEscapeString(building.getName()) + ","
                    + DatabaseUtils.sqlEscapeString(building.getAddress()) + ","
                    + DatabaseUtils.sqlEscapeString(building.getLat()) + ","
                    + DatabaseUtils.sqlEscapeString(building.getLon()) + ");");

        }

        Log.i(TAG, "Data moved to SQL");

    }

    public ArrayList<Building> getAllBuildings() {
        Log.i(TAG, "Getting all buildings from database");
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM buildings", null);
        ArrayList<Building> listOfBuildings = new ArrayList<>();

        //Iterates over all elements selected by query
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

                //Creates new building object and adds it to list
                listOfBuildings.add(new Building(cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("address")),
                        cursor.getString(cursor.getColumnIndex("lat")),
                        cursor.getString(cursor.getColumnIndex("lon"))));
                cursor.moveToNext();
            }

        }
        cursor.close();
        return listOfBuildings;
    }

    public Building getBuilding(String name) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM buildings WHERE name LIKE " + DatabaseUtils.sqlEscapeString(name), null);
        cursor.moveToFirst();

        Building building = new Building(cursor.getString(cursor.getColumnIndex("name")),
                cursor.getString(cursor.getColumnIndex("address")),
                cursor.getString(cursor.getColumnIndex("lat")),
                cursor.getString(cursor.getColumnIndex("lon")));

        cursor.close();
        return building;

    }


}
