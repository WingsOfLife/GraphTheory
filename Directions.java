/**
 * @author: Doc
 * @description: A class that sets up pseudo directions to manage the artifical array.
 **/

import java.util.*;

public class Directions {

    public static Direction[] dirs = {  Direction.LEFT, Direction.RIGHT, Direction.UP, Direction.DOWN };

    public enum Direction {

	UP(0, 1),
	DOWN(0, -1),
	LEFT(-1, 0),
	RIGHT(1, 0);

	public final int xOffset;
	public final int yOffset;

	Direction(int xOffset, int yOffset) {

	    this.xOffset = xOffset;
	    this.yOffset = yOffset;
	}
    }
}
