package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class C_user_input {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button backButton;
    @FXML
    private Button doneButton;
    @FXML
    private TextField textField;
    @FXML
    private Label label;
    @FXML
    private MediaPlayer music;
    @FXML
    public void initialize(){
        music.setOnEndOfMedia(() -> music.seek(Duration.ZERO));
        music.play();
        label.setVisible(false);
    }

    public void press_done(ActionEvent event) throws IOException {
        String name = textField.getText();
        boolean isPresent = false;
        for(int i=0;i<common.theList.size();i++){
            if(common.theList.get(i).getName().equals(name)){
                label.setVisible(true);
                isPresent = true;
                break;
            }
        }
        if(!isPresent){
            String timeStamp = new SimpleDateFormat("MM/dd - HH:mm:ss").format(Calendar.getInstance().getTime());
            common.currGame.setId(timeStamp);
            common.currGame.setName(name);
            common.theList.add(common.currGame);
            music.stop();
            Scene HomePage = FXMLLoader.load(getClass().getResource("application.fxml"));
            Main.gameStage.setScene(HomePage);
        }
    }
    public void press_back(ActionEvent event) throws IOException {
        music.stop();
        Scene HomePage = FXMLLoader.load(getClass().getResource("pause.fxml"));
        Main.gameStage.setScene(HomePage);
    }
}