// Queue - Linked List implementation

#include<iostream>

using namespace std;

struct Node {
    int data;
    struct Node *next;
};

// Two global variables to store address of front and rear nodes
struct Node *front = nullptr;
struct Node *rear = nullptr;

Node *get_new_node(int x) {
    Node *temp = new Node;
    //C: struct Node* temp = (struct Node*)malloc(sizeof(struct Node));

    temp->data = x;
    temp->next = nullptr;

    return temp;
}

// To Enqueue an integer
void Enqueue(int x) {
    Node *temp = get_new_node(x);

    if (front == nullptr && rear == nullptr) {
        front = rear = temp;
        return;
    }

    rear->next = temp;
    rear = temp;
}

// To Dequeue an integer.
void Dequeue() {
    struct Node *temp = front;

    if (front == nullptr) {
        cout << "Queue is Empty" << endl;
        return;
    }

    if (front == rear) {
        front = rear = nullptr;
    } else {
        front = front->next;
    }

    delete temp; //C: free(temp);
}

[[maybe_unused]] int Front() {
    if (front == nullptr) {
        cout << "Queue is empty" << endl;
        return -1;
    }

    return front->data;
}

void Print() {
    struct Node *temp = front;

    while (temp != nullptr) {
        cout << temp->data << ' ';
        temp = temp->next;
    }

    cout << endl;
}

int main() {
    /*
     * Drive code to test the implementation.
     * Printing elements in Queue after each Enqueue or Dequeue
     */

    Enqueue(2);
    Print();

    Enqueue(4);
    Print();

    Enqueue(6);
    Print();

    Dequeue();
    Print();

    Enqueue(8);
    Print();
}