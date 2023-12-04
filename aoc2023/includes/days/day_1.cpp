#include <cctype>
#include <cstddef>
#include <iostream>

// using namespace std;

class DayOne {
	std::string input;

	public:
		DayOne (std::string);
		int puzzleOne();
		// puzzleTwo();
};

DayOne::DayOne(std::string content) {
	input = content;
}

int DayOne::puzzleOne() {
	// std::cout << input;
	// std::string test = "test";
	int i = 0;
	int firstDigit = 10;
	int lastDigit = 10;
	int currentVal = 0;

	while (input[i] != NULL) {
		switch (input[i]) {
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
				if (firstDigit > 9) {
					firstDigit = input[i] - '0';
					// std::cout << "first digit ";
				}
				lastDigit = input[i] - '0';
				// std::cout << " number ";

				break;
			case 'o':
				// std::cout << i;
				if (input[i + 1] == 'n' && input[i + 2] == 'e') {
					// std::cout << " one ";
					if (firstDigit > 9) {
						firstDigit = 1;
					}
					lastDigit = 1;
				}
				// std::cout << i;
				break;
			case 't':
				// std::cout << i;
				if (input[i + 1] == 'w' && input[i + 2] == 'o') {
					// std::cout << " two ";
					if (firstDigit > 9) {
						firstDigit = 2;
					}
					lastDigit = 2;
				} else if (input[i + 1] == 'h' && input[i + 2] == 'r' && input[i + 3] == 'e' && input[i + 4] == 'e') {
					// std::cout << " three ";
					if (firstDigit > 9) {
						firstDigit = 3;
					}
					lastDigit = 3;
				}
				break;
			case 'f':
				if (input[i + 1] == 'o' && input[i + 2] == 'u' && input[i + 3] == 'r') {
					// std::cout << " four ";
					if (firstDigit > 9) {
						firstDigit = 4;
					}
					lastDigit = 4;
				} else if (input[i + 1] == 'i' && input[i + 2] == 'v' && input[i + 3] == 'e') {
					// std::cout << " five ";
					if (firstDigit > 9)  {
						firstDigit = 5;
					}
					lastDigit = 5;
				}
				break;
			case 's':
				if (input[i + 1] == 'i' && input[i + 2] == 'x') {
					// std::cout << " six ";
					if (firstDigit > 9) {
						firstDigit = 6;
					}
					lastDigit = 6;
				} else if (input[i + 1] == 'e' && input[i + 2] == 'v' && input[i + 3] == 'e' && input[i + 4] == 'n') {
					// std::cout << " seven ";
					if (firstDigit > 9) {
						firstDigit = 7;
					}
					lastDigit = 7;
				}
				break;
			case 'e':
				if (input[i + 1] == 'i' && input[i + 2] == 'g' && input[i + 3] == 'h' && input[i + 4] == 't') {
					// std::cout << " eight ";
					if (firstDigit > 9) {
						firstDigit = 8;
					}
					lastDigit = 8;
				}
				break;
			
			case 'n':
				if (input[i + 1] == 'i' && input[i + 2] == 'n' && input[i + 3] == 'e') {
					// std::cout << " nine ";
					if (firstDigit > 9) {
						firstDigit = 9;
					}
					lastDigit = 9;
				}
				break;
			case '\n':
				int val = 10 * firstDigit + lastDigit;
				firstDigit = 10;
				currentVal += val;
				// std::cout << "value: " << val << "\n";
				break;
		}
		i++;
	}

	std::cout << currentVal;
	return 0;
}