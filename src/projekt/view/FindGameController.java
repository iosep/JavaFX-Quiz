package projekt.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import projekt.model.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class FindGameController implements Initializable {

    @FXML
    private ImageView playerImgView;

    @FXML
    private Text playerNameText;

    public FindGameController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Init");
    }


    public void initPlayer(Player player) {
        playerImgView.setImage(player.getImg());
        playerNameText.setText(player.getName());
    }
}
