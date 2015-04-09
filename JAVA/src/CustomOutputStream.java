import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import javax.swing.JTextArea;

/**
 * This class extends from OutputStream to redirect output to a JTextArrea
 * @author www.codejava.net
 *
 */
public class CustomOutputStream extends OutputStream {
	private JTextArea textArea;

	public CustomOutputStream(JTextArea textArea) {
		this.textArea = textArea;
		createPrintStreamFromJTextArea(this.textArea);
	}

	@Override
	public void write(int b) throws IOException {
		

		// redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	public static OutputStreamWriter createUTF8OutputStreamWriter(OutputStream out) {
		try {
			return new OutputStreamWriter(out, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			handleUEE();
			return null;
		}
		
	}
	public static PrintStream createPrintStreamFromJTextArea(final JTextArea area) {
		try {
		return new PrintStream(new ByteArrayOutputStream(), false, "UTF-8") {

			public void write(byte[] buf, int off, int len) {
				area.append(CustomOutputStream.createUTF8String(buf, off, len));
				area.setCaretPosition(area.getText().length());
			}
		};
		} catch (UnsupportedEncodingException uee) {
			handleUEE();
			return null;
		}
    }
	public static String createUTF8String(byte[] buf, int off, int len) {
		try {
			return new String(buf, off, len, "UTF-8");
		} catch (UnsupportedEncodingException uee) {
			handleUEE();
			return null;
		}
	}
	
	private static void handleUEE() throws RuntimeException {
		throw new RuntimeException("UTF-8 is required to be supported by any java virtual machine, but is not by this one!");
	}
}