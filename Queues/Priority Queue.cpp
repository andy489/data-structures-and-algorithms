// Priority Queue Test
#include <iostream>
#include <vector>
#include <queue>
#include <ctime>
#include <string>
using namespace std;

struct Student
{
	string name;
	unsigned grade;
	Student(string name = "default", unsigned grade = 2) :
		name(name), grade(grade) {}
	bool operator<(const Student& other) const
	{
		if (this->grade != other.grade)
			return this->grade < other.grade;
		else
			return this->name < other.name;
	}
	friend ostream& operator<<(ostream& os, const Student& s)
	{
		os << s.name << ' ' << s.grade << "\n------\n";
		return os;
	}
};

void printVEC(const vector<Student>& vec)
{
	for (const auto& s : vec)
	{
		cout << s;
	}
}

void printPQ(priority_queue<Student, vector<Student>, less<Student>>& priorityQueue)
{
	while (!priorityQueue.empty())
	{
		Student s = priorityQueue.top();
		cout << s;
		priorityQueue.pop();
	}
}

int main()
{
	srand(unsigned(time(0)));
	priority_queue<Student, vector<Student>, less<Student>> PQ;
	vector<Student> input;
	Student s;
	for (size_t i = 0; i < 10; i++)
	{
		s.grade = 1 + rand() % 26;
		s.name = 65 + rand() % 26;
		s.name += 97 + rand() % 26;
		input.push_back(s);
		PQ.push(s);
	}

	printVEC(input);
	cout << '\n';
	printPQ(PQ);

	return 0;
}
