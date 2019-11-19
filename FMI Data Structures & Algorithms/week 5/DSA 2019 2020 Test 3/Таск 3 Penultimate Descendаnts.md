## Penultimate Descendants

[Penultimate Descendants](https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/penultimate-descendants)

Напишете функция, която изтрива тези върхове на Двоично дърво за търсене, чиито 2 деца са:

- листо и листо, или

- листо и NULL (NULL и листо)

След изтриването полученото дърво трябва да продължи да бъде двоично наредено.
```
	    5             7
           / \     -->   /
          3   7         3

	    5              5
           / \            / \
          3   8     -->  4   9 
         / \   \        /
        1   4   9      1
```
*Показаните подредби не са единствени

#### Входен формат

Функцията не приема никакви аргументи.

#### Ограниченияг

<img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le">Броят на елементите в дървото<img src="https://latex.codecogs.com/svg.latex?\Large&space;\le{1000000}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le">Стойността на елементите на дървото<img src="https://latex.codecogs.com/svg.latex?\Large&space;\le{1000000}">

#### Изходен формат

На единствения ред на стандартния изход изведете елементите на полученото дърво в сортиран ред.

Примерен вход|Очакван изход
6<br>5 3 8 1 4 9|1 4 5 9 

