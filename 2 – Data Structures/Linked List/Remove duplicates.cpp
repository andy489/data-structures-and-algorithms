// https://www.hackerrank.com/challenges/30-linked-list-deletion/problem

#include <vector>
#include <iostream>
#include <algorithm>

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
    static Node *removeDuplicates(Node *head) {
        //Write your code here
        Node *traverse = head;
        while (traverse && traverse->next) {
            if (traverse->data == traverse->next->data) {
                Node *duplicate = traverse->next;
                traverse->next = duplicate->next;
                delete duplicate;
            } else {
                traverse = traverse->next;
            }
        }
        return head;
    }

    Node *insert(Node *head, int data) {
        Node *p = new Node(data);
        if (head == nullptr) {
            head = p;

        } else if (head->next == nullptr) {
            head->next = p;
        } else {
            Node *start = head;
            while (start->next != nullptr) {
                start = start->next;
            }
            start->next = p;
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

    head = Solution::removeDuplicates(head);

    Solution::display(head);
}
