# Sorting Algorithms

За да може да бъде сортирана една колекция от данни, то елементирте и трябва да са сравними. Сортирането представлява пренареждане на елементи по даден признак *(възходящ ред, низходящ ред, лексикографска наредба, ранг, цвят и т.н.)*.

Name | Best | Average | Worst | Memory | Stable | Method
------------ | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
**Selection Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;n^2"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;n^2"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;n^2"> | 1 | No | *selection*
**Bubble Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;n^2"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;n^2"> | 1 | Yes | *exchanging*
**Insertion Sort** | <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;n^2"> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;n^2"> | 1 | Yes | *insertion*
 
- *сложността на един алгоритъм описва нарастването на броя операции спрямо нарастването на броя данни (и състоянието им - почти подредени, средно разбъркани, силно разбъркани).*

 [Визуално може да видите как работят алгоритмите ТУК](https://visualgo.net/en/sorting).
  
 ### Selection Sort      
  - за всеки елемент обикаля всички останали след него <img src="https://latex.codecogs.com/svg.latex?\Large&space;\bigg[\frac{(n-1)n}{2}\bigg]\sim{O}(n^2)"> , като започва от първия и търси най-малкия от тях, който е по-малък и от текущия и след това ги разменя.
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

 ### Bubble Sort      
  - започва от началото и взима двойка елементи и ги сравнява, ако не са правилно наредени ги разменя и така до края на колекцията. Ако е направена поне една размяна - повтаря цикъла отново, в противен случай ще означава, че колекцията е сортирана. Сложност <img src="https://latex.codecogs.com/svg.latex?\Large&space;O\bigg[\frac{(n-1)n}{2}\bigg]\sim{O}(n)"> - за почти сортирана и <img src="https://latex.codecogs.com/svg.latex?\Large&space;O\bigg[\frac{(n-1)n}{2}\bigg]\sim{O}(n^2)"> - за напълно разбъркана колекция.
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

 ### Insertion Sort      
  - започва от втория елемент в колекцията и върви надясно. За всеки текущ елемент проверява във вече сортираните елементи преди него, къде да го подпъхне (докато достигне първия или не достигне по-малък от текущия елемент → измества елементите преди него надясно, след което поставя текущия елемент на достигнатата позиция). Сложност <img src="https://latex.codecogs.com/svg.latex?\Large&space;\leq{O}\big(\frac{n(n-1)}{2}\big)\sim{n^2}">, „=“ в най-лошия случай.
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
