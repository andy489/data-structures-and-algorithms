// https://www.hackerrank.com/contests/si-practice-5/challenges/challenge-1669

#include <iostream>
#include <string>
#include <utility>

using namespace std;

const int MIN = -1e9;

struct Stone {
    Stone *prev, *next;
    string color;
    int number;

    Stone(string color, int number, Stone *prev = nullptr, Stone *next = nullptr) {
        this->color = move(color);
        this->number = number;
        this->prev = prev;
        this->next = next;
    }
};

struct Path {
    Stone *head, *tail; // in our case we use head only for printing
    int size;

    Path() {
        head = tail = nullptr;
        size = 0;
    }

    static Stone *get_new_node(string color, int number) {
        auto *new_node = new Stone(move(color), number);
        return new_node;
    }

    void addAtTail(string color, int number) {
        Stone *new_node = get_new_node(move(color), number);
        ++size;

        if (head == nullptr)
            head = tail = new_node;
        else {
            Stone *temp = tail;

            tail = new_node;
            new_node->prev = temp;
            temp->next = tail;

            tail = temp->next;
        }
    }

    bool erase_at_tail() {
        if (head == nullptr) {
            cout << "cannot perform erase - path is empty" << endl;
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

    // same as print but with operator << for the list
    friend ostream &operator<<(ostream &os, const Path &path) {
        Stone *traversal = path.head;

        if (traversal == nullptr)
            os << "path is empty" << endl;
        else {
            while (traversal != nullptr) {
                os << /* traversal->color << ' ' << */ traversal->number << " ";
                traversal = traversal->next;
            }
        }

        return os;
    }
};

int main() {
    Path LillyPath;
    string color;
    int number, cnt;

    // cout << "Enter cnt of stones at Lilly's path: ";
    cin >> cnt;

    for (int i = 1; i <= cnt; ++i) {
        if (i == 1) {
            // cout << "~For every stone enter color and number separated by space:" << endl;
        }

        // cout << "Stone " << i << ": ";
        cin >> color >> number;

        if (color == "white") {
            LillyPath.addAtTail(color, number);
        } else {
            if (color == "green") {
                int sum_prev = 0;

                for (int j = 0; j < number; ++j) {
                    sum_prev += LillyPath.tail->number;
                    LillyPath.erase_at_tail();
                }

                LillyPath.addAtTail("white", sum_prev);
            } else if (color == "blue") {
                int max_prev = MIN;

                for (int j = 0; j < number; ++j) {
                    if (LillyPath.tail->number > max_prev) {
                        max_prev = LillyPath.tail->number;
                    }

                    LillyPath.erase_at_tail();
                }

                LillyPath.addAtTail("white", max_prev);
            }
        }
    }
    // cout << "~Lilly's path after her walk:" << endl;

    cout << LillyPath;

    return 0;
}


