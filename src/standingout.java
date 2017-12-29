
/*
ID: rishikesh
LANG: JAVA
TASK: standingout
*/
import java.io.*;
import java.util.*;

public class standingout
{

    public static void main(String[] args) throws IOException
    {

        FastScanner in = new FastScanner(new File("standingout.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("standingout.out")));
        

        int n = in.nextInt();
        HashMap<String, String[]> inputs = new HashMap<String, String[]>();

        int[] matches = new int[n];

        for (int i = 0; i < n; i++)
        {
            String element = in.next();
            String[] perms = permutate(element);
            inputs.put(element, perms);

            matches[i] = perms.length;

        }

        for (int i = 0; i < n; i++)
        {

            for (int j = i + 1; j < n; j++)
            {
                String StringI = inputs.keySet().toArray()[i].toString();
                String StringJ = inputs.keySet().toArray()[j].toString();

                for (int counterI = 0; counterI < inputs.get(StringI).length; counterI++)
                {

                    for (int counterJ = 0; counterJ < inputs.get(StringJ).length; counterJ++)
                    {

                        if (inputs.get(StringI)[counterI].equals(inputs.get(StringJ)[counterJ]))
                        {

                            matches[i]--;
                            matches[j]--;

                            // System.out.println(matches[i] + " " + matches[j]);

                        }
                    }

                }
            }
        }

        for (int i = 0; i < matches.length; i++)
        {
            out.println(matches[i]);
        }

        out.close();
    }

    private static String[] permutate(String input)
    {
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < input.length(); i++)
        {
            for (int j = i + 1; j <= input.length(); j++)
            {
                String perm = input.substring(i, j);

                if (!result.contains(perm))
                    result.add(perm);
            }

        }


        return result.toArray(new String[result.size()]);
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