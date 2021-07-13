import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioSystem;

public class Music {
	
void playmusic(String loc, int t) {
	try {
		File path = new File(loc);
		if (path.exists()) {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
			TimeUnit.SECONDS.sleep(t);
			System.out.println("Starting"); 
			clip.close();
		}
		else {
			System.out.println("doesnt exist");
		}
	}
	catch(Exception ex) {
		ex.printStackTrace();
		
	}
}
}
