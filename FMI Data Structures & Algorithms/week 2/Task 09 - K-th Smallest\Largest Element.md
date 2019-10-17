## Problem
Given an array and a number <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> where <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> is smaller than size of array, we need to find the <img src="https://latex.codecogs.com/svg.latex?\Large&space;K^{th}"> smallest element in the given array. It is given that ll array elements are distinct.

Примерен вход|Oчакван изход
-|-
6<br>7, 10, 4, 3, 20, 15<br>3|7
6<br>7, 10, 4, 3, 20, 15<br>4|10

*Първо подаваме броя на несортираните елементи, след което ги въвеждаме от конзолата. Накрая подаваме К-тото най-малко търсено чисо. Изхода е търсеното такова число.*  

## Quick Select

*In **QuickSort**, we pick a pivot element, then move the pivot element to its correct position and partition the array around it. The idea is, not to do complete quicksort, but stop at the point where pivot itself is k’th smallest element. Also, not to recur for both left and right sides of pivot, but recur for one of them according to the position of pivot. The worst case time complexity of this method is <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n^2)">, but it works in <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n)"> on average.*

```cpp
#include <iostream> 
#include <vector>
#include <climits> 

int partition(std::vector<int>& seq, int left, int right);
/* Function that returns the K-th smallest element in an unsorted collecton
of element assuming that all elements in the collection are distinct*/
int KthSmallest(std::vector<int>& seq, int left, int right, int K)
{
	if (K > 0 && K <= right - left + 1) // Bounds of seq
	{
		/* Partition the array around last element and get
		 position of pivot element in sorted sequence */
		int pos = partition(seq, left, right);

		if (pos - left == K - 1) return seq[pos]; // SUCCESS! (position == K)
		// Position is further
		else if (pos - left > K - 1) return KthSmallest(seq, left, pos - 1, K);  
		else return KthSmallest(seq, pos + 1, right, K - pos + left - 1);
	}
	// If k is more than number of elements in array 
	return INT_MAX;
}

/* Partition function from QuickSort(), which takes the last 
 element as pivot and moves all smaller element to left of it 
 and greater elements to right. Pure classic masterpiece! */
int partition(std::vector<int>& seq, int left, int right)
{
	int X = seq[right], i = left;
	for (int j = left; j <= right - 1; j++)
	{
		if (seq[j] <= X)
		{
			std::swap(seq[i++], seq[j]);
		}
	}
	std::swap(seq[i], seq[right]);
	return i;
}

int main()
{
	std::vector<int>seq = { 0,1,1,13,8,21,3,34,5,55,2};
	int N = (int)seq.size();

	int K(0);
	std::cin >> K; // K is in scope

	std::cout << "K-th smallest element is " << KthSmallest(seq, 0, N - 1, K);
	return 0;
}

```
