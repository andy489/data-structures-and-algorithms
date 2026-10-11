/*
 * My Singly Linked List
 * Functionality:
 *
 * get_node()
 * insert_at_end()
 * insert_at_beginning()
 * insert_at_position()
 * reverse_ll_iterative()
 * reverse_ll_recursive()
 * bubble_sort_ll()
 * merge_2_sorted_ll()
 * split_ll()
 * merge_sort()
 * print_ll()
 * print_ll_recursive()
 * print_ll_reversed_recursive()
 * delete_at_position()
 * erase_ll()
*/
#include <iostream>
#include <cassert>
#include <algorithm>
#include <ctime>

using namespace std;

struct Node {
    int data;
    Node *next;
};

Node *get_new_node(int data) {
    Node *new_node = new Node();

    new_node->data = data;
    new_node->next = nullptr;

    return new_node;
}

Node *insert_at_end(Node *head, int data) {
    Node *new_node = get_new_node(data);

    if (head == nullptr) {
        head = new_node;
    } else {
        Node *traverse_node = head;

        while (traverse_node->next != nullptr) {
            traverse_node = traverse_node->next;
        }

        traverse_node->next = new_node;
    }

    return head;
}

Node *insert_at_beginning(Node *head, int data) {
    Node *new_node = get_new_node(data);

    new_node->next = head;

    head = new_node;

    return head;
}

void insert_at_beginning_void(Node **ptr_to_head, int data) { // second approach
    Node *new_node = get_new_node(data);

    new_node->next = *ptr_to_head;

    *ptr_to_head = new_node;
}

Node *insert_at_position(Node *head, int data, int pos) {
    Node *new_node = get_new_node(data);

    if (pos < 1) {
        return insert_at_beginning(head, data);
    } else if (pos == 1) { // if we want to insert at the head
        /*newNode->next = head;
        head = newNode;
        return head;*/
        return insert_at_beginning(head, data);
    } else {
        Node *traverse_node = head;

        for (int i = 0; i < pos - 2; ++i) {
            if (traverse_node == nullptr) {
                return insert_at_end(head, data);
            }

            traverse_node = traverse_node->next;
        }

        new_node->next = traverse_node->next;
        traverse_node->next = new_node;

        return head;
    }
}

Node *reverse_ll_iterative(Node *head) {
    Node *current = head;  // traversal Node
    Node *prev = nullptr;

    while (current != nullptr) {
        Node *next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }

    head = prev;
    return head;
}

Node *reverse_ll_recursive(Node *head) {
    if (head == nullptr || head->next == nullptr) {
        return head;
    }

    Node *rest = reverse_ll_recursive(head->next);

    head->next->next = head;
    head->next = nullptr;

    return rest;
}

Node *bubble_sort_ll(Node *head) {
    if (head == nullptr) {
        return head;
    }

    for (Node *i = head; i->next != nullptr; i = i->next) {
        for (Node *j = i->next; j != nullptr; j = j->next) {
            if (i->data > j->data) {
                swap(i->data, j->data);
            }
        }
    }

    return head;
}

void move_node(Node **destRef, Node **srcRef) {
    /* moveNode() is an utility function takes the node from the front
     * of the source, and move it to the front of the dest. It is an error
     * to call this function with the source list empty.
     * Before calling move_node(): source == {1, 2, 3}; dest == {3, 4, 5}
     * After calling move_node(): source == {2, 3}; dest == {1, 3, 4, 5}
     */

    Node *new_node = *srcRef; // the front source node
    assert(new_node != nullptr); // assuming that new_node is not nullptr

    *srcRef = new_node->next; // Advance the source pointer
    new_node->next = *destRef; // Link the old dest off the new node
    *destRef = new_node; // Move dest to point to the new node
}

Node *merge_2_sorted_ll(Node *L1, Node *L2) {    //merges two sorted LL into one LL sorted (increasing order)
    Node dummy{}; // dummy node to collect the result
    Node *tail = &dummy; // tail points to the last result node
    dummy.next = nullptr;

    while (true) {
        if (L1 == nullptr) {
            tail->next = L2;
            break;
        } else if (L2 == nullptr) {
            tail->next = L1;
            break;
        }

        if (L1->data <= L2->data) {
            move_node(&(tail->next), &L1);
        } else {
            move_node(&(tail->next), &L2);
        }

        tail = tail->next;
    }

    return dummy.next;
}

void split_ll(Node *source, Node **front_ref, Node **back_ref) {
    /* Split the nodes of the given list into front and back halves,
     * and return the two lists using the reference parameters.
     * If the length is odd, the extra node should go in the front list.
     * Uses the fast/slow pointer strategy.
     */
    Node *fast, *slow;

    slow = source;
    fast = source->next;

    /* Advance "fast" two nodes, and advance "slow" one node */
    while (fast != nullptr) {
        fast = fast->next;

        if (fast != nullptr) {
            slow = slow->next;
            fast = fast->next;
        }
    }

    // "slow" is before the midpoint in the list, so split it in two at that point

    *front_ref = source;
    *back_ref = slow->next;

    slow->next = nullptr;
}

void merge_sort(Node **head_ref) {
    Node *head = *head_ref;
    Node *L1, *L2;

    if ((head == nullptr) || (head->next == nullptr)) {
        return; // Base case - length 0 or 1
    }

    split_ll(head, &L1, &L2); // Split head into L1 sublist and L2 sublist

    // Recursively sort the sublist
    merge_sort(&L1);
    merge_sort(&L2);

    // answer = merge the two sorted lists together
    *head_ref = merge_2_sorted_ll(L1, L2);
}

void print_ll(Node *head) {
    if (head == nullptr) {
        cout << "empty linked list" << endl;
    } else {
        cout << "head: ";

        while (head->next != nullptr) {
            cout << head->data << " -> ";
            head = head->next;
        }

        cout << head->data << " -| end of linked list" << endl;
    }
}

void print_ll_recursive(Node *head, int &cnt) {
    if (cnt == 0 && head == nullptr) {
        cout << "empty linked list" << endl;
    } else if (head == nullptr) {
        cout << "end of linked list" << endl;
    } else {
        ++cnt;
        if (cnt == 1) std::cout << "head: ";
        // First print the data in the node

        if (head->next != nullptr) {
            cout << head->data << " -> ";
        } else {
            cout << head->data << " -| ";
        }

        print_ll_recursive(head->next, cnt); // Recursive call
    }

    cnt = 0;
}

void print_ll_reversed_recursive(Node *head, int &cnt) {
    if (head == nullptr && cnt == 0) {
        cout << "empty linked list" << endl;
        return;
    }

    if (head == nullptr) {
        return;
    }

    ++cnt;

    if (cnt == 1) {
        cout << "head: ";
    }

    print_ll_reversed_recursive(head->next, cnt);

    --cnt;

    if (cnt != 0) {
        cout << head->data << " -> ";
    } else {
        cout << head->data << " -| end of linked list" << endl;
    }
}

Node *deleteAtPosition(Node *head, int n) {
    if (n < 1) {
        return head;
    }

    Node *traverse_node = head;

    if (n == 1) {
        if (head == nullptr) {
            return head;
        }

        head = traverse_node->next; // head now points to second node (nullptr)
        delete traverse_node;

        return head; // or else statement
    }
    for (int i = 0; i < n - 2; i++) {
        if (traverse_node->next->next == nullptr) {
            return head;
        }

        traverse_node = traverse_node->next;
    } // traverse_node points to (n-1)th Node

    Node *temp = traverse_node->next; // nth Node
    traverse_node->next = temp->next; // (n+1)th Node

    delete temp; // free(temp);
    return head;
}

Node *erase_ll(Node *head) {
    while (head != nullptr) {
        head = deleteAtPosition(head, 1);
    }

    return head;
}

void test() {
    Node *head = nullptr; /* The identity of the linked list.
							 Not the head, but a pointer to the head.
							 Initialize an empty list. */

    int cnt_nodes, index, data;

    cout << "Enter how many Nodes you would like to insert at the beginning?" << endl;
    cin >> cnt_nodes;

    for (index = 0; index < cnt_nodes; ++index) {
        cout << "Enter data of Node to insert: ";
        cin >> data;

        head = insert_at_beginning(head, data); // head = insert_at_end(head, data);
        // insert_at_beginning_void(&head, data); // second way
        print_ll(head);
    }

    int insert_nodes;

    cout << endl << "Enter number of Nodes you want to INSERT with a selectable index:" << endl;

    cin >> insert_nodes;

    cout << endl << "~Insert " << insert_nodes << " Nodes at position of your choice." << endl
         << "If position is bigger than the size of the linked list," << endl
         << "the node will be inserted at the end of the linked list." << endl
         << "Else if the position is smaller than the first position," << endl
         << "the node will be inserted at the beginning of the linked list." << endl
         << "Thus there are no bad inputs." << endl;

    for (int i = 0; i < insert_nodes; ++i) {
        int pos, curr_data;

        cout << "Enter a position to insert a Node: ";
        cin >> pos;
        cout << "Enter curr_data (int) to Node to be inserted: ";
        cin >> curr_data;

        head = insert_at_position(head, curr_data, pos);

        print_ll(head);
    }

    cout << endl << "~Printing the linked list ITERATIVELY:" << endl;
    print_ll(head);
    cout << endl << "~Printing the linked list RECURSIVELY:" << endl;
    int cnt = 0;

    print_ll_recursive(head, cnt);
    cout << endl << "~Printing the linked list RECURSIVELY & REVERSED :" << endl;

    print_ll_reversed_recursive(head, cnt);
    cout << endl << "~Reversing the linked list (iteratively):" << endl;

    head = reverse_ll_iterative(head);
    print_ll(head);
    cout << endl << "~Reversing the linked list (recursively):" << endl;

    head = reverse_ll_recursive(head);
    print_ll(head);

    cout << endl << "~Sorting the linked list (bubbleSort):" << endl;
    head = bubble_sort_ll(head);
    print_ll(head);

    int delete_nodes;

    cout << endl << "Enter number of Nodes you want to DELETE with a selectable index:" << endl;
    cin >> delete_nodes;
    cout << endl << "~Delete " << delete_nodes << " Nodes at position of your choice." << endl
         << "If position is bigger than the size of the linked list" << endl
         << "or smaller than 1 - no Node will be deleted." << endl
         << "Thus there are no bad inputs." << endl;

    for (int i = 0; i < delete_nodes; ++i) {
        int pos;

        cout << "Enter a position at which you want to delete a Node: ";
        cin >> pos;

        head = deleteAtPosition(head, pos);
        print_ll(head);
    }

    cout << endl << "~Clearing the linked list:" << endl;
    head = erase_ll(head);

    print_ll(head);
}

void test_merge() {
    Node *head1 = nullptr;
    Node *head2 = nullptr;

    srand(time(nullptr));

    int ran1 = 2 + rand() % 8;
    int ran2 = 2 + rand() % 8;

    for (int i = 0; i < ran1; ++i) {
        head1 = insert_at_end(head1, rand() % 100);
    }

    for (int i = 0; i < ran2; ++i) {
        head2 = insert_at_end(head2, rand() % 100);
    }

    std::cout << endl << "~Printing two randomly created Linked Lists:" << endl;
    print_ll(head1);
    print_ll(head2);

    std::cout << endl << "~Sorting the Lists:" << endl;

    head1 = bubble_sort_ll(head1);
    head2 = bubble_sort_ll(head2);

    print_ll(head1);
    print_ll(head2);

    std::cout << endl << "~Merging the Lists:" << endl;

    Node *res;

    res = merge_2_sorted_ll(head1, head2);
    print_ll(res);

    cout << endl;
}

void test_merge_sort() {
    Node *head = nullptr;

    srand(time(nullptr));

    int ran = 5 + rand() % 20;

    for (int i = 0; i < ran; ++i) {
        head = insert_at_end(head, rand() % 100);
    }

    cout << "~Printing the randomly created Linked List:" << endl;
    print_ll(head);

    cout << endl << "~Printing the sorted List (via Merge Sort):" << endl;

    merge_sort(&head);
    print_ll(head);
}

int main() {
    test();

    test_merge();

    test_merge_sort();

    return 0;
}