// https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/

var minTime = function(skill, mana) {
    const n = skill.length;
    const prefSkill = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefSkill[i + 1] = prefSkill[i] + skill[i];
    }

    const done = new Array(n).fill(0);

    for (const mj of mana) {
        let t = 0;
        for (let i = 0; i < n; i++) {
            t = Math.max(t, done[i] - prefSkill[i] * mj);
        }
        for (let i = 0; i < n; i++) {
            done[i] = t + prefSkill[i + 1] * mj;
        }
    }

    return done[n - 1];
};
