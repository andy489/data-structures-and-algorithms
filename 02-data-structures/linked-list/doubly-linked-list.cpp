/*
 * My Doubly Linked List
 * Functionality
 * 
 * get_node()
 * insert_at_head()
 * insert_at_tail()
 * print_dll()
 * reverse_print_dll()
*/

#include <iostream>

using namespace std;

struct Node {
    Node *prev, *next;
    int data;
};

Node *head;

Node *get_new_node(int data) {
    Node *new_node = new Node;
    //C: struct Node* temp=(struct Node*)malloc(sizeof(struct Node));

    new_node->data = data;
    new_node->prev = new_node->next = nullptr;

    return new_node;
}

void insert_at_head(int data) {
    Node *new_node = get_new_node(data);

    if (head == nullptr) {
        head = new_node;
        return;
    }

    head->prev = new_node;
    new_node->next = head;

    head = new_node;
}

void insertAtTail(int data) {
    Node *new_node = get_new_node(data);

    if (head == nullptr) {
        head = new_node;
        return;
    }

    Node *temp = head;

    while (temp->next != nullptr) {
        temp = temp->next;
    }

    temp->next = new_node;
    new_node->prev = temp;
}

void print_dll() {
    Node *temp = head;

    if (temp == nullptr) {
        cout << "empty DLL" << endl;
        return;
    }
    
    cout << "head-> ";
    
    while (temp != nullptr) {
        cout << temp->data << ' ';

        temp = temp->next;
    }
    
    cout << "<-tail" << endl;
}

void reverse_print_dll() {
    Node *temp = head;
    
    if (temp == nullptr) {
        cout << "empty DLL"<< endl;
        
        return;
    }
    // traversing to last Node
    while (temp->next != nullptr) {
        temp = temp->next;
    }
    
    // Traversing backward using prev pointer
    cout << "Reverse: tail-> ";
    
    while (temp != nullptr) {
        cout << temp->data << ' ';
        temp = temp->prev;
    }
    
    cout << " <-head" << endl;
}

int main() {
    insert_at_head(2);
    insert_at_head(4);
    insert_at_head(6);
    insertAtTail(8);
    insertAtTail(10);
    insertAtTail(12);

    print_dll();

    reverse_print_dll();
}
