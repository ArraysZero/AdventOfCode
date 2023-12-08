#include <iostream>
#include "includes/reader.cpp"
#include "includes/days/day_1.cpp"
#include "includes/days/day_2.cpp"
#include "includes/days/day_3.cpp"

// int function() {
// 	return 1;
// }

using namespace std;

int main() {
	// int num = '9' - '0';
	// std::cout << "Hello World! \n" << num;

	Reader reader;

	//day 1 puzzles
	// DayOne dayOne(reader.read("input/day1.txt"));

	// dayOne.puzzleOne();

	//day 2 puzzles
	// DayTwo dayTwo(reader.read("input/day2.txt"));

	// cout << dayTwo.puzzleOne();

	//day 3 puzzles
	DayThree dayThree(reader.read("input/day3.txt"), reader.getLines("input/day3.txt"));
	
	cout << dayThree.solution();

	return 0;
}