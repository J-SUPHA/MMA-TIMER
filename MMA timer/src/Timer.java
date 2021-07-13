import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;

public class Timer {
	
	
	public static void main(String [] args) throws InterruptedException, UnsupportedAudioFileException, IOException {

		Input b = new Input();
		int [] data = new int [5];
		b.store = data;
		
		
	
		String Path1 = "S.wav";
		String Path2 = "L.wav";
		String Path3 = "E.wav";
		
		
		timer(data[0], data[1], data[2], data[3], data[4], Path1, Path2, Path3);
		
	}
	public static void timer(int min1, int sec1, int min2, int sec2, int rounds, String A, String B,String C) throws InterruptedException, UnsupportedAudioFileException, IOException {
		
		int tot1 = (min1*60)+sec1;
		int T1 = tot1;
		int tot2 = (min2*60)+sec2;
		int T2 = tot2;
		
		int counter1 = duration(A);
		int counter2 = duration(B);
		int counter3 = duration(C);
		
		while(rounds > 0) {
			T1 = tot1;
			T2 = tot2;
			while (T1>0) {
				if (T1==tot1 && rounds == 1) {
					playmusic(C,counter3);
					System.out.println("Final Round Start");
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
		Music ob = new Music();
		ob.playmusic(s,t);
		System.out.println("Playing");
	}
	public static int duration(String s) throws UnsupportedAudioFileException, IOException {
		int t;
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
