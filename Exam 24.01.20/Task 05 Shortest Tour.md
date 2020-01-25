## Най-кратък тур

[Judge System](https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/shortest-tour/problem)

Намирате се в град с <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой туристически атракции и много странна пътна инфраструктура. Знаете, че измежду атракциите има <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> на брой еднопосочни улички с равна дължина. Вие сте си набелязали <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> на брой атракции <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_1,X_2,...,X_K"> в точната последователност, в която искате да ги обиколите за възможно най-кратко време. От вас се иска да намерите най-краткия път от <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_1"> до <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_K">, минаваща през всяка една от атракциите <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_2,...,X_{K-1}">.

Забележка: Искате да обходите атракциите точно в последователността, която сте си избрали. Първото срещане на всяко <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_i"> не трябва да се среща преди първото срещане на <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_{i-1}">. Забележете, че един връх може да участва по повече от веднъж в търсения път, а всяка атракция може да се посети пак след като е посетена първоначално.

#### Входен формат

От първия ред на стандартния вход се въвеждат <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;М"> - съответно броя на върховете и броя на ребрата в графа. На следващите <img src="https://latex.codecogs.com/svg.latex?\Large&space;М"> на брой реда се въвеждат по <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> променливи <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_i"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;b_i"> - определящи ребро с начало <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_i"> и край <img src="https://latex.codecogs.com/svg.latex?\Large&space;b_i">. На следващия ред се въвежда <img src="https://latex.codecogs.com/svg.latex?\Large&space;К">. На последния ред от стандартния вход се въвеждат <img src="https://latex.codecogs.com/svg.latex?\Large&space;К"> на брой числа - номерата на върховете <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_1,...,X_K">

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N\le{10^3}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;M,K\le{10^4}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{a_i,b_i,X_i}<N">

#### Изходен формат

Извежда се едно число - дължината на искания най-кратък път. Ако такъв път не съществува изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

Примерен вход|Oчакван изход
-|-
5 7<br>0 1<br>1 4<br>0 2<br>2 3<br>3 4<br>4 1<br>3 2<br>3<br>0 4 1|4

*Пояснение:*

Пътят, който търсим е <img src="https://latex.codecogs.com/svg.latex?\Large&space;0->2->3->4->1"> и е с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">. Забележете, че има път <img src="https://latex.codecogs.com/svg.latex?\Large&space;0->1->4->1">, който е с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">, но той не минава по атракциите в зададения ред, а минава през <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> преди през <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">.
