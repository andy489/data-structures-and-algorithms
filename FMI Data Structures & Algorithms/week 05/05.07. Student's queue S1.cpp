// github.com/andy489

// https://www.hackerrank.com/contests/practice-5-sda/challenges/challenge-2231

#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;

struct Student {
    string name;
    int group, enter;

    Student(string name = "", size_t group = 0, int enter = 0) :
            name(name), group(group), enter(enter) {};
};

void fillQueue(int N,
               vector<queue<Student *>> &students,
               queue<int> &studentQueue,
               queue<Student *> &finalQueue) {
    string name;
    int group;
    Student *student;
    for (int i = 0; i < N; ++i) {
        cin >> name >> group;
        student = new Student(name, group, i);
        if (students[student->group].empty())
            studentQueue.push(student->group);
        students[student->group].push(student);

        if ((i + 1) & 1 && i > 0) {
            finalQueue.push(students[studentQueue.front()].front());
            students[studentQueue.front()].pop();
            if (students[studentQueue.front()].empty())
                studentQueue.pop();
        }
    }
}

void displayStudents(queue<Student *> &finalQueue,
                     queue<int> studentQueue,
                     vector<queue<Student *>> &students) {
    int exitCount(2);

    while (!finalQueue.empty()) {
        cout << finalQueue.front()->name << ' ' << finalQueue.front()->enter << ' ' << exitCount;
        exitCount += 2;
        finalQueue.pop();
        cout << '\n';
    }

    while (!studentQueue.empty()) {
        while (!students[studentQueue.front()].empty()) {
            cout << students[studentQueue.front()].front()->name << ' '
                 << students[studentQueue.front()].front()->enter << ' '
                 << exitCount << '\n';
            exitCount += 2;
            students[studentQueue.front()].pop();
        }
        studentQueue.pop();
    }
}

int main() {
    queue<Student *> finalQueue;
    int N, M;
    cin >> N >> M;

    vector<queue<Student *>> students(M + 1); // vector of subqueues for every student with group number M
    queue<int> studentQueue;

    fillQueue(N, students, studentQueue, finalQueue);
    return displayStudents(finalQueue, studentQueue, students), 0;
}
