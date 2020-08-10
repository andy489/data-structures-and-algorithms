// github.com/andy489

#include <iostream>
#include <climits>

using namespace std;

struct Node {
    int data;
    Node *next;
};

Node *getNewNode(int data) {    // creates new node
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

int getMin(Node *head) {
    int minData = INT_MAX;
    while (head != nullptr) {
        if (head->data < minData)
            minData = head->data;
        head = head->next;
    }
    return minData;
}

int getMax(Node *head) {
    int maxData(INT_MIN);
    while (head != nullptr) {
        if (head->data > maxData)
            maxData = head->data;
        head = head->next;
    }
    return maxData;
}

unsigned getSum(Node *head) {
    int sum(0);
    while (head != nullptr)
        sum += head->data, head = head->next;
    return sum;
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

void test() {
    Node *head = nullptr;
    int n, data;
    cin>>n;
    while (n--) { //we will use addFront, because time complexity there is constant - O(1)
        cin >> data;
        head = addFront(head, data); //head = addBack(head, data);
    }
    cout << "\nmin: ";
    (head != nullptr) ? cout << getMin(head) : cout << "no min element";
    cout << "\nmax: ";
    (head != nullptr) ? cout << getMax(head) : cout << "no max element";
    cout << "\nsum: " << getSum(head) << "\n\n";

    cout << "~Displaying Linked List: \n";

    printLinkedList(head);
}

int main() {
    test();
    return 0;
}
