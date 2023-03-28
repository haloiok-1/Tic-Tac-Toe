public class Player {

    char playIcon;
    String name;

    public Player(char playIcon) {
        this.playIcon = playIcon;
    }

    // getter, setter
    public void setPlayIcon(char playIcon) {
        this.playIcon = playIcon;
    }

    public char getPlayIcon() {
        return playIcon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
