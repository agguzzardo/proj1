
public class Rule {
	private int ruleNum;
	private boolean[] ruleArray;
	public Rule(int ruleNum) {
		this.ruleNum = ruleNum;
		String ruleBinary = Integer.toBinaryString(ruleNum);
		ruleBinary = String.format("%8s", ruleBinary);
		boolean[] ruleArray = new boolean[ruleBinary.length()];
		
		for(int i=0;i<ruleBinary.length();i++) {
			if(ruleBinary.charAt(i)=='1') {
				ruleArray[i]=true;
			}else {
				ruleArray[i]=false;
			}
		}
		this.ruleArray = ruleArray;
	}
	public boolean isNowBlack(String ruleCode) {
		if(ruleCode.contentEquals("111")) {
			if(ruleArray[0]==true) {
				return true;
			}else {
				return false;
			}
		} else if(ruleCode.equals("110")) {
			if(ruleArray[1]==true) {
				return true;
			}else {
				return false;
			}
		} else if(ruleCode.equals("101")) {
			if(ruleArray[2]==true) {
				return true;
			}else {
				return false;
			}
		} else if(ruleCode.equals("100")) {
			if(ruleArray[3]==true) {
				return true;
			}else {
				return false;
			}
		} else if(ruleCode.equals("011")) {
			if(ruleArray[4]==true) {
				return true;
			}else {
				return false;
			}
		} else if(ruleCode.equals("010")) {
			if(ruleArray[5]==true) {
				return true;
			}else {
				return false;
			}
		} else if(ruleCode.equals("001")) {
			if(ruleArray[6]==true) {
				return true;
			}else {
				return false;
			}
		} else if(ruleCode.equals("000")) {
			if(ruleArray[7]==true) {
				return true;
			}else {
				return false;
			}
		}else {
			System.out.println("you shouldnt see this");
			return false;
		}
	}
	public boolean[] getRuleArray() {
		return ruleArray;
	}
	public int getRuleNum() {
		return ruleNum;
	}
	
}
