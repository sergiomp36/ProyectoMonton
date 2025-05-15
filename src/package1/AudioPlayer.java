package package1;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

    private static Clip clip; 

    public static void ReproducirAudio() { //Inicia audio menu
        detenerAudio(); 
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

    public static void ReproducirAudio2() { //Inicia audio combate
        detenerAudio();
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
    
    public static void ReproducirAudio3() { //Suena cuando atacas
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("ataque.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error al reproducir intro.wav");
            ex.printStackTrace();
        }
    }

    private static void detenerAudio() { //Detiene audio
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}

