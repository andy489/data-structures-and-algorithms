// https://www.hackerrank.com/challenges/30-linked-list/problem

#include <iostream>

using namespace std;

class Node {
public:
    int data;
    Node *next;

    explicit Node(int d) {
        data = d;
        next = nullptr;
    }
};

class Solution {
public:

    Node *insert(Node *head, int data) {
        //Complete this method
        if (!head) {
            return new Node(data);
        } else {
            head->next = insert(head->next, data);
        }
        return head;
    }

    static void display(Node *head) {
        Node *start = head;
        while (start) {
            cout << start->data << " ";
            start = start->next;
        }
    }
};

int main() {
    Node *head = nullptr;
    Solution mylist;
    
    int T, data;
    cin >> T;

    while (T-- > 0) {
        cin >> data;
        head = mylist.insert(head, data);
    }

    Solution::display(head);
}
