#include <bits/stdc++.h>
using namespace std;

const int INF=1000000000;
const long double EPS=1e-9;

char maZe[25][25];
int tonnel[25][25];
int indx[25][25];
char used[25][25];
int N=0;
int n,m;

long double a[407][407];
long double c[407];

int getType(int x, int y) //0-empty, 1-no way, 2 - exit, 3-mine
{
    if (x<0 || x>=n || y<0 || y>=m) return 1;
    if (maZe[x][y]=='O' || maZe[x][y]=='A') return 0;
    if (maZe[x][y]=='#') return 1;
    if (maZe[x][y]=='%') return 2;
    if (maZe[x][y]=='*') return 3;
    return 100;
}

int getIndex(int x, int y)
{
    if(indx[x][y]==-1)
    {
        indx[x][y]=N;
        N++;
    }
    return indx[x][y];
}

void dfs(int x, int y)
{
    if(x<0 || x>=n || y<0 || y>=m || used[x][y]==1 || getType(x,y)!=0)return;
    used[x][y]=1;

    int z = getIndex(x,y);

    int h=0,r=0;
    int xx=x;
    int yy=y;

    if(tonnel[x][y]!=-1)
    {
        xx = tonnel[x][y]/100;
        yy = tonnel[x][y]%100;
    }

    if(getType(xx-1,yy)!=1)h++;
    if(getType(xx,yy-1)!=1)h++;
    if(getType(xx+1,yy)!=1)h++;
    if(getType(xx,yy+1)!=1)h++;

    if(getType(xx-1,yy)==2)r++;
    if(getType(xx,yy-1)==2)r++;
    if(getType(xx+1,yy)==2)r++;
    if(getType(xx,yy+1)==2)r++;

    if(h==0)
    {
        a[z][z]=1;
        return;
    }

    if(getType(xx-1,yy)==0) a[z][getIndex(xx-1,yy)]=-1;
    if(getType(xx,yy-1)==0) a[z][getIndex(xx,yy-1)]=-1;
    if(getType(xx+1,yy)==0) a[z][getIndex(xx+1,yy)]=-1;
    if(getType(xx,yy+1)==0) a[z][getIndex(xx,yy+1)]=-1;

    a[z][z]+=h;
    c[z]=r;

    dfs(xx-1,yy);
    dfs(xx,yy-1);
    dfs(xx+1,yy);
    dfs(xx,yy+1);
}


int gauss (vector < vector<long double> > a, vector<long double> & ans) {
    int n = (int) a.size();
    int m = (int) a[0].size() - 1;

    vector<int> where (m, -1);
    for (int col=0, row=0; col<m && row<n; ++col) {
        int sel = row;
        for (int i=row; i<n; ++i)
            if (abs (a[i][col]) > abs (a[sel][col]))
                sel = i;
        if (abs (a[sel][col]) < EPS)
            continue;
        for (int i=col; i<=m; ++i)
            swap (a[sel][i], a[row][i]);
        where[col] = row;

        for (int i=0; i<n; ++i)
            if (i != row) {
                long double c = a[i][col] / a[row][col];
                for (int j=col; j<=m; ++j)
                    a[i][j] -= a[row][j] * c;
            }
        ++row;
    }

    ans.assign (m, 0);
    for (int i=0; i<m; ++i)
        if (where[i] != -1)
            ans[i] = a[where[i]][m] / a[where[i]][i];
    for (int i=0; i<n; ++i) {
        long double sum = 0;
        for (int j=0; j<m; ++j)
            sum += ans[j] * a[i][j];
        if (abs (sum - a[i][m]) > EPS)
            return 0;
    }

    for (int i=0; i<m; ++i)
        if (where[i] == -1)
            return INF;
    return 1;
}


int main()
{
    int k,i,j;
    int x1,x2,y1,y2,xa,ya;

    scanf("%d %d %d",&n,&m,&k);

    for(i=0;i<n;i++)
        scanf("%s", maZe[i]);

    for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        {
            indx[i][j]=-1;
            tonnel[i][j]=-1;
            used[i][j]=0;

            if(maZe[i][j]=='A')
            {
                xa=i;
                ya=j;
            }
        }


    for(i=0;i<k;i++)
    {
        scanf("%d %d %d %d",&x1,&y1,&x2,&y2);
        x1--;x2--;y1--;y2--;

        tonnel[x1][y1]=100*x2+(y2);
        tonnel[x2][y2]=100*x1+(y1);
    }


    for(i=0;i<400;i++)
    {
        for(j=0;j<400;j++)a[i][j]=0;
        c[i]=0;
    }

    dfs(xa,ya);

    char NoExit=1;
    for(int i=0;i<N;i++){if(c[i]!=0)NoExit=0;}
    if(NoExit)
    {
        printf("0\n");
        return 0;
    }

    vector<vector<long double> > aa;
    aa.resize(N);
    for(i=0;i<N;i++)
    {
        aa[i].resize(N+1);
        for(j=0;j<N;j++)aa[i][j]=a[i][j];
        aa[i][N]=c[i];
    }

    vector<long double> ans;

    int z = gauss(aa,ans);

    cout<< fixed<<setprecision(10);
    cout<< ans[getIndex(xa,ya)]<<"\n";

    return 0;
}
