## Move Down/Right Sum
Given a **matrix of N by M** cells filled with positive integers, find the path from **top left** to **bottom right** with a **highest sum** of cells by moving only down or right.
#### Examples
Input|Output
-|-
4<br>4<br>**1** 3 2 1<br>**5 3** 2 1<br>1 **7** 3 1<br>1 **3 1 1**|	[0, 0] [1, 0] [1, 1] [2, 1] [3, 1] [3, 2] [3, 3]
3<br>3<br>**1** 1 1<br>**1** 1 1<br>**1 1 1**|	[0, 0] [1, 0] [2, 0] [2, 1] [2, 2]
3<br>3<br>**1** 0 6<br>**8 3 7**<br>2 4 **9**|	[0, 0] [1, 0] [1, 1] [1, 2] [2, 2]

#### Solution
```cpp
#include <iostream>
#include <stack>
#include <string>

size_t max(size_t a, size_t b);
size_t** createMatrix(size_t rows, size_t cols);
void displayMatrix(size_t** matrix, size_t rows, size_t cols);
void releaseMatrix(size_t**matrix, size_t rows);

int main()
{
	size_t rows, cols; std::cin >> rows >> cols;
	size_t** numbers = createMatrix(rows, cols);
	size_t** sums = createMatrix(rows, cols);
	for (size_t i = 0; i < rows; i++)
	{
		for (size_t j = 0; j < cols; j++)
		{
			std::cin >> numbers[i][j];
		}
	}

	sums[0][0] = numbers[0][0];

	for (size_t r = 1; r < rows; r++)
	{
		sums[r][0] = sums[r - 1][0] + numbers[r][0];
	}
	for (size_t c = 1; c < cols; c++)
	{
		sums[0][c] = sums[0][c - 1] + numbers[0][c];
	}

	for (size_t r = 1; r < rows; r++)
	{
		for (size_t c = 1; c < cols; c++)
		{
			sums[r][c] = max(sums[r - 1][c], sums[r][c - 1]) + numbers[r][c];
		}
	}
	// displayMatrix(sums, rows, cols);
	std::stack<std::string> resultPath;
	int currRow = rows - 1; int currCol = cols - 1;

	std::string currRes = '[' + std::to_string(currRow) + ", " + std::to_string(currCol) + ']';
	resultPath.push(currRes);

	while (!(currRow == 0 || currCol == 0)) // Bool's theorem <=> (currRow != 0 && currCol != 0)
	{
		size_t top = sums[currRow - 1][currCol];
		size_t left = sums[currRow][currCol - 1];

		if (top > left)
		{
			currRes.clear();
			currRes = '[' + std::to_string(currRow - 1) + ", " + std::to_string(currCol) + ']';
			resultPath.push(currRes);
			currRow--;
		}
		else
		{
			currRes.clear();
			currRes = '[' + std::to_string(currRow) + ", " + std::to_string(currCol - 1) + ']';
			resultPath.push(currRes);
			currCol--;
		}
	}
	if (currRow == 0)
		for (int i = 0; i < currCol; i++) std::cout << "[0, " + std::to_string(i) + "] ";
	else
		for (int i = 0; i < currRow; i++) std::cout << "[" + std::to_string(i) + ", 0] ";
	
	while (!resultPath.empty())
	{
		std::cout << resultPath.top() << ' ';
		resultPath.pop();
	}
	releaseMatrix(numbers, rows); releaseMatrix(sums, rows);
	return 0;
}

size_t max(size_t a, size_t b)
{
	return a > b ? a : b;
}

size_t ** createMatrix(size_t rows, size_t cols)
{
	size_t** matrix = new size_t *[rows]();
	for (size_t i = 0; i < rows; i++)
	{
		matrix[i] = new size_t[cols]();
	}
	return matrix;
}

void displayMatrix(size_t ** matrix, size_t rows, size_t cols)
{
	for (size_t i = 0; i < rows; i++)
	{
		for (size_t j = 0; j < cols; j++)
		{
			std::cout << matrix[i][j] << ' ';
		}
		std::cout << '\n';
	}
}

void releaseMatrix(size_t ** matrix, size_t rows)
{
	for (size_t i = 0; i < rows; i++)
	{
		delete[] matrix[i];
	}
	delete[] matrix;
}
```
