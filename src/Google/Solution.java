package Google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        File file = new File("test.in");
//        try(Scanner in = new Scanner(file, StandardCharsets.UTF_8.name())) {
        Scanner in = new Scanner(System.in);
        int testcases = Integer.parseInt(in.nextLine());
        int numberOfBuildings;
        int left;
        int right;
        int numberOfHighest;
        int numberAtLeft;
        int numberAtRight;


        for(int i = 0; i < testcases; i++){
            String[] input = in.nextLine().split(" ");
            numberOfBuildings = Integer.parseInt(input[0]);
            left =  Integer.parseInt(input[1]);
            right =  Integer.parseInt(input[2]);
            numberOfHighest =  Integer.parseInt(input[3]);


            if(right + left > numberOfBuildings + numberOfHighest ||
            left < numberOfHighest || right < numberOfHighest || numberOfHighest == 0 || left == 0 || right == 0 || numberOfBuildings == 0){
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else{


                if(left == numberOfHighest){
                    numberAtLeft = 0;
                } else{
                    numberAtLeft = left - numberOfHighest;
                    if(left >= right){
                        numberAtLeft++;
                    }
                }
                if(right == numberOfHighest){
                    numberAtRight = 0;
                }else{
                    numberAtRight = right - numberOfHighest;
                    if(left < right){
                        numberAtRight++;
                    }
                }

                if(numberAtLeft == 0){
                    numberAtRight = numberOfBuildings - numberOfHighest;
                }
                if(numberAtRight == 0){
                    numberAtLeft = numberOfBuildings - numberOfHighest;
                }



                List<Integer> leftList = new ArrayList<>();
                List<Integer> rightList = new ArrayList<>();
                List<Integer> middleList = new ArrayList<>();
                for(int j = 0; j < numberOfHighest; j++) {
                    middleList.add(numberOfBuildings);
                }

                for(int j = 0; j < numberAtLeft; j++){
                    leftList.add(1);
                }

                for(int j = 0; j < numberAtRight; j++){
                    rightList.add(1);
                }

                if(rightList.size() + numberOfHighest > right){
                    int diff = rightList.size() + numberOfHighest - right;
                    for(int k = 1; k <= diff; k++){
                        rightList.set(k, k + 1);
                    }
                }

                if(leftList.size() + numberOfHighest > left){
                    int diff1 = leftList.size() + numberOfHighest - left;
                    for(int k = 1; k <= diff1; k++){
                        leftList.set(k, k + 1);
                    }
                    Collections.reverse(leftList);
                }

                List<Integer> finish = new ArrayList<>();
                finish.addAll(leftList);
                finish.addAll(middleList);
                finish.addAll(rightList);
                System.out.print("Case #" + (i + 1) + ": ");
                for(int l: finish){
                    System.out.print(l + " ");
                }
                System.out.println();

            }

        }
//        }catch (IOException e){
//            System.out.println(e);
//        }

    }


}
