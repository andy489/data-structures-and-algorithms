## Min-Max-Intervals

[Min-Max-Intervals Judge](https://www.hackerrank.com/contests/practice-5-sda/challenges/min-max-intervals)

Даден ви е масив с N цели положителни числа: A[0], A[1], ..., A[N - 1] и цялото число K. Min-Max интервал ще наричаме последователност от елементи на масива, такава че разликата между минималния и максималния измежду тях е най-много K. По-формално казано:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;Min-Max-Intervals=\{s=A[i],A[i+1],...,A[j]|0\le{i\le{j}<N{\;}\&{\;}max(s)-min(s)\le{K}\}">

Намерете броят на Min-Max интервалите в масива А (броя на елементите на множеството Min-Max-Intervals).

#### Входен формат

На първият ред се въвеждат числата N и К.

Следват N числа - елементите на масива A[0], A[1], ..., A[N - 1];

#### Ограничения
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{N}\le{2{\;}000{\;}000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{K}\le{2{\;}000{\;}000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{A[i]}\le{2{\;}000{\;}000}">

#### Изходен формат

Изведете едно число - броя на Min-Max интервалите в масива А.

Примерен вход|Очакван изход
-|-
10 5<br>8 4 9 5 7 1 2 10 6 3|23
8 4<br>4 1 8 7 2 6 5 3|16
