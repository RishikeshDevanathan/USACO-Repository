
/*
ID: rishikesh
LANG: JAVA
TASK: measurement
*/

import java.io.*;
import java.util.*;

public class measurement
{

    public static void main(String[] args) throws IOException
    {

        FastScanner in = new FastScanner(new File("measurement.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        int n = in.nextInt();
        
        String[] names = new String[n];
        int[] day = new int[n];
        int[] data = new int[n];
        
        for (int i = 0; i < n; i++)
        {
            day[i] = in.nextInt();
            names[i] = in.next();
            data[i] = in.nextInt();
             
            
        }
        
        
         
        int[] score = {7, 7, 7}; // Bessie, Mildred, Elsie
        boolean[] on = {true, true, true}; // Bessie, Mildred, Elsie
        
        int result = 0;
        
        for (int j = 0; j < 100; j++)
        {
            for (int i = 0; i < n; i++)
            {
                if (day[i] == j)
                {
                    String element = names[i];
                    if (element.equals("Bessie"))
                        score[0] += data[i];
                    else if (element.equals("Mildred"))
                        score[1] += data[i];
                    else if (element.equals("Elsie"))
                        score[2] += data[i];
                    
                }
                
            }

            int max = Math.max(score[0], Math.max(score[1], score[2]));
            boolean[] onNext = {score[0] == max, score[1] == max, score[2] == max}; 
            
            if(onNext[0] != on[0] || onNext[1] != on[1] || onNext[2] != on[2])
                result++;
            
            on[0] = onNext[0];
            on[1] = onNext[1];
            on[2] = onNext[2];
            
        }
        
        
       
        out.println(result);
        
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
