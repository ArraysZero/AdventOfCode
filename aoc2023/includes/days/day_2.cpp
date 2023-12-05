#include <iostream>
#include <string>

class DayTwo {
    std::string input;

    public:
        DayTwo(std::string);
        int puzzleOne();
};

DayTwo::DayTwo(std::string content) {
    input = content;
}

int DayTwo::puzzleOne() {
    std::cout << input;
    return 0;
}