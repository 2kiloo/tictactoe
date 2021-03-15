import java.util.*;

/*
 * there is a problem.....mark already there
 *
 * */
public class Main {

    static ArrayList<Integer> playPos = new ArrayList<>();
    static ArrayList<Integer> cpuPos = new ArrayList<>();

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}, {'-', '+', '-', '+', '-'}, {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        while (true) {
            int inputPlayer = getInput();
            while(playPos.contains(inputPlayer) || cpuPos.contains(inputPlayer)){
                inputPlayer = getInput();
            }

            setMart("player", inputPlayer, gameBoard);
            System.out.println(winner());


            Random rand = new Random();
            int inputCpu = rand.nextInt(9);
            while(playPos.contains(inputCpu) || cpuPos.contains(inputCpu)){
                inputCpu = rand.nextInt();
            }
            setMart("cpu", inputCpu, gameBoard);
            printGameBoard(gameBoard);
           System.out.println(winner());




        }


    }

    //print the board
    public static void printGameBoard(char[][] gameBoard) {
        for (char[] c : gameBoard) {
            for (char ch : c) {
                System.out.print(ch);
            }
            System.out.print("\n");

        }
    }

    // get the input
    public static int getInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("PLEASE ENTER NEW POSITION");
        int in = input.nextInt();
        while (in < 0 || in > 8) {
            System.out.println("ERROR: INVALID POSITION PLEASE ENTER NEW POSITION");
            in = input.nextInt();
        }
        return in;
    }

    // set the mark on the board
    public static void setMart(String user, int pos, char[][] gameBoard) {
        char mark = ' ';
        if (user.equals("player")) {
            mark = 'X';
            playPos.add(pos);
        } else if (user.equals("cpu")) {
            mark = 'O';
            cpuPos.add(pos);
        } else {
            System.out.println("Invalide Mark");
        }

        switch (pos) {
            case 0:
                gameBoard[0][0] = mark;

                break;
            case 1:

                gameBoard[0][2] = mark;

                break;
            case 2:

                gameBoard[0][4] = mark;

                break;
            case 3:

                gameBoard[2][0] = mark;

                break;
            case 4:

                gameBoard[2][2] = mark;

                break;
            case 5:

                gameBoard[2][4] = mark;

                break;
            case 6:

                gameBoard[4][0] = mark;

                break;
            case 7:

                gameBoard[4][2] = mark;

                break;
            case 8:

                gameBoard[4][4] = mark;

                break;


        }

    }

//    public static boolean win(char[][] gameBoard, char mark) {
//        boolean win = false;
//        //first column
//        if (gameBoard[0][0] == gameBoard[0][2] && gameBoard[0][0] == gameBoard[0][4] && mark == gameBoard[0][0]) {
//            win = true;
//            return win;
//        }
//        //second column
//        if (gameBoard[2][0] == gameBoard[2][2] && gameBoard[2][0] == gameBoard[2][4] && mark == gameBoard[2][0]) {
//            win = true;
//            return win;
//        }
//        //third column
//        if (gameBoard[4][0] == gameBoard[4][2] && gameBoard[4][0] == gameBoard[4][4] && mark == gameBoard[4][0]) {
//            win = true;
//            return win;
//        }
//        //first row
//        if (gameBoard[0][0] == gameBoard[2][0] && gameBoard[0][0] == gameBoard[4][0] && mark == gameBoard[0][0]) {
//            win = true;
//            return win;
//        }
//        //second row
//        if (gameBoard[0][2] == gameBoard[2][2] && gameBoard[0][2] == gameBoard[4][2] && mark == gameBoard[0][2]) {
//            win = true;
//            return win;
//        }
//        //third row
//        if (gameBoard[0][4] == gameBoard[2][4] && gameBoard[0][0] == gameBoard[4][4] && mark == gameBoard[0][4]) {
//            win = true;
//            return win;
//        }
//
//        return win;
//    }

    public static String winner() {
        List<Integer> topRow = Arrays.asList(0, 1, 2);
        List<Integer> middleRow = Arrays.asList(3, 4, 5);
        List<Integer> botRow = Arrays.asList(6, 7, 8);
        List<Integer> leftCol = Arrays.asList(0, 3, 6);
        List<Integer> midCol = Arrays.asList(1, 4, 7);
        List<Integer> rightCol = Arrays.asList(2, 5, 8);

        List<List> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);

        for (List l : winning) {
            if (playPos.containsAll(l))
                return "Congrats you won!";
            else if (cpuPos.containsAll(l))
                return "cpu won";
            else if (cpuPos.size() + playPos.size() == 9)
                return "draw";

        }
        return "";
    }


}



