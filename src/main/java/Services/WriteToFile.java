package Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	public void whenWriteStringUsingBufferedWritter_thenCorrect(String str) 
			  throws IOException {
			    BufferedWriter writer = new BufferedWriter(new FileWriter("idUpdate.txt"));
			    writer.write(str);
			    writer.close();
			}
}
