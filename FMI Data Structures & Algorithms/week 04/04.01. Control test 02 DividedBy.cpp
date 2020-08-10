// github.com/andy489

// https://www.hackerrank.com/contests/sda-test2/challenges/--82/problem

#include <vector>
#include <iostream>

using namespace std;

struct Node {
    Node *next;
    int data;

    Node(Node *_next, int _data) {
        next = _next;
        data = _data;
    }
};

class LinkedList {
public:
    LinkedList() {
        head = nullptr;
    }

    ~LinkedList() {
        Node *tmp;
        while (head != nullptr) {
            tmp = head;
            head = head->next;
            delete tmp;
        }
    }

    void add(int number) {
        Node *tmp = new Node(head, number);
        head = tmp;
    }

    void print() {
        Node *curr = head;
        while (curr != nullptr) {
            cout << curr->data << " ";
            curr = curr->next;
        }
    }

    void removeComplex(int dividedBy) { //  TODO: write your code here
        Node *temp = head, *prev;
        while (temp != nullptr && temp->data % dividedBy == 0) {
            head = temp->next;
            delete temp;
            temp = head;
        }
        while (temp != nullptr) {
            while (temp != nullptr && temp->data % dividedBy != 0) {
                prev = temp;
                temp = temp->next;
            }

            if (temp == nullptr) return;

            prev->next = temp->next;
            delete temp;
            temp = prev->next;
        }
    }


private:
    Node *head;
};

int main() {
    LinkedList l;

    int n;
    cin >> n;
    int number;
    for (int i = 0; i < n; i++) {
        cin >> number;
        l.add(number);
    }
    int dividedBy;
    cin >> dividedBy;
    l.removeComplex(dividedBy);
    l.print();
}
