**Задача 1.** *(Пермутации без повтарения)* Генерирайте всички пермутации на даден списък от уникални елементи.

*Решение:*

```cpp
#include <iostream>

int elements[] = { 1,2,3 };
unsigned n = sizeof(elements) / sizeof(elements[0]);
bool* used = new bool[n]();
int* permutations = new int[n]();
unsigned countPerm(0);

void displayList()
{
	std::cout << '(';
	for (unsigned i = 0; i < n; i++)
	{
		std::cout << permutations[i];
		if (i != n - 1)	std::cout << ',';
	}
	std::cout << ")\n";
}

void genPerm(unsigned indx)
{	// indx е съответната клетка която искаме да запълним
	if (indx > n - 1)
	{
		countPerm++;
		displayList();
	}
	else
	{
		for (unsigned i = 0; i < n; i++)
		{
			if (!used[i])
			{
				used[i] = true;
				permutations[indx] = elements[i];
				genPerm(indx + 1);
				used[i] = false;
			}
		}
	}
}

int main()
{
	genPerm(0);
	std::cout << "Total: " << n << "! = " << countPerm << " permutations.\n";
	delete[] used;
	delete[] permutations;
	return 0;
}
```
*Коментар:* В имплементацията по-горе използваме два допълнителни (помощни) масива bool used[] и int permutations[]. Първият е от булев тип и в него маркираме кой елемент е използван при разгъването на рекурсията, а при свиването ѝ го отмаркираме. Другият е от същия тип, от който са съответните елементи, от които генерираме пермутациите и го използваме за да го запълваме с тези елементи и в момента в който го напълним го принтираме на конзолата. Метода за генериране на пермутации с *backtracking* е стандартен и лесен за имплементация, но използва два допълнителни масива за да работи. Можем ли да избегнем заделянето на тази странична памет?

За да оптимизираме решението, ще трябва да „задълбаем“ (да достигнем максимално напред в клетката, в която искаме да поставим елемент) в рекурсията до край, след което да разменяме елементите без да повтаряме видовете размени. Т.е. вървим докрая напред, след което се връщаме назад и се опитваме да разменим нещо, като в момента в който размениме нещо викаме рекурсията напред и се връщаме.

```cpp
#include <iostream>

int elements[] = { 1,2,3 };
unsigned n = sizeof(elements) / sizeof(elements[0]);
unsigned countPerm(0);

void displayList()
{
	std::cout << '(';
	for (unsigned i = 0; i < n; i++)
	{
		std::cout << elements[i];
		if (i != n - 1)	std::cout << ',';
	}
	std::cout << ")\n";
}

void genPerm(unsigned indx)
{	
	if (indx > n - 1)
	{
		countPerm++;
		displayList();
	}
	else
	{
		genPerm(indx + 1);
		for (unsigned i = indx + 1; i < n; i++)
		{
			std::swap(elements[indx], elements[i]);
			genPerm(indx + 1);
			std::swap(elements[indx], elements[i]);
		}
	}
}

int main()
{
	genPerm(0);
	std::cout << "Total: " << n << "! = " << countPerm << " permutations.\n";
	return 0;
}
```

**Задача 2.** *(Пермутации с повтарения)* Генерирайте всички пермутации на даден списък с повтарящи се елементи.

*Пример:* за списъка {A,B,B} съществуват следните пермутации: (A,B,B), (B,A,B) и (B,B,A). Точно <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{3!}{2!1!}=3"> на борй.

*Решение:*
```cpp
#include <iostream>
#include <set>

int elements[] = { 1,3,3 };
unsigned n = sizeof(elements) / sizeof(elements[0]);
unsigned countPermRep(0);


void displayList()
{
	std::cout << '(';
	for (unsigned i = 0; i < n; i++)
	{
		std::cout << elements[i];
		if (i != n - 1)	std::cout << ',';
	}
	std::cout << ")\n";
}

void genPermRep(unsigned indx)
{
	if (indx > n - 1)
	{
		countPermRep++;
		displayList();
	}
	else
	{
		std::set<int> swapped;
		for (unsigned i = indx; i < n; i++)
		{
			if (!swapped.count(elements[i]))
			{
				std::swap(elements[indx], elements[i]);
				genPermRep(indx + 1);
				std::swap(elements[indx], elements[i]);
				swapped.insert(elements[i]);
			}
		}
	}
}

int main()
{
	genPermRep(0);
	std::cout << "Total: " << countPermRep << " permutations.\n";
	return 0;
}
```

*Коментар:* В горната имплементация използваме предишния алгоритъм, като в дадено множество броим всички елементи които сме използвали (разменяли), защото те ще генерират същите пермутации като тези породени от еднаквите с тях елементи. Така лесно ще направим проверката дали дадения елемент го има в множеството и, ако това не е изпълнено ще разменяме. Но отново използваме странична памет като използваме място за множеството, което се заделя многократно. Възможно ли е да оптимизираме?

Това би могло да се реализира, като на всеки текущ елемент, който ще „джуркаме“ му разменяме неговата позиция с позицията на всички следващи елементи.

```cpp
#include <iostream>
#include <set>

int elements[] = { 1,3,3 };
unsigned n = sizeof(elements) / sizeof(elements[0]);
unsigned countPermRep(0);


void displayList()
{
	std::cout << '(';
	for (unsigned i = 0; i < n; i++)
	{
		std::cout << elements[i];
		if (i != n - 1)	std::cout << ',';
	}
	std::cout << ")\n";
}

void genPermRep(int startIndx, int endIndx)
{
	displayList();
	countPermRep++;
	for (int left = endIndx - 1; left >= startIndx; left--)
	{
		for (int right = left + 1; right <= endIndx; right++)
		{
			if (elements[left] != elements[right])
			{
				std::swap(elements[left], elements[right]);
				genPermRep(left + 1, endIndx);
			}
		}
		int firstElement = elements[left];
		for (int i = left; i <= endIndx - 1; i++)
		{
			elements[i] = elements[i + 1];
		}
		elements[endIndx] = firstElement;
	}
}

int main()
{
	genPermRep(0, n - 1);
	std::cout << "Total: " << countPermRep << " permutations.\n";
	return 0;
}
```
*Обяснение:* започваме да вървим отзад напред с един цикъл и с друг цикъл от другата страна и в момента, в който два елемента се различават ги разменяме. Има и един множо важем момент, в който след като сме изциклили навсякъде с даден елемент, го връщаме обратно на стартовата позиция и рекурсията го разменя ако е необходимо. За по-ясно разбиране може да приложим алгоритъма за списък от вида {1,3,3,3,3,3,3} и да дебъгнем програмата, като преди това анализираме резултата от нея.

