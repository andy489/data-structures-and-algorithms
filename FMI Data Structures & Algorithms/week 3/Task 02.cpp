// binary search (sorted array)
#include <iostream>

int searchFirst(long long target, long long* sortedArr, size_t arrSize)
{
	if (arrSize == 0) return -2;
	size_t pivot = arrSize / 2;
	int lastEncounter = -2;
	size_t start(0);
	while (start < arrSize)
	{
		if (sortedArr[pivot] < target) start = pivot;
		else if (sortedArr[pivot] > target)	arrSize = pivot;
		else
		{
			lastEncounter = pivot;
			arrSize = pivot; // search first
		}
		if (pivot != (arrSize + start) / 2) pivot = (arrSize + start) / 2;
		else break;
	}
	return lastEncounter+1;
}

int searchLast(long long target, long long* sortedArr, size_t arrSize)
{
	if (arrSize == 0) return -2;
	size_t pivot = arrSize / 2;
	int lastEncounter = -2;
	size_t start(0);
	while (start < arrSize)
	{
		if (sortedArr[pivot] < target) start = pivot;
		else if (sortedArr[pivot] > target) arrSize = pivot;
		else
		{
			lastEncounter = pivot;
			start = pivot; // search last
		}
		if (pivot != (arrSize + start) / 2)	pivot = (arrSize + start) / 2;
		else break;
	}
	return lastEncounter+1;
}

void printResult(long long* result, size_t N)
{
	for (size_t i = 0; i < N; i += 2)
	{
		std::cout << result[i] << ' ' << result[i + 1] << '\n';
	}
}

int main()
{
	size_t N, Q; std::cin >> N;
	long long* sortedArr = new long long[N];
	for (size_t i = 0; i < N; i++) std::cin >> sortedArr[i];
	//sort(sortedArr, sortedArr+n);
	std::cin >> Q;
	long long* result = new long long[2 * Q];
	size_t indx(0);
	for (size_t i = 0; i < Q; i++)
	{
		int P; std::cin >> P;
		result[indx++] = searchFirst(P, sortedArr, N);
		result[indx++] = searchLast(P, sortedArr, N);
	}
	printResult(result, 2 * Q);
}

