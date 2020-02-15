
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Automaton {
	private char falseSymbol;
	private char trueSymbol;
	private ArrayList<Generation> automaton = new ArrayList<Generation>();
	private Rule rule;
	
	public Automaton(int ruleNum, boolean[] initialState){
		this.rule = new Rule(ruleNum);
		automaton.add(new Generation(initialState));
		this.falseSymbol = '0';
		this.trueSymbol = '1';
	}
	public Automaton(String filename) throws NumberFormatException, IOException {
		 BufferedReader scnr = new BufferedReader(new FileReader(filename));
		 this.rule = new Rule(Integer.parseInt(scnr.readLine()));
		 String[] secondLine = scnr.readLine().split(" ");
		 char falseChar = secondLine[0].charAt(0);
		 char trueChar = secondLine[1].charAt(0);
		 this.setFalseSymbol(falseChar);
		 this.setTrueSymbol(trueChar);
		 String initialGenString = scnr.readLine();
		 boolean[] initialGenBoolArray = new boolean[initialGenString.length()];
		 for(int i=0;i<initialGenString.length();i++) {
			 if(initialGenString.charAt(i)==falseSymbol) {
				 initialGenBoolArray[i] = false;
			 }else {
				 initialGenBoolArray[i]=true;
			 }
		 }
		 Generation initialGeneration = new Generation(initialGenBoolArray);
		 automaton.add(initialGeneration);
		 scnr.close();
	}
	public int getRuleNum(){
		return rule.getRuleNum();
	}
	public void evolve(int steps) {
		for(int i=0;i<steps;i++) {
			this.evolve();
		}
	}
	public void evolve() {
		Generation recentGen = automaton.get(automaton.size()-1);
		Cell[] recentGenArray = recentGen.getGeneration();
		boolean[] newBoolGeneration = new boolean[recentGen.length()];
		for(int i=0;i<recentGenArray.length;i++) {
			StringBuilder codeString = new StringBuilder();
			Cell leftCell;
			Cell mainCell = recentGenArray[i];
			Cell rightCell;
			if(i==0) {
				leftCell = recentGenArray[recentGenArray.length-1];
				rightCell = recentGenArray[i+1];
			}else if(i==recentGenArray.length-1) {
				rightCell = recentGenArray[0];
				leftCell = recentGenArray[i-1];
			}else {
				rightCell = recentGenArray[i+1];
				leftCell = recentGenArray[i-1];
			}
			if(leftCell.getState() == true) {
				codeString.append(1);
			}else {
				codeString.append(0);
			}
			if(mainCell.getState() == true) {
				codeString.append(1);
			}else {
				codeString.append(0);
			}if(rightCell.getState() == true) {
				codeString.append(1);
			}else {
				codeString.append(0);
			}
			//System.out.println(codeString);
			if(rule.isNowBlack(codeString.toString()) == true) {
				newBoolGeneration[i] = true;
			}else {
				newBoolGeneration[i] = false;
			}
		}
		Generation newGeneration = new Generation(newBoolGeneration);
		automaton.add(newGeneration);
	}
	public int getTotalSteps() {
		return automaton.size()-1;
	}
	public boolean[] getState(int stepNum) {
		return automaton.get(stepNum).toBoolean();
	}
	public String getStateString(int stepNum) {
		boolean[] stateArray = this.getState(stepNum);
		StringBuilder stateString = new StringBuilder();
		for(int i=0;i<stateArray.length;i++) {
			if(stateArray[i] == true) {
				stateString.append(this.getTrueSymbol());
			}else {
				stateString.append(this.getFalseSymbol());
			}
		}
		return stateString.toString();
	}
	public String toString() {
		StringBuilder automatonString = new StringBuilder();
		for(int i=0;i<automaton.size()-1;i++) {
			automatonString.append(this.getStateString(i));
			automatonString.append('\n');
		}
		automatonString.append(this.getStateString(automaton.size()-1));
		return automatonString.toString();
	}
	public void save(String filename) throws IOException {
		FileWriter scnr = new FileWriter(filename);
		scnr.write(this.toString());
		scnr.close();
	}
	public char getFalseSymbol() {
		return falseSymbol;
	}
	public void setFalseSymbol(char symbol) {
		this.falseSymbol = symbol;
	}
	public char getTrueSymbol() {
		return trueSymbol;
	}
	public void setTrueSymbol(char symbol) {
		this.trueSymbol = symbol;
	}
}
