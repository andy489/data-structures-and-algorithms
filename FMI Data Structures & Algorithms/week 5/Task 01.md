## Задача 1.
Рицарите от приказния свят Алгоритмия много обичат да се сражават и да измислят хитри стратегии и алгоритми, с които да побеждават техните противници. Когато нямат битки те рашават да играят помежду си на следната игра: рицарите, които са <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой се нареждат в кръг. Те са номерирани с числата от <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> до <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">, като рицаря стоящ отляво на <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> е номериран с числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">, рицаря стоящ отляво на <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> е номериран с числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> и т.н (отляво на рицаря с номер <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> стои рицаря с номер <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">). Играта започва с рицаря с номер <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">, който трябва да елиминира рицаря стоящ отляво на него (в случая рицаря с номер <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">). След това следващия непобеден рицар стоящ отляво на <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> трябва да направи същия ход, като играта продължава докато не остане само един непобеден рицар. Вашата задача е да изведете неговия номер. На първия ред ще получите числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - броя на рицарите. Трябва да изведете на един ред номера на рицаря който печели.

#### Входен формат
<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - броя на рицарите

#### Ограничения
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{20000000}">

#### Изходен формат
На единствен ред номера на рицаря, който печели

Примерен вход: 6
Oчакван изход: 5
Обяснение:
```
    1
6       2
       
5       3
    4
```
Рицаря с номер 1 елиминира рицаря с номер 2

Рицаря с номер 3 елиминира рицаря с номер 4

Рицаря с номер 1 елиминира рицаря номер 3

Рицаря с номер 5 елиминира рицаря номер 1

Рицаря с номер 5 печели тъй като е последния останал.

Примерен вход: 4
Oчакван изход: 1
Обяснение:

```
  1
4   2
  3
```

Рицаря с номер 1 елиминира рицаря с номер 2

Рицаря с номер 3 елиминира рицаря с номер 4

Рицаря с номер 1 елиминира рицаря номер 3

Рицаря с номер 1 печели тъй като е последния останал.

Примерен вход: 3
Oчакван изход: 3

