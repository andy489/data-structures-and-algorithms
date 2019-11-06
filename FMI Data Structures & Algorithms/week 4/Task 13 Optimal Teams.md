## Optimal Teams

За предстоящата студентска олимпиада по информатика преподавателите от ФМИ искат да формират 2 отбора. За целта те са подредили всичките n студента желаещи да участват в редица. Знаейки уменията на <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-тия студент в редицата капитаните Иван и Георги избират отборите по следния начин - първо Иван избира студента с най-голям брой умения както и <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">-те студента в ляво и дясно от него(Ако в ляво или дясно има по-малко от <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> студенти, Иван взима в отбора колкото има). След това Георги избира по същия начин студента с най-много умения и <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">-те студента в ляво и дясно от него. Отборите са сформирани, когато няма повече студенти в редицата. От вас се иска да намерите кои са отборите за да спестите малко време на преподавателите.

#### Входен формат

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> - брой студенти
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> - брой допълнителни студенти, които ще бъдат избрани
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_i">- броя умения на <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-тия студент

На първия ред ще получите числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">. На втория ред ще получите числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_i">. Всички числа ще са разделени с един интервал.

#### Ограничения
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{k}\le{n}\le{2*10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{a_i}\le{n}">
- Броя умения на всеки студент е различенn<img src="https://latex.codecogs.com/svg.latex?\Large&space;(i\neq{j}\Rightarrow{a_i}\neq{a_j})">

#### Изходен формат

На един ред изведете редицата <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_1t_2...t_n">, като е <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_i"> е 1, ако <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-тия студент се намира в първия отбор и <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_i"> е 2, ако <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-тия студент се намира във втория отбор.

Примерен вход|Очакван изход
-|-
5 2<br>2 4 5 3 1|11111
5 1<br>2 1 3 5 4|22111
7 1<br>7 2 1 3 5 4 6|1121122
5 1<br>2 4 5 3 1|21112

