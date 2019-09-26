#include <iostream>
#define MIN  0
#define MAX  1000000000

int getMax(int* arr, int size)
{
	int currentMax(0);
	for (int i = 0; i < size; i++)
	{
		if (currentMax < arr[i]) currentMax = arr[i];
	}
	return currentMax;
}

bool driesForTime(int* clothes, int size, int dryer, int time)
{
	int accumulated = 0;
	for (int i = 0; i < size; i++)
	{
		if (clothes[i] > time)
		{
			accumulated += (clothes[i] - time) / (dryer - 1) + ((clothes[i] - time) % (dryer - 1) != 0);
			if (accumulated > time)
			{
				return false;
			}
		}
	}
	return true;
}

int minDry(int* clothes, int size, int dryer)
{
	if (dryer < 2)	return getMax(clothes, size);
	int low(MIN);
	int high(MAX);
	int tempMin(MAX);
	while (low < high)
	{
		int mid = (low + high) / 2;
		if (driesForTime(clothes, size, dryer, mid))
		{
			tempMin = mid;
			high = mid - 1;
		}
		else
		{
			low = mid + 1;
		}
	}
	return driesForTime(clothes, size, dryer, low) ? low : tempMin;
}

int main()
{
	int N, K; std::cin >> N >> K;
	int *clothes = new int[N];
	int i(0);
	for (i; i < N; i++) std::cin >> clothes[i];
	std::cout << minDry(clothes, N, K);
	return 0;
}

