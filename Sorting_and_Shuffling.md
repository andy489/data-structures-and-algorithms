# Sorting Algorithms

За да може да бъде сортирана една колекция от данни, елементите и трябва да са сравними. Сортирането представлява пренареждане на елементи по даден признак *(възходящ ред, низходящ ред, лексикографска наредба, ранг, цвят и т.н.)*.

Name | Best | Average | Worst | Memory | Stable | Method
------------ | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
**Selection Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | 1 | No | *selection*
**Bubble Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | 1 | Yes | *exchanging*
**Insertion Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | 1 | Yes | *insertion*
**Merge Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log_{2}n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log_{2}n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log_{2}n)}"> | O(n) | Yes | *middle partitioning*
**Quick Sort** [*(Tony Hoare)*](https://en.wikipedia.org/wiki/Tony_Hoare) | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log_{2}n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log_{2}n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | O(n) | depends | *choice partitioning*
 
- *сложността на един алгоритъм описва нарастването на броя операции спрямо нарастването на броя данни (и състоянието им - почти подредени, средно разбъркани, силно разбъркани).*

 [Визуално може да видите как работят алгоритмите ТУК](https://visualgo.net/en/sorting).
  
 ### 1. Selection Sort      
За всеки елемент алгоритъма обикаля всички останали след него <img src="https://latex.codecogs.com/svg.latex?\Large&space;\bigg[\frac{(n-1)n}{2}\bigg]\sim{O}(n^2)"> , като започва от първия и търси най-малкия от тях, който е по-малък и от текущия и след това ги разменя.
```cpp
 void selectionSort(int* arr, size_t arrLen)
{
	for (size_t index = 0; index < arrLen - 1; index++)
	{
		size_t min = index;
		for (size_t curr = index + 1; curr < arrLen; curr++)
			if (arr[curr] < arr[min]) min = curr;
		std::swap(arr[index], arr[min]);
	}
}
```

 ### 2. Bubble Sort      
Алгоритъма започва от началото и взима двойка елементи и ги сравнява, ако не са правилно наредени ги разменя и така до края на колекцията. Ако е направена поне една размяна - повтаря цикъла отново, в противен случай ще означава, че колекцията е сортирана. Сложност <img src="https://latex.codecogs.com/svg.latex?\Large&space;O\bigg[\frac{(n-1)n}{2}\bigg]\sim{O}(n)"> - за почти сортирана и <img src="https://latex.codecogs.com/svg.latex?\Large&space;O\bigg[\frac{(n-1)n}{2}\bigg]\sim{O}(n^2)"> - за напълно разбъркана колекция.
```cpp
 void bubbleSort(int* arr, size_t arrLen)
{
	while (true)
	{
		bool swapped = false;
		for (size_t index = 0; index < arrLen - 1; index++)
		{
			if (arr[index] > arr[index + 1])
			{
				std::swap(arr[index], arr[index + 1]);
				swapped = true;
			}
		}
		if (!swapped) break;
	}
}
```

 ### 3. Insertion Sort      
Алгоритъма започва от втория елемент в колекцията и върви надясно. За всеки текущ елемент проверява във вече сортираните елементи преди него, къде да го подпъхне (докато достигне първия или не достигне по-малък от текущия елемент → измества елементите преди него надясно, след което поставя текущия елемент на достигнатата позиция). Сложност <img src="https://latex.codecogs.com/svg.latex?\Large&space;\leq{O}\big(\frac{n(n-1)}{2}\big)\sim{n^2}">, „=“ в най-лошия случай.
```cpp
void insertionSort(int* arr, size_t arrLen)
{
	for (size_t i = 1; i < arrLen; i++)
	{
		int curr = arr[i]; size_t j(i - 1);
		while (j>=0 && arr[j]>curr)
		{
			arr[j + 1] = arr[j];
			j--;			
		}
		arr[j + 1] = curr;
	}
}
```
 ### 4. Merge Sort 
 
Това е алгоритъм, който разделя входния масив на две половини, извиква себе си за двете половини и след това слива двете подредени половинки. Функцията за сливане *merge()* се използва за сливане на две половини. Обединяването *(arr, l, m, r)* е ключов процес, който приема, че arr *[l..m]* и arr *[m+1..r]* са сортирани и слива двaта подредени под-масивa в един. Сложността на този алгоритъм може да се изрази рекурсивно чрез следната формула <img src="https://latex.codecogs.com/svg.latex?\Large&space;T(n)=2T(\frac{n}{2})+\Theta(n)"> 

    mergeSort(arr[], l,  r) - псевдокод
    Ако r > l
    1. Намери средния индекс и раздели масива на два подмасива:  
             middle m = (l+r)/2
     
    2. Извикай mergeSort за първата половина:   
             mergeSort(arr, l, m)
    3. Извикай mergeSort за втората половина:
             mergeSort(arr, m+1, r)
    4. Обедини двете сортирани половини от стъпка 2 и 3:
             merge(arr, l, m, r)
	     
```cpp
/* Merges two subarrays of arr[].
   First subarray is arr[l..m]
   Second subarray is arr[m+1..r] */
void merge(int arr[], size_t l, size_t m, size_t r) //l<=r
{
	size_t i, j, k;
	size_t n1 = m - l + 1;
	size_t n2 = r - m;
	/* Create temp arrays, which we should delete afterwards (dynamic memory) */
	int* L = new int[n1];
	int* R = new int[n2];
	/* Copy data to temp arrays L[] and R[] */
	for (i = 0; i < n1; i++) L[i] = arr[l + i];
	for (j = 0; j < n2; j++) R[j] = arr[m + 1 + j];
	/* Merge the temp arrays back into arr[l..r]*/
	i = 0; // Initial index of first subarray 
	j = 0; // Initial index of second subarray 
	k = l; // Initial index of merged subarray 
	while (i < n1 && j < n2)
	{
		if (L[i] <= R[j])
		{
			arr[k] = L[i];
			i++;
		}
		else
		{
			arr[k] = R[j];
			j++;
		}
		k++;
	}
	while (i < n1) // Copy the remaining elements of L[], if there are any
	{
		arr[k] = L[i];
		i++;
		k++;
	}
	while (j < n2) // Copy the remaining elements of R[], if there are any 
	{
		arr[k] = R[j];
		j++;
		k++;
	}
	delete[] L;
	delete[] R;
}
// l is for left index and r for right index of the sub-array of arr to be sorted 
void mergeSort(int* arr, int l, int r)
{
	if (l < r)
	{
		// Same as (l+r)/2, but avoids overflow for large l and r 		
		int m = l + (r - l) / 2;
		// Sort first and second halves 
		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);

		merge(arr, l, m, r);
	}
}
```
	     
 
 ### 5. Quick Sort      
Също като Merge Sort, този алгоритъм се базира на техниката *„разделяй и владей“* и следователно е *рекурсивен* алгоритъм. Той избира начален елемент като *централна точка* и *разделя* дадената колекция спрямо тази точка. Спрямо тази централна точка, алгоритъма *Quick Sort* придобива множество различни версии:

  - винаги избира пъврия елемент като централна точка;
  - винаги избира последния елемент като централна точка;
  - винаги избира произволен елемент като централна точка;
  - винаги избира медианата като централна точка и т.н.
	
Но при която и версия да се реализира алгоритъма, ключовото действие в него ще е винаги разделянето *(за това ще е необходимо да имплементираме като отделна функция **partition()** , която освен всичко останало ще връща и позицията на поставения в средата елемент от колекцията)*.
При дадена колекция избираме централна точка да бъде елемента `X` принадлежащ на колекцията и го поставяме на правилната му позиция в сортираната колекция и поставяме всички по-малки (от `X`) елементи преди `X` и по-големи елементи (от `X`) след `X`. Сложността на този алгоритъм е описана в таблицата по-горе.

Цикъла, който ще се върти във функцията *partition()* ще проверява дали текущия елемент е по-малък (а в нашия случай и равен) от централния елемент и ако това е изпълнено ще го разменя с последния елемент, който е бил по-голям от централния.
Така например след извикването на *partition()* (при взимане на централен елемент последния), масива {*2,8,3,4,2,9,10,* ***5***} ще се преобразува последователно като:
   - 2 е по-малко от 5, размяме 2 с 2, инкрементираме брояча(позицията) помнещ до къде сме стигнали;
   - 8 не е по-малко от 5, не правим нищо (за да си остане запомнената позиция);
   - 3 е по-малко от 5, разменяме 3 и 8, инкрементираме позицията; (за разменямето ще ползваме запомнената позиция)
   - отново 8 не е по малко от 5, не правим нищо;
   - 4 е по-малко от 5, размени 4 и 8, инкрементирай позицията;
   - отново 8 не е по-малко от 5, не правим нищо;
   - 2 е по-малко от 5, размени 2 и 8, инкрементирай позицията;
   - 9 не е по-малко от 5;
   - 10 не е по малко от 5;
   - и най-накрая извън цикъла - размени 5 и 8 и върни новата позиция на 5;
	
```cpp
size_t partition(int* arr, int start, int end)
{
	int pivot = arr[end]; // pick rightmost element as pivot from the array
	/* elements less than pivot will be pushed to the left of pIndex
	   elements more than pivot will be pushed to the right of pIndex
	   equal elements can go either way */
	size_t pIndex = start;
	/* each time we finds an element less than or equal to pivot, pIndex
	  is incremented and that element would be placed before the pivot. */
	for (int i = start; i < end; i++)
	{
		if (arr[i] <= pivot)
		{
			std::swap(arr[i], arr[pIndex]);
			pIndex++;
		}
	}
	std::swap(arr[pIndex], arr[end]); // swap pIndex with Pivot	
	return pIndex; // return pIndex (index of pivot element)
}
```
Нека извикаме имплементираната функция със следния *main()* и дебъгнем кода за да проследим още ведъж действието ѝ, което описахме по-горе:
```cpp
int main()
{
	int arr[] = { 2,8,3,4,2,9,10,5 };
	size_t arrLen = sizeof(arr) / sizeof(arr[0]);

	printArr(arr, arrLen);
	size_t position = partition(arr, 0, arrLen - 1);
	printArr(arr, arrLen);

	return 0;
}
```
За целта добавете *най-отгоре* в *.cpp* или в *.h* файла, следната функция за принтиране на масив:
```cpp
void printArr(int* arr, size_t arrLen)
{
	for (size_t i = 0; i < arrLen; i++)
		std::cout << arr[i] << ' ';
	std::cout << std::endl;
}
```
Получения резултат е логично да бъде следния: {*2,3,4,2,* ***5*** *,9,10,8*}. 

```cpp
void quickSort(int* arr, int start, int end)
{
	if (start >= end) return; // base condition		
	size_t pivot = partition(arr, start, end); // rearrange the elements across pivot	
	// recursion on sub-array containing elements that are less than pivot
	quickSort(arr, start, pivot - 1);
	// recursion on sub-array containing elements that are more than pivot
	quickSort(arr, pivot + 1, end);
}
```
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
	{ // exchange arr[i] with random element in arr[i..n-1]
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
