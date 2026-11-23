// https://leetcode.com/problems/queue-reconstruction-by-height/

var reconstructQueue = function(people) {
    people.sort((a, b) => a[0] !== b[0] ? b[0] - a[0] : a[1] - b[1]);
    const queue = [];
    for (const person of people) {
        queue.splice(person[1], 0, person);
    }
    return queue;
};
