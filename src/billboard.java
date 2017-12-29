
/*
ID: rishikesh
LANG: JAVA
TASK: billboard
*/

import java.io.*;
import java.util.*;


public class billboard
{
    

    public static void main(String[] args) throws IOException
    {

        FastScanner in = new FastScanner(new File("billboard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));


        Rectangle b1 = new Rectangle(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        Rectangle b2 = new Rectangle(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        Rectangle truck = new Rectangle(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());

        int x_overlap = Math.max(0, Math.min(b1.right, truck.right) - Math.max(b1.left, truck.left));
        int y_overlap = Math.max(0, Math.min(b1.bottom, truck.bottom) - Math.max(b1.top, truck.top));
        int overlapArea = x_overlap * y_overlap;
        
        int x_overlapA = Math.max(0, Math.min(b2.right, truck.right) - Math.max(b2.left, truck.left));
        int y_overlapA = Math.max(0, Math.min(b2.bottom, truck.bottom) - Math.max(b2.top, truck.top));
        int overlapAreaA = x_overlapA * y_overlapA;
        
        out.print(((b1.right - b1.left) * (b1.bottom - b1.top)) + ((b2.right - b2.left) * (b2.bottom - b2.top))
                - (overlapArea + overlapAreaA));
        
        out.close();
    }

    
    static class FastScanner{
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(File i) throws IOException{
            br = new BufferedReader(new FileReader(i));
            st = new StringTokenizer("");
        }
        public String next() throws IOException {
            if(st.hasMoreTokens())
                return st.nextToken();
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public String nextLine() throws IOException {
            if(!st.hasMoreTokens())
                return br.readLine();
            String ret = st.nextToken();
            while(st.hasMoreTokens())
                ret += " " + st.nextToken();
            return ret;
        }
    }
}

class Rectangle
{

    public int left, right;
    public int top, bottom;
    
    public Rectangle(int x1, int y1, int x2, int y2)
    {

        left = x1;
        right = x2;
        top = y1;
        bottom = y2;
    }
}