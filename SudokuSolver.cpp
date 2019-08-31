/* Да се напише програма, която намира броя и вида на решенията на произволно частично запълнено судоку 9х9. */

#include <iostream> 
#define UNASSIGNED 0  
#define N 9  

int grid[N][N] = { {0, 0, 0, 0, 0, 0, 6, 8, 0},
		   {0, 0, 0, 0, 7, 3, 0, 0, 9},
		   {3, 0, 9, 0, 0, 0, 0, 4, 5},
		   {4, 9, 0, 0, 0, 0, 0, 0, 0},
		   {8, 0, 3, 0, 5, 0, 9, 0, 2},
		   {0, 0, 0, 0, 0, 0, 0, 3, 6},
		   {9, 6, 0, 0, 0, 0, 3, 0, 8},
		   {0, 0, 0, 6, 8, 0, 0, 0, 0},
		   {0, 2, 8, 0, 0, 0, 0, 0, 0} };

unsigned count(0);
// проверява дали има незапълнена клетка
bool findUnassignedLocation(unsigned &row, unsigned &col)
{
	for (row = 0; row < N; row++)
		for (col = 0; col < N; col++)
			if (grid[row][col] == UNASSIGNED)
				return true;
	return false;
}

// проверява дали дадено число вече го има в съответния ред
bool usedInRow(unsigned row, unsigned num)
{
	for (unsigned col = 0; col < N; col++)
		if (grid[row][col] == num)
			return true;
	return false;
}

// проверява дали дадено число вече го има в съответната колона
bool usedInCol(unsigned col, unsigned num)
{
	for (unsigned row = 0; row < N; row++)
		if (grid[row][col] == num)
			return true;
	return false;
}

// проверява дали дадено число вече го има в съответната кутиика 3х3
bool usedInBox(unsigned boxStartRow, unsigned boxStartCol, unsigned num)
{
	for (unsigned row = 0; row < 3; row++)
		for (unsigned col = 0; col < 3; col++)
			if (grid[row + boxStartRow]
				[col + boxStartCol] == num)
				return true;
	return false;
}

// връща булева променлива, която показва дали е възможно да поставим число
bool isSafe(unsigned row, unsigned col, unsigned num)
{
	/* проверява дали числото го няма в
	съответния ред, колона или кутиика 3х3*/
	return !usedInRow(row, num) &&
		!usedInCol(col, num) &&
		!usedInBox(row - row % 3, col - col % 3, num) &&
		grid[row][col] == UNASSIGNED;
}

//принтира судоку
void printGrid()
{
	count++;
	for (unsigned row = 0; row < N; row++)
	{
		for (unsigned col = 0; col < N; col++)
			std::cout << grid[row][col] << " ";
		std::cout << std::endl;
	}
	std::cout << std::endl;
}

void solveSudoku()
{
	unsigned row(0), col(0);
	// ако сме попълнили всичко значи е решение
	if (!findUnassignedLocation(row, col))
	{	/* във функция findUnassignedLocation() освен булевия резултат, който
		получаваме - инкрементираме и позицията в сусокуто и така го обхождаме */
		printGrid();
	}
	else
	{
		// опитваме се да поставим числата от 1 до 9
		for (unsigned num = 1; num <= 9; num++)
		{
			// ако може да поставим такова число
			if (isSafe(row, col, num))
			{
				// поставяме числото на разгуването на рекурсията
				grid[row][col] = num;

				// ако сме попълнили навсякъде връщаме истина 
				solveSudoku();

				// отмаркираме клетката при свиването на рекурсията
				grid[row][col] = UNASSIGNED;
			}
		}

	}
}

int main()
{
	solveSudoku();
	if (!count)
	{
		std::cout << "No solution exists.\n";
		return 0;
	}
	std::cout << "Number of solutions: " << count << "\n";
	return 0;
}
