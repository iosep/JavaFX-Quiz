package projekt.model;


import javafx.scene.image.Image;

/**
 * enthält Name, Bild, Joker und andere Informationen vom Spielern
 */
public class Player {
    private Image img;
    private String name;

    public Player(Image img, String name) {
        this.img = img;
        this.name = name;
    }

    public Image getImg() {
        return img;
    }

    public String getName() {
        return name;
    }
}
