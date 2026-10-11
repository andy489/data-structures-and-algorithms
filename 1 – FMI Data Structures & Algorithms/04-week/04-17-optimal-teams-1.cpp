// https://www.hackerrank.com/contests/practice-4-sda/challenges/optimal-teams

#include <iostream>
#include <vector>

using namespace std;

struct Student {
    int pos, team;

    explicit Student(int pos = 0, int team = 0) : pos(pos), team(team) {}
};

bool does_student_have_a_team(const vector<Student> &students, const vector<Student *> &st_pointers, int M) {
    return st_pointers[M - 1]->team != 0;
}

int main() {
    int n, k;
    cin >> n >> k;

    vector<Student> students;
    students.reserve(n);

    vector<Student *> student_pointers(n);

    int skill;
    for (int i = 0; i < n; ++i) {
        cin >> skill;

        students.emplace_back(i, 0);
        student_pointers[skill - 1] = &students[i];
    }

    int cnt = 0;
    int m = n;

    while (m > 0) {
        int left_k = k;
        int right_k = k;

        if (!does_student_have_a_team(students, student_pointers, m)) {
            int position_left;
            int position_right;

            position_right = position_left = student_pointers[m - 1]->pos;

            while (right_k >= 0 && position_right <= n - 1) {
                if (students[position_right].team == 0) {
                    students[position_right].team = 1 + (cnt & 1);

                    --right_k;
                    ++position_right;
                } else {
                    position_right += 2 * k + 1;
                }
            }

            while (left_k > 0 && position_left - 1 >= 0) {
                if (!students[position_left - 1].team) {
                    students[position_left - 1].team = 1 + (cnt & 1);

                    --left_k;
                    --position_left;
                } else {
                    position_left -= 2 * k + 1;
                }
            }
            ++cnt;
        }

        --m;
    }

    for (const auto &s : students) {
        cout << s.team;
    }

    return 0;
}
