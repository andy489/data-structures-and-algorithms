// https://leetcode.com/problems/subrectangle-queries/

// Solution: Lazy Log (Stack of Updates) — O(1) update, O(updates) query time, O(updates) space
class SubrectangleQueries {
    private int[][] rect;
    private List<int[]> updates = new ArrayList<>();
    public SubrectangleQueries(int[][] rectangle) { this.rect = rectangle; }
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        updates.add(new int[]{row1,col1,row2,col2,newValue});
    }
    public int getValue(int row, int col) {
        for (int i = updates.size()-1; i >= 0; i--) {
            int[] u = updates.get(i);
            if (row>=u[0]&&row<=u[2]&&col>=u[1]&&col<=u[3]) return u[4];
        }
        return rect[row][col];
    }
}
