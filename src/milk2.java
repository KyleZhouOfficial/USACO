import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: milk2
*/
public class milk2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int times = Integer.parseInt(f.readLine());
        int start1;
        int end1;
        int start2;
        int end2;

        int idle = 0;
        int max = 0;

        int time_m=0;

        int start;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < times; i++){
            String[] array1 = f.readLine().split(" ");
            start1 = Integer.parseInt(array1[0]);
            end1 = Integer.parseInt(array1[1]);
            if (map.containsKey(start1)){
                if(map.get(start1) < end1) {
                    map.put(start1, end1);
                }
            }
            else{
                map.put(start1, end1);
            }
        }

        Iterator it = map.entrySet().iterator();
        Map.Entry pair;

        int biggest=0;
        int end;

        pair = (Map.Entry) it.next();

        start1 = (Integer)pair.getKey();
        start = start1;
        end1 = (Integer) pair.getValue();
        end = end1;

        max = end1-start1;

        biggest = end1;
        int idle_t;

        boolean overlap=false;

        while (it.hasNext()) {
            overlap=false;
            pair = (Map.Entry) it.next();

            start2 = (Integer)pair.getKey();
            end2 = (Integer) pair.getValue();

            if (end2 >= biggest){
                biggest = end2;
            }

            if (start2 > end1){
                time_m = end - start;

                idle_t = start2-end1;
                if (idle_t > idle && end2== biggest){
                    idle = idle_t;
                }

                // update start
                start = start2;

                if (max < time_m){
                    max = time_m;
                }
            }
            else{
                if (end2 < end1){
                    overlap = true;
                }
                else{
                    end = end2;
                }
            }



            if (max < end-start){
                max=end-start;
            }

            if (!overlap){
                start1 = start2;
                end1 = end2;
            }
            it.remove();
        }

        out.print(max + " " + idle);
        out.println();
        out.close();


    }
}
