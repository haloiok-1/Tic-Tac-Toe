import java.io.IOException;

public class Main extends Thread {


    static Player[] players;
    static int amountOfPlayers = 2;
    static Player firstPlayer = new Player('X');
    static Player secondPlayer = new Player('O');

    static Field field;

    public static void main(String[] args) {
        players = new Player[amountOfPlayers - 1];
        createPlayerArray();

        field = new Field(players);


    }


    public static void createPlayerArray() {
        players[0] = firstPlayer;
        players[1] = secondPlayer;
    }


    public void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            // Fehlerbehandlung
        }

    }

}