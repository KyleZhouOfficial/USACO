import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: gift1
*/
public class gift1 {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int friends = 0;
        friends = Integer.parseInt(f.readLine());
        f.mark(0);
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] finish = new String[friends];
        for(int i = 0; i < friends; i++){
            finish[i] = f.readLine();
        }
        f.reset();
        for(int i = 0; i < friends; i++){
            map.put(f.readLine(), 0);
        }




        String person = "";
        int money = -1;
        int split = -1;
        int dough = 0;
        String person1 = "";
        for(int j = 0; j < friends; j++){
            person = f.readLine();
            String[]numbers = f.readLine().split(" ");
            money = Integer.parseInt(numbers[0]);
            split = Integer.parseInt(numbers[1]);
            if(split == 0){
                continue;
            }

            map.put(person, map.get(person) + -money + (money % split));

            for(int i = 0; i < split; i++){
                person1 = f.readLine();
                dough = map.get(person1);
                dough += money/split;
                map.put(person1, dough);
            }

        }


        for(int i = 0; i < finish.length; i++){
            out.print(finish[i] + " ");
            out.println(map.get(finish[i]));

        }

        out.close();

    }


}
