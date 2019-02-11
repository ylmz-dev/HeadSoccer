import java.io.*;
import sun.audio.*;

public class Audio {
	public static void Cal(String path) {
		try {
			InputStream in = new FileInputStream(path);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
