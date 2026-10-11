// https://www.hackerrank.com/contests/si-practice-4/challenges/challenge-1646

#include <iostream>
#include <set>
#include <unordered_set>

using namespace std;

struct Node {
    int data;
    Node *next;
};

Node *get_new_node(int data) { // creates new node
    Node *newNode = new Node();

    newNode->data = data;
    newNode->next = nullptr;

    return newNode;
}

Node *add_back(Node *head, int data) { // adds at the end of the linked list - time complexity O(n)
    Node *nodeToAdd = get_new_node(data);
    if (head == nullptr) {
        head = nodeToAdd;
    } else {
        Node *traversal = head;

        while (traversal->next != nullptr) {
            traversal = traversal->next;
        }

        traversal->next = nodeToAdd;
    }
    return head;
}

Node *add_front(Node *head, int data) { // adds at head of the linked list - time complexity O(1)
    Node *nodeToAdd = get_new_node(data);

    if (head == nullptr) {
        head = nodeToAdd;
    } else {
        Node *temp = head;
        head = nodeToAdd;
        nodeToAdd->next = temp;
    }

    return head;
}

void print_linked_list(Node *head) {
    if (head == nullptr) {
        cout << "list is empty" << endl;
    } else {
        cout << "head: ";

        while (head != nullptr) {
            cout << head->data;

            if (head->next != nullptr) {
                cout << " -> ";
            } else {
                cout << " -||" << endl;
            }

            head = head->next;
        }
    }
}

void count_neighbouring_pairs(Node *head, const unordered_set<int> &s, set<pair<int, int>> &ans) {
    while (head->next != nullptr) {
        if (s.count(head->data) && s.count(head->next->data)) {
            ans.insert({head->data, head->next->data});
        }

        head = head->next;
    }
}

void test() {
    Node *head = nullptr; // pointer to head

    int N;
    cin >> N;

    int data;
    for (int i = 0; i < N; ++i) {
        cin >> data;
        head = add_front(head, data);
    }

    unordered_set<int> s;
    set<pair<int, int>> ans;

    int P;
    cin >> P;

    int element;
    for (int i = 0; i < P; ++i) {
        cin >> element;
        s.insert(element);
    }

    count_neighbouring_pairs(head, s, ans);

    cout << ans.size();

    // cout << "Answer:\n " << ans.size() << endl;

    // for (const auto &kvp: ans) {
    //     cout << '(' << kvp.first << ' ' << kvp.second << ")" << endl;
    // }

    // cout << "Displaying Linked List:" << endl;

    // print_linked_list(head);
}

int main() {
    test();
    return 0;
}