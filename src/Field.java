import java.util.Arrays;
import java.util.Scanner;

public class Field {
    //initialize Scanner for UserInput
    static Scanner scanner = new Scanner(System.in);
    //initialize Array for the field
    static char[][] field = new char[3][3];
    Player[] players;
    static Player currentPlayer;

    public Field(Player[] players) {

        //initialize players
        this.players = players;

        //fill Array with blank spaces
        cycleThroughWholeArray();

        //chose by random which player starts
        if (Math.random() < 0.5) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];
        }

        //currentPlayer = players[0];

    }

    private static void cycleThroughWholeArray() {
        //fill Array with blank spaces
        for (char[] chars : field) {
            Arrays.fill(chars, ' ');
        }
    }

    public static void drawField() {
        System.out.println("    |  1  |  2  |  3  |");
        for (int i = 0; i < 3; i++) {
            System.out.println("  --------------------");
            System.out.println("  " + (i + 1) + " |  " + field[i][0] + "  |  " + field[i][1] + "  |  " + field[i][2] + "  |");
            System.out.println("  --------------------");
        }
    }

    public void changePlayer() {
        if (currentPlayer == players[0]) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];
        }
    }

    private static void getCoordinatesFromUser(){

        // ask user for coordinates
        System.out.print("Gib deine Koordinaten ein > ");
        String input = scanner.nextLine();

        //split input at every character that is not a number
        String[] parts = input.split("[^0-9]+");

        //check if the input is valid (2 numbers)
        if (parts.length >= 3) {
            System.out.println("Ungültige Eingabe!");
            return;
        }

        //check if the coordinates are in the field
        for (String part : parts) {
            int currentCoordinate = Math.abs(Integer.parseInt(part));

            //check if the coordinates are in the field
            if (currentCoordinate > 3) {
                System.out.println("Diese Koordinaten sind nicht im Spielfeld!");
                return;
            }

            //check if field at this position is empty
            if (field[currentCoordinate - 1][currentCoordinate - 1] != ' ') {
                System.out.println("Dieses Feld ist bereits belegt!");
                return;
            }
        }


        // if the input is valid print that the coordinates are valid
        System.out.println("Deine Koordinaten sind gültig!");

        //set the coordinates in the field
        field[Integer.parseInt(parts[0]) - 1][Integer.parseInt(parts[1]) - 1] = currentPlayer.getPlayIcon();

        //return true if the input is valid
    }

    public void startGame() {
        //clear console before starting the game
        Main.clearConsole();


        while (!checkIfGameOver()) {
            Main.clearConsole();
            drawField();
            getCoordinatesFromUser();
            changePlayer();
        }

        //print the winner and how he won
        Main.clearConsole();
        drawField();
        System.out.println("Der Spieler " + currentPlayer.getName() + " hat gewonnen!");

    }

    //check if the game is over
    public static boolean checkIfGameOver() {
        //check if there are 3 in a row
        for(int i = 0; i < 3; i++){
            if(field[i][0] == currentPlayer.getPlayIcon()
                    && field[i][1] == currentPlayer.getPlayIcon()
                    && field[i][2] == currentPlayer.getPlayIcon()){
                return true;
            }
        }

        //check if there are 3 in a column
        for(int i = 0; i < 3; i++){
            if(field[0][i] == currentPlayer.getPlayIcon()
                    && field[1][i] == currentPlayer.getPlayIcon()
                    && field[2][i] == currentPlayer.getPlayIcon()){
                return true;
            }
        }

        //check if there are 3 in a diagonal
        if(field[0][0] == currentPlayer.getPlayIcon()
                && field[1][1] == currentPlayer.getPlayIcon()
                && field[2][2] == currentPlayer.getPlayIcon()){
            return true;
        }
        else if(field[0][2] == currentPlayer.getPlayIcon()
                && field[1][1] == currentPlayer.getPlayIcon()
                && field[2][0] == currentPlayer.getPlayIcon()){
            return true;
        }

        //check if the whole field is filled
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(field[i][j] == ' '){
                    return false;
                }
            }
        }

        return false;
    }









}





