package structure;

/**
 * Created by igor on 19.04.17.
 */

public class Building {

    private String name;
    private String address;
    private String lat;
    private String lon;


    public Building(String[] buildingInfoInTable) {
        this.name = buildingInfoInTable[0];
        this.address = buildingInfoInTable[1];
        this.lat = buildingInfoInTable[2];
        this.lon = buildingInfoInTable[3];
    }

    public Building(String name, String address, String lat, String lon) {
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

}
