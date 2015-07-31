package projekt.model;


import javafx.scene.image.Image;

/**
 * Klasse zum Erstellen eines Spielerobjekts.
 * Sie enthält den Namen, das Bild, die Joker, die Punkte und andere Informationen von Spielern.
 */
public class Player {
    private Image img;
    private String name;

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
     * Gibt den Namen des Spielers zurück.
     *
     * @return Name des Spielers.
     */
    public String getName() {
        return name;
    }
}
