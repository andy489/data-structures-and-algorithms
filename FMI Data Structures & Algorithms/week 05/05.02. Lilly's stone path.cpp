// github.com/andy489

#include <iostream>
#include <string>
#include <climits>

using namespace std;

struct Stone {
    Stone *prev, *next;
    string color;
    int number;

    Stone(string color, int number, Stone *prev = nullptr,
          Stone *next = nullptr); //constructor with two default arguments
};

struct Path {
    Stone *head, *tail; // in our case we use head only for printing
    int size = 0;

    Path(); // default constructor
    // utility function for creating a new Node
    Stone *getNewNode(string color, int number);

    void addAtTail(string color, int number);

    bool eraseAtTail();

    // same as print but with operator << for the List
    friend ostream &operator<<(ostream &os, const Path &list);
};

int main() {
    Path LillyPath;
    string color;
    int number, i(1),j, count;
    cout << "Enter count of stones at Lilly's path: ";
    cin >> count;
    for (; i <= count; ++i) {
        if (i == 1)
            cout << "~For every stone enter color and number separated by space:\n";
        cout << "Stone " << i << ": ";
        cin >> color >> number;
        if (color == "white")
            LillyPath.addAtTail(color, number);
        else {
            if (color == "green") {
                int sumPrev(0);
                for (j = 0; j < number; ++j) {
                    sumPrev += LillyPath.tail->number;
                    LillyPath.eraseAtTail();
                }
                LillyPath.addAtTail("white", sumPrev);
            } else if (color == "blue") {
                int maxPrev(INT_MIN);
                for (j = 0; j < number; ++j) {
                    if (LillyPath.tail->number > maxPrev)
                        maxPrev = LillyPath.tail->number;
                    LillyPath.eraseAtTail();
                }
                LillyPath.addAtTail("white", maxPrev);
            }
        }
    }
    cout << "~Lilly's path after her walk:\n";
    return cout << LillyPath, 0;
}

Stone::Stone(string color, int number, Stone *prev, Stone *next) {
    this->color = color;
    this->number = number;
    this->prev = prev;
    this->next = next;
}

Path::Path() {
    head = tail = nullptr;
}

Stone *Path::getNewNode(string color, int number) {
    Stone *newNode = new Stone(color, number);
    return newNode;
}

void Path::addAtTail(string color, int number) {
    Stone *newNode = getNewNode(color, number);
    ++size;
    if (head == nullptr)
        head = tail = newNode;
    else {
        Stone *temp = tail;
        tail = newNode;
        newNode->prev = temp;
        temp->next = tail;
        tail = temp->next;
    }
}

bool Path::eraseAtTail() {
    if (head == nullptr) {
        cout << "cannot perform erase - path is empty\n";
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

ostream &operator<<(ostream &os, const Path &path) {
    Stone *traversal = path.head;
    if (traversal == nullptr)
        os << "path is empty\n";
    else {
        while (traversal != nullptr) {
            os << traversal->color << ' ' << traversal->number << '\n';
            traversal = traversal->next;
        }
    }
    return os;
}
