package projekt.model;


import javafx.scene.image.Image;
import projekt.MainApplication;
import projekt.io.DirectoryIO;

import java.util.List;

/**
 * Klasse zum Erstellen eines Spielerobjekts.
 * Sie enthält den Namen, das Bild, die Joker, die Punkte und andere Informationen von Spielern.
 */
public class Player {
    private static List<String> playerImages = DirectoryIO.getFileList("src/" + MainApplication.DIR_PLAYER_IMAGES);
    private int imageNum;
    private String name;
    private int score;
    private Image image;

    public Player(int imageNum, String name) {
        this.name = name;
        setImageNum(imageNum);
    }

    public Player(int imageNum, String name, int score) {
        setImageNum(imageNum);
        this.name = name;
        this.score = score;
    }

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
     * Gibt den Namen des Spielers zurück.
     *
     * @param name
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

    public void setImageNum(int imageNum) {
        this.imageNum = imageNum;
        this.image = new Image(MainApplication.DIR_PLAYER_IMAGES + playerImages.get(imageNum));
    }
}
