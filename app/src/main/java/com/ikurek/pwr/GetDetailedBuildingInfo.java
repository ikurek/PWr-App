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

            buildingAdress = "Wybrzeże Stanisława Wyspiańskiego 27, Wrocław";

        } else if (buildingName == "A-2") {

            buildingAdress = "Ul. Ignacego Łukasiewicza 2, Wrocław";

        } else if (buildingName == "A-3") {

            buildingAdress = "Ul. Mariana Smoluchowskiego 23, Wrocław";

        } else if (buildingName == "A-4") {

            buildingAdress = "Ul. Mariana Smoluchowskiego 21, Wrocław";

        } else if (buildingName == "A-5") {

            buildingAdress = "Ul. Mariana Smoluchowskiego 19, Wrocław";

        } else if (buildingName == "A-6") {

            buildingAdress = "Ul. Cypriana Kamila Norwida 1, Wrocław";

        } else if (buildingName == "A-7") {

            buildingAdress = "Ul. Cypriana Kamila Norwida 2, Wrocław";

        } else if (buildingName == "A-8") {

            buildingAdress = "Ul. Mariana Smoluchowskiego 20, Wrocław";

        } else if (buildingName == "A-9") {

            buildingAdress = "???";

        } else if (buildingName == "A-10") {

            buildingAdress = "Cypriana Kamila Norwida 3, Wrocław";

        } else if (buildingName == "B-1") {

            buildingAdress = "Ul. Mariana Smoluchowskiego 25, Wrocław";

        } else if (buildingName == "B-2") {

            buildingAdress = "Ul. Ignacego Łukasiewicza 1, Wrocław";

        } else if (buildingName == "B-4") {

            buildingAdress = "ul. Ignacego Łukasiewicza 3/5, Wrocław";

        } else if (buildingName == "B-5") {

            buildingAdress = "ul. Ignacego Łukasiewicza 7/9, Wrocław";

        } else if (buildingName == "C-1") {

            buildingAdress = "Ul. Zygmunta Janiszewskiego 11/17, Wrocław";

        } else if (buildingName == "C-2") {

            buildingAdress = "Ul. Zygmunta Janiszewskiego 11/17, Wrocław";

        } else if (buildingName == "C-3") {

            buildingAdress = "Ul. Zygmunta Janiszewskiego 11/17, Wrocław";

        } else if (buildingName == "C-4") {

            buildingAdress = "Ul. Zygmunta Janiszewskiego 7/9, Wrocław";

        } else if (buildingName == "C-5") {

            buildingAdress = "Ul. Zygmunta Janiszewskiego 7/9, Wrocław";

        } else if (buildingName == "C-6") {

            buildingAdress = "Ul. Cypriana Kamila Norwida 4/6, Wrocław";

        } else if (buildingName == "C-7") {

            buildingAdress = "Plac Grunwaldzki 11, Wrocław";

        } else if (buildingName == "C-8") {

            buildingAdress = "Plac Grunwaldzki 14, Wrocław";

        } else if (buildingName == "D-1") {

            buildingAdress = "Plac Grunwaldzki 13, Wrocław";

        } else if (buildingName == "D-2") {

            buildingAdress = "Plac Grunwaldzki 9, Wrocław";

        } else if (buildingName == "D-3") {

            buildingAdress = "Plac Grunwaldzki 9a, Wrocław";

        } else if (buildingName == "D-20") {

            buildingAdress = "Ul. Zygmunta Janiszewskiego 8, Wrocław";

        } else if (buildingName == "D-21") {

            buildingAdress = "Plac Grunwaldzki 11, Wrocław";

        } else if (buildingName == "E-1") {

            buildingAdress = "Ul. Bolesława Prusa 53/55, Wrocław";

        } else if (buildingName == "E-3") {

            buildingAdress = "Ul. Chemiczna 4, Wrocław";

        } else if (buildingName == "E-5") {

            buildingAdress = "Ul. Rozbrat 7, Wrocław";

        } else if (buildingName == "F-1") {

            buildingAdress = "Ul. Gdańska 7/9, Wrocław";

        } else if (buildingName == "F-2") {

            buildingAdress = "Ul. Gdańska 7/9, Wrocław";

        } else if (buildingName == "F-3") {

            buildingAdress = "Ul. Gdańska 7/9, Wrocław";

        } else if (buildingName == "F-4") {

            buildingAdress = "Ul. Gdańska 7/9, Wrocław";

        } else if (buildingName == "H-3") {

            buildingAdress = "Wybrzeże Stanisława Wyspiańskiego 41, Wrocław";

        } else if (buildingName == "H-4") {

            buildingAdress = "Wybrzeże Stanisława Wyspiańskiego 7, Wrocław";

        } else if (buildingName == "H-5") {

            buildingAdress = "???";

        } else if (buildingName == "H-6") {

            buildingAdress = "???";

        } else if (buildingName == "H-7") {

            buildingAdress = "???";

        } else if (buildingName == "H-8") {

            buildingAdress = "???";

        } else if (buildingName == "H-9") {

            buildingAdress = "???";

        } else if (buildingName == "H-10") {

            buildingAdress = "???";

        } else if (buildingName == "H-14") {

            buildingAdress = "Wybrzeże Stanisława Wyspiańskiego 40, Wrocław";

        } else if (buildingName == "L-1") {

            buildingAdress = "Ul. Na Grobli 13/15, Wrocław";

        } else if (buildingName == "M-3") {

            buildingAdress = "Ul. Długa 61, Wrocław";

        } else if (buildingName == "M-4") {

            buildingAdress = "???";

        } else if (buildingName == "M-6") {

            buildingAdress = "???";

        } else if (buildingName == "M-11") {

            buildingAdress = "???";

        } else if (buildingName == "P-2") {

            buildingAdress = "Ul. Józefa Chełmońskiego 16, Wrocław";

        } else if (buildingName == "P-4") {

            buildingAdress = "???";

        } else if (buildingName == "P-14") {

            buildingAdress = "???";

        } else if (buildingName == "P-20") {

            buildingAdress = "???";

        }

        return buildingAdress;
    }

    public String getBuildingInfo(String buildingName) {
        String buildingInfo = null;

        if (buildingName == "A-1") {

            buildingInfo = "Gabinet Rektora\n" +
                    "Gabinety Pełnomocników Rektora\n" +
                    "Gabinety Prorektorów\n" +
                    "Sekretariat Uczelni\n" +
                    "Sekretariat Wydziału Inżynierii Środowiska\n" +
                    "Sekretariat Wydziału Mechaniczno-Energetycznego\n" +
                    "Sekretariat Wydziału Podstawowych Problemów Techniki\n" +
                    "Instytut Fizyki\n" +
                    "Instytut Inżynierii Lądowej";

        } else if (buildingName == "A-2") {

            buildingInfo = "Instytut Chemii Organicznej, Biochemii i Biotechnologii\n" +
                    "Instytut Technologii Organicznej i Tworzyw Sztucznych\n" +
                    "Instytut Chemii Fizycznej i Teoretycznej\n" +
                    "Zakład Chemii Kwantowej";
        }

        return buildingInfo;
    }
}
