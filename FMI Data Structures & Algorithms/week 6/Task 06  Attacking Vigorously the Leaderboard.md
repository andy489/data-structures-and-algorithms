Довършете балансираното AVL дърво като имплементирате следните операции

- 1.добавяне на елемент
- 2.премахване на елемент

Забранено е използването на stl::set или stl::map

## Входен формат

При add ако числото вече съществува, да изписва "X already added" и нов ред след това (на мястото на X да се изписва самото подадено число)

При remove ако числото не съществува, да изписва "X not found to remove" и нов ред след това (на мястото на X да се изписва самото подадено число)

## Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{100000}">

int.MIN_VALUE <= number <= int.MAX_VALUE

Output Format

При операция contains изпишете "yes" или "no" в зависимост от това дали даденото число се съдържа в дървото.

При операция print изпишете текущото състояние на дървото във формат Ляво-Корен-Дясно с разстояние между елементите.

Note! cout << fixed; винаги връща до 6 символа след десетичната запетая.

Sample Input 0

7
add 58
add 98
contains 58
add 52
contains 23
add 23
print

Sample Output 0

yes
no
23.000000 52.000000 58.000000 98.000000 

Sample Input 1

16
add 8.43
add 5.83
add 7.66
add 1.92
remove 7.66
add 4.47
add -2.76
contains 7.23
add -1.64
remove 5.49
add 4.66
add 3.04
add 4.47
contains 8.43
add 7.34
print

Sample Output 1

no
5.490000 not found to remove
4.470000 already added
yes
-2.760000 -1.640000 1.920000 3.040000 4.470000 4.660000 5.830000 7.340000 8.430000 

