// https://leetcode.com/problems/destroying-asteroids/
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentMass = mass;
        for (int asteroid : asteroids) {
            if (currentMass < asteroid) {
                return false;
            }
            currentMass += asteroid;
        }
        return true;
    }
}
