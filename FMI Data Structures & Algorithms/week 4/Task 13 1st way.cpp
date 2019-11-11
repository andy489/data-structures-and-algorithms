#include <iostream>
#include <vector>
using namespace std;

struct Student
{
    int skills, pos, team;
    Student(int skills = 0, int pos = 0, int team = 0) :skills(skills), pos(pos), team(team) {}
};

bool doesStudentHaveATeam(vector<Student>& students, vector<Student*>& pointers, int M)
{
    if (pointers[M - 1]->team == 0)
    {
        return false;
    }
    else
    {
        return true;
    }

}

int main()
{
    int N, K, skill, i;
    cin >> N >> K;

    vector<Student> students;
    students.reserve(N);
    vector<Student*> pointers(N);

    for (i = 0; i < N; i++)
    {
        cin >> skill;
        students.emplace_back(skill, i, 0);
        pointers[skill - 1] = &students[i];
    }

    int team(2), count(0), M(N);
    while (M > 0)
    {
        int rightK(K), leftK(K);
        if (!doesStudentHaveATeam(students, pointers, M))
        { 
            int positionRight, positionLeft;
            positionRight =positionLeft=pointers[M - 1]->pos;
            while (rightK >= 0 && positionRight <= N - 1)
            {
                if (students[positionRight].team == 0)
                {
                    students[positionRight].team = 1 + (count % 2);
                    rightK--;
                    positionRight++;
                }
                else
                {
                    positionRight+=2*K+1;
                }
            }
            while (leftK>0&&positionLeft-1>=0)
            {
                if (students[positionLeft-1].team == 0)
                {
                    students[positionLeft-1].team = 1 + (count % 2);
                    leftK --;
                    positionLeft--;
                }
                else
                {
                    positionLeft-=2*K+1;
                }

            }
            count++;
        }
        M--;
    }
    for (const auto& s : students)
    {
        cout << s.team;
    }

    return 0;
}
