package runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) throws IOException {
		for (int i = 0; i <= 8; i++)
		{
			Path dataPath = Paths.get("data/" + i);
			if (!Files.exists(dataPath)) {
				Files.createDirectories(dataPath);
			}
		}
		Runner runner = new Runner();
		runner.runDFS();
	}
}
