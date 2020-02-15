
public class Generation {
	private Cell[] generation;
	
	public Generation(Cell[] generation) {
		this.generation = generation;
	}
	public Generation(boolean[] generation) {
		Cell[] newGeneration = new Cell[generation.length];
		for(int i=0;i<generation.length;i++) {
			Cell newCell = new Cell(generation[i]);
			newGeneration[i] = newCell;
		}
		this.generation = newGeneration;
	}
	public Cell[] getGeneration() {
		return generation;
	}
	public boolean[] toBoolean() {
		boolean[] toBoolean = new boolean[generation.length];
		for(int i=0;i<toBoolean.length;i++) {
			toBoolean[i] = generation[i].getState();
		}
		return toBoolean;
	}
	public String toString() {
		StringBuilder genString  = new StringBuilder();
		for(int i=0;i<generation.length-1;i++) {
			genString.append(generation[i].getState());
			genString.append(", ");
		}
		genString.append(generation[generation.length-1].getState());
		return genString.toString();
	}
	public int length() {
		return generation.length;
	}
}
