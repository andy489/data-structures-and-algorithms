// github.com/andy489

// https://www.hackerrank.com/contests/sdatest3/challenges/test3-zad1

#include <cmath>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

struct Node {
    int value;
    Node *next;

    Node(int value = 0, Node *next = nullptr) : value(value), next(next) {};
};

class LinkedList {
    Node *head, *tail;
    int size;
public:
    LinkedList() : head(nullptr), tail(nullptr), size(0) {};

    void addAtHead(int val) {
        Node *newNode = new Node(val);
        if (head == nullptr)
            head = tail = newNode;
        else {
            Node *temp = head;
            newNode->next = temp;
            head = newNode;
        }
        size++;
    }

    void addAtTail(int val) {
        Node *newNode = new Node(val);
        if (head == nullptr)
            head = tail = newNode;
        else {
            tail->next = newNode;
            tail = newNode;
        }
        size++;
    }

    void add(int val, int pos) {
        if (pos < 0) {
            addAtTail(val);
            cout << "add_last";
        } else if (pos == 0) addAtHead(val);
        else if (pos > (int) size) {
            addAtTail(val);
            cout << "add_last";
        } else {
            Node *newNode = new Node(val);
            Node *traverse = head;
            for (int i = 1; i < pos; i++) {
                traverse = traverse->next;
            } // traverse points to (pos-1)th Node
            Node *temp = traverse->next; // pos-th Node  :  traverse - newNode - temp
            traverse->next = newNode;
            newNode->next = temp;
            size++;
        }
    }

    void print() {
        Node *traverse = head;
        while (traverse != nullptr) {
            cout << traverse->value << '#';
            traverse = traverse->next;
        }
    }

    void remove(int pos) {
        if (pos < 0 || pos >= (int) size)
            cout << "remove_failed";
        else if (pos == 0) {
            Node *temp = head->next;
            delete head;
            head = temp;
            size--;
        } else {
            Node *traverse = head;
            int i(0);
            for (; i < pos - 1; ++i)
                traverse = traverse->next;
            // traverseNode points to (pos-1)th Node
            Node *temp = traverse->next; // pos-th Node (node we want to remove)
            traverse->next = temp->next; // (pos+1)th Node
            if (temp->next == nullptr)
                tail = traverse;
            delete temp; // remove temp;
            size--;
        }
    }

    void reverse() {
        Node *traverse = head;
        Node *prev = nullptr;
        while (traverse != nullptr) {
            Node *next = traverse->next;
            traverse->next = prev;
            prev = traverse;
            traverse = next;
        }
        head = prev;
    }

    void remove_all(int val) {
        Node *traverse = head;
        Node *prev = nullptr;
        while (traverse != nullptr && traverse->value == val) {
            head = traverse->next;
            delete traverse;
            size--;
            traverse = head;
        }
        // if we are here we know that either the list is empty or it doesn't start with val
        while (traverse != nullptr) {    // looks like O(n*n) but it's only O(n)
            while (traverse != nullptr && traverse->value != val) {
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
        if (a < 0 || b < 0 || a >= (int) size || b >= (int) size || a > b) {
            cout << "fail_grouping";
            return;
        }
        if (a == b)
            return;
        Node *traverse = head;
        for (int i = 0; i < a - 1; i++) {
            traverse = traverse->next;
        } // traverse now points to the element before begin of grouping
        Node *begin = traverse; // we memorize from where we start to group
        // we will need that information to connect the linked list after the removals
        if (a != 0) // but if there is no element before begin (i.e. we start from 0)
            traverse = traverse->next; // then don't do this step
        int sum(0), i(0);
        for (; i < b - a + 1; ++i) {
            Node *temp = traverse;
            sum += traverse->value;
            traverse = traverse->next;
            delete temp;
        }
        Node *newGroupedNode = new Node(sum);
        if (traverse == nullptr)
            tail = traverse;
        if (a == 0)
            head = newGroupedNode;
        newGroupedNode->next = traverse;
        begin->next = newGroupedNode;
        size -= b - a;
    }

    void count(int val) {
        size_t counter(0);
        Node *traverse = head;
        while (traverse != nullptr) {
            if (traverse->value == val)
                counter++;
            traverse = traverse->next;
        }
        cout << counter;
    }


    void is_palindrome() {
        if (size <= 1) {
            cout << "true";
            return;
        } else {
            LinkedList S;
            Node *traverse = head;
            int i(0);
            for (; i < size / 2; ++i) {
                S.addAtHead(traverse->value);
                traverse = traverse->next;
            }
            if (size & 1) // If there are odd number of nodes we traverse one more time before we start to compare
                traverse = traverse->next;
            while (S.size != 0) {
                if (traverse->value == S.head->value) {
                    traverse = traverse->next;
                    S.remove(0);
                } else {
                    cout << "false";
                    return;
                }

            }
        }
        cout << "true";
    }

    friend ostream &operator<<(ostream &os, const LinkedList &ll) {
        Node *traverse = ll.head;
        while (traverse != nullptr) {
            os << traverse->value << '#';
            traverse = traverse->next;
        }
        return os;
    }

    ~LinkedList() {
        Node *traverse = head;
        Node *next;

        while (traverse != nullptr) {
            next = traverse->next;
            delete traverse;
            traverse = next;
        }
    }
};

int main() {
    int cases;
    cin >> cases;
    while (cases--) {
        LinkedList ll;
        int ops, j(0);
        string op;
        cin >> ops;
        for (; j < ops; j++) {
            cin >> op;

            if (op == "count") {
                int arg1;
                cin >> arg1;
                ll.count(arg1);
            }

            if (op == "add") {
                int arg1, arg2;
                cin >> arg1 >> arg2;
                ll.add(arg1, arg2);
            }

            if (op == "print")
                ll.print();

            if (op == "remove") {
                int arg1;
                cin >> arg1;
                ll.remove(arg1);
            }

            if (op == "reverse")
                ll.reverse();

            if (op == "remove_all") {
                int arg1;
                cin >> arg1;
                ll.remove_all(arg1);
            }

            if (op == "group") {
                int arg1, arg2;
                cin >> arg1 >> arg2;
                ll.group(arg1, arg2);
            }

            if (op == "is_palindrom")
                ll.is_palindrome();
        }
        cout << endl;
    }
    return 0;
}
