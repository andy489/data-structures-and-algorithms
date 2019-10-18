#include <iostream>
#include <vector>

size_t partition(std::vector<size_t>& stones, int start, int end)
{
	size_t midIndex = start + (end - start) / 2;
	std::swap(stones[midIndex], stones[end]);

	int pivot = stones[end];
	size_t pIndex = start;

	for (int i = start; i < end; i++)
	{
		if (stones[i] <= pivot)
		{
			std::swap(stones[i], stones[pIndex++]);
		}
	}
	std::swap(stones[pIndex], stones[end]);
	return pIndex;
}

void quickSort(std::vector<size_t>& stones, int start, int end)
{
	if (start >= end) return;
	size_t pivot = partition(stones, start, end);
	quickSort(stones, start, pivot - 1);
	quickSort(stones, pivot + 1, end);
}

bool isPairPresent(std::vector<size_t>& stones, size_t SUM)
{
	int left(0), right(stones.size() - 1);

	while (left < right)
	{
		if (stones[left] + stones[right] == SUM)    return true;
		else if (stones[left] + stones[right] > SUM)    right--;
		else left++;
	}
	return false;
}

int main()
{
	size_t N; std::cin >> N;

	std::vector<size_t> stones(N);
	for (size_t i = 0; i < N; i++) std::cin >> stones[i];

	quickSort(stones, 0, N - 1);

	for (auto stone : stones)
	{
		if (isPairPresent(stones, stone))
		{
			std::cout << "true";
			return 0;
		}
	}
	std::cout << "false";
	return 0;
}
