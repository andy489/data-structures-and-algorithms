/* Даден е лабиринт, представен чрез матрица от клетки. Целта е да намерим всички пътища от стартовата позиция 
(клетка с координати (0,0)) до финалната позиция (клетка със символ 'e'). Празните (проходими) клетки са маркирани с '-', а
стените (непроходимите клетки) са маркирани с '*'. На първия и втория ред ще получим размерите на лабиринта. На следващите 
редове ще получаваме клетките на лабиринта. Редът на пътищата е без значение. */

// github.com/andy489

#include <iostream>
#include <vector>

char** labyrinth;
int rows, cols;
std::vector<char> path;

void readLabyrinth() {
	std::cout << "rows: ";
	std::cin >> rows;
	std::cout << "cols: ";
	std::cin >> cols;
	// заделяме динамична памет за лабиринта
	labyrinth = new char*[rows];
	for (int i = 0; i < rows; i++) labyrinth[i] = new char[cols];
	// въвеждаме лабиринта от конзолата
	for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++) std::cin >> labyrinth[i][j];
}
void eraseLabyrinth() { // функция за освобождаване на динамично заделената памет за лабиринта
	for (int i = 0; i < rows; i++) delete[] labyrinth[i];
	delete[] labyrinth;
}
bool outOfLabyrinth(int row, int col) { // област на допустимите стойности
	return (row<0 || col<0 || row>rows - 1 || col>cols - 1) ? true : false;
}
bool isExit(int row, int col) { // стигнали сме до желаната дестинация
	return labyrinth[row][col] == 'e';
}
bool isPassable(int row, int col) { // ако е посетено или е стена върни лъжа, в противен случай върни истина
	return (labyrinth[row][col] == 'X' || labyrinth[row][col] == '*') ? false : true;
}
void printSolution() { // принтираме но без първия символ, който е стартовия S
	for (unsigned i = 1; i < path.size(); i++) std::cout << path[i];
	std::cout << std::endl;
}
void solve(int row, int col, char direction) {
	if (outOfLabyrinth(row, col)) return;
	path.push_back(direction); // съхраняваме потенциално носещия решение път
	if (isExit(row, col)) printSolution();
	else if (isPassable(row, col)) {
		// при разгъване
		labyrinth[row][col] = 'X'; // маркираме като посетена клетка
		// извикваме рекурсивно функцията		
		solve(row, col + 1, 'R'); // надясно
		solve(row, col - 1, 'L'); // наляво
		solve(row + 1, col, 'D'); // надолу
		solve(row - 1, col, 'U'); // нагоре
		// при свиване
		labyrinth[row][col] = '-'; // отмаркираме посетената клетка (непосетена)
	}
	path.pop_back(); // премахваме неоптималния път
}
int main() {
	readLabyrinth();
	solve(0, 0, 'S');
	eraseLabyrinth();
	return 0;
}
