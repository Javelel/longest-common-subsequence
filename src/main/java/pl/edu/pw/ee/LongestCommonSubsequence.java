package pl.edu.pw.ee;

class LongestCommonSubsequence {
    
    private String topStr;
    private String leftStr;
    private final int LEFT = 0;
    private final int DIAG = 1;
    private final int TOP = 2;
    private StringBuilder result;
	private Cell[][] table;
	private boolean isLCSFound = false;

    public LongestCommonSubsequence(String topStr, String leftStr){
		if (topStr == null || leftStr == null) {
			throw new IllegalArgumentException("any of arguments cannot be null");
		}
		this.topStr = topStr;
        this.leftStr = leftStr;
		this.result = new StringBuilder();

		table = new Cell[leftStr.length()+1][topStr.length()+1];
		for (int i = 0; i < leftStr.length() + 1; i++) {
			for (int j = 0; j < topStr.length() + 1; j++) {
				table[i][j] = new Cell(0);
			}
		}
    }
    

    public String findLCS(){

        
        for(int i = 0; i < leftStr.length() + 1; i++) {
            table[i][0].setVal(0);
        }
        
        for(int i = 0; i < topStr.length() + 1; i++) {
            table[0][i].setVal(0);
        }
        
        for(int i = 1; i < leftStr.length() + 1; i++) {
            for(int j = 1; j < topStr.length() + 1; j++) {

                if (leftStr.charAt(i-1) == topStr.charAt(j-1)) {
                    table[i][j].setVal(table[i-1][j-1].getVal() + 1);
                    table[i][j].setDirection(DIAG);
                }
                else if(table[i][j-1].getVal() >= table[i-1][j].getVal()) {
                    table[i][j].setVal(table[i][j-1].getVal());
                    table[i][j].setDirection(LEFT);
                }
                else {
                    table[i][j].setVal(table[i-1][j].getVal());
                    table[i][j].setDirection(TOP);
                }
                
            }
        }

		int i = leftStr.length();
        int j = topStr.length();
        while (i != 0 && j != 0) {
            switch (table[i][j].getDirection()) {
                case LEFT:
					table[i][j].setOnRoute(true);
                    j--;
                    break;
                case TOP:
					table[i][j].setOnRoute(true);
                    i--;
                    break;
                case DIAG:
					table[i][j].setOnRoute(true);
					i--;
                    j--;
					result.append(leftStr.charAt(i));
                    break;
                default:
                    break;
            }
    	}
		isLCSFound = true;
		return result.reverse().toString();
    }

    public void display(){
		if (!isLCSFound) {
			throw new IllegalStateException("LCS must be found before using display method");
		}

		printFirstRow();

		for (int i = 0; i < leftStr.length() + 1; i++) {

			printTheFirstLineOfTheRow(i);

			System.out.println();

			printCharColumn(i);

			printTheSecondLineOfTheRow(i);

			System.out.println();

			System.out.print("|       |");
			for (int j = 0; j < topStr.length() + 1; j++) {
				System.out.print("     |");
			}
			System.out.println();

			System.out.print("+-------+");
			for (int j = 0; j < topStr.length() + 1; j++) {
				System.out.print("-----+");
			}
			System.out.println();
		}

    }

	private void printCharColumn(int i) {
		if (i == 0) {
			System.out.print("|       |");
		} else if (!Character.isWhitespace(leftStr.charAt(i-1))) {
			System.out.print("|   " + leftStr.charAt(i-1) + "   |");
		} else {
			System.out.print("|  " + convertWhitespaceToString(leftStr.charAt(i-1)) + "   |");
		}
	}

	private void printTheSecondLineOfTheRow(int i) {

		for (int j = 0; j < topStr.length() + 1; j++) {
			if (table[i][j].isOnRoute() && table[i][j].getDirection() == LEFT) {
				System.out.print("<");
			} else {
				System.out.print(" ");
			}

			if (table[i][j].getVal() <= 9) {
				System.out.print(" " + table[i][j].getVal() + "  |");
				continue;
			}
			if (table[i][j].getVal() <= 99) {
				System.out.print(" " + table[i][j].getVal() + " |");
				continue;
			}
			if (table[i][j].getVal() <= 999) {
				System.out.print("" + table[i][j].getVal() + " |");
			}
		}
	}

	private void printFirstRow() {
		System.out.print("+-------+");
		for (int i = 0; i < topStr.length() + 1; i++) {
			System.out.print("-----+");
		}
		System.out.println();
		System.out.print("|       |");
		for (int i = 0; i < topStr.length() + 1; i++) {
			System.out.print("     |");
		}
		System.out.println();
		System.out.print("|       |     |");
		for (int i = 0; i < topStr.length(); i++) {
			if (!Character.isWhitespace(topStr.charAt(i))) {
				System.out.print("  " + topStr.charAt(i) + "  |");
			} else {
				System.out.print(" " + convertWhitespaceToString(topStr.charAt(i)) + "  |");
			}
		}
		System.out.println();
		System.out.print("|       |");
		for (int i = 0; i < topStr.length() + 1; i++) {
			System.out.print("     |");
		}
		System.out.println();
		System.out.print("+-------+");
		for (int i = 0; i < topStr.length() + 1; i++) {
			System.out.print("-----+");
		}
		System.out.println();
	}

	private String convertWhitespaceToString(char c) {
		switch (c) {
			case '\n':
				return "\\n";
			case '\t':
				return "\\t";
			case '\r':
				return "\\r";
			case '\f':
				return "\\f";
			case '\b':
				return "\\b";
			default:
				return "  ";
		}
	}

	private void printTheFirstLineOfTheRow(int i) {
		System.out.print("|       |");
		for (int j = 0; j < topStr.length() + 1; j++) {
			if (table[i][j].isOnRoute() && table[i][j].getDirection() == DIAG) {
				System.out.print("\\    |");
			} else if (table[i][j].isOnRoute() && table[i][j].getDirection() == TOP) {
				System.out.print("  ^  |");
			} else {
				System.out.print("     |");
			}
		}
	}

}
