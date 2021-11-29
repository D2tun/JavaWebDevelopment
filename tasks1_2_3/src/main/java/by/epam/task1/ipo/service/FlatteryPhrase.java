package by.epam.task1.ipo.service;

public class FlatteryPhrase {

	private static FlatteryPhrase instance;
	
	private FlatteryPhrase() {
		
	}
	
	public static FlatteryPhrase getInstance() {
		if (instance == null) {
			instance = new FlatteryPhrase();
		}
		return instance;
	}
	
	public String getPhrase (char ch) {
		return (ch == 'Д') ? "Мне нравятся девочки!": "Мне нравятся мальчики!";
	}
	
}
