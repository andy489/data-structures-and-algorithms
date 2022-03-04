// Given a linked list, check if the linked list has loop or not.

// Floyd’s Cycle-Finding Algorithm
// Traverse linked list using two pointers.
// Move one pointer (slow) by one and another
// pointer (fast) by two. If these pointers meet
// at the same node then there is a loop.
// If pointers do not meet then linked list does
// not have a loop

#include <iostream>

using namespace std;

template<typename T>
struct Node {
    T some_data;
    Node *next;

    explicit Node(T data, Node *next = nullptr) : some_data(data), next(next) {}
};

template<typename T>
struct List {
    Node<T> *head{};

    explicit List(Node<T> *head = nullptr) : head(nullptr) {}

    void push(T data) {
        Node<T> *new_node = new Node(data);
        new_node->next = head;
        head = new_node;
    }

    bool detect_loop() {
        Node<T> *slow(head);
        Node<T> *fast(head);

        while (slow && fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
};

int main() {
    List<int> L;
    L.push(20);
    L.push(4);
    L.push(15);
    L.push(10);

    L.head->next->next->next->next = L.head;

    cout << (L.detect_loop() ? "LOOP FOUND" : "NO LOOP") << endl;

    return 0;
}