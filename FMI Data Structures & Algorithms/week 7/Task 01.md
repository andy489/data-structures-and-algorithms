## Task 1.

Реализирайте едносвързан списък, който има следните операции:

1. **add(X,pos)** - добавя числото X на позиция pos в писъка, като ако няма възможност да се добави на такава позиция(отрицателен индекс или прекаленно голям индекс) добавя елемента в края на списъка и извежда след това съобщение на стандартният изход add_last.
2. **remove(pos)** - премахва елемента, който е на позиция pos, ако няма възможност да се премахне на такава позиция(отрицателнен индекс или прекаленно голям индекс) не се премахва елемент, а на стандартният изход се извежда текста remove_failed
3. **print()** - изкарва на стандартният изход числата от списъка, като след всяко число се принтира символа #. При празен списък не се изкарва нищо на стандартният изход.
4. **reverse()** - обръща списъка на обратно, т.е. последният елемент става вече първи,предпоследният втори и т.н.
5. **is_palindrom()** - проверява дали списъка е палиндром(поредица,която се чете еднакво отпред назад и отзад напред), като ако е палиндром принтира на стандартният изход true, а ако не е false
6. **count(X)** - преброява, колко пъти се среща числото Х в списъка и извежда резултата на стандартният изход
7. **remove_all(X)** -премахва всички срещания на числото Х в списъка
8. **group(startPos,endPos)** -сумира елементите между подадените две позиции(включително позициите) и ги замества в масива със сумата им. (Пример: при масив 1,2,3,4,5,6,7,8,9 и group(2,4) получаваме списък 1,2,12,6,7,8,9) Ако позициите не са валидни операцията не се изпълнява, а на стандартният изход се принтира fail_grouping

#### Входен формат

всеки тест започва с число N показващо броя на тестващите редици с операции. След това ще се подадат К на брой операции, като първо се подава числото К и след това всяка една операция. Всяка операция е на нов ред, като първо е името на операцията, а след това ако операцията има параметри те се подават с разделител интервал

#### Ограничения

Ще бъдат подадени максимум 1 милион операции.

#### Изходен формат

Изхода е спрямо указанията по-горе, като изхода от всяка тестова редица от операции се извежда на нов ред. При изкарването на резултатите не принтирайте никакви символи(интервали,табулации или нещо друго), които на са в указанието.

Примерен вход|Очакван изход
-|-
2<br>3<br>add 1 0<br>add 2 1<br>print<br>5<br>add 10 0<br>add 20 0<br>add 30 2<br>remove 1<br>print|1#2#<br>20#30#

Тестовете покриват всяка една функция и може да си тествате функционалността по време на писане като ги стартирате.

Примерен вход|Очакван изход
-|-
4<br>4<br>add 1 0<br>add 2 1<br>add 3 2<br>print<br>4<br>add 1 0<br>add 2 0<br>add 3 0<br>print<br>4<br>add 1 0<br>add 2 1<br>add 3 1<br>print<br>4<br>add 1 2<br>add 2 2<br>add 3 2<br>print|1#2#3#<br>3#2#1#<br>1#3#2#<br>add_lastadd_last1#2#3#
6<br>5<br>add 1 0<br>add 2 1<br>add 3 2<br>remove 0<br>print<br>5<br>add 1 0<br>add 2 0<br>add 3 0<br>remove 1<br>print<br>5<br>add 1 0<br>add 2 1<br>add 3 1<br>remove 2<br>print<br>5<br>add 1 2<br>add 2 2<br>add 3 2<br>remove 3<br>print<br>8<br>add 1 2<br>add 2 2<br>remove 1<br>add 3 2<br>remove 1<br>add 5 2<br>remove 0<br>print<br>9<br>add 1 2<br>add 2 2<br>remove 1<br>remove 0<br>add 3 2<br>remove 1<br>add 5 2<br>remove 0<br>print|2#3#<br>3#1#<br>1#3#<br>add_lastadd_lastremove_failed1#2#3#<br>add_lastadd_lastadd_lastadd_last5#<br>add_lastadd_lastadd_lastremove_failedadd_last5#
4<br>5<br>add 1 0<br>add 2 1<br>add 3 2<br>reverse<br>print<br>5<br>add 1 0<br>add 2 0<br>add 3 0<br>reverse<br>print<br>7<br>add 1 0<br>add 2 1<br>add 3 1<br>reverse<br>print<br>reverse<br>print<br>6<br>add 1 2<br>add 2 2<br>add 3 2<br>reverse<br>reverse<br>print|3#2#1#<br>1#2#3#<br>2#3#1#<br>1#3#2#<br>add_lastadd_last1#2#3#
4<br>4<br>add 1 0<br>add 2 0<br>add 3 0<br>is_palindrom<br>4<br>add 1 0<br>add 1 0<br>add 1 0<br>is_palindrom<br>4<br>add 1 0<br>add 2 0<br>add 1 0<br>is_palindrom<br>6<br>add 1 0<br>add 2 0<br>add 3 0<br>add 2 0<br>add 1 0<br>is_palindrom|false<br>true<br>true<br>true
4<br>4<br>add 1 0<br>add 2 0<br>add 3 0<br>count 2<br>4<br>add 1 0<br>add 1 1<br>add 1 1<br>count 1<br>4<br>add 1 2<br>add 2 2<br>add 2 2<br>count 2<br>9<br>add 1 0<br>add 2 1<br>add 3 2<br>add 2 1<br>add 2 4<br>count 2<br>count 1<br>count 3<br>count 2|1<br>3<br>add_lastadd_last2<br>3113
4<br>5<br>add 1 0<br>add 2 0<br>add 3 0<br>remove_all 2<br>print<br>5<br>add 1 0<br>add 1 1<br>add 1 1<br>remove_all 1<br>print<br>5<br>add 1 2<br>add 2 2<br>add 2 2<br>remove_all 2<br>print<br>7<br>add 1 0<br>add 2 1<br>add 3 2<br>add 2 1<br>add 2 4<br>remove_all 2<br>print|3#1#<br>add_lastadd_last1#<br>1#3#
4<br>5<br>add 1 0<br>add 2 0<br>add 3 0<br>group 0 0<br>print<br>5<br>add 1 0<br>add 2 0<br>add 3 0<br>group 0 1<br>print<br>5<br>add 1 0<br>add 2 0<br>add 3 0<br>group 0 2<br>print<br>5<br>add 1 0<br>add 2 0<br>add 3 0<br>group 0 3<br>print|3#2#1#<br>5#1#<br>6#<br>fail_grouping3#2#1#
