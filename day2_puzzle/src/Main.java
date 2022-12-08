import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReader(new File("./strategy.txt"));

        ArrayList<String> games = reader.readFile();

        int myScore = 0;

        for (String game : games) {
            String[] gamePick = game.split(" ");
            if(gamePick[0].equals("A")){
                if(gamePick[1].equals("X")){
                    myScore +=(1+3);
                } else if(gamePick[1].equals("Y")){
                    myScore +=(2+6);
                }else if(gamePick[1].equals("Z")){
                    myScore += (0+3);
                }
            } else if(gamePick[0].equals("B")){
                if(gamePick[1].equals("X")){
                    myScore +=(1+0);
                } else if(gamePick[1].equals("Y")){
                    myScore +=(2+3);
                }else if(gamePick[1].equals("Z")){
                    myScore += (3+6);
                }
            } else if(gamePick[0].equals("C")){
                if(gamePick[1].equals("X")){
                    myScore +=(1+6);
                } else if(gamePick[1].equals("Y")){
                    myScore +=(2+0);
                }else if(gamePick[1].equals("Z")){
                    myScore += (3+3);
                }
            }
        }
        System.out.println(myScore);
        int WIN = 6;
        int DRAW = 3;
        int LOOSE = 0;

        int ROCK = 1;
        int PAPER = 2;
        int SCISSOR = 3;

        int myNewScore = 0;
        for (String game : games) {
            String[] gamePick = game.split(" ");

            //Rock
            if(gamePick[0].equals("A")){

                if(gamePick[1].equals("X")){
                    myNewScore +=(SCISSOR+LOOSE);
                } else if(gamePick[1].equals("Y")){
                    myNewScore +=(ROCK+DRAW);
                }else if(gamePick[1].equals("Z")){
                    myNewScore += (PAPER+WIN);
                }
                //Paper
            } else if(gamePick[0].equals("B")){
                if(gamePick[1].equals("X")){
                    myNewScore +=(ROCK+LOOSE);
                } else if(gamePick[1].equals("Y")){
                    myNewScore +=(PAPER+DRAW);
                }else if(gamePick[1].equals("Z")){
                    myNewScore += (SCISSOR+WIN);
                }
                //Scissor
            } else if(gamePick[0].equals("C")){
                if(gamePick[1].equals("X")){
                    myNewScore +=(PAPER+LOOSE);
                } else if(gamePick[1].equals("Y")){
                    myNewScore +=(SCISSOR+DRAW);
                }else if(gamePick[1].equals("Z")){
                    myNewScore += (ROCK+WIN);
                }
            }
        }
        System.out.println(myNewScore);
    }
}