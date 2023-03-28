import java.util.Arrays;
import java.util.Scanner;

public class Field {
    //initialize Scanner for UserInput
    static Scanner scanner = new Scanner(System.in);

    static char[][] field = new char[3][3];
    Player[] players;
    Player currentPlayer;

    int xKoord;
    int yKoord;


    public Field(Player[] players) {
        this.players = players;


        //fill Array with blank spaces
        cycleThroughWholeArray();
    }


    public static void main(String[] args) {
        Player[] blub = new Player[2];

        Field field = new Field(blub);

        cycleThroughWholeArray();
        drawField();
        inputCoordinates();


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

    public void setValueInField(int[] coordinates, Player currentPlayer) {
        this.xKoord = coordinates[0];
        this.yKoord = coordinates[1];
        this.currentPlayer = currentPlayer;
    }

    public static int[] inputCoordinates() {
        int[] coordinates = new int[0];
        boolean inputIsValid = true;

        //a loop where the user can input coordinates and if the input is invalid, the user can try again
        while (inputIsValid) {
            //get the coordinates from the user
            int[] inputCoordinates = new int[2];
            //check if the input is valid
            if (getCoordinatesFromUser()) {
                //set the coordinates to the coordinates array
                coordinates = inputCoordinates;
                inputIsValid = false;
            }


            //check if the input is valid
            if (inputCoordinates != null) {
                //set the coordinates to the coordinates array
                coordinates = inputCoordinates;
                inputIsValid = false;
            }
        }
        // return the coordinates as an array
        return coordinates;
    }

    public void changePlayer() {
        if (currentPlayer == players[0]) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];
        }
    }

    public boolean checkIfFieldIsFull() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean getCoordinatesFromUser(){

        System.out.print("Gib deine Koordinaten ein > ");
        String input = scanner.nextLine();
        System.out.println("Deine Eingabe: " + input);

        //split input at every character that is not a number
        String[] parts = input.split("[^0-9]+");
        //check if the input is valid
        if (parts.length >= 3) {
            System.out.println("Ungültige Eingabe!");



            return false;
        }
        //check if the coordinates are in the field
        for (int i = 0; i < parts.length; i++) {
            int currentKoordinate = Math.abs(Integer.parseInt(parts[i]));
            //gib den inhalt von parts aus
            System.out.println("parts[" + i + "] = " + parts[i]);

            //check if the coordinates are in the field
            if (currentKoordinate > 3) {
                System.out.println("Diese Koordinaten sind nicht im Spielfeld!");
                return false;
            }
            //check if field at this position is empty
            if (field[currentKoordinate - 1][currentKoordinate - 1] != ' ') {
                System.out.println("Dieses Feld ist bereits belegt!");
                return false;
            }
        }


        // if the input is valid, return the length of the array
        return true;



    }







}





