## Задача 9.

Асистентът ви много харесва балони и иска да му давате балони всеки ден в продължение на <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> дни (номерирани с числата от <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> до <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">). На поредния ден <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">, вашият асистент иска <img src="https://latex.codecogs.com/svg.latex?\Large&space;A_i"> балона. Проблемът е, че имате само <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> балона.

За щастие може да давате бонбони вместо балони на асистента си. На поредния ден <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> той е съгласен да получи <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_i"> бонбона за всеки балон който не сте му дали, или по-формално казано, ако му дадете <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_i"> балона на ден <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">, тогава трябва да му дадете и <img src="https://latex.codecogs.com/svg.latex?\Large&space;C_i=max(0,A_i−X_i)\times{B_i}"> бонбона.

Задачата ви е да минимизирате максималният брой бонбони, които трябва да дадете на асистента си в един ден − намерете минималната възможна стойност на <img src="https://latex.codecogs.com/svg.latex?\Large&space;max(C_1,C_2,...,C_N)">.

#### Входен формат

На първият ред от входа ще са дадени числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;M">.

На вторият ред от входа ще бъдат дадени числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;A_1,A_2,...,A_N">.

На третият ред от входа ще бъдат дадени числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_1,B_2,...,B_N">.

#### Ограничения
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^5}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;N\le{M}\le{10^18}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{A_i}\le{10^9}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{B_i}\le{10^9}"><br>

#### Изходен формат

Изведете едно число - минималната стойност на <img src="https://latex.codecogs.com/svg.latex?\Large&space;max(C_1,C_2,...,C_N)">.

Примерен вход|Очакван изход|Пояснение
-|-|-
5 3<br>1 2 3 4 5<br>1 2 3 4 5|15|Оптималното разпределение на балоните по дни е (0, 0, 0, 1, 2) което води и до отговора 15 (бонбоните които ще трябва да дадете на 5тия ден).<br>(Ограничението <img src="https://latex.codecogs.com/svg.latex?\Large&space;N\le{M}"> е изпълено във всички останали тестове, тук <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> е по-млако за по-лесно разписване на теста)
5 6<br>1 3 3 3 2<br>4 1 5 3 7|5|Оптималното разпределение на балоните по дни е (0, 0, 2, 2, 2) което води и до отговора 5 (бонбоните които ще трябва да дадете на третия ден).
