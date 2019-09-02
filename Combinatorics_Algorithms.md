**Задача 1.** *(Пермутации без повтарения)* Имплементирайте рекурсивен метод за генериране на всички пермутации на даден списък от уникални елементи.

*Решение:*

```cpp
#include <iostream>

int elements[] = { 1,2,3 };
unsigned n = sizeof(elements) / sizeof(elements[0]);
bool* used = new bool[n]();
int* permutations = new int[n]();
unsigned countPerm(0);

void displayPerm()
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
		displayPerm();
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

**Задача 2.** *(Пермутации с повтарения)* Имплементирайте рекурсивен метод за генериране на всички пермутации на даден списък с повтарящи се елементи.

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
 
**Важно!** Алгоритъма ще работи много по-оптимално ако преди да извикаме рекурсивния метод genPermRep() сортираме списъка от елементи.

```cpp
#include <iostream>
#include <set>
#include <algorithm>
#include <vector>

std::vector<int> elements = {3,3,3,1,3,3,3,3};
unsigned countPermRep(0);

void displayList()
{
	std::cout << '(';
	for (unsigned i = 0; i < elements.size(); i++)
	{
		std::cout << elements[i];
		if (i != elements.size() - 1)	std::cout << ',';
	}
	std::cout << ")\n";
}

void genPermRep(unsigned indx)
{
	if (indx > elements.size() - 1)
	{
		countPermRep++;
		displayList();
	}
	else
	{
		std::set<int> swapped;
		for (unsigned i = indx; i < elements.size(); i++)
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
	sort(elements.begin(),elements.end());
	genPermRep(0);
	std::cout << "Total: " << countPermRep << " permutations.\n";
	return 0;
}
```
**Задача 3.** *(Вариации без повтарения)* Имплементирайте рекурсивен метод за генериране на всички вариации от два елемента на даден списък с уникални елементи.

*Пример:* за списъка {A,B,C} съществуват следните вариации без повторения от два елемента: (A,B), (A,C), (B,A), (B,C), (C,A) и (C,B). Точно <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{n!}{(n-k)!}=\frac{3!}{(3-2)!}=6"> на борй.

*Решение:*

```cpp
#define k 2
#include <iostream>

int elements[] = { 1,2,3 };
unsigned n = sizeof(elements) / sizeof(elements[0]);
int* variations = new int[k]();
bool* used = new bool[n]();
unsigned countVar(0);

void displayVar()
{
	std::cout << '(';
	for (unsigned i = 0; i < k; i++)
	{
		std::cout << variations[i];
		if (i !=k - 1)	std::cout << ',';
	}
	std::cout << ")\n";
}

void genVar(unsigned indx)
{
	if (indx > k - 1)
	{
		countVar++;
		displayVar();
	}
	else
	{
		for (unsigned i = 0; i < n; i++)
		{
			if (!used[i])
			{
				used[i] = true;
				variations[indx] = elements[i];
				genVar(indx + 1);
				used[i] = false;
			}			
		}
	}
}

int main()
{
	genVar(0);
	std::cout << "Total: " << countVar << " variations.\n";
	return 0;
}
```
**Задача 4.** *(Вариации с повтарения)* Имплементирайте рекурсивен метод за генериране на всички вариации с повторения от два елемента на даден списък с уникални елементи.

*Пример:* за списъка {A,B,C} съществуват следните вариации с повторения от два елемента: (A,A), (A,B), (A,C), (B,B), (B,A), (B,C), (C,A), (C,B) и (C,C). Точно <img src="https://latex.codecogs.com/svg.latex?\Large&space;n^2=3^2=9"> на борй.

*Решение:*

```cpp
#define k 2
#include <iostream>

int elements[] = { 1,2,3 };
unsigned n = sizeof(elements) / sizeof(elements[0]);
int* variations = new int[k]();
bool* used = new bool[n]();
unsigned countVarRep(0);

void displayVar()
{
	std::cout << '(';
	for (unsigned i = 0; i < k; i++)
	{
		std::cout << variations[i];
		if (i != k - 1)	std::cout << ',';
	}
	std::cout << ")\n";
}

void genVarRep(unsigned indx)
{
	if (indx > k - 1)
	{
		countVarRep++;
		displayVar();
	}
	else
	{
		for (unsigned i = 0; i < n; i++)
		{
			variations[indx] = elements[i];
			genVarRep(indx + 1);
		}
	}
}

int main()
{
	genVarRep(0);
	std::cout << "Total: " << n << '.' << n<<" = " << countVarRep << " variations.\n";
	return 0;
}
```
**Задача 5.** *(Вариации с повтарения)* Имплементирайте итеративен метод за генериране на всички двумерни вариации с повторения на числата {0,1,2,3,4}.

*Решение:*

```cpp
#define n 5
#define k 3
#include <iostream>

int* variations = new int[k]();
unsigned countVarRep(0);

void displayVar()
{
	std::cout << '(';
	for (unsigned i = 0; i < k; i++)
	{
		std::cout << variations[i];
		if (i != k - 1)	std::cout << ',';
	}
	std::cout << ")\n";
}

void genVarRepIterative()
{
	while (true)
	{
		countVarRep++;
		displayVar();
		int indx = k - 1;
		while (indx >= 0 && variations[indx] == n - 1)
		{
			indx--;
		}
		if (indx < 0)
		{
			break;
		}
		variations[indx]++;
		for (int i = indx + 1; i < k; i++)
		{
			variations[i] = 0;
		}
	}
}

int main()
{
	genVarRepIterative();
	std::cout << "Total: " << n << '^' << k << " = " << countVarRep << " variations.\n";
	delete[] variations;
	return 0;
}
```

*Този метод се базира на броенето, аналогично на двоичното, третичното и т.н. броене.* 

**Задача 6.** *(Комбинации)* Имплементирайте рекурсивен метод за генериране на всички тримерни комбинации на даден списък от уникални елементи, например {2,4,6,8,10}.

*Решение:*

```cpp
#define k 3
#define n 5
#include <iostream>
int* elements = new int[n]();
int* comb = new int[k]();

unsigned combCount(0);

void displayComb()
{
	for (unsigned i = 0; i < k; i++)
	{
		std::cout << comb[i] << ' ';
	}
	std::cout << '\n';
}

void genComb(int indx, int start)
{
	if (indx >= k) { displayComb(); combCount++; }
	else
	{
		for (int i = start; i <= n - 1; i++)
		{
			comb[indx] = elements[i];
			genComb(indx + 1, i + 1);
		}
	}
}

int main()
{
	for (unsigned i = 0; i < n; i++)
	{
		elements[i] = 2 * (i + 1); // {2,4,6,8,10}
	}
	genComb(0, 0);
	std::cout << "Total count: " << combCount << " combinations.\n";
	return 0;
}
```
*Коментар:* броя на комбинациите е <img src="https://latex.codecogs.com/svg.latex?\Large&space;C_{k}^{n}=\binom{n}{k}=\frac{n!}{k!(n-k)!}=\frac{5!}{3!(5-3)!}=10">.

**Задача 6.** *(Комбинации с повторения)* Имплементирайте рекурсивен метод за генериране на всички тримерни комбинации на даден списък от уникални елементи, например {2,4,6,8,10}.

*Решение:*

В имплементацията на предишната задача пви извикването на рекурсивния метод е необходимо да осигурим достъп и до текущия елемент, който взимаме. Т.е. е необходимо да извикваме метода по следния начин:  „*genComb(indx + 1, i);*“ . Броят им е точно <img src="https://latex.codecogs.com/svg.latex?\Large&space;\binom{n+k-1}{k}=\binom{7}{3}=\frac{7!}{3!(7-3)!}=\frac{7!}{3!4!}=35">.

**Задача 7.** Пресметнете по-колко начина може да изберем <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> елементе от <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> елемента като използвате [триъгълника на Паскал](https://medium.com/i-math/top-10-secrets-of-pascals-triangle-6012ba9c5e23).

*Решение:*

```cpp
#define K 3
#define N 6

#include <iostream>

long long binom(int n, int k)
{
	if (k > n) return 0;
	if (k == 0 || k == n) return 1;
	return binom(n - 1, k - 1) + binom(n - 1, k);
}

int main()
{
	long long choose_k_n = binom(N, K);
	std::cout << choose_k_n << '\n';
	return 0;
}
```
