#include <iostream>
#include <vector>

// Iterative
int binarySearchIterative(const std::vector<int>& vec, int X)
{
	int SIZE = (int)vec.size();
	int low(0), high(SIZE - 1);
	while (low <= high)
	{
		int mid = low + (high - low) / 2; // better practice
		if (X == vec[mid])
		{
			return mid;
		}
		else if (X < vec[mid]) /* discard anything which is on or after mid
								because X is less than the middle element and A is sorted */
		{
			high = mid - 1;
		}
		else
		{
			low = mid + 1;
		}
	}
	return -1;
}

// Recursive
int binarySearchRecursive(const std::vector<int>& vec, int low, int high, int X)
{
	if (low > high)
	{
		return -1;
	}
	int mid = low + (high - low) / 2;
	if (X == vec[mid])
	{
		return mid;
	}
	else if (X < vec[mid])
	{
		return binarySearchRecursive(vec, low, mid - 1, X);
	}
	else
	{
		return binarySearchRecursive(vec, mid + 1, high, X);
	}
}

int main()
{
	std::vector<int>vec; vec.reserve(1000);

	vec = { 0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597 };

	std::cout << binarySearchIterative(vec, 8);
	std::cout << '\n';
	std::cout << binarySearchRecursive(vec, 0, (int)vec.size()-1, 8);

	return 0;
}
