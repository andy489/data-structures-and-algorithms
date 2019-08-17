# Searching Algorithms

Aлгоритъмът за търсене е алгоритъм за намиране на елемент със специфични свойства сред колекция от елементи.

Име | метод
------- | -------  
**Linear Search** *Последователно търсене |  обхожда елемент по елемент докато срещне търсения

### 1. Последователно търсене
Най-елементарният и очевиден алгоритъм за търсене е последователното търсене. Нека предположим, че елементите на множеството се съдържат в едномерен масив. Търсенето се извършва посредством последователно преглеждане на елементите на масива до откриване на търсения елемент или до преглеждане на всички елементи. Последното означава, че елемент с такъв ключ не съществува.При постъпване на нов елемент ще го вмъкваме в края на масива *seqSearch()*. Следва една възможна реализация на основните функции, основаваща се на последователното търсене:

```cpp
#define MAX 10
#define DataType int
#include <iostream>
#include <time.h>

struct CElem
{
	int key;
	DataType data;
	/*...*/
}m[MAX + 1]; /* Масив от записи*/
unsigned n;  /*Брой елементи в масива*/

void seqInit(void) { n = 0; }  /*Инициализиране*/

unsigned seqSearch(int key)    /*Последователно търсене*/
{
	unsigned x;
	m[0].key = key;  /*Ограничител*/
	for (x = n + 1; key != m[--x].key; );
	return x;
}

void seqInsert(int key, DataType data) /*Добавя нов елемент*/
{
	m[++n].key = key;
	m[n].data = data;
}

void seqPrint(void) /*Извежда списъка на екрана*/
{
	unsigned i;

	for (i = 1; i <= n; i++)
	{
		std::cout << m[i].key << ' ' << m[i].data << std::endl;
	}
}

void performSearchTest(void)
{
	unsigned ind, elem2Search;
	for (elem2Search = 0; elem2Search < 2 * MAX; elem2Search++)
	{
		std::cout << "We search an element with key " << elem2Search << "\n";
		if (0 == (ind = seqSearch(elem2Search)))
			std::cout << "Element with such key does not exist!" << "\n\n";
		else
			std::cout << "Item found! Info part: " << m[ind].data << "\n\n";
	}
}

int main()
{
	srand(unsigned(time(0)));
	unsigned ind;
	seqInit();
	for (ind = 0; ind < MAX; ind++) seqInsert(rand() % (MAX * 2), ind);
	std::cout << "the list contains the following items:\n";
	seqPrint();
	std::cout << "Testing:\n";
	performSearchTest();
	return 0;
}
```


