**Задача 1.** Даден е множество от допустими монети {1,2,5,10,20,50} и желана сума. Целта е да достигнем желаната сума с възможно най-малко монети.


Вход |	Изход |	Коментар
----|----|----
Монети: 1, 2, 5, 10, 20, 50; Сума: 923 | Брой монети за желаната сума: 21; 18 монета/и с номинал 50; 1 монета с номинал 20; 1 монета с номинал 2; 1 монета с номинал 1 |	18*50 + 1*20 + 1*2 + 1*1 = 900 + 20 + 2 + 1 = 923; 
Монети: 1; Сума: 42 |	Брой монети за желаната сума: 42; 42 монети с номинал 1	
Монети: 3, 7; Сума: 11 |	Грешка! |	Желаната сума е недостижима с тоя набор от монети
Монети: 1, 2, 5; Сума: 2031154123| 	Брой монети за желаната сума: 406230826; 406230824 монети с номинал 5; 1 монета с номинал 2; 1 монета с номинал 1| Решението трябва да е достатъчно бързо за да се справи с комбинация от много малки монети и голяма желана сума
Монети: 1, 9, 10; Сума: 27 |	Брой монети за желаната сума: 9; 2 монети с номинал 10; 7 монетаи с номинал 1 |	Подходът с *greedy* алгоритъм връща неоптимално решение (9 монети вместо 3 с номинал 9)

*Решение:*

```cpp
#include <iostream>
#include <algorithm>

int coins[] = { 1,2,5,10,20,50 };
unsigned coinsLength = sizeof(coins) / sizeof(coins[0]);
int targetSum = 923;

unsigned* countCoins = new unsigned[coinsLength]();

unsigned numCoins(0);

void printCoins();

int main()
{
	sort(coins, coins + coinsLength, std::greater<int>());

	int currentSum(0);
	unsigned coinIndx(0);

	while (coinIndx < coinsLength || currentSum > targetSum)
	{
		int currentCoinValue = coins[coinIndx];

		if (currentSum + currentCoinValue > targetSum)
		{
			coinIndx++;
			continue;
		}

		int remainingSum = targetSum - currentSum;
		int coinsToTake = remainingSum / currentCoinValue;

		if (coinsToTake > 0)
		{
			countCoins[coinIndx] = coinsToTake;

			currentSum += coinsToTake * currentCoinValue;
		}
	}
	for (unsigned i = 0; i < coinsLength; i++)
	{
		numCoins += countCoins[i];
	}
	if (currentSum!=targetSum)
	{
		std::cout << "Error\n";
		return 0;
	}
	printCoins();
	return 0;
}

void printCoins()
{
	std::cout << "Number of coins to take: " << numCoins << "\n";
	for (unsigned i = 0; i < coinsLength; i++)	{
		
		if (countCoins[i] != 0)
		{
			std::cout << countCoins[i] << " coin(s) with value " << coins[i] << "\n";
		}
	}
}
```
Забележете, че в последния от примерните случай, *greedy* алгоритъмът не дава оптимално решение, но все пак дава някакво решение. За да бъде оптимално решението на алгоритъма е необходимо монетите да изпълняват следното условие: сбора на която и да е (текуща) монета с най-малката от всички монети да не е по-малък от удвоената следваща по-малка монета от текущата монета. Например монетите 10,5,4,1 няма да дават оптимални решения, защото 5+1<2.4
