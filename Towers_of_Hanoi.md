[Кулите в Ханой](https://bg.wikipedia.org/wiki/%D0%A5%D0%B0%D0%BD%D0%BE%D0%B9%D1%81%D0%BA%D0%B0_%D0%BA%D1%83%D0%BB%D0%B0) е известна древна игра. Условието на играта е следното: Дадени са три колони и n диска, като всеки диск е с различен размер. Да наименуваме колоните от ляво на дясно съответно с имената *source, spare, destination* и да номерираме дисковете – от 1 за най-малкия до n за най-големия. В началото всичките n дискове са на *source* колоната, подредени в низходящ ред от най-долния към най-горния, така че диск n е най-отдолу, а диск 1 е най-отгоре.

![](https://upload.wikimedia.org/wikipedia/commons/0/07/Tower_of_Hanoi.jpeg)

Целта е да преместим всичките n диска от колона *source* до колона *destination*. Звучи лесно, нали? Но не е толкова просто, защото трябва да се спазват две правила:
- Позволено е да се мести само по един диск на ход;
- Не е позволено да се поставя по-голям върху по-малък диск. Например, ако диск 3 е на колоната, всички дискове под диск 3 трябва да са с номер, по-голям от 3.

[Анимирана версия на играта](https://www.mathsisfun.com/games/towerofhanoi.html)

Според легендата някъде в Азия (Тибет, Виетнам, Индия – избери си легенда от интернет), монасите са решавали тази задача с 64 диска и – поне така се твърди – монасите вярвали, че след като преместят по правилата всички дискове от колона *source* на колона *destination*, светът ще свърши. Ако монасите са прави, трябва ли да се тревожим?

При решаването на задачата за <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=1,2,3,..."> се забелязват 2 модела. Първо, можем да решим задачата за Ханойските кули рекурсивно. Ако n=1, преместваме диск 1. В противен случай, когато <img src="https://latex.codecogs.com/svg.latex?\Large&space;n\ge{2}">, решаваме задачата в 3 стъпки:

- Рекурсивно решаваме подзадачата за преместване на дисковете от 1 до n−1 от коя да е колона към допълнителната колона.
- Преместваме диск n от колоната, от която започва, към крайната колона.
- Рекурсивно решаваме подзадачата за преместване на дисковете от 1 до n−1 от допълнителната колона към крайната колона.

След това решаването на задача за n диска изисква <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^n-1"> хода. Видяхме, че това е вярно за:

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=1"> (<img src="https://latex.codecogs.com/svg.latex?\Large&space;2^1-1=1">, нужен е само 1 ход)
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=2"> (<img src="https://latex.codecogs.com/svg.latex?\Large&space;2^2-1=3">, нужни са 3 хода)
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=3"> (<img src="https://latex.codecogs.com/svg.latex?\Large&space;2^3-1=7">, нужни са 7 хода)
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=4"> (<img src="https://latex.codecogs.com/svg.latex?\Large&space;2^4-1=15">, нужни са 15 хода)

Ако можеш да решиш задачата за <img src="https://latex.codecogs.com/svg.latex?\Large&space;n-1"> диска за <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{n-1}-1"> хода, тогава можеш да решиш задачата за n диска за <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^n-1"> хода. Трябват ни:

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{n-1}-1"> хода, за да решим рекурсивно първата подзадача за преместване на дискове 1 до n−1 
- 1  ход, за да преместим диск n 
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{n-1}-1"> хода (отново), за да решим рекурсивно втората подзадача за преместването на дисковете 1 до n−1 

Ако съберем броя ходове, ще получим <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^n-1">.

Да се върнем при монасите. Те използват n=64 диска и ще трябва да преместят един диск <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{64}-1"> пъти. Допускаме, че монасите са сръчни, силни и организирани. Тогава, те могат да местят един диск всяка секунда, денонощно.
Колко време са <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{64}-1"> секунди? Ако приемем, че една година има грубо 365,25 дни, тогава това са 584 542 046 090,6263 години. Това е 584+ милиарда години. На слънцето му остават само още 5 до 7 милиарда години, преди да се превърне в супернова. Така че, да, светът ще свърши, въпреки упоритостта на монасите, но това ще стане много преди те да успеят да пренесат всичките 64 диска в колона *деstination*.

*Рекурсивно решение:*

*Тъй като кулите работят на принципа LIFO (last in first out), то ще е удобно да се представяк като [стекова структора от данни](https://bg.wikipedia.org/wiki/%D0%A1%D1%82%D0%B5%D0%BA_(%D1%81%D1%82%D1%80%D1%83%D0%BA%D1%82%D1%83%D1%80%D0%B0_%D0%BE%D1%82_%D0%B4%D0%B0%D0%BD%D0%BD%D0%B8)) (за всяка кула - отделен стек)*

```cpp
#include <iostream>
#include <stack>

std::stack<int> src;
std::stack<int> dest;
std::stack<int> spare;

int setTowers()
{
	int disks;
	std::cout << "Enter number of disks: ";
	std::cin >> disks;

	for (int i = 0; i < disks; i++) src.push(disks - i);
	return disks;
}

void printRod(std::stack<int>tower)
{
	std::stack<int>temp;
	while (!tower.empty())
	{
		temp.push(tower.top());
		tower.pop();
	}
	if (!temp.size()) std::cout << "empty rod\n";
	else
	{
		while (!temp.empty())
		{
			std::cout << temp.top();
			temp.pop();
			if (temp.size() != 0) std::cout << ", ";
		}
		std::cout << '\n';
	}
}

void PrintRods()
{
	std::cout << "Source: "; printRod(src);
	std::cout << "Destination: ", printRod(dest);
	std::cout << "Spare: ", printRod(spare);
	std::cout << "----------------------------\n";
}

void MoveDisks(int disks, std::stack<int>& src, std::stack<int>& dest, std::stack<int>& spare, unsigned& stepsTaken)
{
	if (disks < 1)  return;
	else if (disks == 1)
	{
		stepsTaken++;
		dest.push(src.top());
		src.pop();
		std::cout << "Step #" << stepsTaken << ": Moved disk " << disks << '\n';
		PrintRods();
		return;
	}
	else
	{
		MoveDisks(disks - 1, src, spare, dest, stepsTaken);
		stepsTaken++;
		dest.push(src.top());
		src.pop();
		std::cout << "Step #" << stepsTaken << ": Moved disk " << disks << '\n';
		PrintRods();
		MoveDisks(disks - 1, spare, dest, src, stepsTaken);
	}
}
int main()
{
	unsigned stepsTaken(0);
	int disks = setTowers();
	PrintRods();
	MoveDisks(disks, src, dest, spare, stepsTaken);
	return 0;
}
```

Тази имплементация има един дребен недостатък. Това е, че кулите са хардкоднати извън *main()* функцията. За да коригираме този факт няма да е достатъчно да вкараме стековете като аргументи във всяка функция, която ги използва, защото по време на имплементацията - когато рекурсивните методи се извикват - при всяко тяхно свиване референциите на колоните се разменят.

Един не толкова елегантен, но доста хитър начин за справянето с този проблем е да извикваме функциите с допълнителен сет от референции към стековете като параметри до *MoveDisks* функцията:

```cpp
#include<iostream>
#include<stack>
using namespace std;
int setTowers(std::stack<int>& src)
{
	int disks;
	std::cout << "Enter number of disks: ";
	std::cin >> disks;

	for (int i = 0; i < disks; i++) src.push(disks - i);
	return disks;
}

void printRod(std::stack<int>tower)
{
	std::stack<int>temp;
	while (!tower.empty())
	{
		temp.push(tower.top());
		tower.pop();
	}
	if (!temp.size()) std::cout << "empty rod\n";
	else
	{
		while (!temp.empty())
		{
			std::cout << temp.top();
			temp.pop();
			if (temp.size() != 0) std::cout << ", ";
		}
		std::cout << '\n';
	}
}

void PrintRods(std::stack<int>& src, std::stack<int>& dest, std::stack<int>& spare)
{
	std::cout << "Source: "; printRod(src);
	std::cout << "Destination: ", printRod(dest);
	std::cout << "Spare: ", printRod(spare);
	std::cout << "----------------------------\n";
}

void MoveDisks(int disks, std::stack<int>& src, std::stack<int>& dest, std::stack<int>& spare, std::stack<int>&a, std::stack<int>&b, std::stack<int>&c, unsigned& stepsTaken)
{
	if (disks < 1)  return;
	else if (disks == 1)
	{
		stepsTaken++;
		dest.push(src.top());
		src.pop();
		std::cout << "Step #" << stepsTaken << ": Moved disk " << disks << '\n';
		PrintRods(a, b, c);
		return;
	}
	else
	{
		MoveDisks(disks - 1, src, spare, dest, a, b, c, stepsTaken);
		stepsTaken++;
		dest.push(src.top());
		src.pop();
		std::cout << "Step #" << stepsTaken << ": Moved disk " << disks << '\n';
		PrintRods(a, b, c);
		MoveDisks(disks - 1, spare, dest, src, a, b, c, stepsTaken);
	}
}
int main()
{
	std::stack<int> src;
	std::stack<int> dest;
	std::stack<int> spare;

	unsigned stepsTaken(0);
	int disks = setTowers(src);
	PrintRods(src, dest, spare);
	MoveDisks(disks, src, dest, spare, src, dest, spare, stepsTaken);
	return 0;
}
```
