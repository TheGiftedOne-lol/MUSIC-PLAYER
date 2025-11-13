
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class music{
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
       boolean musicplay=true;
       int c=1;
       Scanner sc=new Scanner(System.in);
       try{
        File sound=new File("song.wav");//your song here
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(sound);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        while(musicplay){
        System.out.println("WHAT DO YOU WANT TO DO?\n | 'P' to play   |\n | 'S' to stop   |\n | 'R' to resume | \n | 'L' to pause  |\n | 'E' to replay |");
        char a=sc.next().charAt(0);
        a=Character.toUpperCase(a);
        switch(a){
            case 'P'->{
                if(c==1){
                clip.start();
                System.out.println("Playing...");
                c++;}
                else{
                    System.out.println("YOU CAN ONLY PRESS PLAY ONCE");
                    musicplay=false;
                }
                break;
            }
            case 'L'->{
            clip.stop();
            System.out.println("Paused.");
            break;
            }
            case 'R'->{
            if (!clip.isRunning()) {
                            clip.start();
                            System.out.println("Resumed.");
                        } else {
                            System.out.println("Already playing!");
                        }

            break;
            }
            case 'S'->{
                musicplay=false;
                System.out.println("Music stopped. Exiting...");
                break;
            }
            case 'E'->{
                clip.setFramePosition(0);
                System.out.println("Replaying...");
                break;
            }
            default -> System.out.println("WRONG INPUT");
        }
        }
        
        
     }
     catch(UnsupportedAudioFileException e){
     System.out.println("WRONG FILE FORMAT");
     }
     catch(IOException e){
        System.out.println("FILE NOT FOUND");
     }
     catch(Exception e){
       System.out.println("SOMETHING WENT WRONG");
     }
     sc.close();
    }
}