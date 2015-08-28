package projekt.model;


import javafx.scene.image.Image;

/**
 * Klasse zum Erstellen eines Spielerobjekts.
 * Sie enthält den Namen, das Bild, die Joker, die Punkte und andere Informationen von Spielern.
 */
public class Player {
    private Image img;
    private String name;
    private int score;

    public Player(Image img, String name) {
        this.img = img;
        this.name = name;
    }

    /**
     * Gibt das Bild des Spielers zurück.
     *
     * @return Bild des Spielers.
     */
    public Image getImg() {
        return img;
    }

    /**
     * Setzt das Bild des Spieler.
     *
     * @param img Bild, das der Spieler erhalten soll.
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     * Gibt den Namen des Spielers zurück.
     *
     * @return Name des Spielers.
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt den Punktestand des Spielers zurück.
     *
     * @return Punktestand des Spielers.
     */
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
