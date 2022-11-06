// https://www.hackerrank.com/contests/sdatest3/challenges/test3-zad1

#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

struct Node {
    int value;
    Node *next;

    explicit Node(int value = 0, Node *next = nullptr) : value(value), next(next) {};
};

class LinkedList {
    Node *head, *tail;
    int size;
public:
    LinkedList() : head(nullptr), tail(nullptr), size(0) {};

    void add_ad_head(int val) {
        Node *new_node = new Node(val);

        if (head == nullptr) {
            head = tail = new_node;
        } else {
            new_node->next = head;
            head = new_node;
        }

        ++size;
    }

    void add_at_tail(int val) {
        Node *new_node = new Node(val);

        if (head == nullptr) {
            head = tail = new_node;
        } else {
            tail->next = new_node;
            tail = new_node;
        }

        ++size;
    }

    void add(int val, int pos) {
        if (pos < 0) {
            add_at_tail(val);
            cout << "add_last";
        } else if (pos == 0) {
            add_ad_head(val);
        } else if (pos > size) {
            add_at_tail(val);
            cout << "add_last";
        } else {
            Node *new_nod = new Node(val);
            Node *traversal_node = head;

            for (int i = 1; i < pos; i++) {
                traversal_node = traversal_node->next;
            } // traversal_node points to (pos-1)th Node

            Node *temp = traversal_node->next; // pos-th Node  :  traversal_node - new_nod - temp
            traversal_node->next = new_nod;
            new_nod->next = temp;

            ++size;
        }
    }

    void print() {
        Node *traversal_node = head;

        while (traversal_node != nullptr) {
            cout << traversal_node->value << '#';
            traversal_node = traversal_node->next;
        }
    }

    void remove(int pos) {
        if (pos < 0 || pos >= (int) size) {
            cout << "remove_failed";
        } else if (pos == 0) {
            Node *temp = head->next;
            delete head;
            head = temp;

            --size;
        } else {
            Node *traversal_node = head;

            for (int i = 0; i < pos - 1; ++i) {
                traversal_node = traversal_node->next;
            }

            // traverseNode points to (pos-1)th Node
            Node *temp = traversal_node->next; // pos-th Node (node we want to remove)
            traversal_node->next = temp->next; // (pos+1)th Node

            if (temp->next == nullptr) {
                tail = traversal_node;
            }

            delete temp;

            --size;
        }
    }

    void reverse() {
        Node *traversal_node = head;
        Node *prev = nullptr;

        while (traversal_node != nullptr) {
            Node *next = traversal_node->next;
            traversal_node->next = prev;
            prev = traversal_node;
            traversal_node = next;
        }

        head = prev;
    }

    void remove_all(int val) {
        Node *traversal_node = head;
        Node *prev = nullptr;

        while (traversal_node != nullptr && traversal_node->value == val) {
            head = traversal_node->next;
            delete traversal_node;
            --size;
            traversal_node = head;
        }
        // if we are here we know that either the list is empty or it doesn't start with val
        while (traversal_node != nullptr) {    // looks like O(n*n) but it's only O(n)
            while (traversal_node != nullptr && traversal_node->value != val) {
                prev = traversal_node;
                traversal_node = traversal_node->next;
            }

            if (traversal_node == nullptr) {
                return;
            }

            prev->next = traversal_node->next;

            delete traversal_node;

            traversal_node = prev->next;
        }
    }

    void group(int a, int b) {
        if (a < 0 || b < 0 || a >= size || b >= size || a > b) {
            cout << "fail_grouping";
            return;
        }

        if (a == b) {
            return;
        }

        if (a == 0 && b == 1) {
            Node *new_node = new Node(head->value);
            if (size > 1) {
                new_node->value += head->next->value;

                Node *attach_to = head->next->next;
                new_node->next = attach_to;
                
                delete head->next;
                delete head;
                
                head = new_node;
                --size;
                
                return;
            } else {
                cout << "fail_grouping";
                return;
            }
        }

        Node *traversal_node = head;

        for (int i = 0; i < a - 1; ++i) {
            traversal_node = traversal_node->next;
        } // traversal_node now points to the element before begin of grouping

        Node *begin = traversal_node; // we memorize from where we start to group
        // we will need that information to connect the linked list after the removals

        if (a != 0) { // but if there is no element before begin (i.e. we start from 0)
            traversal_node = traversal_node->next; // then don't do this step
        }

        int sum = 0;

        for (int i = 0; i < b - a + 1; ++i) {
            Node *temp = traversal_node;
            sum += traversal_node->value;
            traversal_node = traversal_node->next;

            delete temp;
        }

        Node *new_grouped_node = new Node(sum);

        if (traversal_node == nullptr) {
            tail = traversal_node;
        }

        if (a == 0) {
            head = new_grouped_node;
        }

        new_grouped_node->next = traversal_node;
        begin->next = new_grouped_node;
        size -= b - a;
    }

    void count(int val) {
        int cnt = 0;

        Node *traversal_node = head;

        while (traversal_node != nullptr) {
            if (traversal_node->value == val) {
                ++cnt;
            }
            traversal_node = traversal_node->next;
        }

        cout << cnt;
    }
    
    void is_palindrome() {
        if (size <= 1) {
            cout << "true";
            return;
        } else {
            LinkedList S;
            Node *traversal_node = head;

            for (int i = 0; i < size / 2; ++i) {
                S.add_ad_head(traversal_node->value);
                traversal_node = traversal_node->next;
            }
            
            if (size & 1) {
                // if there are odd number of nodes we traversal_node one more time before we start to compare
                traversal_node = traversal_node->next;
            }
            
            while (S.size != 0) {
                if (traversal_node->value == S.head->value) {
                    traversal_node = traversal_node->next;
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
        Node *traversal_node = ll.head;
        
        while (traversal_node != nullptr) {
            os << traversal_node->value << '#';
            traversal_node = traversal_node->next;
        }
        
        return os;
    }

    ~LinkedList() {
        Node *traversal_node = head;
        Node *next;

        while (traversal_node != nullptr) {
            next = traversal_node->next;
            delete traversal_node;
            traversal_node = next;
        }

        head = nullptr;
    }
};

int main() {
    int test_cases;
    cin >> test_cases;
    
    while (test_cases--) {
        LinkedList ll;
        int ops;

        string op;
        cin >> ops;

        for (int j = 0; j < ops; j++) {
            cin >> op;

            if (op == "add") {
                int arg1, arg2;
                cin >> arg1 >> arg2;
                ll.add(arg1, arg2);
                continue;
            }

            if (op == "count") {
                int arg1;
                cin >> arg1;
                ll.count(arg1);
                continue;
            }

            if (op == "print") {
                ll.print();
                continue;
            }

            if (op == "remove") {
                int arg1;
                cin >> arg1;
                ll.remove(arg1);
                continue;
            }

            if (op == "reverse") {
                ll.reverse();
                continue;

            }

            if (op == "remove_all") {
                int arg1;
                cin >> arg1;
                ll.remove_all(arg1);
                continue;

            }

            if (op == "group") {
                int arg1, arg2;
                cin >> arg1 >> arg2;
                ll.group(arg1, arg2);
                continue;

            }

            if (op == "is_palindrom") {
                ll.is_palindrome();
                continue;
            }
        }
        cout << endl;
    }

    return 0;
}

/*
1
17
add 1 0
add 2 0
add 3 0
add 4 0
add 5 0
add 6 0
add 7 0
add 8 0
add 9 0
add 10 0
print
group 0 1
print
group 0 1
print
group 0 1
print
*/
