import java.io.*;
import java.util.Map;
import java.util.TreeMap;


/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: milk
*/
public class milk {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        String[] array = f.readLine().split(" ");
        int capacity = Integer.parseInt(array[0]);
        int farmers = Integer.parseInt(array[1]);
        int price = 0;
        Map<Integer, Integer> map = new TreeMap<>();


        for(int i = 0; i < farmers ; i++){
            array = f.readLine().split(" ");
            if(map.containsKey(Integer.parseInt(array[0]))){
                int temp = map.get(Integer.parseInt(array[0])) + Integer.parseInt(array[1]);
                map.put(Integer.parseInt(array[0]), temp);
            } else {
                map.put(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
            }
        }



        if(capacity == 0){
            out.println(price);
            out.close();
        }



        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(capacity >= entry.getValue()){
                capacity -= entry.getValue();
                price += entry.getKey() * entry.getValue();
            } else if( capacity < entry.getValue()){
                price += entry.getKey() * (capacity);
                capacity = 0;
            }

            if(capacity == 0){
                out.println(price);
                out.close();
                break;
            }

        }

    }
}
