package ACSL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bits {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("test.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        List<String> list = new ArrayList<>();
        String result = "";
        boolean lol =  false;
        for(int i = 0; i < 6; i++){
            String[] str = f.readLine().split( " ");
            int numbers = Integer.parseInt(str[0]);

            for(int j = 1; j < str.length; j++){
                list.add((str[j]));
            }

            for(int j = 0; j < list.get(0).length(); j++){
                char zeroOne = list.get(0).charAt(j);
                for(int k = 1; k < list.size(); k++){
                    if (list.get(k).charAt(j) != zeroOne){
                        lol = true;
                        result += "*";
                        break;
                    }
                }

                if(lol == false){
                    result += zeroOne;
                }

                lol = false;
            }

            if((!result.contains("0") && !result.contains("1")) && Math.pow(2, list.get(0).length()) != numbers){
                System.out.println("NONE");
            } else{
                System.out.println(result);
            }





            result = "";






            list.clear();
        }
    }




}
