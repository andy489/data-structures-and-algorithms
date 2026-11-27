// https://leetcode.com/problems/score-validator/

/**
 * @param {string[]} events
 * @return {number[]}
 */
var scoreValidator = function(events) {
    let score = 0, counter = 0;
    for (const e of events) {
        if (e === "W") {
            counter++;
            if (counter === 10) {
                break;
            }
        } else if (e === "WD" || e === "NB") {
            score += 1;
        } else {
            score += parseInt(e);
        }
    }
    return [score, counter];
};
