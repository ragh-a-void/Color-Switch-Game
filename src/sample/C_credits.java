package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.IOException;

public class C_credits {
    @FXML
    private Button backButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private MediaPlayer music;
    @FXML
    void initialize(){
        music.setOnEndOfMedia(() -> music.seek(Duration.ZERO));
        music.play();
    }
    public void press_back(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}