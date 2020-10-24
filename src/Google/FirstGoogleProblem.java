

import java.util.Scanner;

public class FirstGoogleProblem {
    public static void main(String[] args) {
//        File file = new File("test.in");
//        try(Scanner in = new Scanner(file, StandardCharsets.UTF_8.name())) {
            Scanner in = new Scanner(System.in);
            int testCases = Integer.parseInt(in.nextLine());
            int arraySize;

            for (int i = 0; i < testCases; i++) {
                arraySize = Integer.parseInt(in.nextLine());
                int count = 1;
                int largest = -1;
                String[] temp = in.nextLine().split(" ");
                int diff = Integer.parseInt(temp[1]) - Integer.parseInt(temp[0]);
                if(temp.length <= 2 ){
                    System.out.println("Case #" + (i + 1) + ": " + temp.length);
                }else{
                    for (int j = 1; j < arraySize - 1; j++) {
                        if (Integer.parseInt(temp[j + 1]) - Integer.parseInt(temp[j]) == diff) {
                            count++;

                        } else {
                            diff = Integer.parseInt(temp[j + 1]) - Integer.parseInt(temp[j]);
                            count = 1;
                        }
                        if(largest < count){
                            largest = count;
                        }
                    }

                    largest += 1;
                    System.out.println("Case #" + (i + 1) + ": " + largest);
                }

            }
//        }catch (IOException e){
//
//        }
    }
}
