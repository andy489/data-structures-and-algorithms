# Sorting Algorithms

За да може да бъде сортирана една колекция от данни, елементите и трябва да са сравними. Сортирането представлява пренареждане на елементи по даден признак *(възходящ ред, низходящ ред, лексикографска наредба, ранг, цвят и т.н.)*.

Name | Best | Average | Worst | Memory | Stable | Method
------------ | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
**Selection Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;O{(1)}"> | No | *selection*
**Bubble Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;O{(1)}"> | Yes | *exchanging*
**Cocktail Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;O{(1)}"> | Yes | *exchanging*
**Insertion Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;O{(1)}"> | Yes | *insertion*
**Merge Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> | Yes | *middle partitioning*
**Quick Sort** [*(Tony Hoare)*](https://en.wikipedia.org/wiki/Tony_Hoare) | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\log{n}"> | Yes (depends) | *choice partitioning*
**Counting Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n+k)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n+k)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n+k)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n+k)">, worst-case | Yes (depends)| counting
**Bucket Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n+k)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n+\frac{n^2}{k}+k)}">, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> is the number of buckets and <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}">, when <img src="https://latex.codecogs.com/svg.latex?\Large&space;k\approx{n}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n.k)">, worst-case | Yes (depends) | partition into buckets
**Heap Sort** [*(J. W. J. Williams)*](https://en.wikipedia.org/wiki/J._W._J._Williams) | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;O{(1)}"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n)"> | No | *improved selection*
**Bogo Sort** *also known as permutation sort or monkey sort* | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.n!)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.n!)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;O{(1)}"> or worst case <img src="https://latex.codecogs.com/svg.latex?\Large&space;O{(1)}"> | No | *luck*
 
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
 ### 3. Cocktail Sort  
Коктейлното сортиране (*Cocktail Sort*) е разновидност на сортирането с метода на балончето (*Bubble Sort*). Алгоритъмът за сортиране с метода на балончетата винаги преминава елементите отляво и премества най-големия елемент в правилната му позиция при първа итерация и втори по големина при втората итерация и така нататък. Коктейлното сортиране преминава през даден масив и в двете посоки алтернативно. 

*Алгоритъм:*

Всяка итерация на алгоритъма се разделя на 2 етапа:

- Първият етап преминава през масива отляво надясно, точно както сортирането с балончета. По време на цикъла се сравняват съседните елементи и ако стойността вляво е по-голяма от стойността вдясно, тогава стойностите се разменят. В края на първата итерация най-голямото число ще пребивава в края на масива.
- Вторият етап преминава през масива в противоположна посока - започвайки от елемента непосредствено преди последния сортиран елемент и се връща обратно към началото на масива. Тук също се сравняват съседни елементи и се разменят, ако е необходимо.

Пример : Нека разгледаме примерната редица (5 1 4 2 8 0 2)

Първо преминаване напред:

  - (**5 1** 4 2 8 0 2) ? (**1 5** 4 2 8 0 2), разменя, т.к. 5 > 1
  - (1 **5 4** 2 8 0 2) ? (1 **4 5** 2 8 0 2), разменя, т.к. 5 > 4
  - (1 4 **5 2** 8 0 2) ? (1 4 **2 5** 8 0 2), разменя, т.к. 5 > 2
  - (1 4 2 **5 8** 0 2) ? (1 4 2 **5 8** 0 2)
  - (1 4 2 5 **8 0** 2) ? (1 4 2 5 **0 8** 2), разменя, т.к. 8 > 0
  - (1 4 2 5 0 **8 2**) ? (1 4 2 5 0 **2 8**), разменя, т.к. 8 > 2

След първото преминаване напред, най-големият елемент от масива ще е на последния индекс на масива.

Първо преминаване назад:

  - (1 4 2 5 **0 2** 8) ? (1 4 2 5 **0 2** 8)
  - (1 4 2 **5 0** 2 8) ? (1 4 2 **0 5** 2 8), разменя, т.к. 5 > 0
  - (1 4 **2 0** 5 2 8) ? (1 4 **0 2** 5 2 8), разменя, т.к. 2 > 0
  - (1 **4 0** 2 5 2 8) ? (1 **0 4** 2 5 2 8), разменя, т.к. 4 > 0
  - (**1 0** 4 2 5 2 8) ? (**0 1** 4 2 5 2 8), разменя, т.к. 1 > 0

След първо преминаване назад, най-малкият елемент от масива ще е на първия индекс на масива.

Второ преминаване напред:

(0 1 4 2 5 2 8) ? (0 1 4 2 5 2 8)
(0 1 **4 2** 5 2 8) ? (0 1 **2 4** 5 2 8), разменя, т.к. 4 > 2
(0 1 2 4 5 2 8) ? (0 1 2 4 5 2 8)
(0 1 2 4 **5 2** 8) ? (0 1 2 4 **2 5** 8), разменя, т.к. 5 > 2

Второ преминаване назад:

(0 1 2 **4 2** 5 8) ? (0 1 2 **2 4** 5 8), разменя, т.к. 4 > 2

Сега масивът вече е почти сортиран, но алгоритъмът ни не знае дали е завършен. Алгоритъмът трябва да завърши целия този пропуск без никакъв *swap* (без никакво разменяне), за да знае, че е сортиран.

(0 1 2 2 4 5 8) ? (0 1 2 2 4 5 8)
(0 1 2 2 4 5 8) ? (0 1 2 2 4 5 8)

По-долу е имплементацията на горния алгоритъм:

```cpp
#include <iostream> 
void cocktailSort(int a[], int n)
{
	bool swapped = true;
	int start = 0;
	int end = n - 1;

	while (swapped) {
		// reset the swapped flag on entering 
		// the loop, because it might be true from 
		// a previous iteration. 
		swapped = false;

		// loop from left to right same as 
		// the bubble sort 
		for (int i = start; i < end; ++i) {
			if (a[i] > a[i + 1]) {
				std::swap(a[i], a[i + 1]);
				swapped = true;
			}
		}

		// if nothing moved, then array is sorted. 
		if (!swapped)
			break;

		// otherwise, reset the swapped flag so that it 
		// can be used in the next stage 
		swapped = false;

		// move the end point back by one, because 
		// item at the end is in its rightful spot 
		--end;

		// from right to left, doing the 
		// same comparison as in the previous stage 
		for (int i = end - 1; i >= start; --i) {
			if (a[i] > a[i + 1]) {
				std::swap(a[i], a[i + 1]);
				swapped = true;
			}
		}

		// increase the starting point, because 
		// the last stage would have moved the next 
		// smallest number to its rightful spot. 
		++start;
	}
}

/* Prints the array */
void printArray(int a[], int n)
{
	for (int i = 0; i < n; i++)
		std::cout<<a[i]<<' ';
	std::cout << std::endl;
}

// Driver code 
int main()
{
	int arr[] = { 5, 1, 4, 2, 8, 0, 2 };
	int n = sizeof(arr) / sizeof(arr[0]);
	cocktailSort(arr, n);
	printf("Sorted array :\n");
	printArray(arr, n);
	return 0;
}
```

 ### 4. Insertion Sort      
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
 ### 5. Merge Sort 
 
Това е алгоритъм, който разделя входния масив на две половини, извиква себе си за двете половини и след това слива двете подредени половинки. Функцията за сливане *merge()* се използва за сливане на две половини. Обединяването *(arr, l, m, r)* е ключов процес, който приема, че arr *[l..m]* и arr *[m+1..r]* са сортирани и слива двaта подредени под-масивa в един. Сложността на този алгоритъм може да се изрази рекурсивно чрез следната формула <img src="https://latex.codecogs.com/svg.latex?\Large&space;T(n)=2T(\frac{n}{2})+\Theta(n)"> 

![alt text](https://www.101computing.net/wp/wp-content/uploads/Merge-Sort-Algorithm.png)

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
	     
 
 ### 6. Quick Sort      
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
size_t partition(int* arr, size_t start, size_t end)
{
	int pivot = arr[end]; // pick rightmost element as pivot from the array
	/* elements less than pivot will be pushed to the left of pIndex
	   elements more than pivot will be pushed to the right of pIndex
	   equal elements can go either way */
	size_t pIndex = start;
	/* each time we finds an element less than or equal to pivot, pIndex
	  is incremented and that element would be placed before the pivot. */
	for (size_t i = start; i < end; i++)
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

Сега за функцията за ***сортирането*** имаме:
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
За нея може да използваме следния *main()*:

```cpp
int main()
{
	int arr[] = { 17,16,2,7,20,12,1,19,9,18,6,4,10,8,11,0,5,14,13,15,3 };
	size_t arrLen = sizeof(arr) / sizeof(arr[0]);

	printArr(arr, arrLen);
	quickSort(arr, 0, arrLen - 1);
	printArr(arr, arrLen);

	return 0;
}
```
Показания до тук алгоритъм за сортиране е ефикасен и използва за централна точка (*pivot*) последния (най-десния) елемент на колекцията от данни. За да напишем алгоритъм, който използва първия (най-ляв) елемент от колекцията може да се ***изхитрим*** и знаеики алгоритъма за разделяне на колекцията на две части спрямо централна точка последния елемент, просто преди да го приложим да разменим (*swap-нем*) последния елемент с първия. Аналогично ще е ако искаме централната точка да е средната (което е най-оптимално) или дори произволна (*random*) точка всеки път.

   - за ***деление с централна точка първия елемент*** може да приложим следното в началото на алгоритъма за разделяне *partition()*: 
```cpp
	std::swap(arr[start], arr[end]); // swap the first with the last element
``` 
   - за ***деление с централна точка средния елемент***  
```cpp
size_t midIndex= start + (end - start) / 2; // find position of the middle element from the interval [start..end]
	std::swap(arr[midIndex], arr[end]); // swap the middle with the last element
``` 
   - за ***деление с централна точка всеки път произволен елемент***  
```cpp
size_t randIndex = start + rand()%((end-start)+1);// find position of the random element from the interval [start..end]
	std::swap(arr[randIndex], arr[end]);      //swap the random with the last element	
``` 
### 7. Counting Sort
Това е един много хитър и ефективен метод за сортиране на числа, който вместо да ги сравнява по между им ги брои. В случая е необходимо да знаем колко са големи числата, т.е. трябва да имаме някакъв rangе (k). Нека се опитаме да разберем метода по-лесно чрез следния пример:
````
За яснота взимаме числа, които са от 0 до 9. 
Входни данни: 1, 4, 1, 2, 7, 5, 2
  1) Вземаме масив, който да съхранява всички уникални числа от 0 до 9.
  Индекс:     0  1  2  3  4  5  6  7  8  9
  Брой:       0  2  2  0  1  1  0  1  0  0

  2) Модифицираме масива с преброените срещания на уникални числа така, че елемента на всеки индекс 
     да съхранява сумата на елементите на предходния и текущия индекси: 
  Индекс:     0  1  2  3  4  5  6  7  8  9
  Брой:       0  2  4  4  5  6  6  7  7  7

Модифицирания масив с преброените срещания индикира позицията на всеки обект (число) в изходната редица.
 
  3) Извеждаме всеки обект от входната редица, след което декрементираме броя му.
  Обработваме входните данни: 1, 4, 1, 2, 7, 5, 2. Позицията на 1 е 2.
  Слагаме данна 1 на позиция 1 в изходните данни. намаляме броя и с 1, за да поставим
  следващата данна 1 на позиция 0.
````

````cpp
#include<iostream>
#include<cstring> 
#define RANGE 255  

// The main function that sort the given string arr[] in alphabatical order  
void countSort(char arr[])
{	// The output character array that will have sorted arr  
	char* output=new char[strlen(arr)];
	// Create a count array to store count of inidividul  
	// characters and initialize count array as 0  
	int count[RANGE + 1], i;
	memset(count, 0, sizeof(count));
	// Store count of each character  
	for (i = 0; arr[i]; i++) ++count[arr[i]];
	// Change count[i] so that count[i] now contains actual  
	// position of this character in output array  
	for (i = 1; i <= RANGE; i++) count[i] += count[i - 1];
	// Build the output character array  
	for (i = 0; arr[i]; i++)
	{
		output[count[arr[i]] - 1] = arr[i];
		--count[arr[i]];
	}

	/*
	For Stable algorithm
	for (i = sizeof(arr)-1; i>=0; i--)
	{
		output[count[arr[i]]-1] = arr[i];
		--count[arr[i]];
	}
	*/

	// Copy the output array to arr, so that arr now contains sorted characters  
	for (i = 0; arr[i]; ++i) arr[i] = output[i];
	delete[] output;
} 
int main()
{
	char arr[] = "Data Structures and Algorithums";
	countSort(arr);

	std::cout << "Sorted character array is: " << arr;
	return 0;
}
````
Проблемът с предишния подреден брой беше, че не може да подредим елементите, ако имаме отрицателни числа в него. Тъй като няма отрицателни индекси на масив. Така че това, което правим е da намерим минималния елемент и ще съхраним броя на този минимален елемент при нулев индекс.

````cpp
//Counting sort which takes negative numbers as well 
#include <iostream> 
#include <vector> 
#include <algorithm> 
using namespace std;

void countSort(vector <int>& arr)
{
	int max = *max_element(arr.begin(), arr.end());
	int min = *min_element(arr.begin(), arr.end());
	int range = max - min + 1;

	vector<int> count(range), output(arr.size());
	for (int i = 0; i < (int)arr.size(); i++) count[arr[i] - min]++;

	for (int i = 1; i < (int)count.size(); i++) count[i] += count[i - 1];

	for (int i = (int)arr.size() - 1; i >= 0; i--)
	{
		output[count[arr[i] - min] - 1] = arr[i];
		count[arr[i] - min]--;
	}
	for (int i = 0; i < (int)arr.size(); i++) arr[i] = output[i];
}
void printArray(vector <int> & arr)
{
	for (int i = 0; i < (int)arr.size(); i++)
		cout << arr[i] << " ";
	cout << "\n";
}
int main()
{
	vector<int> arr = { -5, -10, 0, -3, 8, 5, -1, 10 };
	countSort(arr);
	printArray(arr);
	return 0;
}
````
- Counting Sort е ефикасен, ако обхватът на входните данни не е значително по-голям от броя на обектите, които ще бъдат сортирани. Помислете за ситуацията, в която последователността на въвеждане е в диапазон от 1 до 10K и данните са 10, 5, 10K, 5K.
- както споменахме по-горе, това не е сортиране, основано на сравнение. Сложността на време на работа е O(n) с пространство, пропорционално на диапазона от данни.
- Counting Sort използва частично хеширане за отчитане на появата на обекта на данни в O(1).
- алгоритъма може да се разшири, за да работи и за отрицателни входове.

### 8. Bucket Sort 

Подобно на Counting Sort, Bucket Sort-a дефинита направени от него контейнери като диапазони. Представете си следното: искаме да сортираме дадена група хора по години, но ни интересува само в какъв диапазон години са, например - от 10 до 20, от 20 до 30 и т.н. Съответно ние взимаме обектите (хората) и ги поставяме в конкретния диапазон (bucket) с този рейндж и вече конкретния диапазон може да изберем да го сортираме с алгоритъм, който работи добре за малко елементи. Т.е. разцепваме данните на групи и ако искаме да ги досортираме - отделната група я сортираме с нещо елементарно и оптимално.
Алгоритъма аналогично не използва сравнения между елементите.

Ето и друг пример: Сортирайте голям набор от числа с плаваща запетая, които са в диапазон от 0,0 до 1,0 и са равномерно разпределени в обхвата. Как да подредим числата ефективно?

Прост начин е да се приложи алгоритъм за сортиране, базиран на сравнение. Долната граница за алгоритъм за сортиране на базата на Сравнение (Merge Sort, Heap Sort, Quick-Sort... и т.н.) е <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}">, т.е. те не могат да се справят по-добре от <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}">. Можем ли да сортираме масива в линейно време? Тук не може да се приложи Counting Sort, тъй като ние използваме ключовете като индекс при отброяване. Тук ключовете са числа с плаваща запетая.
Идеята е да се използва сортиране с "кофички". Следва псевдокод на алгоритъм на кофичките:

````bucketSort (arr [], n)
1) Създаваме n празни кофи (или списъци).
2) Правим следното за всеки елемент от масива - arr[i].
- a) Вмъкваме arr[i] в кофичка [n * масив[i]]
3) Сортираме отделните кофички с помощта на Insertion Sort.
4) Съединяваме всички сортирани кофички.
````

![alt text](https://upload.wikimedia.org/wikipedia/commons/e/e3/Bucket_sort_2.svg)

```cpp
#include <iostream> 
#include <algorithm> 
#include <vector> 

// Function to sort arr[] of size n using bucket sort 
void bucketSort(double arr[], int n)
{
	// 1) Create n empty buckets 
	std::vector<std::vector<double>> b(n);

	// 2) Put array elements in different buckets 
	for (int i = 0; i < n; i++)
	{
		int bi = (int)(n * arr[i]); // Index in bucket 
		b[bi].push_back(arr[i]);
	}

	// 3) Sort individual buckets 
	for (int i = 0; i < n; i++)	sort(b[i].begin(), b[i].end());

	// 4) Concatenate all buckets into arr[] 
	int index = 0;
	for (int i = 0; i < n; i++)
		for (size_t j = 0; j < b[i].size(); j++)
			arr[index++] = b[i][j];
}
int main()
{
	double arr[] = { 0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434 };
	int n = sizeof(arr) / sizeof(arr[0]);
	bucketSort(arr, n);

	std::cout << "Sorted array is \n";
	for (int i = 0; i < n; i++)
		std::cout << arr[i] << " ";
	return 0;
}
```

### 9. Heap Sort 

В компютърните науки, Heap Sort е алгоритъм за сортиране базиран на сравнение. Heap Sort може да се разглежда като подобрен вид на Selection Sort. Подобно на него, той разделя своя вход на сортиран и несортиран регион и итеративно свива несортирания регион, като извлича най-големия елемент и го премества в сортирания регион. Подобрението се състои в използването на структура от данни за купчина, а не в линейно търсене за намиране на максимум. Макар и малко по-бавен на практика на повечето машини, отколкото един добре имплементиран Quick Sort, той има предимството на по-благоприятното време за изпълнение <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}"> в най-лошия случай. Heap Sort е изобретен от J.W.J. Williams през 1964 г. Тази година също така беше и рожденната на heap-a, представена вече от Williams като полезна структура от данни сама по себе си. През същата година R.W.Floyd публикува подобрена версия, продължавайки по-ранните си изследвания в алгоритъма на Tree Sort.

Heap Sort алгоритъма може да бъде разделен на две части. В първата стъпка от данните се изгражда купчина. Купчината често се поставя в масив с оформлението на цялостно бинарно дърво. Цялостното двоично дърво картира (maps) двоичната структура на индексите на масива; всеки индекс на масива представлява възел в дървото; индексът на родителския възел, левия наследен клон или десния наследен клон са прости изрази. За масив базиран на нула, коренният възел (корена на дървото) се съхранява в индекс 0; ако i е индексът на текущия възел, тогава:
````
iParent(i) = floor((i-1)/2), където floor функциите картографират реално число до най-малкото цяло число.
  iLeftChild(i) = 2*i + 1
  iRightChild(i) = 2*i + 2
````
Във втората сръпка се подрежда сортиран масив, като многократно се премахва най-големият елемент от грамадата (коренът на купчината) и се вмъква в масива. Купчината се актуализира след всяко премахване, за да се поддържа свойството ѝ. След като всички обекти са извадени от купчината, резултатът е подреден масив. Heap Sort може да се извърши in place. Масивът може да бъде разделен на две части, сортиран масив и купчина. Тук съхранението на купичини като масиви е под формата на диаграми. Инвариантът на купчината се запазва след всяко извличане, така че единствената цена е тази на извличането.

*Алгоритъма:*

Алгоритъмът Heap Sort включва подготвяне на списъка, като първо го превръща в цялостно бинарно дърво. След това алгоритъмът многократно заменя първата стойност на списъка с последната стойност, като намалява обхвата от стойности, разгледани в операцията на купчината, с една и пресява новата първа стойност в нейната позиция в купчината. Това се повтаря докато обхватът на разглежданите стойности не е една стойност по дължина.

*Стъпките са:*

1. Извикваме buildMaxHeap() функция върху списъка, наричана също hepify(). Това изгражда купчина от списък в <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}"> операции.
2. Разменяме първия елемент от списъка с крайния елемент. Намаляме разглеждания обхват на списъка с едно.
3. Извикваме функцията siftDown() в списъка, за да пресеем новия първи елемент към съответния му индекс в купчината.
4. Отиваме на стъпка (2.), освен ако разглежданият обхват на списъка е един елемент.

Операцията buildMaxHeap() се стартира еднократно и е <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}"> в изпълнение. Функцията siftDown() е <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log{n})}"> и се извиква n пъти. Следователно, ефективността на този алгоритъм е <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n+n.\log{n})}\approx\Theta{(n.\log{n})}">.

```cpp
#include <iostream> 
// heapify a subtree rooted with node i which is 
// an index in arr[]. n is size of heap 
void heapify(int arr[], int n, int i)
{
	int largest = i; // Initialize largest as root 
	int l = 2 * i + 1; // left = 2*i + 1 
	int r = 2 * i + 2; // right = 2*i + 2 

	// If left child is larger than root 
	if (l < n && arr[l] > arr[largest])
		largest = l;

	// If right child is larger than largest so far 
	if (r < n && arr[r] > arr[largest])
		largest = r;

	// If largest is not root 
	if (largest != i)
	{
		std::swap(arr[i], arr[largest]);

		// Recursively heapify the affected sub-tree 
		heapify(arr, n, largest);
	}
}
// main function to do heap sort 
void heapSort(int arr[], int n)
{
	// Build heap (rearrange array) 
	for (int i = n / 2 - 1; i >= 0; i--)
		heapify(arr, n, i);

	// One by one extract an element from heap 
	for (int i = n - 1; i >= 0; i--)
	{
		// Move current root to end 
		std::swap(arr[0], arr[i]);

		// call max heapify on the reduced heap 
		heapify(arr, i, 0);
	}
}
/* A utility function to print array of size n */
void printArray(int arr[], int n)
{
	for (int i = 0; i < n; ++i)
		std::cout << arr[i] << " ";
	std::cout << "\n";
}
// Driver program 
int main()
{
	int arr[] = { 12, 11, 13, 5, 7, 6 };
	int n = sizeof(arr) / sizeof(arr[0]);

	heapSort(arr, n);

	std::cout << "Sorted array is \n";
	printArray(arr, n);
}
```
*Heap Sort Descending Example:*

![Alt Text](https://upload.wikimedia.org/wikipedia/commons/4/4d/Heapsort-example.gif)

### 10. Bogo Sort 

*BogoSort* известен още като сортиране чрез пермутация, глупаво сортиране, бавно сортиране, сортиране на пробния изстрел или маймунско сортиране е особено неефективен алгоритъм, базиран на парадигмата - генериране и тестване. Алгоритъмът последователно генерира пермутации на своя вход, докато не намери сортирана :smile: . Звучи смешно, но все пак си е *ИДЕЯ*, а всяка идея, която работи заслужава внимание.
Например, ако *bogosort* се използва за сортиране на тесте карти, това ще се състои в проверка дали тестето е в ред, а ако не е, човек би хвърлил тестето във въздуха, след което би събирал картите на случаен принцип и би повтори процесът, ако тестето не е било сортирано.

*Псевдо код:*

*while not Sorted(list) do shuffle (list); done*

Пример:

Нека разгледаме следния списък ( 3 2 5 1 0 4 )
- 4 5 0 3 2 1 (1-во разбъркване)
- 4 1 3 2 5 0 (2-ро разбъркване)
- 1 0 3 2 5 4 (3-то разбъркване)
- 3 1 0 2 4 5 (4-то разбъркване)
- 1 4 5 0 3 2 (5-то разбъркване)
- ...
- 0 1 2 3 4 5 (n-то разбъркване) — сортиран списък

В случая <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> не е известно, защото алгоритъма не казва на коя стъпка резултатната пермутация ще е желаната.

```cpp
#include<iostream> 

// To check if array is sorted or not 
bool isSorted(int a[], size_t n)
{
	for (size_t i = 0; i < n - 1; i++)
	{
		if (a[i] > a[i + 1]) return false;
	}
	return true;
}

// To generate permuatation of the array 
void shuffle(int a[], int n)
{
	for (int i = 0; i < n; i++)
		std::swap(a[i], a[rand() % n]);
}

// Sorts array a[0..n-1] using Bogo sort 
void bogosort(int a[], int n)
{
	// if array is not sorted then shuffle 
	// the array again 
	while (!isSorted(a, n)) shuffle(a, n);
}

// prints the array 
void printArray(int a[], int n)
{
	for (int i = 0; i < n; i++)
		std::cout << a[i] << ' ';
	std::cout << std::endl;
}

int main()
{
	int a[] = { 3, 2, 5, 9, 1, 0, 4, 7, 6, 8, 10 };
	size_t n = sizeof a / sizeof a[0];
	bogosort(a, n);
	printf("Sorted array :\n");
	printArray(a, n);
	return 0;
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
```
