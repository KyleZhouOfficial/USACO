import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: friday
*/
public class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int years = Integer.parseInt(f.readLine());
        int day = 1;
        int startyear = 1900;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < years ; i++){
            boolean isLeapYear = (((startyear + i)  % 4 == 0) && ((startyear + i) % 100 != 0) || ((startyear + i) % 400 == 0));

            for(int j = 1 ; j <= 12; j++){
                int day1 = day;
                day1 += 12;
                day1 %= 7;
                if(map.containsKey(day1)){
                    map.put(day1, map.get(day1) + 1);
                }else{
                    map.put(day1, 1);
                }

                if(j == 2){
                    if(isLeapYear){
                        day += 1;
                        day %=7;
                    }
                }
                if(j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j ==10 || j == 12){
                    day += 3;
                    day %= 7;
                }
                if(j == 4 || j== 6 || j ==9 || j == 11){
                    day += 2;
                    day %= 7;
                }

            }
        }

        System.out.println(Arrays.asList(map));


        out.print(map.get(6) + " ");
        out.print(map.get(0));

        for(int i = 01; i < 6; i++){
            out.print(" " + map.get(i));

        }
        out.println();







        out.close();
    }
}
