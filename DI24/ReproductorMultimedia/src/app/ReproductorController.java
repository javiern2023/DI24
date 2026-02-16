package app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media; //Representa el archivo multimedia
import javafx.scene.media.MediaPlayer; //Representa el reproductor
import javafx.util.Duration; //Representa tiempos en JavaFx

public class ReproductorController {

    @FXML private Label lblEstado;
    @FXML private Slider sliderProgreso;
    @FXML private Slider sliderVolumen;

    private MediaPlayer mediaPlayer; //Objeto que reproduce el audio
    private boolean cambiandoSlider = false;

    @FXML
    public void initialize() {

        // Cargamos el MP3 de forma segura
        try {
            Media media = new Media(
                    getClass().getResource("/audio/cancion.wav").toExternalForm()
            );
            mediaPlayer = new MediaPlayer(media);

            // Volumen inicial
            sliderVolumen.setValue(50); //el slider lo empezamos al 50%
            mediaPlayer.setVolume(0.5); //volumen del reproductor (del 0 al 1)

            // Cada vez que el usuario toca el slider calcula el valor de 0 a 100
            sliderVolumen.valueProperty().addListener((obs, oldVal, newVal) ->
                    mediaPlayer.setVolume(newVal.doubleValue() / 100)
            );

            // Carga el audio y recoge el valor de la duración en segundos.
            mediaPlayer.setOnReady(() -> sliderProgreso.setMax(mediaPlayer.getTotalDuration().toSeconds()));

            // Cambia el slider según el tiempo que queda de la canción.
            mediaPlayer.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
                if (!cambiandoSlider) {
                    sliderProgreso.setValue(newTime.toSeconds());
                }
            });

            //Cuando se mueve el ratón
            sliderProgreso.setOnMousePressed(e -> cambiandoSlider = true);
            //Cuando se suelta el ratón.
            sliderProgreso.setOnMouseReleased(e -> {
                mediaPlayer.seek(Duration.seconds(sliderProgreso.getValue()));
                cambiandoSlider = false;
            });

        } catch (Exception e) {
            lblEstado.setText("No se pudo cargar el audio");
            System.out.println("Error cargando MP3: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void play() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
            lblEstado.setText("▶ Reproduciendo");
        }
    }

    @FXML
    private void pause() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            lblEstado.setText("⏸ Pausado");
        }
    }

    @FXML
    private void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            sliderProgreso.setValue(0);
            lblEstado.setText("⏹ Detenido");
        }
    }
}
