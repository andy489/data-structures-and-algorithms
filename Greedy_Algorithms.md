**Задача 1.** Даден е множество от допустими монети {1,2,5,10,20,50} и желана сума. Целта е да достигнем желаната сума с възможно най-малко монети.


Вход |	Изход |	Коментар
----|----|----
Монети: 1, 2, 5, 10, 20, 50; Сума: 923 | Брой монети: 21; 18 coin(s) with value 50; 1 coin(s) with value 20; 1 coin(s) with value 2; 1 coin(s) with value 1 |	18*50 + 1*20 + 1*2 + 1*1 = 900 + 20 + 2 + 1 = 923; 
Монети: 1; Сума: 42 |	Number of coins to take: 42; 42 coin(s) with value 1	
Монети: 3, 7; Сума: 11 |	Error |	Cannot reach desired sum with these coin values
Монети: 1, 2, 5; Сума: 2031154123| 	Number of coins to take: 406230826; 406230824 coin(s) with value 5; 1 coin(s) with value 2; 1 coin(s) with value 1| Solution should be fast enough to handle a combination of small coin values and a large desired sum
Монети: 1, 9, 10; Сума: 27 |	Number of coins to take: 9; 2 coin(s) with value 10; 7 coin(s) with value 1 |	Greedy approach produces non-optimal solution (9 coins to take instead of 3 with value 9)

