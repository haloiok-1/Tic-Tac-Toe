import java.io.IOException;

public class Main extends Thread {

    static int amountOfPlayers = 2;
    static Player firstPlayer = new Player('X');
    static Player secondPlayer = new Player('O');
    static Field field;

    public static void main(String[] args) {
        field = new Field(createPlayerArray());
        welcomeScreen();

        //start game
        field.startGame();
    }

    //create Player Array with 2 players
    public static Player[] createPlayerArray() {
        Player[] players = new Player[amountOfPlayers];
        players[0] = firstPlayer;
        players[1] = secondPlayer;
        return players;
    }

    //welcome screen
    public static void welcomeScreen() {
        clearConsole();
        System.out.println("Willkommen zu TicTacToe!");
        System.out.println("Bitte geben Sie den Namen des ersten Spielers ein:");
        firstPlayer.setName(Field.scanner.nextLine());
        System.out.println("Bitte geben Sie den Namen des zweiten Spielers ein:");
        secondPlayer.setName(Field.scanner.nextLine());
        System.out.println("Spiel wird gestartet...");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearConsole() {
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