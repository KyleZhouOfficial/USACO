import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("test.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        parse(f.readLine());
    }

    private static void parse(String gamepadAction){
        float one = 0;
        float one1 = 0;
        float one2 = 0;
        float one3 = 0;
        while(!gamepadAction.isEmpty()) {
            if (gamepadAction.contains("_A")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_AP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_AR");
                }
            }
            if (gamepadAction.contains("_B")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_BP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_BR");
                }
            }
            if (gamepadAction.contains("_X")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_XP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_XR");
                }
            }
            if (gamepadAction.contains("_Y")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_YP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_YR");
                }
            }
            if (gamepadAction.contains("_D")) {
                if (gamepadAction.contains("UP")) {
                    System.out.print("_DUP");
                }
                if (gamepadAction.contains("DOWN")) {
                    System.out.print("_DDOWN");
                }
                if (gamepadAction.contains("LEFT")) {
                    System.out.print("_DDOWN");
                }
                if (gamepadAction.contains("RIGHT")) {
                    System.out.print("_DRIGHT");
                }
                if (gamepadAction.contains("NONE")) {
                    System.out.print("_NONE");
                }
            }
            if (gamepadAction.contains("_RT")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_RTP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_RTR");
                }
            }
            if (gamepadAction.contains("_LT")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_LTP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_LTR");
                }
            }
            if (gamepadAction.contains("_RB")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_RBP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_RBR");
                }
            }
            if (gamepadAction.contains("_LB")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_LBP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_LBR");
                }
            }
            if (gamepadAction.contains("_RS")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_RSP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_RSR");
                }
            }
            if (gamepadAction.contains("_LS")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_LSP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_LSR");
                }
            }
            if (gamepadAction.contains("_START")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_STARTP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_STARTR");
                }
            }
            if (gamepadAction.contains("_BACK")) {
                if (gamepadAction.contains("P")) {
                    System.out.print("_BACKP");
                } else if (gamepadAction.contains("R")) {
                    System.out.print("_BACKR");
                }
            }
            if (gamepadAction.contains("_jrx")) {
                if (gamepadAction.charAt(gamepadAction.indexOf("_jrx") + 4) != '-') {
                     one = Float.parseFloat(gamepadAction.substring(gamepadAction.indexOf("_jrx") + 4, gamepadAction.indexOf("_jrx") + 9));
                    gamepadAction = gamepadAction.substring(gamepadAction.indexOf("_jrx") + 9);
                    System.out.println(one);
                } else {
                    one = Float.parseFloat(gamepadAction.substring(gamepadAction.indexOf("_jrx") + 4, gamepadAction.indexOf("_jrx") + 10));
                    gamepadAction = gamepadAction.substring(gamepadAction.indexOf("_jrx") + 10);
                    System.out.println(one);
                }

            }
            if (gamepadAction.contains("_jry")) {
                if (gamepadAction.charAt(gamepadAction.indexOf("_jry") + 4) != '-') {
                    one1 = Float.parseFloat(gamepadAction.substring(gamepadAction.indexOf("_jry") + 4, gamepadAction.indexOf("_jry") + 9));
                    gamepadAction = gamepadAction.substring(gamepadAction.indexOf("_jry") + 9);
                    System.out.println(one1);
                } else {
                    one1 = Float.parseFloat(gamepadAction.substring(gamepadAction.indexOf("_jry") + 4, gamepadAction.indexOf("_jry") + 10));
                    gamepadAction = gamepadAction.substring(gamepadAction.indexOf("_jry") + 10);
                    System.out.println(one1);
                }
            }
            if (gamepadAction.contains("_jlx")) {
                if (gamepadAction.charAt(gamepadAction.indexOf("_jlx") + 4) != '-') {
                    one2 = Float.parseFloat(gamepadAction.substring(gamepadAction.indexOf("_jlx") + 4, gamepadAction.indexOf("_jlx") + 9));
                    gamepadAction = gamepadAction.substring(gamepadAction.indexOf("_jlx") + 9);
                    System.out.println(one2);
                } else {
                    one2 = Float.parseFloat(gamepadAction.substring(gamepadAction.indexOf("_jlx") + 4, gamepadAction.indexOf("_jlx") + 10));
                    gamepadAction = gamepadAction.substring(gamepadAction.indexOf("_jlx") + 10);
                    System.out.println(one2);
                }
            }
            if (gamepadAction.contains("_jly")) {
                if (gamepadAction.charAt(gamepadAction.indexOf("_jly") + 4) != '-') {
                    one3 = Float.parseFloat(gamepadAction.substring(gamepadAction.indexOf("_jly") + 4, gamepadAction.indexOf("_jly") + 9));
                    if(gamepadAction.indexOf("_jly") + 9 == gamepadAction.length()){
                        System.out.println(one3);
                        gamepadAction = "";
                    } else {
                        gamepadAction = gamepadAction.substring(gamepadAction.indexOf("_jly") + 9);
                        System.out.println(one3);
                    }
                } else {
                    one3 = Float.parseFloat(gamepadAction.substring(gamepadAction.indexOf("_jly") + 4, gamepadAction.indexOf("_jly") + 10));
                    if(gamepadAction.indexOf("_jly") + 10 == gamepadAction.length()){
                        System.out.println(one3);
                        gamepadAction = "";
                    } else{
                        gamepadAction = gamepadAction.substring(gamepadAction.indexOf("_jly") + 10);
                        System.out.println(one3);
                    }
                }


            }
            System.out.println(gamepadAction);
        }

        System.out.println("exit");

    }
}
