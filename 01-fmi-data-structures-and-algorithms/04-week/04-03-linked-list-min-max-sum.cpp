// https://www.hackerrank.com/contests/si-practice-4/challenges/challenge-1645/problem

#include <iostream>

using namespace std;

struct Node {
    int data;
    Node *next;

    Node(int data, Node *next) : data(data), next(next) {}
};

Node *add_front(Node *head, int data) {
    if (head == nullptr) {
        head = new Node(data, nullptr);
        return head;
    }

    Node *node_to_add = new Node(data, head);
    return node_to_add;
}

int sum = 0;
int min_data = 1e4 + 5;
int max_data = -1e4 + 5;

void traverse_list(Node *head) {
    while (head != nullptr) {
        int curr = head->data;

        sum += curr;

        if (curr > max_data) {
            max_data = curr;
        }

        if (curr < min_data) {
            min_data = curr;
        }

        head = head->next;
    }
}

void stream() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    Node *head = nullptr;

    int k;
    while (cin >> k) {
        head = add_front(head, k);
    }

    traverse_list(head);
    cout << min_data << " " << max_data << " " << sum;
}

int main() {
    stream();
    return 0;
}