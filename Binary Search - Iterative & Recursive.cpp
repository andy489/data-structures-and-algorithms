#include <iostream>
#include <vector>

// Iterative
int binarySearchIterativeFirst(const std::vector<int>& sorted, int X)
{
	int firstFind = -1;
	int SIZE = (int)sorted.size();
	int low(0), high(SIZE-1);
	while (low <= high)
	{
		int mid = low + (high - low) / 2;
		if (X == sorted[mid])
		{
			firstFind = mid;
			high = mid; // first
		}
		else if (X < sorted[mid]) /* discard anything which is on or after mid
					because X is less than the middle element and A is sorted */
		{
			high = mid;
		}
		else if (X > sorted[mid])
		{
			low = mid;
		}
		if (mid != low + (high - low) / 2) mid = low + (high - low) / 2;
		else break;
	}
	return firstFind;
}

// Iterative
int binarySearchIterativeLast(const std::vector<int>& sorted, int X)
{
	int lastFind = -1;
	int SIZE = (int)sorted.size();
	int low(0), high(SIZE);
	while (low <= high)
	{
		int mid = low + (high - low) / 2; // better practice
		if (X == sorted[mid])
		{
			lastFind = mid;
			low = mid; // last
		}
		else if (X < sorted[mid]) /* discard anything which is on or after mid
					because X is less than the middle element and A is sorted */
		{
			high = mid;
		}
		else if (X > sorted[mid])
		{
			low = mid;
		}
		if (mid != low + (high - low) / 2) mid = low + (high - low) / 2;
		else break;
	}
	return lastFind;
}

// Recursive
int binarySearchRecursiveFirst(const std::vector<int>& sorted, int low, int high, int X)
{
	if (high >= low)
	{
		int mid = low + (high - low) / 2;
		if ((mid == 0 || X > sorted[mid - 1]) && sorted[mid] == X)
		{
			return mid;
		}
		else if (X > sorted[mid])
		{
			return binarySearchRecursiveFirst(sorted, mid + 1, high, X);
		}
		else
		{
			return binarySearchRecursiveFirst(sorted, low, mid - 1, X);
		}
	}
	return -1;
}

// Recursive
int binarySearchRecursiveLast(const std::vector<int>& sorted, int low, int high, int X)
{
	if (high >= low)
	{
		int mid = low + (high - low) / 2;
		if ((mid == sorted.size() - 1 || X < sorted[mid + 1]) && sorted[mid] == X)
		{
			return mid;
		}
		else if (X < sorted[mid])
		{
			return binarySearchRecursiveLast(sorted, low, mid - 1, X);
		}
		else
		{
			return binarySearchRecursiveLast(sorted, mid + 1, high, X);
		}
	}
	return -1;
}

int main()
{
	std::vector<int>vec; vec.reserve(1000);

	vec = { 0,0,1,2,4,4,4,8,8,8,8,8,8,8,8,8,8,9 };

	std::cout << "First encounter iterative: " << binarySearchIterativeFirst(vec, 8);
	std::cout << '\n';
	std::cout << "Last encounter iterative: " << binarySearchIterativeLast(vec, 8);
	std::cout << '\n';
	std::cout << "First encounter recursive: " << binarySearchRecursiveFirst(vec, 0, vec.size() - 1, 8);
	std::cout << '\n';
	std::cout << "Last encounter recursive: " << binarySearchRecursiveLast(vec, 0, vec.size() - 1, 8);
	std::cout << '\n';

	return 0;
}
