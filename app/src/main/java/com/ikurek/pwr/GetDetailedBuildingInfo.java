package com.ikurek.pwr;

/**
 * Created by Igor on 29.08.2016.
 */
public class GetDetailedBuildingInfo {

    //TODO: wygląda głupio, jest głupie, ale działa
    //Osobna klasa, bo liczę na to że kiedyś zbiorę się w sobie i wykorzystam do tego bazę danych
    //Na razie mi się nie chce

    //Funkcje zwracaja stringa zawierającego adres, informacje itd, na bazie nazwy budynku
    public String getBuildingAdress(String buildingName) {
        String buildingAdress = null;

        if (buildingName == "A-1") {

            buildingAdress = "Adres budynku A-1";

        } else if (buildingName == "A-2") {

            buildingAdress = "Adres budynku A-2";
        }

        return buildingAdress;
    }

    public String getBuildingInfo(String buildingName){
        String buildingInfo = null;

        if (buildingName == "A-1") {

            buildingInfo = "Info budynku A-1";

        } else if (buildingName == "A-2") {

            buildingInfo = "Info budynku A-2\nTest wielu lini\nW teori ten teks powinien mieć 3 wiersze";
        }

        return buildingInfo;
    }
}
