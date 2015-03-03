/**
 * @author: Doc
 **/

import java.util.*;
import java.lang.*;

public class Theory {

    public static Random rnd = new Random();

    public static final char GOAL_CHAR = 'X';
    public static final char ACCESS_CHAR = '=';
    public static final char MODIFIED = '-';

    //public static void main(String[] args) {

	//PositionObj[] modArr = {};
	//modArr = makeRandomArr(modArr, 7);
	//print(modArr, 7);
	//PositionObj goal = findShortestPath(modArr);
	//if (goal != null)
	    //  System.out.printf("Goal at: (%d, %d)\n", goal.xPos, goal.yPos);
	//else
	    //  System.out.println("No goal found.");
	//}

    public static int arraySize = 1;
    public static boolean print = false;

    public Theory(int arraySize, boolean print) {

	this.arraySize = arraySize;
	PositionObj[] modArr = {};
	modArr = makeRandomArr(modArr, arraySize);
	if (print) print(modArr, arraySize);
	PositionObj goal = findShortestPath(modArr, print);
	System.out.printf("Goal at: (%d, %d)\n-------\n", goal.xPos, goal.yPos);
    }

    public static PositionObj[] makeRandomArr(PositionObj[] toPlace, int size) {

	boolean isGoal = false;
	toPlace = new PositionObj[size * size];

	for (int i = 0; i < size; i++)
	    for (int j = 0; j < size; j++)
		toPlace[i * size + j] = new PositionObj(i, j, ACCESS_CHAR);

	toPlace[rnd.nextInt(size * size - 1)].heldVal = GOAL_CHAR;

	return toPlace;
    }

    public static void print(PositionObj[] toPrint, int size) {


	for (int i = 0; i < size; i++) {
	    System.out.println("");
	    for (int j = 0; j < size; j++) {
		System.out.printf("[%c], ", toPrint[i * size + j].heldVal);
	    }
	}

	System.out.println("\n-----------------\n");

	//int c = 0;
	//for (PositionObj pObj : toPrint) {

	//System.out.println("" + c);	    
	//System.out.printf("%d value of X: %d, Y: %d holding %c.\n", c, pObj.xPos, pObj.yPos, pObj.heldVal);
	//c++;
	//}
    }

    public static PositionObj findInArr(PositionObj toFind, PositionObj[] iter) {

	for (PositionObj pObj : iter) {

	    if (pObj.equals(toFind))
		return pObj;
	}

	return null;
    }

    public static void setSearched(PositionObj justS, PositionObj[] iter) {

	for (PositionObj pObj : iter) {

	    if (pObj.equals(justS))
		pObj.heldVal = MODIFIED;
	}
    }

    public static PositionObj findShortestPath(PositionObj[] iter, boolean print) {

	Queue<PositionObj> toSearch = new Queue<PositionObj>();
	//Stack<PositionObj> toSearch = new Stack<PositionObj>();
	LinkedList<PositionObj> path = new LinkedList<PositionObj>();

	toSearch.push(iter[0]);

	while (!toSearch.isEmpty()) {

	    //System.out.println("Items on stack: " + toSearch.size());

	    if (print)
		print(iter, arraySize);

	    PositionObj currentComp = toSearch.pop();
	    for (Directions.Direction dir : Directions.dirs) {

		PositionObj toComp = new PositionObj(currentComp.xPos + dir.xOffset, currentComp.yPos + dir.yOffset);
		if (findInArr(toComp, iter) != null) {

		    PositionObj arrVal = findInArr(toComp, iter);
		    // System.out.printf("Find neighbor with val: %c\n", arrVal.heldVal);
		    if (arrVal.heldVal == GOAL_CHAR) {
			for (PositionObj pObj : path)
			    System.out.printf("(%d, %d) -> ", pObj.xPos, pObj.yPos);

			System.out.println("Paths taken: " + path.size());
			return arrVal;
		    }
		    else if (arrVal.heldVal == MODIFIED) { }//path.add(arrVal); }
		    else {
		       
			//System.out.println("Adding to stack.");
			setSearched(arrVal, iter);
			toSearch.push(arrVal);
			path.add(arrVal);
		    }
		} 
	    }
	}

	return null;
    }
}
