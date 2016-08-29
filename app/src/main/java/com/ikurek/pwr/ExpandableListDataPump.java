package com.ikurek.pwr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Igor on 29.08.2016.
 */
public class ExpandableListDataPump {
    public static LinkedHashMap<String, List<String>> getData() {

        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();


        List<String> abuildings = new ArrayList<String>();
        abuildings.add("A-1");
        abuildings.add("A-2");
        abuildings.add("A-3");
        abuildings.add("A-5");
        abuildings.add("A-7");
        expandableListDetail.put("A", abuildings);

        List<String> bbuildings = new ArrayList<String>();
        bbuildings.add("B-1");
        bbuildings.add("B-2");
        bbuildings.add("B-3");
        bbuildings.add("B-5");
        bbuildings.add("B-6");
        expandableListDetail.put("B", bbuildings);

        List<String> cbuildings = new ArrayList<String>();
        cbuildings.add("C-1");
        cbuildings.add("C-3");
        cbuildings.add("C-4");
        cbuildings.add("C-5");
        cbuildings.add("C-6");
        expandableListDetail.put("C", cbuildings);

        List<String> dbuildings = new ArrayList<String>();
        dbuildings.add("D-1");
        dbuildings.add("D-2");
        dbuildings.add("D-3");
        dbuildings.add("D-5");
        dbuildings.add("D-7");
        expandableListDetail.put("D", dbuildings);

        List<String> ebuildings = new ArrayList<String>();
        dbuildings.add("E-1");
        dbuildings.add("E-2");
        dbuildings.add("E-3");
        dbuildings.add("E-5");
        dbuildings.add("E-7");
        expandableListDetail.put("E", ebuildings);

        List<String> fbuildings = new ArrayList<String>();
        dbuildings.add("F-1");
        dbuildings.add("F-2");
        dbuildings.add("F-3");
        dbuildings.add("F-5");
        dbuildings.add("F-7");
        expandableListDetail.put("F", fbuildings);

        List<String> gbuildings = new ArrayList<String>();
        dbuildings.add("G-1");
        dbuildings.add("G-2");
        dbuildings.add("G-3");
        dbuildings.add("G-5");
        dbuildings.add("G-7");
        expandableListDetail.put("G", gbuildings);

        return expandableListDetail;
    }
}