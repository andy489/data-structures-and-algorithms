// https://www.hackerrank.com/contests/practice-5-sda/challenges/challenge-2231

#include <iostream>
#include <utility>
#include <vector>
#include <queue>
#include <string>

using namespace std;

struct Student {
    string name;
    int group, enter;

    explicit Student(string name = "", size_t group = 0, int enter = 0) :
            name(move(name)), group(group), enter(enter) {};
};

void fill_queue(int n, vector<queue<Student *>> &students, queue<int> &student_queue, queue<Student *> &final_queue) {
    string name;
    int group;

    Student *student;
    for (int i = 0; i < n; ++i) {
        cin >> name >> group;

        student = new Student(name, group, i);

        if (students[student->group].empty()) {
            student_queue.push(student->group);
        }

        students[student->group].push(student);

        if ((i + 1) & 1 && i > 0) {
            final_queue.push(students[student_queue.front()].front());
            students[student_queue.front()].pop();

            if (students[student_queue.front()].empty()) {
                student_queue.pop();
            }
        }
    }
}

void display_students(queue<Student *> &final_queue, queue<int> student_queue, vector<queue<Student *>> &students) {
    int exit_cnt = 2;

    while (!final_queue.empty()) {
        cout << final_queue.front()->name << ' ' << final_queue.front()->enter << ' ' << exit_cnt;

        exit_cnt += 2;
        final_queue.pop();
        cout << endl;
    }

    while (!student_queue.empty()) {
        while (!students[student_queue.front()].empty()) {
            cout << students[student_queue.front()].front()->name << ' '
                 << students[student_queue.front()].front()->enter << ' '
                 << exit_cnt << endl;

            exit_cnt += 2;
            students[student_queue.front()].pop();
        }

        student_queue.pop();
    }
}

int main() {
    queue<Student *> final_queue;
    int n, m;
    cin >> n >> m;

    vector<queue<Student *>> students(m + 1); // vector of sub_queues for every student with group number m
    queue<int> students_queue;

    fill_queue(n, students, students_queue, final_queue);

    display_students(final_queue, students_queue, students);

    return 0;
}
