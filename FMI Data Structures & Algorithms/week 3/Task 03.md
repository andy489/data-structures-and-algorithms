
## Задача 3.
Една студена зима младата програмистка Мърджания решила да си изсуши дрехите. Нека сега си представим, че нашата млада програмистка разполага с простор с <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> дрехи, които трябва да изсуши. Тя разполага със сешоар, който във всеки един момент може да се използва върху една дреха.<br>Мърджания иска да изсуши всички дрехи за възможно най-кратък период от време.

Разполагате с <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> дрехи като за всяка дреха <img src="https://latex.codecogs.com/svg.latex?\Large&space;N_i"> се знае колко време в минути е необходимо за да стане суха. При дреха която е с <img src="https://latex.codecogs.com/svg.latex?\Large&space;\le{0}"> минути считаме, че вече е суха и готова да се прибере.

Сешоарът на Мърджиния не е обикновен. Tой може на всяка кръгла минута по избрана от вас дреха да намаля нейното време за сушене с <img src="https://latex.codecogs.com/svg.latex?\Large&space;K">. Тоест ако <img src="https://latex.codecogs.com/svg.latex?\Large&space;K=3"> и някоя дреха <img src="https://latex.codecogs.com/svg.latex?\Large&space;N_i=3">, то ако използвате сешоара върху тази дреха тя за 1 минута ще бъде суха.

Дори и навън да е зима, вятърът понякога помага и в нашия случай той е на ваша страна. Знае се че вятърът постоянно намалява времето за сушене на всички ваши дрехи с 1 минута. Тоест ако имате дреха <img src="https://latex.codecogs.com/svg.latex?\Large&space;N_i=2">, то дори и да не използвате сешоара - след 2 минути тази дреха ще бъда суха.

От вас се иска по подадени <img src="https://latex.codecogs.com/svg.latex?\Large&space;N,K"> и след това <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> дрехи, и по ваша преценка използвайки сешоара да върнете мининалният брой минути за които всички дрехи ще бъдат сухи.

*ВАЖНО: Когато използваме сешоара, вятърът НЕ ОКАЗВА ВЛИЯНИЕ на тази дреха !!!*

#### Входен формат
Броя на дрехите <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и мощността на сешоара <img src="https://latex.codecogs.com/svg.latex?\Large&space;K">. След това се въвеждат минутите необходими за изсушаването на всяка дреха - <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> числа.

#### Ограничения 
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<N\le{100000}"><br>
Началното време за сушене на всяка дреха ще е <img src="https://latex.codecogs.com/svg.latex?\Large&space;\le{1000000000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<K\le{1000000000}">
#### Изходен формат
Минималното време използвайки или не сешоара, за което всички дрехи ще са сухи.

Примерен вход|Oчакван изход
3 5<br>2 3 9|3
4 3<br>4 9 19 1|7
4 3<br>4 10 19 1|8

