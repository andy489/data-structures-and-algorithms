// https://www.hackerrank.com/contests/si-practice-5/challenges/challenge-1668

#include <iostream>

using namespace std;

struct Node {
    long num;
    Node *next;

    explicit Node(long num) {
        this->num = num;
        next = nullptr;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    long n;
    cin >> n;
    
    if (!n) {
        return cout << 0, 0;
    }

    if (!(n & n - 1)) { // optimization: if N is power of 2 the answer is always the first who attacks
        return cout << 1, 0;
    }

    Node *head(nullptr), *tail(nullptr);

    for (int i = 1; i <= n; i += 2) {
        if (tail) {
            tail->next = new Node(i);
            tail = tail->next;
        } else {
            head = tail = new Node(i);
        }
    }

    tail->next = head; // circular linked list

    if (n & 1) { // N is even
        head = tail; // because knight at the end will be killed and he is our tail
    }

    while (head->next != head) { // head->next != tail
        head->next = head->next->next;
        head = head->next;
    }
    
    cout << head->num;
}
