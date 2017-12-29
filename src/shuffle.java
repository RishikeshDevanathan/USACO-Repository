
/*
ID: rishikesh
LANG: JAVA
TASK: shuffle
*/

import java.io.*;
import java.util.*;

public class shuffle
{

    public static void main(String[] args) throws IOException
    {

        FastScanner in = new FastScanner(new File("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

        int n = in.nextInt();

        int[] moves = new int[n];
        int[] finalID = new int[n];

        for (int i = 0; i < n * 2; i++)
        {
            if (i < n)
                moves[i] = in.nextInt();
            else
                finalID[i - n] = in.nextInt();
        }

        for (int times = 0; times < 3; times++)
        {
            int[] result = Arrays.copyOf(finalID, finalID.length);

            for (int i = n - 1; i >= 0; i--)
            {
                result[i] = finalID[moves[i] - 1];
            }

            finalID = result;
        }

        for (int i : finalID)
            out.println(i);

        out.close();
    }

    static class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File i) throws IOException
        {
            br = new BufferedReader(new FileReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException
        {
            if (st.hasMoreTokens())
                return st.nextToken();
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }

        public int nextInt() throws IOException
        {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException
        {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException
        {
            if (!st.hasMoreTokens())
                return br.readLine();
            String ret = st.nextToken();
            while (st.hasMoreTokens())
                ret += " " + st.nextToken();
            return ret;
        }
    }
}
