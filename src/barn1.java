import java.io.*;
import java.util.*;
import java.util.Map.*;

/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: barn1
*/
public class barn1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

        String[] array = f.readLine().split(" ");
        int maxBoards = Integer.parseInt(array[0]);
        int totalStalls = Integer.parseInt(array[1]);
        int cows = Integer.parseInt(array[2]);
        int[] cowindex = new int[cows];
        ArrayList<Integer> cuts = new ArrayList<>();
        HashMap<Integer, Integer> gaps = new HashMap<>();
        int covered = 0;

        for(int i = 0; i < cows; i++){
            cowindex[i] = Integer.parseInt(f.readLine());
        }

        Arrays.sort(cowindex);

        for(int i = 1; i < cows; i++){
            gaps.put(cowindex[i-1], cowindex[i] - cowindex[i - 1]);
        }


        gaps = sortByValue(gaps);

        if(maxBoards > gaps.size()){
            out.println(gaps.size() + 1);
            out.close();
            System.exit(0);
        }

        cuts.add(cowindex[0]);
        cuts.add(cowindex[cows - 1]);

        Map.Entry obj = null;
        Iterator it = gaps.entrySet().iterator();

        while(cuts.size() != maxBoards * 2){

                if(it.hasNext()){
                    obj = (Entry) it.next();

                    cuts.add( (int) obj.getKey());
                    cuts.add( (int) obj.getValue() +  (int) obj.getKey());
            }

        }
        Collections.sort(cuts);

        for(int i = 0; i < cuts.size(); i += 2){
            covered += distance(i, i + 1, cuts);
        }

        out.println(covered);
        out.close();




    }

    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }



    private static int distance(int start, int end, ArrayList<Integer> cowindex){
        return cowindex.get(end) - cowindex.get(start) + 1;
    }




}
