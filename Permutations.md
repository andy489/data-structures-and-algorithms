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
	std::cout << "Total: " << n << "! = " << countPerm << " permutations\n";
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
	std::cout << "Total: " << n << "! = " << countPerm << " permutations\n";
	return 0;
}
```
