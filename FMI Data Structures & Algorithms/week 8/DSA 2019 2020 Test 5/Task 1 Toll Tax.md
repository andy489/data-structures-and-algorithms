## Toll Tax

[Judge System](https://www.hackerrank.com/contests/sda-2019-2020-test-5/challenges/challenge-2298)

Алгоритмия е държава с множество градове и голяма пътна мрежа. За поддръжка на пътната инфраструктура се използват събиране на тол такси, като такса се дължи при преминаването през всеки град. Понеже пътната мрежа е доста сложна и всеки иска да спести колкото се може от плащането на такси, то на вас се пада честта да направите приложение, което да смята дължимите такси по зададени градове през които се минава.

#### Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - брой градове

<img src="https://latex.codecogs.com/svg.latex?\Large&space;М"> - дължина на път

<img src="https://latex.codecogs.com/svg.latex?\Large&space;name_i,cost_i"> - <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой двойки показващи име на град и тол такса за преминаване през него.

<img src="https://latex.codecogs.com/svg.latex?\Large&space;name_j"> - <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> на брой двойки показващи пътя за който търсим дължимите тол такси.

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{M}\le{N}\le{100,000,000}"> 
Имената са сформирани от букви и цифри като малка и голяма буква са различни букви.
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{cost_i}\le{max_int}">

#### Изходен формат

Сумата от тол таксите за преминаване на подаденият път

Примерен вход|Очакван изход
-|-
5 3<br>FF 5<br>pL 0<br>vl 6<br>X6 6<br>YW 2<br>FF vl pL|11
