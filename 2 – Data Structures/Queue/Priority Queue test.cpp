// Priority Queue Test

#include <iostream>
#include <utility>
#include <vector>
#include <queue>
#include <ctime>
#include <string>

using namespace std;

struct Student {
    string name;
    unsigned grade;

    explicit Student(string name = "default", unsigned grade = 2) :
            name(move(name)), grade(grade) {}

    bool operator<(const Student &other) const {
        if (this->grade != other.grade) {
            return this->grade < other.grade;
        } else {
            return this->name < other.name;
        }
    }

    friend ostream &operator<<(ostream &os, const Student &s) {
        os << s.name
           << ' '
           << s.grade
           << endl
           << "------"
           << endl;

        return os;
    }
};

void print_vec(const vector<Student> &vec) {
    for (const auto &s : vec) {
        cout << s;
    }
}

void printPQ(priority_queue<Student, vector<Student>, less<>> &priorityQueue) {
    while (!priorityQueue.empty()) {
        Student s = priorityQueue.top();
        cout << s;
        priorityQueue.pop();
    }
}

int main() {
    srand(unsigned(time(nullptr)));
    priority_queue<Student, vector<Student>, less<>> PQ;
    vector<Student> input;
    
    Student s;
    for (unsigned i = 0; i < 10; ++i) {
        s.grade = 1 + rand() % 26;
        s.name = 65 + rand() % 26;
        s.name += 97 + rand() % 26;
        
        input.push_back(s);
        PQ.push(s);
    }

    print_vec(input);
    cout << endl;
    
    printPQ(PQ);

    return 0;
}