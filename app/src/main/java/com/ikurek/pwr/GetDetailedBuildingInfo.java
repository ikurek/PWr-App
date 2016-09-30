package com.ikurek.pwr;

import android.content.Context;

/**
 * Created by Igor on 29.08.2016.
 */
public class GetDetailedBuildingInfo {

    private final Context context;

    //TODO: wygląda głupio, jest głupie, ale działa
    //Osobna klasa, bo liczę na to że kiedyś zbiorę się w sobie i wykorzystam do tego bazę danych
    //Na razie mi się nie chce

    public GetDetailedBuildingInfo(Context current) {
        this.context = current;
    }

    //Funkcje zwracaja stringa zawierającego adres, informacje itd, na bazie nazwy budynku
    public String[] getBuildingData(String buildingName) {


        String[] buildingdata = null;

        if (buildingName == "A-1") {

            buildingdata = context.getResources().getStringArray(R.array.A_1);

        } else if (buildingName == "A-2") {

            buildingdata = context.getResources().getStringArray(R.array.A_2);

        } else if (buildingName == "A-3") {

            buildingdata = context.getResources().getStringArray(R.array.A_3);

        } else if (buildingName == "A-4") {

            buildingdata = context.getResources().getStringArray(R.array.A_4);

        } else if (buildingName == "A-5") {

            buildingdata = context.getResources().getStringArray(R.array.A_5);

        } else if (buildingName == "A-6") {

            buildingdata = context.getResources().getStringArray(R.array.A_6);

        } else if (buildingName == "A-7 (Zielony Domek)") {

            buildingdata = context.getResources().getStringArray(R.array.A_7);

        } else if (buildingName == "A-8") {

            buildingdata = context.getResources().getStringArray(R.array.A_8);

        } else if (buildingName == "A-9") {

            buildingdata = context.getResources().getStringArray(R.array.A_9);

        } else if (buildingName == "A-10") {

            buildingdata = context.getResources().getStringArray(R.array.A_10);

        } else if (buildingName == "A-11") {

            buildingdata = context.getResources().getStringArray(R.array.A_11);

        } else if (buildingName == "B-1") {

            buildingdata = context.getResources().getStringArray(R.array.B_1);

        } else if (buildingName == "B-2") {

            buildingdata = context.getResources().getStringArray(R.array.B_2);

        } else if (buildingName == "B-4") {

            buildingdata = context.getResources().getStringArray(R.array.B_4);

        } else if (buildingName == "B-5") {

            buildingdata = context.getResources().getStringArray(R.array.B_5);

        } else if (buildingName == "B-6") {

            buildingdata = context.getResources().getStringArray(R.array.B_6);

        } else if (buildingName == "B-7") {

            buildingdata = context.getResources().getStringArray(R.array.B_7);

        } else if (buildingName == "B-8") {

            buildingdata = context.getResources().getStringArray(R.array.B_8);

        } else if (buildingName == "B-9") {

            buildingdata = context.getResources().getStringArray(R.array.B_9);

        } else if (buildingName == "B-11") {

            buildingdata = context.getResources().getStringArray(R.array.B_11);

        } else if (buildingName == "C-1") {

            buildingdata = context.getResources().getStringArray(R.array.C_1);

        } else if (buildingName == "C-2") {

            buildingdata = context.getResources().getStringArray(R.array.C_2);

        } else if (buildingName == "C-3") {

            buildingdata = context.getResources().getStringArray(R.array.C_3);

        } else if (buildingName == "C-4") {

            buildingdata = context.getResources().getStringArray(R.array.C_4);

        } else if (buildingName == "C-5") {

            buildingdata = context.getResources().getStringArray(R.array.C_5);

        } else if (buildingName == "C-6") {

            buildingdata = context.getResources().getStringArray(R.array.C_6);

        } else if (buildingName == "C-7") {

            buildingdata = context.getResources().getStringArray(R.array.C_7);

        } else if (buildingName == "C-8") {

            buildingdata = context.getResources().getStringArray(R.array.C_8);

        } else if (buildingName == "C-11 (Wieża Magów)") {

            buildingdata = context.getResources().getStringArray(R.array.C_11);

        } else if (buildingName == "C-13 (Serowiec)") {

            buildingdata = context.getResources().getStringArray(R.array.C_13);

        } else if (buildingName == "C-14") {

            buildingdata = context.getResources().getStringArray(R.array.C_14);

        } else if (buildingName == "C-15") {

            buildingdata = context.getResources().getStringArray(R.array.C_15);

        } else if (buildingName == "C-16 (Technopolis)") {

            buildingdata = context.getResources().getStringArray(R.array.C_16);

        } else if (buildingName == "C-18 (SKS)") {

            buildingdata = context.getResources().getStringArray(R.array.C_18);

        } else if (buildingName == "D-1") {

            buildingdata = context.getResources().getStringArray(R.array.D_1);

        } else if (buildingName == "D-2") {

            buildingdata = context.getResources().getStringArray(R.array.D_2);

        } else if (buildingName == "D-3") {

            buildingdata = context.getResources().getStringArray(R.array.D_3);

        } else if (buildingName == "D-20") {

            buildingdata = context.getResources().getStringArray(R.array.D_20);

        } else if (buildingName == "D-21") {

            buildingdata = context.getResources().getStringArray(R.array.D_21);

        } else if (buildingName == "E-1 (Hogwart)") {

            buildingdata = context.getResources().getStringArray(R.array.E_1);

        } else if (buildingName == "E-3") {

            buildingdata = context.getResources().getStringArray(R.array.E_3);

        } else if (buildingName == "E-5") {

            buildingdata = context.getResources().getStringArray(R.array.E_5);

        } else if (buildingName == "F-1") {

            buildingdata = context.getResources().getStringArray(R.array.F_1);

        } else if (buildingName == "F-2") {

            buildingdata = context.getResources().getStringArray(R.array.F_2);

        } else if (buildingName == "F-3") {

            buildingdata = context.getResources().getStringArray(R.array.F_3);

        } else if (buildingName == "F-4") {

            buildingdata = context.getResources().getStringArray(R.array.F_4);

        } else if (buildingName == "H-3") {

            buildingdata = context.getResources().getStringArray(R.array.H_3);

        } else if (buildingName == "H-4") {

            buildingdata = context.getResources().getStringArray(R.array.H_4);

        } else if (buildingName == "H-5") {

            buildingdata = context.getResources().getStringArray(R.array.H_5);

        } else if (buildingName == "H-6") {

            buildingdata = context.getResources().getStringArray(R.array.H_6);

        } else if (buildingName == "H-7") {

            buildingdata = context.getResources().getStringArray(R.array.H_7);

        } else if (buildingName == "H-8") {

            buildingdata = context.getResources().getStringArray(R.array.H_8);

        } else if (buildingName == "H-9") {

            buildingdata = context.getResources().getStringArray(R.array.H_9);

        } else if (buildingName == "H-10") {

            buildingdata = context.getResources().getStringArray(R.array.H_10);

        } else if (buildingName == "H-12") {

            buildingdata = context.getResources().getStringArray(R.array.H_12);

        } else if (buildingName == "H-13") {

            buildingdata = context.getResources().getStringArray(R.array.H_13);

        } else if (buildingName == "H-14") {

            buildingdata = context.getResources().getStringArray(R.array.H_14);

        } else if (buildingName == "L-1 (Geocentrum)") {

            buildingdata = context.getResources().getStringArray(R.array.L_1);

        } else if (buildingName == "M-3") {

            buildingdata = context.getResources().getStringArray(R.array.M_3);

        } else if (buildingName == "M-4") {

            buildingdata = context.getResources().getStringArray(R.array.M_4);

        } else if (buildingName == "M-6") {

            buildingdata = context.getResources().getStringArray(R.array.M_6);

        } else if (buildingName == "M-11") {

            buildingdata = context.getResources().getStringArray(R.array.M_11);

        } else if (buildingName == "P-2") {

            buildingdata = context.getResources().getStringArray(R.array.P_2);

        } else if (buildingName == "P-4") {

            buildingdata = context.getResources().getStringArray(R.array.P_4);

        } else if (buildingName == "P-14") {

            buildingdata = context.getResources().getStringArray(R.array.P_14);

        } else if (buildingName == "P-20") {

            buildingdata = context.getResources().getStringArray(R.array.P_20);

        } else if (buildingName == "T-2 (Telemik)") {

            buildingdata = context.getResources().getStringArray(R.array.T_2);

        } else if (buildingName == "T-3 (Straszny Dwór)") {

            buildingdata = context.getResources().getStringArray(R.array.T_3);

        } else if (buildingName == "T-4 (Czworak)") {

            buildingdata = context.getResources().getStringArray(R.array.T_4);

        } else if (buildingName == "T-6 (Alcatraz)") {

            buildingdata = context.getResources().getStringArray(R.array.T_6);

        } else if (buildingName == "T-7 (Dom Doktoranta)") {

            buildingdata = context.getResources().getStringArray(R.array.T_7);

        } else if (buildingName == "T-9 (Atol)") {

            buildingdata = context.getResources().getStringArray(R.array.T_9);

        } else if (buildingName == "T-14 (Azyl)") {

            buildingdata = context.getResources().getStringArray(R.array.T_14);

        } else if (buildingName == "T-15 (Hades)") {

            buildingdata = context.getResources().getStringArray(R.array.T_15);

        } else if (buildingName == "T-16 (Tower)") {

            buildingdata = context.getResources().getStringArray(R.array.T_16);

        } else if (buildingName == "T-17 (Ikar)") {

            buildingdata = context.getResources().getStringArray(R.array.T_17);

        } else if (buildingName == "T-19 (Piast)") {

            buildingdata = context.getResources().getStringArray(R.array.T_19);

        } else if (buildingName == "T-22 (Hotel Asystenta)") {

            buildingdata = context.getResources().getStringArray(R.array.T_22);

        }

        return buildingdata;
    }

}
