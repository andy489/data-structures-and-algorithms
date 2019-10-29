## Singly Linked List.

[Link to online judge system](https://www.hackerrank.com/contests/sdatest3/challenges/test3-zad1)

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


##Solution
```cpp
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

struct Node {
	int value;
	Node* next;
	Node(int value = 0, Node* next = nullptr) :value(value), next(next) {};
};

class LinkedList {
	Node* head, * tail;
	int size;
public:
	LinkedList() :head(nullptr), tail(nullptr), size(0) {};

	void addAtHead(int val) {
		Node* newNode = new Node(val);
		if (head == nullptr) {
			head = tail = newNode;
		}
		else {
			Node* temp = head;
			newNode->next = temp;
			head = newNode;
		}
		size++;
	}

	void addAtTail(int val) {
		Node* newNode = new Node(val);
		if (head == nullptr) {
			head = tail = newNode;
		}
		else {
			tail->next = newNode;
			tail = newNode;
		}
		size++;
	}

	void add(int val, int pos) {
		if (pos < 0) {
			addAtTail(val);
			std::cout << "add_last";
		}
		else if (pos == 0) addAtHead(val);
		/*else if (pos == size){
			addAtTail(X);
		}*/
		else if (pos > (int)size) {
			addAtTail(val);
			std::cout << "add_last";
		}
		else {
			Node* newNode = new Node(val);
			Node* traverse = head;
			for (int i = 1; i < pos; i++) {
				traverse = traverse->next;
			} // traverse points to (pos-1)th Node		
			Node* temp = traverse->next; // pos-th Node  :  traverse - newNode - temp
			traverse->next = newNode;
			newNode->next = temp;
			size++;
		}
	}

	void print()
	{
		Node* traverse = head;
		while (traverse != nullptr) {
			cout << traverse->value << '#';
			traverse = traverse->next;
		}	//cout << '\n';		
	}

	void remove(int pos) {
		if (pos < 0 || pos >= (int)size)
		{
			std::cout << "remove_failed";
		}
		else if (pos == 0)
		{
			Node* temp = head->next;
			delete head;
			head = temp;
			size--;
		}
		else
		{
			Node* traverse = head;
			for (int i = 0; i < pos - 1; i++)
			{
				traverse = traverse->next;
			} // traverseNode points to (pos-1)th Node
			Node* temp = traverse->next; // pos-th Node (node we want to remove)
			traverse->next = temp->next; // (pos+1)th Node
			if (temp->next == nullptr)
			{
				tail = traverse;
			}
			delete temp; // remove temp;
			size--;
		}
	}

	void reverse() {
		Node* traverse = head;
		Node* prev = nullptr;
		while (traverse != nullptr)
		{
			Node* next = traverse->next;
			traverse->next = prev;
			prev = traverse;
			traverse = next;
		}
		head = prev;
	}

	void remove_all(int val) {
		Node* traverse = head;
		Node* prev = nullptr;
		while (traverse != nullptr && traverse->value == val)
		{
			head = traverse->next;
			delete traverse;
			size--;
			traverse = head;
		}
		// if we are here we know that either the list is empty or it doesn't start with val
		while (traverse != nullptr)
		{	// looks like O(n*n) but it's only O(n)	
			while (traverse != nullptr && traverse->value != val)
			{
				prev = traverse;
				traverse = traverse->next;
			}

			if (traverse == nullptr) return;
			prev->next = traverse->next;

			delete traverse;
			traverse = prev->next;
		}
	}

	void group(int a, int b) {
		if (a < 0 || b<0 || a >= (int)size || b >= (int)size || a>b)
		{
			std::cout << "fail_grouping";
			return;
		}
		if (a == b)
		{
			return;
		}
		Node* traverse = head;
		for (int i = 0; i < a - 1; i++)
		{
			traverse = traverse->next;
		} // traverse now points to the element before begin of grouping
		Node* begin = traverse; // we memorize from where we start to group 
		// we will need that information to connect the linked list after the removals
		if (a != 0)
		{	// but if there is no element before begin (i.e. we start from 0)
			traverse = traverse->next; // then don't do this step
		}
		int sum(0);
		for (int i = 0; i < b - a + 1; i++)
		{
			Node* temp = traverse;
			sum += traverse->value;
			traverse = traverse->next;
			delete temp;
		}
		Node* newGroupedNode = new Node(sum);
		if (traverse == nullptr)
		{
			tail = traverse;
		}
		if (a == 0)
		{
			head = newGroupedNode;
		}
		newGroupedNode->next = traverse;
		begin->next = newGroupedNode;
		size -= b - a;
	}

	void count(int val) {
		size_t counter(0);
		Node* traverse = head;
		while (traverse != nullptr)
		{
			if (traverse->value == val)
			{
				counter++;
			}
			traverse = traverse->next;
		}
		cout<< counter;
	}


	void is_palindrome() {
		if (size <= 1)
		{
			cout << "true";
			return;
		}
		else
		{
			LinkedList S;
			Node* traverse = head;
			for (int i = 0; i < size / 2; i++)
			{
				S.addAtHead(traverse->value);
				traverse = traverse->next;
			}
			if (size & 1)
			{	// If there are odd number of nodes we traverse one more time before we start to compare
				traverse = traverse->next;
			}
			while (S.size != 0)
			{
				if (traverse->value == S.head->value)
				{
					traverse = traverse->next;
					S.remove(0);
				}
				else
				{
					cout << "false";
					return;
				}

			}
		}
		cout << "true";
	}

	friend ostream& operator<<(ostream& os, const LinkedList& ll) {
		Node* traverse = ll.head;
		while (traverse != nullptr) {
			os << traverse->value << '#';
			traverse = traverse->next;
		}	//os << '\n';
		return os;
	}

	~LinkedList() {
		Node* traverse = head;
		Node* next;

		while (traverse != nullptr) {
			next = traverse->next;
			delete traverse;
			traverse = next;
		}
	}
};

int main() {
	int cases;
	std::cin >> cases;
	for (int i = 0; i < cases; i++) {
		LinkedList ll;
		int ops;
		std::string op;
		std::cin >> ops;
		for (int j = 0; j < ops; j++) {
			std::cin >> op;

			if (op == "count") {
				int arg1;
				std::cin >> arg1;
				ll.count(arg1);
			}

			if (op == "add") {
				int arg1, arg2;
				std::cin >> arg1 >> arg2;
				ll.add(arg1, arg2);
			}

			if (op == "print") {
				ll.print();
			}

			if (op == "remove") {
				int arg1;
				std::cin >> arg1;
				ll.remove(arg1);
			}

			if (op == "reverse") {
				ll.reverse();
			}

			if (op == "remove_all") {
				int arg1;
				std::cin >> arg1;
				ll.remove_all(arg1);
			}

			if (op == "group") {
				int arg1, arg2;
				std::cin >> arg1 >> arg2;
				ll.group(arg1, arg2);
			}

			if (op == "is_palindrom") {
				ll.is_palindrome();
			}
		}

		std::cout << std::endl;

	}
	return 0;
}
```
