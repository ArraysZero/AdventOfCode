#include <ios>
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

class Reader {
    fstream newfile;

    public:
        Reader ();
        string read (string);
        int getLines(string);
};

Reader::Reader () {
    // do nothing
}

string Reader::read(string file) {
    string result = "";

    newfile.open(file, ios::in);
    if (newfile.is_open()) {
        string row;
        while (getline(newfile, row)) {
            result = result + row + "\n";
        }
        newfile.close();
    }

    return result;
}

int Reader::getLines(string file) {
    int lines = 0;

    newfile.open(file, ios::in);
    if (newfile.is_open()) {
        string row;
        while (getline(newfile, row)) {
            lines++;
        }
        newfile.close();
    }
    return lines;
}