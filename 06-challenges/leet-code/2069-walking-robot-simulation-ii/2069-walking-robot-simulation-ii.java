// https://leetcode.com/problems/walking-robot-simulation-ii/

// Solution: Modular Arithmetic — O(1) per step, O(1) space
class Robot {
    private int x, y, dir, w, h, perim;
    private static final int[][] DIRS = {{1,0},{0,1},{-1,0},{0,-1}};
    private static final String[] DIR_NAMES = {"East","North","West","South"};
    private int pos;

    public Robot(int width, int height) {
        w = width; h = height;
        perim = 2 * (w + h - 2);
        pos = 0; x = 0; y = 0; dir = 0;
    }

    public void step(int num) {
        pos = (pos + num) % perim;
        setPos();
    }

    private void setPos() {
        if (pos < w) { x = pos; y = 0; dir = 0; }
        else if (pos < w + h - 1) { x = w - 1; y = pos - w + 1; dir = 1; }
        else if (pos < 2 * w + h - 2) { x = w - 1 - (pos - w - h + 2); y = h - 1; dir = 2; }
        else { x = 0; y = h - 1 - (pos - 2 * w - h + 3); dir = 3; }
    }

    public int[] getPos() { return new int[]{x, y}; }
    public String getDir() { return DIR_NAMES[dir]; }
}
