#include <iostream>
#include <vector>
#include <queue>
#include <string>
using namespace std;

struct Student
{
    string name;
    size_t group, enter;
    Student(string name = "", size_t group = 0, size_t enter = 0) :
        name(name), group(group), enter(enter) {};
};

void fillQueue(int N, 
    vector<queue<Student*>>& students, 
    queue<size_t>& studentQueue,
    queue<Student*>& finalQueue)
{
    string name;
    size_t group;
    Student* student;
    for (size_t i = 0; i < N; i++)
    {
        cin >> name >> group;
        student = new Student(name, group, i);
        if (students[student->group].empty())
        {    
            studentQueue.push(student->group);
        }
        students[student->group].push(student);

        if (i + 1 & 1 && i > 0)
        {
            finalQueue.push(students[studentQueue.front()].front());
            students[studentQueue.front()].pop();
            if (students[studentQueue.front()].empty())
            {    
                studentQueue.pop();
            }
        }
    }
}

void displayStudents(queue<Student*>& finalQueue,
    queue<size_t> studentQueue,
    vector<queue<Student*>>& students)
{
    size_t exitCount(2);

    while (!finalQueue.empty())
    {
        cout << finalQueue.front()->name << ' ' << finalQueue.front()->enter << ' ' << exitCount;
        exitCount += 2;
        finalQueue.pop();
        cout << '\n';
    }

    while (!studentQueue.empty())
    {
        while (!students[studentQueue.front()].empty())
        {
            cout << students[studentQueue.front()].front()->name << ' '
                << students[studentQueue.front()].front()->enter << ' '
                << exitCount << '\n';
            exitCount += 2;
            students[studentQueue.front()].pop();
        }
        studentQueue.pop();
    }
}

int main()
{
    queue<Student*> finalQueue;
    size_t N, M;
    cin >> N >> M;

    vector<queue<Student*>> students(M + 1); // vector of subqueues for every student with group number M
    queue<size_t> studentQueue;

    fillQueue(N, students,studentQueue,finalQueue);
    displayStudents(finalQueue, studentQueue, students);

    return 0;
}
