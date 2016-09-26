#include <iostream>
#include <sstream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
    ifstream datafromcsv;
    ofstream datatoxml;

    datafromcsv.open("Bdynki.csv");
    datatoxml.open("Buildings.xml");

    //Dodaje startową linię do pliku xml
    datatoxml<< "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n\n";


    string line;

    //Zbiera całą linię z pliku csv
    while(getline(datafromcsv,line))
    {
        stringstream lineStream(line);
        string cell;
        int cellFieldCounter = 0;

        //Zbiera komórkę z linii
        while(getline(lineStream,cell,';'))
        {
          switch(cellFieldCounter) {
            //Nazwa
            case 0:
            datatoxml << "<string-array name=\"" + cell + "\">\n\n";
            break;

//Adres
            case 1:
            datatoxml << "<item>" + cell + "</item>\n";
            break;
//Lat
            case 2:
            datatoxml << "<item>" + cell + "</item>\n";
            break;
//Long i zamknięcie
            case 3:
            datatoxml << "<item>" + cell + "</item>\n\n</string-array>\n\n";
            break;

          }

          cellFieldCounter++;

        }
    }

datatoxml << "</resources>";
datafromcsv.close();
datatoxml.close();
return 0;
 }
