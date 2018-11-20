import java.io.IOException;

public class Stats {
	public static void main(String[] args) throws IOException {
		UserInterface ui = new UserInterface();
		Stats stats = new Stats(ui);
		ui.run();
	}
	
	public Stats(UserInterface ui) {
		ui.addNumberListener((number) -> {
			count++;
			total += number;
			if(count == 1 || number > max) {
				max = number;
			}
		});
		
		ui.addEndListener(() -> {
			System.out.println("Count is " + count);
			System.out.println("Total is " + total);
			if(count > 0) {
				System.out.println("Max is " + max);
			} else {
				System.out.println("Max is undefined");
			}
		});
	}
	
	private int count = 0;
	private double total = 0;
	private double max = Double.NEGATIVE_INFINITY;
}
