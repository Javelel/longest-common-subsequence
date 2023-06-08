package pl.edu.pw.ee;

public class Cell {

	private int val;
	private int direction;
	private boolean isOnRoute = false;

	public Cell(int val) {
		this.val = val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getDirection() {
		return direction;
	}

	public void setOnRoute(boolean isOnRoute) {
		this.isOnRoute = isOnRoute;
	}

	public boolean isOnRoute() {
		return isOnRoute;
	}

}
