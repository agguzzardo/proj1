
public class Cell {
	private boolean state;
	
	public Cell() {
		this(false);
	}
	public Cell(boolean state) {
		this.state = state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public boolean getState() {
		return this.state;
	}
	public void switchState() {
		if(state == true) {
			this.setState(false);
		}else {
			this.setState(true);
		}
	}
}
