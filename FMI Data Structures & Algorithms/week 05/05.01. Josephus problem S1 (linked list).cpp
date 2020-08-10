// github.com/andy489

#include <iostream>

using namespace std;

struct Node {
    long num;
    Node *next;

    Node(long num);
};

int main() {
    long N, i(1);
    cin >> N;
    if (N == 0)
        return cout << 0, 0;
    if (!(N & N - 1)) // optimization: if N is power of 2 the answer is always the first who attacks
        return cout << 1, 0;
    Node *head(nullptr), *tail(nullptr);

    for (; i <= N; i += 2) {
        if (tail) {
            tail->next = new Node(i);
            tail = tail->next;
        } else
            head = tail = new Node(i);
    }

    tail->next = head; // circular linked list

    if (N & 1) // N is even
        head = tail; // because knight at the end will be killed and he is our tail
    while (head->next != head) { // head->next != tail
        head->next = head->next->next;
        head = head->next;
    }
    cout << head->num;
}

Node::Node(long num) {
    this->num = num;
    next = nullptr;
}
