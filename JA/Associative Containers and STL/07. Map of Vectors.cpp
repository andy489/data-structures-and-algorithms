#include<iostream>
#include<string>
#include<sstream>
#include<vector>
#include<map>

using namespace std;

int main() {
/*
Read students in the following format:

4
Tony 2 5 5 3 6
George 2 2 3
Kerrigan 6 6 2 6 2 6
Jaina 6 6 5

Then reads commands in the following format:

George
Kerrigan
end

... and prints the grades for each student on a single line
*/

    map<string, vector<int> > studentGrades;

    int numStudents;
    cin >> numStudents;

    // remove the endline from the input (after we read numStudents we're at the end of that line)
    cin.ignore();

    for (int i = 0; i < numStudents; i++) {
        string line;
        getline(cin, line);

        istringstream lineIn(line);
        string name;
        lineIn >> name;

        vector<int> grades;
        int grade;
        while(lineIn >> grade) {
            grades.push_back(grade);
    }

        studentGrades[name] = grades;
    }

    string command;
    getline(cin, command);
    while(command != "end") {
        map<string, vector<int> >::iterator gradesIt = studentGrades.find(command);
        if (gradesIt != studentGrades.end()) {
            for (int grade : gradesIt->second) {
                cout << grade << " ";
            }
        } else {
            cout << "no info" ;
        }

        cout << endl;

        getline(cin, command);
    }

    return 0;
}
