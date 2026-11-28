// https://leetcode.com/problems/high-access-employees/

var findHighAccessEmployees = function(access_times) {
    const timesByEmp = new Map();
    for (const [name, t] of access_times) {
        const minutes = parseInt(t.slice(0, 2)) * 60 + parseInt(t.slice(2));
        if (!timesByEmp.has(name)) timesByEmp.set(name, []);
        timesByEmp.get(name).push(minutes);
    }
    const result = [];
    for (const [name, times] of timesByEmp) {
        times.sort((a, b) => a - b);
        for (let i = 0; i + 2 < times.length; i++) {
            if (times[i + 2] - times[i] < 60) {
                result.push(name);
                break;
            }
        }
    }
    return result;
};
