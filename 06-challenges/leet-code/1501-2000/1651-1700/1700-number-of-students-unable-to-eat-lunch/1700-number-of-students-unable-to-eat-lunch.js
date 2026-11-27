// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

var countStudents = function(students, sandwiches) {
    const count = [0, 0];
    for (const s of students) {
        count[s]++;
    }
    for (const sandwich of sandwiches) {
        if (count[sandwich] === 0) {
            return count[0] + count[1];
        }
        count[sandwich]--;
    }
    return 0;
};
