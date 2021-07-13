import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;

public class Timer {
	
	
	public static void main(String [] args) throws InterruptedException, UnsupportedAudioFileException, IOException {

		Input b = new Input(); //instance of java.swing class
		int [] data = new int [5];//where users inputs go
		b.store = data; // getting the inputs from the user 
		
		
	
		String Path1 = "S.wav";
		String Path2 = "L.wav";
		String Path3 = "E.wav";
		
		
		timer(data[0], data[1], data[2], data[3], data[4], Path1, Path2, Path3); //passing through the timer
		
	}
	public static void timer(int min1, int sec1, int min2, int sec2, int rounds, String A, String B,String C) throws InterruptedException, UnsupportedAudioFileException, IOException {
		
		int tot1 = (min1*60)+sec1; //conversion to seconds 
		int T1 = tot1;
		int tot2 = (min2*60)+sec2; //conversion seconds
		int T2 = tot2;
		
		int counter1 = duration(A); //to get the duration of time needed to play the sound recordings (coded so that sound recording don't count in terms of time)
		int counter2 = duration(B);
		int counter3 = duration(C);
		
		while(rounds > 0) {
			T1 = tot1; // reset timer after each round is complete
			T2 = tot2;
			while (T1>0) { //while loop that goes through the timer
				if (T1==tot1 && rounds == 1) {
					playmusic(C,counter3);
					System.out.println("Final Round Start");//trackers 
				}
				else if (T1 == tot1) {
					playmusic(A,counter1);
					System.out.println("Normal Round Start");
				}
				TimeUnit.SECONDS.sleep(1);
				T1--;
			}
			while (T2>0) {
				if (T2==tot2) {
					playmusic(B,counter2);
					System.out.println("Round over");
				}
				TimeUnit.SECONDS.sleep(1);
				T2--;
			}
			rounds--;
		}
		
	}
	public static void playmusic(String s, int t) {
		Music ob = new Music(); //start playing music
		ob.playmusic(s,t);
		System.out.println("Playing");
	}
	public static int duration(String s) throws UnsupportedAudioFileException, IOException {
		int t; // for conversion from float to string
		File file = new File(s);
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		AudioFormat format = audioInputStream.getFormat();
		long audioFileLength = file.length();
		int frameSize = format.getFrameSize();
		float frameRate = format.getFrameRate();
		float durationInSeconds = (audioFileLength / (frameSize * frameRate));
		t = (int)(durationInSeconds);
		return t;
		
	}

}
