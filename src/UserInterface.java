import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {
	private List<NumberListener> numberListeners = new ArrayList<>();
	private List<EndListener> endListeners = new ArrayList<>();
	
	public void addNumberListener(NumberListener listener) {
		numberListeners.add(listener);
	}
	
	public void addEndListener(EndListener listener) {
		endListeners.add(listener);
	}
	
	public void run() throws IOException {
		BufferedReader keyboard = new BufferedReader(
			new InputStreamReader(System.in)
		);
		
		System.out.println("Enter some numbers.");
		
		while(true) {
			System.out.print("> ");
			String line = keyboard.readLine();
			if("end".equals(line)) {
				break;
			}
			
			double number = Double.parseDouble(line);
			
			// trigger the Number event
			onNumber(number);
		}
		
		// trigger the End event
		onEnd();
	}
	
	private void onNumber(double number) {
		for(NumberListener listener : numberListeners) {
			listener.onNumber(number);
		}
	}
	
	private void onEnd() {
		for(EndListener listener : endListeners) {
			listener.onEnd();
		}
	}
}
