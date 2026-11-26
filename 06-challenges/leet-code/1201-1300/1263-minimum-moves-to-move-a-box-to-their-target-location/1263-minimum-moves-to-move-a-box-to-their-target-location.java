// https://leetcode.com/problems/minimum-moves-to-move-a-box-to-their-target-location/

// Solution: BFS (0-1 BFS or Dijkstra) — O((m*n)^2) time, O((m*n)^2) space
// Solution: Dijkstra BFS — O((m*n)^2) time, O((m*n)^2) space
class Solution {
    int m, n;
    char[][] grid;
    int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    public int minPushBox(char[][] grid) {
        this.grid = grid; m = grid.length; n = grid[0].length;
        int[] box = null, player = null;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (grid[i][j]=='B') box = new int[]{i,j};
            if (grid[i][j]=='S') player = new int[]{i,j};
        }
        int[][][] dist = new int[m][n][m*n];
        for (int[][] a : dist) for (int[] b : a) java.util.Arrays.fill(b, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0, box[0], box[1], player[0], player[1]});
        dist[box[0]][box[1]][player[0]*n+player[1]] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost=cur[0],br=cur[1],bc=cur[2],pr=cur[3],pc=cur[4];
            if (grid[br][bc]=='T') return cost;
            if (cost > dist[br][bc][pr*n+pc]) continue;
            for (int d = 0; d < 4; d++) {
                int nbr=br+dr[d],nbc=bc+dc[d];
                if (nbr<0||nbr>=m||nbc<0||nbc>=n||grid[nbr][nbc]=='#') continue;
                int pushR=br-dr[d],pushC=bc-dc[d];
                if (pushR<0||pushR>=m||pushC<0||pushC>=n||grid[pushR][pushC]=='#') continue;
                if (canReach(pr,pc,pushR,pushC,br,bc)) {
                    int nd = cost+1;
                    if (nd < dist[nbr][nbc][br*n+bc]) { dist[nbr][nbc][br*n+bc]=nd; pq.add(new int[]{nd,nbr,nbc,br,bc}); }
                }
            }
        }
        return -1;
    }

    boolean canReach(int sr,int sc,int tr,int tc,int br,int bc) {
        if (sr==tr&&sc==tc) return true;
        boolean[][] vis = new boolean[m][n]; vis[sr][sc]=true;
        Deque<int[]> q = new ArrayDeque<>(); q.add(new int[]{sr,sc});
        while (!q.isEmpty()) {
            int[] cur=q.poll(); int r=cur[0],c=cur[1];
            for (int d=0;d<4;d++) {
                int nr=r+dr[d],nc=c+dc[d];
                if (nr<0||nr>=m||nc<0||nc>=n||grid[nr][nc]=='#'||(nr==br&&nc==bc)||vis[nr][nc]) continue;
                if (nr==tr&&nc==tc) return true;
                vis[nr][nc]=true; q.add(new int[]{nr,nc});
            }
        }
        return false;
    }
}
