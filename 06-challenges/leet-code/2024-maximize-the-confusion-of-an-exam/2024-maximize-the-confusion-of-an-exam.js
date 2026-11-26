// https://leetcode.com/problems/maximize-the-confusion-of-an-exam/

// Solution: Sliding Window — O(n) time, O(1) space
var maxConsecutiveAnswers = function(answerKey, k) {
    const maxWin = (flip) => {
        let l = 0, cnt = 0, res = 0;
        for (let r = 0; r < answerKey.length; r++) {
            if (answerKey[r] === flip) cnt++;
            while (cnt > k) { if (answerKey[l++] === flip) cnt--; }
            res = Math.max(res, r - l + 1);
        }
        return res;
    };
    return Math.max(maxWin('T'), maxWin('F'));
};
