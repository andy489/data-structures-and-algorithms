// https://www.hackerrank.com/contests/si-practice-4/challenges/2-52/problem

#include <iostream>

using namespace std;

struct Node {
    Node *prev;
    Node *next;

    int data;

    explicit Node(int data, Node *prev = nullptr, Node *next = nullptr) : data(data), prev(prev), next(next) {}
};

struct DoublyLinkedList {
    Node *head, *mid, *tail;
    size_t size;

    DoublyLinkedList() {
        head = nullptr;
        mid = nullptr;
        tail = nullptr;
        size = 0;
    }

    void add(int x) {
        Node *newNode = new Node(x, tail);
        size++;
        if (tail) { //list is not empty
            tail->next = newNode;
            tail = newNode;
            if ((size & 1) == 0) { //size is even
                mid = mid->next; //fix mid
            }
        } else {
            head = mid = tail = newNode;
        }
    }

    void gun() {
        if (tail) {
            Node *temp = tail;
            tail = tail->prev;
            delete[] temp;
            size--;

            if (tail) { //still not empty
                tail->next = nullptr;

                if (size & 1) { //size is odd
                    mid = mid->prev; //fix mid
                }
            } else { //tail = nullptr
                head = nullptr, mid = nullptr;
            }
        }
    }

    void milen() {
        if (size > 1) {
            Node *oldHead(head), *oldMid(mid), *oldTail(tail);

            tail->next = head;
            head->prev = tail;

            head = oldMid;
            tail = oldMid->prev;
            if ((size & 1) == 0) {
                mid = oldHead;
            } else {
                mid = oldTail;
            }

            tail->next = nullptr;
            head->prev = nullptr;
        }
    }

    friend ostream &operator<<(ostream &os, const DoublyLinkedList &dll) {
        Node *traversal = dll.head;

        if (traversal == nullptr) {
            // os << "list is empty\n";
            return os;
        }

        while (traversal) {
            os << traversal->data << ' ';
            traversal = traversal->next;
        }

        os << endl;
        return os;
    }
};

void help() {
    cout << "Functionality:"
         << endl << "A - add"
         << endl << "G - gun"
         << endl << "M - milen"
         << endl << "Enter number of operations: ";
}

int main() {
    // help();

    int n, k(0);
    cin >> n;

    DoublyLinkedList dll;

    int data;
    char input[8];

    while (k < n) {
        cin >> input;
        if (tolower(input[0]) == 'a') {
            cin >> data;
            dll.add(data);
        } else if (tolower(input[0]) == 'g') {
            dll.gun();
        } else {
            dll.milen();
        }

        ++k;
    }

    cout << dll.size << endl << dll;

    return 0;
}



