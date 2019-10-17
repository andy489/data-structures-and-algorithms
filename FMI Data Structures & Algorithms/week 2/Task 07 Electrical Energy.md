## Задача 7.

**За тази домашна работа не е разрешено използването на std::sort и други вградени методи за сортиране**

В града в който живеете има редица от N на брой сгради. Всяка сграда има определена височкина - <img src="https://latex.codecogs.com/svg.latex?\Large&space;H[i]">.

Вие разполагате с предавател, който може да изпрати сигнал до сграда по ваш избор. За да изпратите сигнал до определена сграда ви трябва различно количество електрическа енергия, базирано на броя по-високи сгради от нея по пътя на сигнала. По-точно за да изпратите сигнал до сграда с пореден номер <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">, ви трябва електрическа енергия <img src="https://latex.codecogs.com/svg.latex?\Large&space;E[i]"> = броят по-високи сгради между вашият предавател и въпрсоната сграда.

Сега ви интересува колко общо електрическа енергия би ви трябвала, за да изпратите сигнал до всяка от <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">-те сгради в редицата. Намерете нужната енергия, ако знаете че предавателят ви се намира от лявата страна на редицата от сгради. 

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Electrical%20Energy%2001.png)

## Входен формат

На първият ред на входа се въвежда числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - брой на сградите в редицата.

Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> числа <img src="https://latex.codecogs.com/svg.latex?\Large&space;H[0],...,H[N-1]"> - височините на сградите.

## Ограничения
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{N}\le{100000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{H[i]}\le{100000}">

## Изходен формат
Изведете 1 число - необходимата електрическа енергия, за да изпратите сигнал до всяка сграда.

Примерен вход|Очакван изход
-|-
5<br>6 4 3 5 7|4
