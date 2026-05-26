package music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class InstanciasMusicas {

    private static MediaPlayer mediaPlayer;

    public static void tocarMenu() {

        pararMusica();

        Media media = new Media(
                InstanciasMusicas.class.getResource("/music/Neon-Apex-Run.mp3").toExternalForm()
        );

        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        mediaPlayer.play();
    }

    public static void tocarClick() {

        Media media = new Media(
                InstanciasMusicas.class.getResource("/music/click.mp3").toExternalForm()
        );

        MediaPlayer click = new MediaPlayer(media);

        click.play();
    }

    public static void tocarSelecionar() {

        Media media = new Media(
                InstanciasMusicas.class.getResource("/music/selecionar.mp3").toExternalForm()
        );

        MediaPlayer click = new MediaPlayer(media);

        click.play();
    }

    public static void tocarNaruto() {

        pararMusica();

        Media media = new Media(
                InstanciasMusicas.class.getResource("/music/naruto.mp3").toExternalForm()
        );

        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.play();
    }

    public static void tocarNarutoBad() {

        pararMusica();

        Media media = new Media(
                InstanciasMusicas.class.getResource("/music/badNaruto.mp3").toExternalForm()
        );

        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.play();
    }

    public static void pararMusica() {

        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

    }
}