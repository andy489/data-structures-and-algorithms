#include <iostream>
#include <vector>
//#include <ctime>
size_t partition(std::vector<int>& collection, int start, int end)
{
	size_t pivIndex = start + (end - start) / 2;
	//size_t pivIndex = start + rand() % ((end - start) + 1);
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

void quickSort(std::vector<int>& collection, int start, int end)
{
	if (start >= end) return;
	size_t pivot = partition(collection, start, end);
	quickSort(collection, start, pivot - 1);
	quickSort(collection, pivot + 1, end);
}

int main()
{
	// srand((size_t)time(0));
	std::vector<int> collection = { 5, -3, 1, 9, 0, 22, 3, 8, 4, -2, 9 };
	int SIZE = (int)collection.size();

	quickSort(collection, 0, SIZE - 1);

	for (auto element : collection)	std::cout << element << ' ';

	return 0;
}
