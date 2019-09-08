Бинарното дърво на търсенето е специален вид бинарно дърво. То е ефективна структора за организиране на данни, за която е необходимо бързо търсене и бързa актуализация. 

структура от данни|масив (несортиран)|свързан списък|масив (сортиран)|двойчно дърво за търсене
----|----|----|----|----
**търсене**|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(log{n})}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(log{n})}">
**актуализиране**|<img src="https://latex.codecogs.com/svg.latex?\Theta{(1)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(1)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(log{n})}">
**премахване**|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(log{n})}">

*Можем да минимализираме цената на търсенето в масива или свързания списък, но за целта трябва да бъдат сорирани. Но дори и да пренебрегнем цената на сортировката първоначално, то трябва при всяка актуализация на данните да поддържаме структурата сортирана.*
