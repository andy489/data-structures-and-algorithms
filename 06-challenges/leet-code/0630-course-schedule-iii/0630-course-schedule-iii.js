// https://leetcode.com/problems/course-schedule-iii/

var scheduleCourse = function(courses) {
    courses.sort((a, b) => a[1] - b[1]);
    // Max heap via sorted array (small n for this problem)
    const taken = [];
    let time = 0;
    for (const [duration, lastDay] of courses) {
        time += duration;
        taken.push(duration);
        taken.sort((a, b) => b - a);
        if (time > lastDay) {
            time -= taken.shift();
        }
    }
    return taken.length;
};
