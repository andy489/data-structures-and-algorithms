// https://leetcode.com/problems/smallest-sufficient-team/

var smallestSufficientTeam = function(req_skills, people) {
    const n = req_skills.length;
    const skillIndex = new Map(req_skills.map((s, i) => [s, i]));
    const full = (1 << n) - 1;
    const dp = new Array(full + 1).fill(null);
    dp[0] = [];

    for (let i = 0; i < people.length; i++) {
        let pmask = 0;
        for (const s of people[i]) {
            pmask |= 1 << skillIndex.get(s);
        }
        for (let mask = full; mask >= 0; mask--) {
            if (dp[mask] === null) { continue; }
            const next = mask | pmask;
            if (dp[next] === null || dp[next].length > dp[mask].length + 1) {
                dp[next] = [...dp[mask], i];
            }
        }
    }

    return dp[full];
};
