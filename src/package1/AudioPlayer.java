package package1;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

    private static Clip clip; // Variable de clase

    public static void ReproducirAudio() {
        detenerAudio(); // Detener cualquier audio antes de iniciar otro
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("intro.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error al reproducir intro.wav");
            ex.printStackTrace();
        }
    }

    public static void ReproducirAudio2() {
        detenerAudio(); // Detener cualquier audio antes de iniciar otro
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("batalla.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error al reproducir batalla.wav");
            ex.printStackTrace();
        }
    }

    private static void detenerAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}

