package projekt.model;


import javafx.scene.image.Image;
import projekt.MainApplication;
import projekt.io.DirectoryIO;

import java.util.List;

/**
 * Klasse zum Erstellen eines Spielers.
 */
public class Player {
    private static List<String> playerImages = DirectoryIO.getFileList("src/" + MainApplication.DIR_PLAYER_IMAGES);
    private int imageNum;
    private String name;
    private int score;
    private Image image;

    /**
     * Erstellt einen Spieler mit Namen und Bild.
     *
     * @param imageNum Bildnummer des Spielers.
     * @param name     Name des Spielers.
     */
    public Player(int imageNum, String name) {
        this.name = name;
        setImageNum(imageNum);
    }

    /**
     * Erstellt einen Spieler mit Namen, Bild und Punktezahl.
     *
     * @param imageNum Bildnummer des Spielers.
     * @param name     Name des Spielers.
     * @param score    Punktezahl des Spielers.
     */
    public Player(int imageNum, String name, int score) {
        this.name = name;
        this.score = score;
        setImageNum(imageNum);
    }

    /**
     * Gibt die Anzahl der Spieleravatare zurück, die geladen wurden.
     *
     * @return Anzahl der Bilder.
     */
    public static int getSizeOfPlayerImages() {
        return playerImages.size();
    }

    /**
     * Gibt das Bild des Spielers zurück.
     *
     * @return Bild des Spielers.
     */
    public Image getImg() {
        return image;
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
     * Setzt den Namen des Spielers.
     *
     * @param name Name des Spielers.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt den Punktestand des Spielers zurück.
     *
     * @return Punktestand des Spielers.
     */
    public int getScore() {
        return score;
    }

    /**
     * Setzt die Punktezahl für den Spieler.
     *
     * @param score Punktezahl des Spielers.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Gibt die Bildnummer des Spielers zurück.
     *
     * @return Bildnummer des Spielers.
     */
    public int getImageNum() {
        return imageNum;
    }

    /**
     * Setzt die Bildnummer des Spielers.
     *
     * @param imageNum Bildnummer des Spielers.
     */
    public void setImageNum(int imageNum) {
        this.imageNum = imageNum;
        this.image = new Image(MainApplication.DIR_PLAYER_IMAGES + playerImages.get(imageNum));
    }
}
