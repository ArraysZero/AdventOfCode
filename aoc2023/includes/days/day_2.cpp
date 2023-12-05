#include <cstddef>
#include <iostream>
#include <string>

class DayTwo {
    std::string input;

    public:
        DayTwo(std::string);
        int puzzleOne();
        int findValue(int);
};

DayTwo::DayTwo(std::string content) {
    input = content;
}

int DayTwo::findValue(int index) {
    if (input[index + 1] != ' ') {
        return (10 * (input[index]  - '0')) + input[index + 1] - '0';
    } else {
        return input[index] - '0';
    }
}

int DayTwo::puzzleOne() {
    std::cout << input;

    int i = 0;
    int sum = 0;
    int currentGameID = 0;
    bool gameInfo = false;
    int redVal, greenVal, blueVal, lastVal;
    while (input[i] != NULL) {
        switch (input[i]) {
            case 'G':
                std::cout << input[i + 5];
                i += 5;
                currentGameID++;
                lastVal = 0;
                blueVal = 0;
                greenVal = 0;
                redVal = 0;
                break;
            case ':':
                std::cout << "reading game ";
                gameInfo = true;
                break;
            case '\n':
                gameInfo = false;

                // std::cout << "red: " << redVal << " green: ";

                if (redVal <= 12 && greenVal <= 13 && blueVal <= 14) {
                    std::cout << currentGameID << " ";
                    sum += currentGameID;
                }

                std::cout << "reading game id \n";
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                if (gameInfo) {
                    int value = findValue(i);
                    std::cout << value << " ";
                    lastVal = value;
                    i++;
                }
                break;
            case 'r':
                if (gameInfo) {
                    std::cout << "red ";
                    i += 2;
                    if (lastVal > redVal) {
                        redVal = lastVal;
                    }
                }
                break;
            case 'g':
                if (gameInfo) {
                    std::cout << "green ";
                    i += 4;
                    if (lastVal > greenVal) {
                        greenVal = lastVal;
                    }
                }
                break;
            case 'b':
                if (gameInfo) {
                    std::cout << "blue ";
                    i += 3;
                    if (lastVal > blueVal) {
                        blueVal = lastVal;
                    }
                }
                break;
            default:
                break;
        }
        i++;
    }

    return sum;
}