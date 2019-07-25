# Shuffling Algorithms

Разбъркване на елементите на дадена колекция. Това означава да се генерира произволна пермутация на елементите от тази колекция.

*„Генерирането на произволни числа е твърде важно, за да бъде оставено на случайността“ - [Robert Coveyou](https://en.wikipedia.org/wiki/Robert_Coveyou)*

```cpp
#include <iostream>  
#include <ctime>    // std::time
#include <cstdlib>  // std::rand, std::srand

void printArr(int* arr, size_t len)
{
	for (size_t i = 0; i < len; i++)
	{
		std::cout << arr[i] << ' ';
	}
	std::cout << std::endl;
}
int myRandom(size_t index)
{
	return std::rand() % index;
}
void shuffleArr(int* arr, size_t arrLen)
{
	for (size_t i = 0; i < arrLen; i++)
	{
		size_t r = i + myRandom(arrLen - i);
		std::swap(arr[i], arr[r]);
	}
}
int main() 
{
	int arr[] = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20 };
	size_t arrLen = sizeof(arr) / sizeof(arr[0]);
	printArr(arr, arrLen);
	
	std::srand(size_t(std::time(0)));

	shuffleArr(arr, arrLen);
	printArr(arr, arrLen);

	return 0;
}
``
