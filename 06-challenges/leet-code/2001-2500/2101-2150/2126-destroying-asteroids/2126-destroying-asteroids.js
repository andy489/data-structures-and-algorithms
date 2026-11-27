// https://leetcode.com/problems/destroying-asteroids/
var asteroidsDestroyed = function(mass, asteroids) {
    asteroids.sort((a, b) => a - b);
    let currentMass = mass;
    for (const a of asteroids) {
        if (currentMass < a) return false;
        currentMass += a;
    }
    return true;
};
