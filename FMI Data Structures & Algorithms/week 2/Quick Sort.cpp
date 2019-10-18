#include <iostream>
#include <vector>

size_t partition(std::vector<int>& collection, int start, int end)
{
	size_t midIndex = start + (end - start) / 2;
	std::swap(collection[midIndex], collection[end]);

	int pivot = collection[end];
	size_t pIndex = start;

	for (int i = start; i < end; i++)
	{
		if (collection[i] <= pivot)
		{
			std::swap(collection[i], collection[pIndex++]);
		}
	}
	std::swap(collection[pIndex], collection[end]);
	return pIndex;
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
	std::vector<int> collection = {5, -3, 1, 9, 0, 22, 3, 8, 4, -2, 9};
	int SIZE = (int)collection.size();

	quickSort(collection, 0, SIZE - 1);

	for (auto element : collection)	std::cout << element << ' ';
	
	return 0;
}
