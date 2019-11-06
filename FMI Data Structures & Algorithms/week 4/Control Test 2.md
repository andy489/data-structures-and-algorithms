
## Списък - специфично изтриване
[Judge system for task](https://www.hackerrank.com/contests/sda-test2/challenges/--82/problem)

Напишете функция за свързан списък, която изтрива всички елементи от списъка които се делят без остатък на подадено число.

void removeComplex(int devidedBy)

Пример: От списък с числа: 1,4,5,6,7,8,5,5,6,7,6 след извикване на *removeComplex(2)*, списъка остава с елементите 1,5,7,5,5,7

Използвайте вече написаният код.

#### Input Format

От стандартният вход ще се подаде n - броя на елементите в списъка, след това последователно ще се подадат n елемента и накрая ще се подаде числото, което ни трябва за removeComplex.

#### Constraints

Масива ще има до 1 милион елемента

#### Output Format

При правилно реализиране на фукцията removeComplex, програмата трябва да изведе на стандартният изход списък с премахнати елементи които се делят на числото.

Sample Input|Expected Output
-|-
10<br>1 2 3 4 5 5 4 6 7 3<br>2|3 7 5 5 3 1 

## Given code
```cpp
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


struct Node {
    Node * next;
    int data;
    Node(Node* _next,int _data){
        next = _next;
        data = _data;
    }
};
class LinkedList{
    public:
    LinkedList(){
        head = NULL;
    }
    ~LinkedList(){
        Node* tmp;
        while(head!=NULL){
            tmp = head;
            head = head->next;
            delete tmp;
        }
    }
    void add(int number){
        Node *tmp = new Node(head,number);
        head = tmp;
    }
    void print(){
        Node* curr = head;
        while(curr!=NULL){
            cout << curr->data << " ";
            curr = curr->next;
        }
    }
    void removeComplex(int devidedBy){
        //  TODO: write your code here  
      
      
    } // end removeComplex
    private:
    Node* head;
};
int main(){
    LinkedList l;

    int n;
    cin >> n;
    int number;
    for(int i = 0 ; i < n ; i++){
        cin >>number;
        l.add(number);
    }
    int devidedBy;
    cin >> devidedBy;
    l.removeComplex(devidedBy);
    l.print();
}
```
