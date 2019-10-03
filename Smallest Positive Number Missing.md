## Find the smallest positive number missing from an unsorted array

You are given an *unsorted array* with both *positive* and *negative* elements. You have to find the smallest positive number missing from the array in **O(n)** time using *constant extra space*. You can modify the original array.

Example input|Expected output
-|-
8<br>2, 3, 7, 6, 8, -1, -10, 15|1
8<br>2, 3, -7, 6, 8, 1, -10, 15|4
4<br>1, 1, 0, -1, -2|2 

#### Solution

```cpp
#include <iostream> 

int findMissing(int* arr, int n)
{	
	int val; // to store current array element 	 
	int nextval; // to store next array element in current traversal

	for (int i = 0; i < n; i++) 
	{
		/* if value is negative or greater than array size, then it cannot 
		 be marked in array. So move to next element. */
		if (arr[i] <= 0 || arr[i] > n) continue;

		val = arr[i];

		/* traverse the array until we reach at an element which 
		 is already marked or which could not be marked. */
		while (arr[val - 1] != val) 
		{
			nextval = arr[val - 1];
			arr[val - 1] = val;
			val = nextval;
			if (val <= 0 || val > n) break;
		}
	}

	/* find first array index which is not marked which is also the 
	 smallest positive missing number. */
	for (int i = 0; i < n; i++) 
	{
		if (arr[i] != i + 1) 
		{
			return i + 1;
		}
	}

	/* if all indices are marked, then smallest missing positive number is array size + 1. */
	return n + 1;
}

int main()
{
	int arr[] = { 2, 3, 7, 6, 8, -1, -10, 15 };
	int n = sizeof(arr) / sizeof(arr[0]);
	std::cout << findMissing(arr, n);
	return 0;
}

```
