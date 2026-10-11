#include<iostream>
#include<stack>

using namespace std;

long steps_taken = 0;

int set_towers(stack<int> &src) {
    int disks;
    cout << "Enter number of disks: ";
    cin >> disks;

    for (int i = 0; i < disks; i++) {
        src.push(disks - i);
    }

    return disks;
}

void print_rod(std::stack<int> tower) {
    stack<int> temp;

    while (!tower.empty()) {
        temp.push(tower.top());
        tower.pop();
    }
    if (!temp.size()) {
        cout << "empty rod" << endl;
    } else {
        while (!temp.empty()) {
            cout << temp.top();
            temp.pop();

            if (temp.size() != 0) {
                cout << ", ";
            }
        }

        cout << endl;
    }
}

void print_rods(stack<int> &src, stack<int> &dest, stack<int> &spare) {
    cout << "Source: ";
    print_rod(src);
    cout << "Destination: ", print_rod(dest);
    cout << "Spare: ", print_rod(spare);
    cout << "-----------------------" << endl;
}

void move_disks(int disks, stack<int> &src, stack<int> &dest, stack<int> &spare, stack<int> &a, stack<int> &b,
                stack<int> &c) {

    if (disks < 1) {
        return;
    } else if (disks == 1) {
        ++steps_taken;
        dest.push(src.top());
        src.pop();

        cout << "Step #" << steps_taken << ": Moved disk " << disks << endl;

        print_rods(a, b, c);
        return;
    } else {
        move_disks(disks - 1, src, spare, dest, a, b, c);
        ++steps_taken;
        dest.push(src.top());
        src.pop();

        cout << "Step #" << steps_taken << ": Moved disk " << disks << endl;

        print_rods(a, b, c);
        move_disks(disks - 1, spare, dest, src, a, b, c);
    }
}

int main() {
    stack<int> src;
    stack<int> dest;
    stack<int> spare;

    int disks = set_towers(src);

    print_rods(src, dest, spare);

    move_disks(disks, src, dest, spare, src, dest, spare);

    cout << "Total moves: " << steps_taken << endl;

    return 0;
}