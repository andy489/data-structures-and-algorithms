/*
 * My Doubly Linked List (OOP)
 * Functionality:
 * get_new_node - utility
 *
 * add_at_head
 * add_at_tail
 * add_at_position (user friendly)
 * erase_at_head
 * erase_at_tail
 * erase_at_position (user friendly)
 * display_dll
 * operator << for display
*/

#include <iostream>
#include <string>
#include <utility>

using namespace std;

struct Node {
    Node *prev;
    Node *next;

    string color;

    int number;

    Node(string color, int number, Node *prev = nullptr, Node *next = nullptr) {
        this->color = move(color);
        this->number = number;
        this->prev = prev;
        this->next = next;
    }
};

struct Doubly_Linked_List {
    Node *head;
    Node *tail;

    int size = 0;

    Doubly_Linked_List() {
        head = tail = nullptr;
    }

    static Node *get_new_node(string color, int number, Node *prev = nullptr, Node *next = nullptr) {
        Node *new_node = new Node(color, number);

        new_node->prev = prev;
        new_node->next = next;

        return new_node;
    }

    void add_at_head(string color, int number) {

        Node *new_node = get_new_node(move(color), number);

        ++size;

        if (head == nullptr) {
            head = tail = new_node;
        } else {
            Node *temp = head;

            new_node->next = temp;
            head = new_node;

            temp->prev = head;
        }
    }

    void add_at_tail(string color, int number) {
        Node *new_node = get_new_node(move(color), number);

        ++size;

        if (head == nullptr) {
            head = tail = new_node;
        } else {
            Node *temp = tail;
            tail = new_node;

            new_node->prev = temp;
            temp->next = tail;
            tail = temp->next;
        }
    }

    void add_at_position(const string &color, int number, int pos) {
        if (pos <= 1) {
            add_at_head(color, number);
        } else if (pos > size) {
            add_at_tail(color, number);
        } else {
            Node *traverse = head;
            for (int i = 1; i < pos - 1; ++i) {
                traverse = traverse->next;
            } // traverse points to (pos-1)-th Node

            Node *temp = traverse->next; // pos-th Node   :   traverse - new_node - temp

            Node *new_node = get_new_node(color, number, traverse, temp);

            traverse->next = new_node;
            temp->prev = new_node;

            ++size;
        }
    }

    bool erase_at_head() {
        if (head == nullptr) {
            cout << "cannot perform erase - list is empty" << endl;
            return false;
        } else if (head->next == nullptr) {
            delete head;

            head = tail = nullptr;
            --size;

            return true;
        } else {
            head = head->next;

            delete head->prev;

            head->prev = nullptr;

            --size;

            return true;
        }
    }

    bool erase_at_tail() {
        if (head == nullptr) {
            cout << "cannot perform erase - list is empty" << endl;
            return false;
        } else if (head->next == nullptr) {
            delete head;
            head = tail = nullptr;

            --size;

            return true;
        } else {
            tail = tail->prev;
            delete tail->next;

            tail->next = nullptr;

            --size;

            return true;
        }
    }

    void erase_at_position(int pos) {
        if (pos <= 1) {
            erase_at_head();
        } else if (pos >= size) {
            erase_at_tail();
        } else {
            Node *traverse = head;

            for (int i = 1; i < pos - 1; ++i) {
                traverse = traverse->next;
            } // traverse points to (pos-1)th Node

            Node *temp = traverse->next; // pos-th Node
            traverse->next = temp->next; // (pos+1)th Node

            temp->next->prev = traverse->next;
            delete temp;

            --size;
        }
    }

    [[maybe_unused]] void display_dll() const {
        Node *traversal = head;

        if (traversal == nullptr) {
            cout << "list is empty"
                 << endl;

            return;
        }
        while (traversal != nullptr) {
            cout << traversal->color
                 << ' '
                 << traversal->number
                 << endl;

            traversal = traversal->next;
        }
    }

    friend ostream &operator<<(ostream &os, const Doubly_Linked_List &list) {
        Node *traversal = list.head;

        if (traversal == nullptr) {
            os << "list is empty"
               << endl;
        } else {
            while (traversal != nullptr) {
                os << traversal->color
                   << ' '
                   << traversal->number
                   << endl;

                traversal = traversal->next;
            }
        }

        return os;
    }
};

void test() {
    Doubly_Linked_List DLL;

    DLL.add_at_tail("white", 3);
    DLL.add_at_tail("blue", 4);
    DLL.add_at_head("green", 2);
    DLL.add_at_head("white", 1);
    DLL.add_at_tail("blue", 5);
    DLL.add_at_tail("green", 6);
    DLL.add_at_tail("white", 7);
    DLL.add_at_tail("white", 8);
    DLL.add_at_tail("blue", 9);

    cout << "~Displaying Doubly Linked List:"
         << endl;

    cout << DLL
         << "head -> "
         << DLL.head->color
         << ' '
         << DLL.head->number
         << endl
         << "tail -> "
         << DLL.tail->color << ' '
         << DLL.tail->number
         << endl
         << "size: "
         << DLL.size
         << endl;

    cout << "~Deleting from head and tail:"
         << endl;

    DLL.erase_at_head();
    DLL.erase_at_tail();

    cout << DLL
         << "head -> "
         << DLL.head->color
         << ' '
         << DLL.head->number
         << endl
         << "tail -> "
         << DLL.tail->color
         << ' '
         << DLL.tail->number
         << endl
         << "size: "
         << DLL.size
         << endl;

    cout << "~Deleting at position 3:"
         << endl;

    DLL.erase_at_position(3);

    cout << DLL
         << "head -> "
         << DLL.head->color
         << ' '
         << DLL.head->number
         << endl
         << "tail -> "
         << DLL.tail->color
         << ' '
         << DLL.tail->number
         << endl << "size: "
         << DLL.size
         << endl;

    cout << "~Adding at position 3:"
         << endl;

    DLL.add_at_position("red", 489, 4);

    cout << DLL
         << "head -> "
         << DLL.head->color
         << ' '
         << DLL.head->number
         << endl
         << "tail -> "
         << DLL.tail->color
         << ' '
         << DLL.tail->number
         << endl
         << "size: "
         << DLL.size
         << endl;
}

int main() {
    test();

    return 0;
}