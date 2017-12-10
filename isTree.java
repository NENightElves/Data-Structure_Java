public class isTree
{
    static int num_node=0,num_edge=0;
    static final int N=5;
    static final int FLAG_SELF=0;
    static final int FLAG_CONN=1;
    static final int FLAG_NCONN=2;
    static int[][] a=new int[100][100];
    static boolean[] visited=new boolean[100];
    static boolean flag=true;

    public static void main(String[] args)
    {
        int i,j;
        for(i=0;i<=99;i++)
        {
            for(j=0;j<=99;j++)
                a[i][j]=0;
            visited[i]=false;
        }
        a[1][2]=1;
        a[2][3]=1;
        a[3][4]=1;
        a[3][5]=1;
        visited[1]=true;
        DFS(1);
        System.out.println(flag);
    }

    public static void DFS(int x)
    {
        int i;
        for(i=x+1;i<=N;i++)
            if (a[x][i]==FLAG_CONN)
                if (visited[i]==true)
                {
                    flag=false;
                    return;
                }
                else
                {
                    visited[i]=true;
                    a[x][i]=FLAG_NCONN;
                    DFS(i);
                }
    }

}