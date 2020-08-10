// github.com/andy489

#include <iostream>
#include <set>
#include <unordered_set>

using namespace std;

struct Node {
    int data;
    Node *next;
};

Node *getNewNode(int data) { // creates new node
    Node *newNode = new Node();
    newNode->data = data;
    newNode->next = nullptr;
    return newNode;
}

Node *addBack(Node *head, int data) { // adds at end of the linked list - time complexity О(n)
    Node *nodeToAdd = getNewNode(data);
    if (head == nullptr)
        head = nodeToAdd;
    else {
        Node *traversal = head;
        while (traversal->next != nullptr)
            traversal = traversal->next;
        traversal->next = nodeToAdd;
    }
    return head;
}

Node *addFront(Node *head, int data) { // adds at head of the linked list - time complexity O(1)
    Node *nodeToAdd = getNewNode(data);
    if (head == nullptr)
        head = nodeToAdd;
    else {
        Node *temp = head;
        head = nodeToAdd;
        nodeToAdd->next = temp;
    }
    return head;
}

void printLinkedList(Node *head) {
    if (head == nullptr)
        cout << "list is empty\n";
    else {
        cout << "head: ";
        while (head != nullptr) {
            cout << head->data;
            if (head->next != nullptr)
                cout << " -> ";
            else
                cout << " -||\n";
            head = head->next;
        }
    }
}

void countNeighbouringPairs(Node *head,
                            const unordered_set<int> &s,
                            set <pair<int, int>> &ans) {
    while (head->next != nullptr) {
        if (s.count(head->data) && s.count(head->next->data))
            ans.insert({head->data, head->next->data});
        head = head->next;
    }
}

void test() {
    Node *head = nullptr; // pointer to head

    int N, P, i(0), data, element;
    cin >> N;
    for (; i < N; ++i) {
        cin >> data;
        head = addFront(head, data);
    }

    unordered_set<int> s;
    set<pair<int, int>> ans;

    cin >> P;
    for (i = 0; i < P; ++i) {
        cin >> element;
        s.insert(element);
    }

    countNeighbouringPairs(head, s, ans);
    cout << "Answer:\n " << ans.size() << '\n';
    for (const auto &kvp: ans)
        cout << '(' << kvp.first << ' ' << kvp.second << ")\n";
    cout << "~Displaying Linked List: \n";
    printLinkedList(head);
}

int main() {
    test();
    return 0;
}
