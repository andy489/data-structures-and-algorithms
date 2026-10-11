// https://www.hackerrank.com/contests/si-practice-4/challenges/challenge-1648

#include <iostream>
#include <string>

using namespace std;

struct Node {
    Node *next;
    string text;

    explicit Node(Node *next = nullptr) : next(next) {}
};

struct List {
    Node *head, *cursor, *tail;

    List() {
        head = new Node();
        cursor = head;
        tail = head;
    }

    void add_front() {
        if (head && head->text.length() != 0) {
            Node *newNode = new Node(head);
            head = newNode;
        }
    }

    void go_to_head() {
        cursor = head;
    }

    void go_to_tail() {
        cursor = tail;
    }

    void write(char c) const {
        cursor->text += c;
    }

    void parse(char c) {
        if (c == ']') {
            go_to_tail();
        } else if (c == '[') {
            add_front(), go_to_head();
        } else {
            write(c);
        }
    }

    friend ostream &operator<<(ostream &os, const List &list) {
        Node *traversal = list.head;

        while (traversal) {
            os << traversal->text;
            traversal = traversal->next;
        }

        os << endl;

        return os;
    }
};

int main() {
    int q;
    cin >> q;
    List *lists = new List[q];

    char input;
    cin >> input;

    if (q > 0) {
        lists[0].parse(input);
    }

    for (int i = 0; i < q; ++i) {
        while (cin.get(input) && input != '\n') {
            lists[i].parse(input);
        }
    }

    for (int i = 0; i < q; ++i) {
        cout << lists[i];
    }

    return 0;
}


