# Searching Algorithms

Aлгоритъмът за търсене е алгоритъм за намиране на елемент със специфични свойства сред колекция от елементи.

Име | метод 
------- | ------- 
**Linear Search** *Последователно търсене* |  обхожда елемент по елемент (изходен елемент за оптимизация)
*Последователно търсене в сортиран списък* |  обхожда елемент по елемент, до достигане на такъв с по-голям ключ
*Последователно търсене с преподреждане* |  обхожда елемент по елемент и актоализира позицията на всеки търсен елемент 
**Quadratic Search** *Търсене със стъпка/Kвадратично търсене*  |  обхожда сектор по сектор в сортиран списък

### 1. Последователно търсене
Най-елементарният и очевиден алгоритъм за търсене е последователното търсене. Нека предположим, че елементите на множеството се съдържат в едномерен масив. Търсенето се извършва посредством последователно преглеждане на елементите на масива до откриване на търсения елемент или до преглеждане на всички елементи. Последното означава, че елемент с такъв ключ не съществува.При постъпване на нов елемент ще го вмъкваме в края на масива *seqSearch()*. Следва една възможна реализация на основните функции, основаваща се на последователното търсене:

```cpp
#define MAX 10
#define DataType int
#include <iostream>
#include <time.h>

struct CPPElem
{
	int key;
	DataType data;
	/*...*/
}m[MAX + 1]; /* Масив от записи*/
unsigned n;  /*Брой елементи в масива*/

void seqInit(void) { n = 0; }  /*Инициализиране*/

unsigned seqSearch(int key)    /*Последователно търсене*/
{
	unsigned x;
	m[0].key = key;  /*Ограничител*/
	for (x = n + 1; key != m[--x].key; );
	return x;
}

void seqInsert(int key, DataType data) /*Добавя нов елемент*/
{
	m[++n].key = key;
	m[n].data = data;
}

void seqPrint(void) /*Извежда списъка на екрана*/
{
	unsigned i;

	for (i = 1; i <= n; i++)
	{
		std::cout << m[i].key << ' ' << m[i].data << std::endl;
	}
}

void performSearchTest(void)
{
	unsigned ind, elem2Search;
	for (elem2Search = 0; elem2Search < 2 * MAX; elem2Search++)
	{
		std::cout << "We search an element with key " << elem2Search << "\n";
		if (0 == (ind = seqSearch(elem2Search)))
			std::cout << "Element with such key does not exist!" << "\n\n";
		else
			std::cout << "Item found! Info part: " << m[ind].data << "\n\n";
	}
}

int main()
{
	srand(unsigned(time(0)));
	unsigned ind;
	seqInit();
	for (ind = 0; ind < MAX; ind++) seqInsert(rand() % (MAX * 2), ind);
	std::cout << "the list contains the following items:\n";
	seqPrint();
	std::cout << "Testing:\n";
	performSearchTest();
	return 0;
}
```
По-горе сме приели, че същинската информационна част на елементите на масива съдържа единствено поле *data*. Както се забелязва, търсенето се извършва последователно по посока на намаляване на индексите. Забележете, че нулевия елемент на масива не съдържа елемент на множеството, а служебна информация. Той е използван като *елемент-ограничител*, позволяващ опростяване на цикъла: проверява се само едно условие, тъй като сме осигурили намирането на елемент със зададения ключ (в краен случай нулевият). В случай на дублиране на ключове горният алгоритъм очевидно връща последния постъпил елемент с този ключ. 

Каква е сложността на алгоритъма в средния и в най-лошия случай съответно? Ясно е, че най-лошият случай е когато търсеният елемент липсва. Тогава се преглеждат всичките *n+1* елемента на масива, включително нулевият. В общия случай, когато търсенето е успешно, средният брой на извършените сравнения е <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{n+1}{2}">. Същевременно, за намиране на всички елементи с даден ключ е необходимо *цялостно* преглеждане на масива.

#### 1.1. Последователно търсене в сортиран списък:

Последователното търсене, разгледано по-горе, е най-простият и най-неефективният алгоритъм за търсене. Бихме могли да се опитаме да подобрим ефективността му, поддържайки елементите в сортиран вид. Това ще ни се удаде сравнително лесно, ако използваме свързан списък вместо масив. Всичко което трябва да направим, е да вмъкваме всеки новопостъпил елемент на съответното му място, така че списъкът да остава сортиран. Така преди всяко вмъкване ще се изисква извършване на съответно търсене, за да се открие съответната позиция.

Операцията по вмъкване се усложнява значително. По-горе я извършвахме за константно време, без нито едно сравнение, а сега това ще изисква предварително търсене. Какво все пак постигнахме? Обстоятелството, че елементите са подредени в нарастващ ред, ще ни позволи да прекратяваме по-нанатъшното търсене при достигане на елемент с ключ, по-голям от търсения. Броят на необходимите сравнения в случай на неуспешно търсене намалява до <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{n+1}{2}">, в сравнение с <img src="https://latex.codecogs.com/svg.latex?\Large&space;n+1"> при несортирания случай. На практика успешното и неуспешното търсене се оказват равнопоставени, тъй като тази модификация очевидно не влияе на успешното търсене. В най-лошия случай отново трябва да се прегледат всички елементи, т.е. да се извършат <img src="https://latex.codecogs.com/svg.latex?\Large&space;n+1"> сравнения. Оказва се, че в замяна на това, че сме приравнили сложността на вмъкването, която по-рано беше константна, към сложността на търсенето, получаваме само равнопоставеност на успешно и неуспешно търсене. Полученият реултат е изключително поучителен и показва, че преди да се пристъпи към някаква „очевидна“ оптимизация, следва много внимателно да се прецени възможната полза и вреда, които тя ще принесе.

Следва примерна реализация на последователно търсене в сортиран списък, заедно със съответна версия на функции за вмъкване и инициализиране:

```cpp
#define DataType int
#define MAX 10
#include <iostream>
#include <time.h>

struct CPPElem
{
	int key;
	DataType data;
	struct CPPElem *next;
	/* ... */
} *head;

void listInit(void) /* Инициализиране */
{
	head = (struct CPPElem*) malloc(sizeof *head);
	head->next = nullptr;
}

void listInsert(int key, DataType data)/* Добавя нов елемент */
{
	struct CPPElem *p, *q, *r;
	q = (struct CPPElem*) malloc(sizeof *head);
	r = (p = head)->next;
	while (r != nullptr && r->key < key)
	{
		p = r;
		r = r->next;
	}
	q->key = key;
	q->data = data;
	q->next = r;
	p->next = q;
}
struct CPPElem *listSearch(int key) /* Последователно търсене */
{
	struct CPPElem *q;
	for (q = head->next; q != nullptr&&q->key < key; q = q->next);
	if (nullptr == q || key != q->key)
		return nullptr;
	else
		return q;

}

void listPrint(void) /* Извежда списъка на екрана */
{
	struct CPPElem *q;
	for (q = head->next; q != nullptr; q = q->next)
	{
		std::cout << q->key << ' ' << q->data;
		std::cout << std::endl;
	}
}

int main()
{
	srand(unsigned(time(0)));
	unsigned ind;
	listInit();
	for (ind = 0; ind < MAX; ind++) listInsert(rand() % (MAX * 2), ind);
	std::cout << "the list contains the following items:\n";
	listPrint();

	std::cout << "Serching: \n";
	CPPElem *el = listSearch(10);
	if (el) std::cout << "Element found: key " << el->key << "; data " << el->data << '\n';
	else std::cout << "No element with such key found.\n";

	return 0;
}
```
#### 1.2. Последователно търсене с преподреждане:

В случай, че разполагаме с предварителна информация относно вероятността за достъп до всеки от елементите, бихме могли да ги подредим така, че най-често търсеният да бъде на върха на списъка, следващият - непосредствено след него и т.н. Използването на подобна стратегия се оказва изключително ефективно, особено при силно неравномерно разпределение, при което малък брой елементи се търсят с много голяма ефективност.

В случай, че не разполагаме с такава предварителна информация, бихме могли сами да си я получим с помощта на прости статистически наблюдения: достатъчно е към всеки елемент да прикрепим брояч на достъпа до него. При всяко ново търсене ще актуализираме брояча на търсения елемент. Ясно е, че след актуализацията той евентуално ще може да мине по-напред в списъка. Ето защо следва да се направи сравнение с предходния елемент в списъка, при което евентуално двата да се разменят. Тъй като в списъка може да има многократно дублиране на честотите на достъп, в случай на размяна се налага съответно сравнение и със следващия предходен елемент и т.н. до достигане на точната позиция, съответваща на новата честота на елемента. Реорганизацията става за време, пропорционално на <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, като в най-лошия случай може да се случи последният елемент на списъка да стане първи, разменяйки се последователно с всички преди него [*Уирт-1980*].

Предложената по-горе схема с поддържане на специални броячи обаче се оказва тромава, изисква допълнителна памет от порядъка на <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> и би могла да се оптимизира. За пореден път се оказва, че простото е по-добро. Действително, в този случай се оказва изключително ефективно прилагането на по-проста стратегия за реорганизация. Не се поддържат никакви броячи и не се води никаква статистика. Вместо това, при всяко успешно търсене на елемент той се поставя в началото на списъка. Разбира се тази стратегия не ни гарантира оптимално подреждане на елементите съгласно честотата им на достъп, но пък е лесна за поддържане и достатъчно ефективна. Действително, за разлика от варианта с броячите, тук реорганизацията става за време константа. От друга страна, колкото по-често е осъществяван достъп до даден елемент, с толкова по-голяма вероятност той ще се намира сред първите елементи на списъка. При това така по-добре се отчитат локалните особености: ако някой глобално погледнато рядко търсен елемент в даден момент се търси често, тази стратегия ще ни позвили да се възползваме от това.

```cpp
#define DataType int
#define MAX 10
#include <iostream>
#include <time.h>

struct CPPElem
{
	int key;
	DataType data;
	struct CPPElem *next;
	/* ... */
} *head;

void listInit(void) /* Инициализиране */
{
	head = (struct CPPElem*) malloc(sizeof *head);
	head->next = nullptr;
}

void listInsert(int key, DataType data)/* Добавя нов елемент */
{
	struct CPPElem *q = (struct CPPElem*) malloc(sizeof *head);
	q->key = key; q->data = data;
	q->next = head; head = q;
}
struct CPPElem *listSearch(int key) /* Последователно търсене с преподреждане */
{
	struct CPPElem *q, *p = head;
	if (nullptr == head)
		return nullptr;
	if (head->key == key) return head;
	for (q = head->next; q != nullptr; )
	{
		if (q->key != key)
		{
			p = q;
			q = q->next;
		}
		else
		{
			p->next = q->next;
			q->next = head;
			return (head = q);
		}
	}
	return nullptr;
}

void listPrint(void) /* Извежда списъка на екрана */
{
	struct CPPElem *q;
	for (q = head; q->next != nullptr; q = q->next)
	{
		std::cout << q->key << ' ' << q->data;
		std::cout << std::endl;
	}
}

int main()
{
	srand(unsigned(time(0)));
	unsigned ind;
	listInit();
	for (ind = 0; ind < MAX; ind++) listInsert(rand() % (MAX * 2), ind);
	std::cout << "the list contains the following items:\n";
	listPrint();

	std::cout << "Serching: \n";
	CPPElem *el = listSearch(10);
	if (el) std::cout << "Element found: key " << el->key << "; data " << el->data << '\n';
	else std::cout << "No element with such key found.\n";
	listPrint();
	return 0;
}
```

### 2. Търсене със стъпка. Квадратично търсене (Qadratic search)

Нека отново разгледаме случая на наредено множество. Разгледаният по-горе метод на търсене в сортиран списък се отличаваше незначително от стандартното последователно търсене и не използваше достатъчно пълноценно наредбата на елементите. Ще се опитаме да поправим тази грешка, като за целта ще възприемем коренно различен подход. Нека изберем някаква стъпка <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> и последователно извършваме проверката дали ключът на търсения елемент е по-голям от първия елемент, от <img src="https://latex.codecogs.com/svg.latex?\Large&space;k+1">-ия елемент, от <img src="https://latex.codecogs.com/svg.latex?\Large&space;2k+1">-ия елемент, от <img src="https://latex.codecogs.com/svg.latex?\Large&space;3k+1">-ия елемент, ... Т.е. сравняваме го с <img src="https://latex.codecogs.com/svg.latex?\Large&space;m[1].key,m[k+1].key,m[2*k+1].key,...">. Процесът приключва при достигане на елемент, по-голям или равен на <img src="https://latex.codecogs.com/svg.latex?\Large&space;x">, или на края на масива.

Да разгледаме по-внимателно горната схема (ще я наричаме *търсене със стъпка*). Нека предположим, че, прилагайки я, сме достигнали до елемент, по-голям от <img src="https://latex.codecogs.com/svg.latex?\Large&space;x">. Сега можем да използваме последователно търсене в интервала, определен от последните две проби. В случай, че сме били излезли извън масива, можем да използваме последователно търсене от предишната проба до края на масива. Очевидно подобен подход би могъл да доведе до силно съкращаване на броя на елементите, които се преглеждат от последователното търсене. Освен това лесно се вижда, че използвания метод е обобщение на линейното търсене. Действително, последното се получава при <img src="https://latex.codecogs.com/svg.latex?\Large&space;k=1">.

Съгласно приведеното по-горе описание, предложеният метод винаги започва с <img src="https://latex.codecogs.com/svg.latex?\Large&space;m[1].key">. Доколко подобно начало е удачно? Не е трудно да се види, че това всъщност е лош избор, при това по същите причини, по които е лош изборът <img src="https://latex.codecogs.com/svg.latex?\Large&space;m[n].key">: носи минимално количество информация. Оказва се, че е много по удачно да се започне направо с <img src="https://latex.codecogs.com/svg.latex?\Large&space;m[k].key">. Лесно се вижда, че и в този случай при <img src="https://latex.codecogs.com/svg.latex?\Large&space;k=1"> се получава линейно търсене.

Каква е ефективността на описания метод при фиксирано <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> и кой е най-лошия случай? Ясно е, че линейното търсене има еднаква цена за всички инервали от вида <img src="https://latex.codecogs.com/svg.latex?\Large&space;\big[m[i*k+1].key;m[(i+1)*k].key\big]">, тъй като се извършва върху еднакъв брой елементи. Изключение може да прави единствено последният интервал, който евентуално може да съдържа по малко от <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> елемента. В най-лошия случай търсеният ключ е в последния интервал, което означава, че ще ни бъде необходимо <img src="https://latex.codecogs.com/svg.latex?\Large&space;{n/k]"> сравнения, за да определим нужния ни интервал, в който да приложим линейното търсене. Към тях следва да прибавим дължината на интервала, която при <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, кратно на <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">, е <img src="https://latex.codecogs.com/svg.latex?\Large&space;k-1">. Получаваме, че в най-лошия случай при търсене със стъпка <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> се извършват не повече от <img src="https://latex.codecogs.com/svg.latex?\Large&space;[n/k]+k-1"> сравнения. Следва примерна реализация на описания алгоритъм:

```cpp
#define KEY 7
#define MAX 10
#define DataType int
#include <iostream>
#include <time.h>
#include <algorithm>
#include <cmath>
struct CPPElem
{
	int key;
	DataType data;
	/*...*/
}m[MAX + 1]; /* Масив от записи*/
unsigned n;  /*Брой елементи в масива*/

void seqInit(void) { n = 0; }  /*Инициализиране*/

bool wayToSort(CPPElem i, CPPElem j) { return i.key < j.key; } /* критерии за сортиране */

void seqInsert(int key, DataType data) /*Добавя нов елемент*/
{
	m[++n].key = key;
	m[n].data = data;
	std::sort(m + 1, m + n + 1, wayToSort); /* сортитаме масива */
}

int seqSearch(unsigned l, unsigned r, int key) /* последователно търсене */
{
	while (l <= r)
		if (m[l++].key == key) return l - 1;
	return -1;
}

int jmpSearch(int key, unsigned step) /* квадратично търсене */
{
	unsigned ind;
	for (ind = 0; ind < n && m[ind].key < key; ind += step);
	return seqSearch(ind + 1 < step ? 0 : ind + 1 - step, n < ind ? n : ind, key);
}

void seqPrint(void) /*Извежда списъка на екрана*/
{
	unsigned i;
	for (i = 1; i <= n; i++) std::cout << "position " << i << " : key " << m[i].key 
	<< " data " << m[i].data << std::endl;
}

int main()
{
	srand(unsigned(time(0)));
	unsigned ind;
	seqInit();
	for (ind = 0; ind < MAX; ind++) seqInsert(rand() % (MAX * 2), ind);
	std::cout << "the list contains the following items:\n";
	seqPrint();

	std::cout << "Testing:\n";
	int el = jmpSearch(KEY, (unsigned)(sqrt(n)));
	(el != -1) ? std::cout << "Element with key " << KEY << " found at position " 
	<< el : std::cout << "no element with key " << KEY;

	return 0;
}
```

Възниква важният въпрос: Как, при зададено <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> да избираме <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> така, че да осигурим максимална ефективност? Таблица 2.1. показва максималния брой сравнения, извършвани от вмъкването със стъпка при различни стойности на <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">:

n/k|1|2|3|4|5|6|7|8
----|----|----|----|----|----|----|----|----
**1**|1| | | | | | |  
**2**|2|2| | | | | | 
**3**|3|2|3| | | | | 
**4**|4|3|3|4| | | |  
**5**|5|3|3|4|5| | | 
**6**|6|4|4|4|5|6| | 
**7**|7|4|4|4|5|6|7| 
**8**|8|5|4|5|5|6|7|8

**Таблица 2.1.** Максимален брой сравнения при различни стойности на <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">.

Вижда се, че най-добрите стойности на <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> са близки до <img src="https://latex.codecogs.com/svg.latex?\Large&space;frac{n}{2}">, т.е. разположени са в средата на съответния ред на таблицата или непосредствени вляво от нея. За да определим по-прецизно кои стойности на <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> са най-добри и как зависят от <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, следва да определим при каква зависимост между <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> функцията <img src="https://latex.codecogs.com/svg.latex?\Large&space;f(k)"> приема минимална стойност: 

<img src="https://latex.codecogs.com/svg.latex?\Large&space;f(k)=[\frac{n}{k}]+k-1">.

Не е трудно да се покаже (например с изследване на знака на втората производна), че това е стойността <img src="https://latex.codecogs.com/svg.latex?\Large&space;k=\sqrt{n}">. Тогава <img src="https://latex.codecogs.com/svg.latex?\Large&space;f(k)\le{2\sqrt{n}+1}">. В този случай търсенето се нарича *квадратично* .

И така, постигнахме едно наистина добро подобрение: от <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> до 
<img src="https://latex.codecogs.com/svg.latex?\Large&space;\sqrt{n}">. Бихме ли могли да постигнем повече? Както следва да се очаква, отговорът на този въпрос е положителен. Действително по-горе минимизирахме <img src="https://latex.codecogs.com/svg.latex?\Large&space;f(k)"> предполагайки, че след определяне на интервала ще извършим последователно търсене. И точно тук идва идеята: А какво ще стане, ако в този момент приложим още веднъж търсене с някаква нова стъпка <img src="https://latex.codecogs.com/svg.latex?\Large&space;l(1\le{l}\le{k})"> и едва след това последователно търсене? Действително, действително дължината на интервала след първото търсене със стъпка <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> е <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sqrt{n}">, което може да бъде достатъчно голямо число, така че подобно подобрение би било разумно. Сега на първата стъпка ще имаме не повече от <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> сравнения за определяне на първия интервал, след това не повече от <img src="https://latex.codecogs.com/svg.latex?\Large&space;l"> сравнения - за определяне на втория, и накрая не повече от <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{n}{k.l}"> - за последователното търсене. Можем да образуваме нова функция, която да минимизираме, като в този случай лесно се получава, че минимумът се достига за <img src="https://latex.codecogs.com/svg.latex?\Large&space;k=l=\frac{n}{k.l}">, откъдето <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=k^3">. В този случай алгоритъмът ще извършва не повече от <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sqrt[3]{n}"> сравнения. За <img src="https://latex.codecogs.com/svg.latex?\Large&space;n\ge{12}"> се получава, че <img src="https://latex.codecogs.com/svg.latex?\Large&space;3\sqrt[3]{n}<2\sqrt{n}">, т.е. постигнахме подобрение [*Gregory, Rawlins-1997*].

А какво би станало, ако приложим алгоритъма и трети и четвърти и т.н. път? Разсъждения, аналогични на горните, ни водят до граничната *логаритмична сложност*. Въпреки значението на описаното обобщение (постигнахме логаритмична сложност!) ние няма да се спираме повече на него, тъй като съществува по-прост начин за постигане на такава сложност.

*Задачи за упражнение:*

1. Да се докаже, че най-добрата стъпка при квадратично търсене в нареден масив с <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> елемента е <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sqrt{n}">.

<details><summary>ДОКАЗАТЕЛСТВО 1.</summary>
<p>
	
- В най-лошия случай търсеният ключ е в последния интервал, което означава, че ще ни бъдат необходими <img src="https://latex.codecogs.com/svg.latex?\Large&space;[n/k]"> сравнения, за да определим нужния ни интервал, в който да приложим линейното търсене. Към тях следва да прибавим дължината на интервала, която при <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> кратно на <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> (в най-лошия случай, т.е. най-голям (пълен) интервал), е <img src="https://latex.codecogs.com/svg.latex?\Large&space;k-1">. Получаваме, че в най-лошия случай при търсене със стъпка <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> се извършват не повече от <img src="https://latex.codecogs.com/svg.latex?\Large&space;[n/k]+k-1"> сравнения. Нека изследваме тази функция спрямо променливата <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">, която съхранява големината на стъпката. Искаме функцията да приема минимална стойност.
	
<img src="https://latex.codecogs.com/svg.latex?\Large&space;f(k)=[\frac{n}{k}]+k-1,k\in{[1,n]}">.
За да има локални екстремуми в този интервал, първата производна на функцията трябва да е равна на нула. Т.е.
<img src="https://latex.codecogs.com/svg.latex?\Large&space;f'(k)=\big([\frac{n}{k}]+k-1\big)'=-1.[n.k^{-2}]+1=0">, т.е.
<img src="https://latex.codecogs.com/svg.latex?\Large&space;[\frac{n}{k^2}]=1"> или максималното <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">, за което това е изпълнено е <img src="https://latex.codecogs.com/svg.latex?\Large&space;\max{k}=\sqrt{n}">. A от това, че <img src="https://latex.codecogs.com/svg.latex?\Large&space;f''(k)=[2.n.k^{-3}]>0"> следва, че за <img src="https://latex.codecogs.com/svg.latex?\Large&space;k=\sqrt{n}">, функцията която отброява сравненията в най-лошия случай, достига своя минимум.

</p>
</details>

2. Да се реализира двустепенно търсене със стъпки <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;l">. Да се намерят експериментално оптималните стойности на <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;l"> като функции на <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">.

<details><summary>РЕШЕНИЕ 2.</summary>
<p>
	
След като доказахме, че първата стъпка <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> е най-добра при <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sqrt{n}">, то получения интервал, в който отново трябва да приложим квадратичното търсене ще е в най-лошия случай пълен и (*jmpSearch()*) ще е с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sqrt{n}">, откъдето следва че втората стъпка трябва да е с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sqrt[4]{n}">:

```cpp
#include <iostream>
#include <cmath>
int a[] = { 3,4,9,12,13,14,40,44,45,50,60,60,70,80,90,100 };
unsigned n = sizeof(a) / sizeof(a[0]);
unsigned counter = 1; /* променлива, която съхранява броя на извиканите квадратични търсения */
const int seqSearch(unsigned l, unsigned r, int key) /* последователно търсене */
{
	while (l <= r)
		if (a[l++] == key) return l - 1;
	return -1;
}
const int jmpSearch(unsigned l, unsigned r,int key, unsigned step) /* квадратично търсене */
{
	counter++;
	unsigned ind;
	for (ind = 0; ind < n && a[ind] < key; ind += step);
	if (counter==3)	return seqSearch(ind + 1 < step ? 0 : ind + 1 - step, n < ind ? n : ind, key); 
	/* ако е извикано два пъти квадратичното търсене - продължи с последователно търсене със стъпка 
	равна на корен квадратен от дължината на сектора в който търсим, т.е. корен квадратен от корен 
	от n, което е корен 4-ти от дължината на цялата колекцията */
	else return jmpSearch(ind + 1 < step ? 0 : ind + 1 - step, n < ind ? n : 
	ind,key, (unsigned)(pow(n,1.0/(counter+1))));
}
int main()
{
	int el=jmpSearch(0,n-1,40,(unsigned)(pow(n, 1.0 / (counter + 1))));
	(el != -1) ? std::cout << "element found at position: " << el : std::cout << "no such element";

	return 0;
}
```

</p>
</details>

### 3. Двоично търсене

В случай на множество с голям брой елементи и голям брой търсения е удобно използването на *двоино търсене* след предварително сортиране на елементите. Двоиното търсене е добър пример за приложение на римския принцип *разделяй и владей*. Основната идея е сложната задача да се разбие на няколко по-прости, те от своя страна също да се разделят на по-прости и т.н. Процесът продължава до достигане на достатъчно проста задача с тривиално решение.

Как стоят нещата при двоичното търсене? Предполагаме, че имаме сортиран масив. Идеята е масивът да се раздели на два подмасива и да се определи в кой от тях търсеният елемент със сигурност не би могъл да се намира. Въпросният подмасив се изключва от по-нататъшни разглеждания, а по-нататъшните усилия се насочват към по-перспективния. Би могло да се възрази, че двоичното търсене не представлява класически пример на приложение на стратегията *разделяй и владей*, тъй като тя предполага разглеждане и на *двата* подмасива. От горното изложение обаче се вижда, че тя не забранява ранно отрязване на безперспективните подмножества.

Как става разделянето? Нека означим търсения елемент с <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> и предположим, че масивът е сортиран. Да сравним <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> със средния му елемент (при четен брой елементи има два средни елемента и няма значение кой ще изберем). В случай на равенство търсенето приключва успешно. Ако <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> се окаже по-малък от средния елемент, веднага може да определим безперспективния подмасив. Действително, това са елементите вдясно от средата: тъй като масивът е сортиран, те всичките са по-големи от средния, а той пък от своя страна вече се е оказал по-голям от <img src="https://latex.codecogs.com/svg.latex?\Large&space;x">. Аналогично се подхожда в случая, когато <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> се окаже по-голям от средния елемент, като тогава се отхвърля левия подмасив. След това същият процес се прилага към неотхвърления подмасив. На всяка стъпка разделяме перспективния масив на два подмасива с приблизително равен брой елементи. Процесът приключва успешно при намиране на търсения елемент или достигане до празния масив. Не е трдно да се види, че процесът винаги завършва. Действително, на всяка стъпка разглежданият масив намалява поне наполовина. *Поне*, тъй като винаги се отхвърля средният елемент на масива, а това при нечетен брой елементи означава, че се отхвърлят с един елемент повече отколкото остават. Впрочем това, че винаги се отхвърля поне един елемент, а именно средният, е съществено, тъй като някое от двете множества(лявото или дясното) може да се окаже празно. Въпреки това, и в този случай броят на елементите в разглеждания подмасив ще намалее строго (поне с 1).

Следвайки директно горните предписания, получаваме следната очевидна рекурсивна реализация на двоичното търсене (извиква се с *binSearch(ключ_който_търсим,0,n-1)*):

```cpp
#include <iostream>
#include <algorithm>
#define MAX 10
#define DataType char
#define KEY 10
#include <time.h>

struct CPPElem
{
	int key;
	DataType data;
	/* ... */

}m[MAX]; /* Масив от записи */
unsigned n; /* Брой елементи в масива */
void seqInit(void) { n = 0; } /* Инициализиране */
bool wayToSort(CPPElem i, CPPElem j) { return i.key < j.key; } /* критерии за сортиране */
void seqInsert(int key, DataType data)
{
	m[n].key = key;
	m[n].data = data;
	n++;
	std::sort(m, m + n, wayToSort); /* Поддържаме масива сортиран след като добавим елемент */
}

int binSearch(int key, int l, int r) /* Рекурсивно бинарно търсене */
{
	int mid;
	if (l > r) return -1;
	mid = (l + r) / 2;
	if (key < m[mid].key)
	{
		return binSearch(key, l, mid - 1);
	}
	else if (key > m[mid].key)
	{
		return binSearch(key, mid + 1, r);
	}
	else return mid;
}

void seqPrint(void) /*Извежда списъка на екрана*/
{
	unsigned i;
	for (i = 0; i < n; i++) std::cout << "position " << i << " : key " << m[i].key
		<< " data " << m[i].data << std::endl;
}

int main()
{
	srand(unsigned(time(0)));
	char ind;
	for (ind = 'a'; ind < 97 + MAX; ind++) seqInsert(rand() % (MAX * 2), ind);
	std::cout << "the list contains the following items:\n";
	seqPrint();
	int el = binSearch(KEY, 0, MAX);
	(el != -1) ? std::cout << "Element with key: " << KEY << " is found at position " << el
		<< " with data " << m[el].data : std::cout << "No such element with key " 
		<< KEY << " in the array";
	return 0;
}
```
Описаният по-горе процес попринцип е рекурсиве. На практика обаче на вяка стъпка се разглежда *точно едно* от двете подмножества. Вземайки предвид това, не е трудно да реализираме съответно итеративно решение:

```cpp
int binSearch(int key) /* Итеративно бинарно търсене */
{
	int l = 0, r = n - 1, mid;
	while (l<=r)
	{
		mid = (l + r) / 2;
		if (key < m[mid].key) r = mid - 1;
		else if (key > m[mid].key) l = mid + 1;
		else return mid;
	}
	return -1;
}
```
Със съответната *main()* функция за тестване:

```cpp
int main()
{
	srand(unsigned(time(0)));
	char ind;
	for (ind = 'a'; ind < 97 + MAX; ind++) seqInsert(rand() % (MAX * 2), ind);
	std::cout << "the list contains the following items:\n";
	seqPrint();
	int el = binSearch(KEY);
	(el != -1) ? std::cout << "Element with key: " << KEY << " is found at position " << el
		<< " with data " << m[el].data : std::cout << "No such element with key " 
		<< KEY << " in the array";
	return 0;
}
```

Горната функция използва два индекса <img src="https://latex.codecogs.com/svg.latex?\Large&space;l"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;r">, указващи съответно лявата и дясната граница на разглежданата област. Разделянето на всяка стъпка става по средата *mid* на областта. Функцията връща позицията, на която се намира елементът с ключ *value* или -1, в случай на неуспех. Тъй като на всяка стъпка на алгоритъма разглежданият подмасив намалява поне наполовина, то горният алгоритъм извършва не повече от <img src="https://latex.codecogs.com/svg.latex?\Large&space;\lceil\log_2{n}\rceil+1"> сравнения. Това е горната граница както за успешно, така и за неуспешно търсене [*Уирт-1980*].

Да се опитаме да подобрим горния вариант на програмата. Очевидно основната идея на двоичното търсене „заковава“ горната граница на <img src="https://latex.codecogs.com/svg.latex?\Large&space;\lceil\log_2{n}\rceil+1"> сравнения. Въпреки това, място за подобрения има. Ще започнем с проста модификация на предложената програмна реализация и по-специално на начина на задаване на границите на разглежданата област. По-горе това ставаше с помощта на двойката индекси <img src="https://latex.codecogs.com/svg.latex?\Large&space;l"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;r">, указващи съответно левия и десния ѝ край. Сега ще преминем към ново представяне, при което ще използваме <img src="https://latex.codecogs.com/svg.latex?\Large&space;offset=r-1"> вместо <img src="https://latex.codecogs.com/svg.latex?\Large&space;r">. Ще искаме още <img src="https://latex.codecogs.com/svg.latex?\Large&space;offset"> винаги да бъде степен на двойката. В случай, че размерът на първоначалната област е степен на двойката, това свойство очевидно ще се поддържа от само себе си без допълнителни усилия от наша страна. В противен случай ще се наложи да си го осигуряваме. Най-простия начин за справяне с проблема е на първата стъпка да разделим масива на две области, които непременно да имат размер, степен на двойката. Това не е трудно да се извърши, макар че ще доведе до пресичане на областите от първата стъпка. Така например, ако размерът на масива е 1000, едно добро решение е на първа стъпка да го разделим на следните области: **(1, 2,...,512)** и **(489, 490 ,..., 1000)**.

Двете области имат еднакъв размер, а именно 512, което е максималната степен на 2, ненадвишаваща размера на масива <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=1000">. Елементите 489, 490,...,512 принадлежат и на двете области. За сметка на това обаче на всяка следваща стъпка размерът ще става тепен на двойката, при което общата ефективност на алгоритъма се очаква да се подобри. Тук тежката операция деление е заменена с поразредно изместване надясно, което води до допълнително подобрение. (Всъщност, това е малко спорно при днешните процесори.)

```cpp
unsigned getMaxPower2(unsigned k)
{
	unsigned pow2;
	for (pow2 = 1; pow2 <= k; pow2 <<= 1);
	return pow2 >> 1;
}

int binSearch(int key)
{
	unsigned i, l, ind;
	i = getMaxPower2(n);
	l = m[i].key >= key ? 0 : n - i + 1;
	while (i > 0)
	{
		i = i >> 1;
		ind = l + i;
		if (m[ind].key == key) return ind;
		else if (m[ind].key < key) l = ind;
	}
	return -1;
}
```
Бихме могли да се освободим от едното сравнение във вътрешността на цикъла. За сметка на това обаче вече няма да можем да прекратяваме преждевременно работата на алгоритъма при откриване на търсения елемент преди последната стъпка. Така промяната се оказва в известен смисъл спорна: 

```cpp
int binSearch(int key)
{
	unsigned i, l;
	i = getMaxPower2(n);
	l = m[i].key >= key ? 0 : n - i + 1;
	while (i > 0)
	{
		i = i >> 1;
		if (m[l + i].key < key) return l += i;
	}
	return (l < MAX && m[++l].key == key ? l : -1);
}
```
Нека разгледаме по-внимателно идеята на алгоритъма. Не е трудно да забележим, че, който и от горните варианта да вземем, все едно за всяка стойност на размера <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> на областта, редът на последователните сравнения за всяка стъпка е предварително определен. Тогава бихме могли да ги разпишем изрично, премахвайки необходимостта от деление и от цикъл въобще. Получената програма се оказва изключително ефективна Бентли съобщава за наблюдавано подобрение от около 4,5 пъти спрямо първоначалния класически вариант [*Bentley-1986*]. Разбира се, следва да се отбележи очевидното ограничение, че за разписването на цикъла в последователни условни конструкции, е необходимо размерът на областта да бъде поне приблизително известен. Освен това външният вид на програмата е способен да убие всеки ентусиазъм:

```cpp
int binSearch(int key)
{
	unsigned l = 0;
	if (m[16].key < key)l = 20 - 16 + 1;
	if (m[l + 8].key < key)l += 8;
	if (m[l + 4].key < key)l += 4;
	if (m[l + 2].key < key)l += 2;
	if (m[l + 1].key < key)l += 1;
	return (l < 20 && m[++l].key == key ? l : -1);
}
```
Макар двоичното търсене да е изключително ефективно, то следва да се използва предпазливо. Основният му недостатък е, че непременно изисква пряк достъп до елементите на множеството, което ни ограничава до използването на масив и не ползволява никакви динамични структури. Изискването за наредба на елементите на множеството пък от своя страна създава още по-големи проблеми пред вмъкването. Действително, ако вмъкваме новите елементи в края на масива, ще трябва да го сортираме преди всяко търсене, следващо вмъкване, което очевидно е крайно неразумно. Налага се вмъкване, при което масивът да остане сортиран. Тази операция е много неефективна, особено при по-малка стойност на ключа на вмъквания <img src="https://latex.codecogs.com/svg.latex?\Large&space;n+1">-ви елемент, тъй като това води до изместване на всички по-големи от него елементи с една позиция надясно. Това изисква изместване средно <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{n}{2}">, а в най-лошия случай - на <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> елемента (<img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> е броя на елементите *преди* вмъкването).

По-горе считахме изрично, че множеството не допуска повтаряне на ключове. Не е трудно обаче да се забележи, че дори и да допуснем повтаряне, двоичното търсене отново ще работи. Действително, то отново юе намира точно един елемент, в случай че такъв изобщо съществува. Сега остава да се съобрази, че масивът е сортиран. Тогава останалите елементи с този ключ следва да се намират в едната или в двете посоки, непосредствено до намерения елемент. Същата идея може да се използва за решаване на по-общата задача за намиране на всички елементи, попадащи в даден интервал.

Проблеми, свързани с необходимостта от преместване на голям брой елементи, възникват и при изтриването. Всъщност, при изтриването на малък брой елементи, е разумно те просто да се *маркират* като изтрити, без преместване. При търсене те следва да се прескачат по подходящ начин. Най-добре е ключовете им все пак да се използват при търсенето, и, едва в случай на успешно завършване, да се проверява дали намереният елемент не е изтрит. След това да се извършва евентуално търсене сред съседните му елементи в двете посоки.
