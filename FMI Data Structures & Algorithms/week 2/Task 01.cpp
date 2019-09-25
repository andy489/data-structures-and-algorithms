/* idea: sort the data in lexicographical descending order and then print the data without intervals, easy as that. */
#include <iostream>

size_t getLength(size_t a)
{	// statically casting log10(a) to get length a
	return size_t(log10(a)) + 1;
}

size_t getMin(size_t a, size_t b)
{
	return a < b ? a : b;
}

//utility function to simulate lexicographical comparison but for unsigned int
bool unsignedCmp(size_t a, size_t b)
{
	//size_t A(a), B(b);
	size_t len_a = getLength(a); size_t len_b = getLength(b);
	size_t minLength = getMin(len_a, len_b);
	for (size_t i = 0; i < minLength; i++)
	{
		short digit_a = (short)(a / pow(10, len_a - 1));
		short digit_b = (short)(b / pow(10, len_b - 1));
		if (digit_a > digit_b)
		{
			return true; //return A;
		}
		else if (digit_a < digit_b)
		{
			return false; //return B;
		}
		a = a % size_t(pow(10, len_a - 1)); b = b % size_t(pow(10, len_b - 1));
		len_a--; len_b--;
	}
	return len_a > len_b ? true : false; //return len_a > len_b ? A : B;
}

void bubbleSortLexicographical(size_t *arr, size_t arrLen)
{
	while (true)
	{
		bool swapped = false;
		for (size_t index = 0; index < arrLen - 1; index++)
		{
			if (!unsignedCmp(arr[index], arr[index + 1]))
			{
				std::swap(arr[index], arr[index + 1]);
				swapped = true;
			}
		}
		if (!swapped) break;
	}
}

void printArr(size_t *arr, size_t n)
{
	for (size_t i = 0; i < n; i++) std::cout << arr[i];
}

int main()
{	//input data
	size_t n; std::cin >> n; 
	//dynamically created array to store the data
	size_t *arr = new size_t[n];
	//collect the data from the input
	for (size_t i = 0; i < n; i++) std::cin >> arr[i];
	//sort the data in lexicographical descending order
	bubbleSortLexicographical(arr, n);
	//print the data without intervals
	printArr(arr, n);
	//release the data
	delete[] arr;
	return 0;
}

/* //Or shortly:
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
int main()
{	
	size_t n; std::cin >> n;
	std::vector<std::string> data(n);
	for (size_t i = 0; i < n; i++) std::cin >> data[i];
	sort(data.begin(), data.end(), std::greater<std::string>());
	for (size_t i = 0; i < n; i++)std::cout << data[i];
	return 0;
}// which is the same logic as above one */

