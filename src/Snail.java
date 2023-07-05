public class Snail {
    public static int curDirection=0;
    public static int[] dx = new int[] {0,1,0,-1};
    public static int[] dy = new int[] {1,0,-1,0};
    static int n=7, curX=0, curY=0;
    static int[][] snail = new int[n][n];

    public static void main(String[] args)
    {
        int curNum=1; snail[0][0]=1;

        while (curNum < n*n)                //Creating
        {
            if (isForwardOK()){
                curX += dx[curDirection];
                curY += dy[curDirection];
                curNum++;
                snail[curX][curY] = curNum;
            }
            else {
                changeDirection();
            }
        }

        for (int x=0; x<n; x++)                 //Printing
        {
            for(int y=0; y<n; y++)
            {
                if(snail[x][y]<10) System.out.print("0");
                System.out.print(snail[x][y]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isForwardOK(){        //Check next position
        int cx = curX + dx[curDirection];
        int cy = curY + dy[curDirection];

        if (cx==n || cy==n || cy==-1) return false;
        return snail[cx][cy] <= 0;  //return false if element is not empty and true when is
    }

    public static void changeDirection(){
        curDirection = (curDirection+1)%4;
    }
}