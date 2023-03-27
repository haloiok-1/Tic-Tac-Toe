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

    public void setValueInField(int xKoord, int yKoord, Player currentPlayer) {
        this.xKoord = xKoord;
        this.yKoord = yKoord;
        this.currentPlayer = currentPlayer;
    }

    public static int[] inputCoordinates() {
        int[] coordinates = new int[2];
        System.out.print("Gib deine Koordinaten ein: ");
        String input = scanner.nextLine();

        String[] parts = input.split("\\d+");

        for (int i = 0; i < parts.length; i++) {
            if (i <= 2) {

                int currentValue = Math.abs(Integer.parseInt(parts[i]));
                if (currentValue > field.length - 1) {

                    break;
                }
                System.out.println(currentValue);
                coordinates[i] = Math.abs(Integer.parseInt(parts[i]));
            }

        }
        return coordinates;
    }

}





