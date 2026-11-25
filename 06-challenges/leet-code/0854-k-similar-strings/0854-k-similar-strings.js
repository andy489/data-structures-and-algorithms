// https://leetcode.com/problems/k-similar-strings/

var kSimilarity = function(s1, s2) {
    const queue = [s1];
    const visited = new Set([s1]);
    let steps = 0;
    while (queue.length) {
        const size = queue.length;
        for (let q = 0; q < size; q++) {
            const curr = queue.shift();
            if (curr === s2) return steps;
            let i = 0;
            while (curr[i] === s2[i]) i++;
            const arr = curr.split('');
            for (let j = i + 1; j < arr.length; j++) {
                if (arr[j] === s2[i]) {
                    [arr[i], arr[j]] = [arr[j], arr[i]];
                    const next = arr.join('');
                    if (!visited.has(next)) {
                        visited.add(next);
                        queue.push(next);
                    }
                    [arr[i], arr[j]] = [arr[j], arr[i]];
                }
            }
        }
        steps++;
    }
    return steps;
};
