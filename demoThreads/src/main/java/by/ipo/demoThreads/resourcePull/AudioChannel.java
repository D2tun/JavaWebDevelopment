package by.ipo.demoThreads.resourcePull;

public class AudioChannel {
	private int сhannellId;

	public AudioChannel(int id) {
		super();
		this.сhannellId = id;
	}

	public int getСhannellId() {
		return сhannellId;

	}

	public void setСhannellId(int id) {
		this.сhannellId = id;
	}

	public void using() {
		try {
			Thread.sleep(new java.util.Random().nextInt(500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
