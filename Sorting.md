# Sorting Algorithms

За да може да бъде сортирана една колекция от данни, то елементирте и трябва да са сравними. Сортирането представлява пренареждане на елементи по даден признак *(възходящ ред, низходящ ред, лексикографска наредба, ранг, цвят и т.н.)*.

Name | Best | Average | Worst | Memory | Stable | Method
------------ | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
**Selection Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | 1 | No | *selection*
**Bubble Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | 1 | Yes | *exchanging*
**Insertion Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | 1 | Yes | *insertion*
**Quick Sort** [*(Tony Hoare)*](https://en.wikipedia.org/wiki/Tony_Hoare) | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log_{2}n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n.\log_{2}n)}"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\Theta{(n^2)}"> | 1 | No | *parting*
 
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

 ### 5. Quick Sort      
Tози алгоритъм се базира на техниката *„разделяй и владей“* и следователно е *рекурсивен* алгоритъм. Той избира начален елемент като *централна точка* и *разделя* дадената колекция спрямо тази точка. Спрямо тази централна точка, алгоритъма *Quick Sort* придобива множество различни версии:

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
За целта добавете *най-тогоре* в *.cpp* файла си или в *h* файла си следната функция за принтиране на масив:
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
