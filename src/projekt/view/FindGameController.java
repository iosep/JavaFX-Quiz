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
        assert playerNameText != null : "fx:id=\"playerNameText\" was not injected: check your FXML file 'FindGame.fxml'.";
        assert playerImgView != null : "fx:id=\"playerImgView\" was not injected: check your FXML file 'FindGame.fxml'.";
    }

    public void initPlayer(Player player) {
        playerImgView.setImage(player.getImg());
        playerNameText.setText(player.getName());
    }
}
