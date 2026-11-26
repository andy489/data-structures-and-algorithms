// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/

// Solution: Sort Both Arrays — O(n log n) time, O(1) space
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) { moves += Math.abs(seats[i] - students[i]); }
        return moves;
    }
}
