#include <iostream>

class DayThree {
    std::string input;
    int inputLines;

    public:
        DayThree (std::string, int);
        int solution();
};

DayThree::DayThree(std::string content, int lines) {
    input = content;
    inputLines = lines;
}

int DayThree::solution() {
    std::cout << "we have: " << inputLines << " \n" << input;
    return 0;
}