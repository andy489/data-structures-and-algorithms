class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> distinct = new HashSet<>();
        for (int c : candyType) {
            distinct.add(c);
        }
        return Math.min(candyType.length / 2, distinct.size());
    }
}
