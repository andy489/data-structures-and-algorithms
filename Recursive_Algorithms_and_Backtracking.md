# Recursion

Рекурсията описва повтаряемост, по-конкретно:

- В математиката и лингвистиката – свързана с или включваща многократното приложение на правило, дефиниция или процедура с цел последващ резултат.
- В програмирането – отнасяща се за или включваща програма, за чието частично приложение се изисква прилагането на цялото, така че неговата изрична интерпретация изисква множество последващи изпълнения: рекурсивна подпрограма.
- Модерните Операционни системи (ОС) дефинират файловата си структура по рекурсивен начин.Състои се от главна директория, а вътре в нея има файлове и други директории.

Един обект наричаме рекурсивен, ако съдържа опростен свой вариант или е дефиниран от по-опростена своя версия. 

#### Характеристики на рекурсията:
  - разделя проблема на подпроблеми от същия тип
    - включва функция, която извиква себе си
    - функцията трябва да има базов случай (*дъно*)
    - на всяка стъпка от рекурсията трябва да се движим напред към базовия случай

#### Примери от живота:
  - две огледала насочени едно към друго
  - фракталите

#### Видове рекурсия:
- пряка - когато една функция извиква сама себе си
- непряка - когато една функция извиква друга, а тя отсвоя страна извиква първата (или аналогично верига от n извикващи се функции)

#### Части на рекурсията:
- Разгъване - когато се извикват вложените функции
  - <img src="https://latex.codecogs.com/svg.latex?\Large&space;3!=3.2!">
  - <img src="https://latex.codecogs.com/svg.latex?\Large&space;2!=2.1!">
- Дъно - когато е достигнато условието за край
  - <img src="https://latex.codecogs.com/svg.latex?\Large&space;1!=1">
- Свиване - когато вложените функции една по една връщат резултатите си
  - <img src="https://latex.codecogs.com/svg.latex?\Large&space;2!=2.1!=2.1=2">
  - <img src="https://latex.codecogs.com/svg.latex?\Large&space;3!=2.2!=3.2=6">
- Дълбочина - броят на рекурсивните извиквания на функцията

#### Решаванена задачи чрез рекурсия
- Задачата се привежда до по-проста задача от същиявид
- Трябва задължително да има условие за край (осигуряващо *дъното* на рекурсията), и трябва разгъването на рекурсията постепенно да ниприближава до дъното
- Ако условието за дъно не е избрано коректно, рекурсията продължава докато се запълни стека, и програмата (или системата) блокира (препълва се стека - *stackoverflow*)
- Кодът който трябва да се изпълни по време на разгъването се поставя преди рекурсивното извикване, а кодът, който ще се изпълнява при свиването на рекурсията - след него

#### Рекурсия или итерация
- решение чрез рекурсия:

```cpp
long long fact(unsigned n)
{
	if (n < 2) return 1;
	return n * fact(n - 1);
}
```
- решение чрез итерация:

```cpp
long long fact(unsigned n)
{
	unsigned result = 1;
	for (unsigned i = 1; i <= n; i++) result *= i;
	return result;
}
```
Някой задачи се решават по-удачно чрез итерации, други чрез рекурсия.

#### Предимства и недостатъци
- Предимства
  - *По-прост код* - обяснението на много задачи чрез рекурсия е по-просто от еквивалентен итеративен алгоритъм
  - *Незаменимо за някои задачи* - някой задачи се решават най-елегантно чрез рекурсия
- Недостатъци 
  - *По-трудна за разбиране и осмисляне* - рекурсията не е толкова очевидно разбираема колкото итерацията например
  - *Коства повече памет* - всяко рекурсивно извикване заделя допълнителна памет от стека
  
 ## Примери
 
 **Задача 1.** Да се напише рекурсивен метод който печата на конзолата следната фигура:
 
	**	***	****
	*	**	***
	#	*	**
	##	#	*
		##	#
		###	##
			###
			####
съответно за подадено число <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=2,3,4,..."> и т.н.
 
 *Решение: *
 
 ```cpp
 #include <iostream>
void helpFunctionPrint(unsigned n, char symbol)
{
	for (size_t i = 0; i < n; i++) std::cout << symbol;
	std::cout << std::endl;
}
void recursionPrint(unsigned n)
{
	if (n == 0) return;
	helpFunctionPrint(n, '*');
	recursionPrint(n - 1);
	helpFunctionPrint(n, '#');
}
int main()
{
	unsigned n;
	std::cin >> n;
	recursionPrint(n);
	return 0;
}
 ```
 
 #### Комбинаторни алгоритми чрез рекурсия
**Задача 2.** Да се генерират рекурсивно всички вектори с дължина 4 съставени само от 0 и 1.

*Решение:*

```cpp
#include <iostream>
#include <vector>

void printVector(std::vector<int> vector)
{
	unsigned n = vector.size();
	for (unsigned i = 0; i < n; i++)
	{
		std::cout << vector[i] << ' ';
	}
	std::cout << std::endl;
}

void generate01(unsigned indx, std::vector<int> vector)
{
	if (indx >= vector.size()) printVector(vector);
	else
	{
		for (int i = 0; i <= 1; i++)
		{
			vector[indx] = i;
			generate01(indx + 1, vector);
		}
	}
}

int main()
{
	std::vector<int> vector = { 8,8,8,8 };
	generate01(0, vector);
	return 0;
}
```

Аналогично, ако искаме да започнем на обратно като принтираме най-големия (според *лексикографска наредба*) вектор може да подходим така:

```cpp
#include <iostream>
#include <vector>

void printVector(std::vector<int> vector)
{
	unsigned n = vector.size();
	for (unsigned i = 0; i < n; i++)
	{
		std::cout << vector[i] << ' ';
	}
	std::cout << std::endl;
}

void generate01(unsigned indx, std::vector<int> vector)
{
	if (indx >= vector.size()) printVector(vector);
	else
	{
		for (int i = 1; i >= 0; i--)
		{
			vector[indx] = i;
			generate01(indx - 1, vector);
		}
	}
}

int main()
{
	std::vector<int> vector = { 8,8,8,8 };
	generate01(vector.size()-1, vector);
	return 0;
}
```
**Задача 3.** Напишете рекурсивна функция, която принтира всички 4-цифрени числа.

*Решение:*
Аналогично на предходната задача, това са всикчи 4-метни вектора с компоненти цифрите от 0,1,...,9, без тези които започват с 0.

```cpp
#include <iostream>
#include <vector>

void printVector(std::vector<int> vector)
{
	unsigned n = vector.size();
	if (vector[0] != 0)
	{
		for (unsigned i = 0; i < n; i++)
		{
			std::cout << vector[i] << ' ';
		}
		std::cout << std::endl;
	}
}

void generate01(unsigned indx, std::vector<int> vector)
{
	if (indx == vector.size()) printVector(vector);
	else
	{
		for (int i = 0; i <= 9; i++)
		{
			vector[indx] = i;
			generate01(indx + 1, vector);
		}
	}
}

int main()
{
	std::vector<int> vector = { 0,0,0,0 };
	generate01(0, vector);
	return 0;
}
```
**Задача 4.** Напишете рекурсивна функция, която извежда на конзолата всички двойни комбинации от 4 на брой елемента.

*Решение:*

Аналогично на горната задача, ще вземем първи вектор от две позиции и втори вектор с допустимите елементи от които ще се грнерират комбинациите. Отново ще генерираме всички двойни вектора с повторения, а от тях ще изберем само тези които например образуват монотонна редица. Отговора ще са исканите комбинации.

```cpp
#include <iostream>
#include <vector>
bool monotoneVector(std::vector<int> vector)
{
	for (size_t i = 0; i < vector.size()-1; i++)
	{
		if (vector[i]>=vector[i+1]) return false;		
	}
	return true;
}
void printVector(std::vector<int> vector)
{
	unsigned n = vector.size();
	if (monotoneVector(vector))
	{
		for (unsigned i = 0; i < n; i++)
		{
			std::cout << vector[i] << ' ';
		}
		std::cout << std::endl;
	}
}

void generate01(unsigned indx, std::vector<int> vector, std::vector<int>mainVector)
{
	if (indx == vector.size()) printVector(vector);
	else
	{
		for (unsigned i = 0; i <= mainVector.size(); i++)
		{
			vector[indx] = i;
			generate01(indx + 1, vector,mainVector);
		}
	}
}

int main()
{
	std::vector<int>mainVector = { 1,2,3,4 };
	std::vector<int>vector = { 0,0 };

	generate01(0, vector,mainVector);
	return 0;
}
```
