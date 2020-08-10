// github.com/andy489

// https://www.hackerrank.com/contests/practice-4-sda/challenges/optimal-teams

#include <iostream>
#include <vector>

using namespace std;

struct Student {
    int skills, pos, team;

    Student(int skills = 0, int pos = 0, int team = 0) :
            skills(skills), pos(pos), team(team) {}
};

bool doesStudentHaveATeam(vector<Student> &students, vector<Student *> &ptrs, int M) {
    if (ptrs[M - 1]->team == 0)
        return false;
    else
        return true;
}

int main() {
    int N, K, skill, i(0);
    cin >> N >> K;

    vector<Student> students;
    students.reserve(N);
    vector<Student *> ptrs(N);

    for (; i < N; ++i) {
        cin >> skill;
        students.emplace_back(skill, i, 0);
        ptrs[skill - 1] = &students[i];
    }

    int cnt(0), M(N);
    while (M > 0) {
        int rightK(K), leftK(K);
        if (!doesStudentHaveATeam(students, ptrs, M)) {
            int positionRight, positionLeft;
            positionRight = positionLeft = ptrs[M - 1]->pos;
            while (rightK >= 0 && positionRight <= N - 1) {
                if (students[positionRight].team == 0) {
                    students[positionRight].team = 1 + (cnt & 1);
                    rightK--;
                    positionRight++;
                } else
                    positionRight += 2 * K + 1;
            }
            while (leftK > 0 && positionLeft - 1 >= 0) {
                if (!students[positionLeft - 1].team) {
                    students[positionLeft - 1].team = 1 + (cnt & 1);
                    leftK--;
                    positionLeft--;
                } else
                    positionLeft -= 2 * K + 1;
            }
            ++cnt;
        }
        --M;
    }
    for (const auto &s : students)
        cout << s.team;
    return 0;
}
