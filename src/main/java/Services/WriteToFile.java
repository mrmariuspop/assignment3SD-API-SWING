package Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	public void whenWriteStringUsingBufferedWritter_thenCorrect(String str,String file) 
			  throws IOException {
			    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			    writer.write(str);
			    writer.close();
			}
}
