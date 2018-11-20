import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
	public static void main(String[] args) throws IOException {
		UserInterface ui = new UserInterface();
		Sort sort = new Sort(ui);
		ui.run();
	}
	
	public Sort(UserInterface ui) {
		ui.addNumberListener(this::onNumber);
		ui.addEndListener(this::onEnd);
	}
	
	private List<Double> numbers = new ArrayList<>();
	
	public void onNumber(double number) {
		numbers.add(number);
	}
	
	public void onEnd() {
		Collections.sort(numbers);
		System.out.println(numbers);
	}
}
