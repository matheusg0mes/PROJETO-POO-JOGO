package music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class InstanciasMusicas {

    public void musicaMenu(){
        Media media = new Media(getClass().getResource("/music/Neon-Apex-Run.mp3").toExternalForm());

        MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void musicaClick(){
        Media media = new Media(getClass().getResource("/music/click.mp3").toExternalForm());

        MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.play();
    }


}
