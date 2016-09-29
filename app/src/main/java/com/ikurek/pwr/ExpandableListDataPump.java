package com.ikurek.pwr;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Igor on 29.08.2016.
 */
public class ExpandableListDataPump {
    public static LinkedHashMap<String, List<String>> getData() {

        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<>();


        List<String> abuildings = new ArrayList<>();
        abuildings.add("A-1");
        abuildings.add("A-2");
        abuildings.add("A-3");
        abuildings.add("A-4");
        abuildings.add("A-5");
        abuildings.add("A-6");
        abuildings.add("A-7");
        abuildings.add("A-8");
        abuildings.add("A-9");
        abuildings.add("A-10");
        abuildings.add("A-11");
        expandableListDetail.put("A", abuildings);

        List<String> bbuildings = new ArrayList<>();
        bbuildings.add("B-1");
        bbuildings.add("B-2");
        bbuildings.add("B-4");
        bbuildings.add("B-5");
        bbuildings.add("B-6");
        bbuildings.add("B-7");
        bbuildings.add("B-8");
        bbuildings.add("B-9");
        bbuildings.add("B-11");
        expandableListDetail.put("B", bbuildings);

        List<String> cbuildings = new ArrayList<>();
        cbuildings.add("C-1");
        cbuildings.add("C-2");
        cbuildings.add("C-3");
        cbuildings.add("C-4");
        cbuildings.add("C-5");
        cbuildings.add("C-6");
        cbuildings.add("C-7");
        cbuildings.add("C-8");
        cbuildings.add("C-11");
        cbuildings.add("C-13");
        cbuildings.add("C-14");
        cbuildings.add("C-15");
        cbuildings.add("C-16");
        cbuildings.add("C-18");
        expandableListDetail.put("C", cbuildings);

        List<String> dbuildings = new ArrayList<>();
        dbuildings.add("D-1");
        dbuildings.add("D-2");
        dbuildings.add("D-3");
        dbuildings.add("D-20");
        dbuildings.add("D-21");
        expandableListDetail.put("D", dbuildings);

        List<String> ebuildings = new ArrayList<>();
        ebuildings.add("E-1");
        ebuildings.add("E-3");
        ebuildings.add("E-5");
        expandableListDetail.put("E", ebuildings);

        List<String> fbuildings = new ArrayList<>();
        fbuildings.add("F-1");
        fbuildings.add("F-2");
        fbuildings.add("F-3");
        fbuildings.add("F-4");
        expandableListDetail.put("F", fbuildings);

        List<String> hbuildings = new ArrayList<>();
        hbuildings.add("H-3");
        hbuildings.add("H-4");
        hbuildings.add("H-5");
        hbuildings.add("H-6");
        hbuildings.add("H-7");
        hbuildings.add("H-8");
        hbuildings.add("H-9");
        hbuildings.add("H-10");
        hbuildings.add("H-12");
        hbuildings.add("H-13");
        hbuildings.add("H-14");
        expandableListDetail.put("H", hbuildings);

        List<String> lbuildings = new ArrayList<>();
        lbuildings.add("L-1");
        expandableListDetail.put("L", lbuildings);

        List<String> mbuildings = new ArrayList<>();
        mbuildings.add("M-3");
        mbuildings.add("M-4");
        mbuildings.add("M-6");
        mbuildings.add("M-11");
        expandableListDetail.put("M", mbuildings);

        List<String> pbuildings = new ArrayList<>();
        pbuildings.add("P-2");
        pbuildings.add("P-4");
        pbuildings.add("P-14");
        pbuildings.add("P-20");
        expandableListDetail.put("P", pbuildings);

        List<String> tbuildings = new ArrayList<>();
        tbuildings.add("T-2");
        tbuildings.add("T-3");
        tbuildings.add("T-4");
        tbuildings.add("T-6");
        tbuildings.add("T-7");
        tbuildings.add("T-9");
        tbuildings.add("T-14");
        tbuildings.add("T-15");
        tbuildings.add("T-16");
        tbuildings.add("T-17");
        tbuildings.add("T-19");
        tbuildings.add("T-22");
        expandableListDetail.put("T", tbuildings);

        return expandableListDetail;
    }
}
