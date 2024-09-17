#include <cstddef>
#include <iostream>
#include <string>

class DayThree {
	std::string input;
	int inputLines;

	int adjacentNums(int x, int y, std::string lines[]);
	int getNum(int x, std::string line);

	public:
		DayThree (std::string, int);
		int solution();
};

DayThree::DayThree(std::string content, int lines) {
	input = content;
	inputLines = lines;
}

int DayThree::solution() {
	std::string lines[inputLines];
	// std::cout << "we have: " << inputLines << " \n" << input;

	int i = 0;
	int lineIndex = 0;
	while (input[i] != NULL) {
		if (input[i] != '\n') {
			lines[lineIndex] += input[i];
		} else {
			lineIndex++;
		}
		i++;
	}

	for (i = 0; i < inputLines; i++) {
		int j = 0;
		while (lines[i][j] != NULL) {
			switch (lines[i][j]) {
				case '.':
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
					// doet iets
					break;
				default:
					std::cout << "find adjacent nums: " << adjacentNums(j, i, lines) << " ";
					break;
			}
			j++;
		}
		std::cout << lines[i] << "\n";
	}
	return 0;
}

int DayThree::adjacentNums(int x, int y, std::string lines[]) {
	int val = 0;
	for (int i = x - 1; i < x + 1; i++) {
		for (int j = y - 1; y < y + 1; y++) {
			switch (lines[y][x]) {
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0':
					val = getNum(x, lines[y]);
					break;
				default:
					// doe niets
					break;
			}
		}
	}
	return val;
}

int DayThree::getNum(int x, std::string line) {
	int num = 0;
	int startNum = -1;
	int endNum = -1;
	int i = 0;
	while (line[i]) {
		switch (line[i]) {
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '0':
				if (startNum == -1) {
					startNum = i;
				}
				endNum = i;
				num = (10 * num) + (line[i] - '0');
				break;
			default:
				if (num != 0 && x >= startNum && x <= endNum) {
					std::cout << num << " ";
					return num;
				}
				break;
		}
		i++;
	}
	return 0;
}