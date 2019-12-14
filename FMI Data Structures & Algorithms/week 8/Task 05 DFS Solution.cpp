class Solution {
    vector<int>xd{-1, 0, 1, 0}, yd{ 0,-1, 0, 1};
    int n,m,counter=0;
    
public:
    bool valid(int x, int y, vector<vector<char>>& grid) {
        return x>=0 && y>=0 && x<n && y<m && grid[x][y]=='1';
    }
    
    void dfs(int x, int y, vector<vector<char>>& grid){
        grid[x][y]='0';
        for(int i=0;i<4;++i){
            if(valid(x+xd[i],y+yd[i],grid)){
                dfs(x+xd[i],y+yd[i],grid);
            }
        }
    }    
    
    int numIslands(vector<vector<char>>& grid) {        
        n=grid.size();
        if(n==0) return 0;
        m=grid[0].size();           
        
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                        counter++;                    
                }                
            }
        }
        return counter;
    }
};
