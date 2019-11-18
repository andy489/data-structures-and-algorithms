#include <iostream>
#include <vector>
using namespace std;

size_t partition(std::vector<int>& collection, int start, int end)
{
	size_t pivIndex = start + (end - start) / 2;
	std::swap(collection[pivIndex], collection[end]);

	int pivot = collection[end];
	pivIndex = start;

	for (int i = start; i < end; i++)
	{
		if (collection[i] <= pivot)
		{
			std::swap(collection[i], collection[pivIndex++]);
		}
	}
	std::swap(collection[pivIndex], collection[end]);
	return pivIndex;
}
// just flexing with quick sort function
void quickSort(std::vector<int>& collection, int start, int end)
{
	if (start >= end) return;
	size_t pivot = partition(collection, start, end);
	quickSort(collection, start, pivot - 1);
	quickSort(collection, pivot + 1, end);
}

vector<vector<int>> inputMatrix(int rows, int cols)
{
	vector<vector<int>> matrix(rows);
	for (int i = 0; i < rows; i++)
	{
		matrix[i] = vector<int>(cols);
	}

	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++)
		{
			cin >> matrix[i][j];
		}
	}
	return matrix;
}

void computeAnswer(vector<vector<int>>& matrix, 
	vector<int>& result,
	int rows,int cols,
	int squareSize,int targetSum)
{
	int currSum(0);
	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++)
		{
			if (i + squareSize <= rows && j + squareSize <= cols)
			{
				for (int k = i; k < i + squareSize; k++)
				{
					for (int m = j; m < j + squareSize; m++)
					{
						currSum += matrix[k][m];
					}
				}
				if (currSum >= targetSum)
				{
					result.push_back(currSum / (squareSize * squareSize));
				}
				currSum = 0;
			}
		}
	}
}

int main()
{
	int rows, cols,squareSize, targetSum;
	cin >> rows >> cols;

	vector<vector<int>> matrix = inputMatrix(rows,cols);

	cin >> squareSize >> targetSum;

	vector<int> result;

	computeAnswer(matrix, result, rows, cols, squareSize, targetSum);

	int N = result.size();

	quickSort(result, 0, N - 1);

	for (const auto& el : result)
	{
		cout << el << ' ';
	}

	return 0;
}
