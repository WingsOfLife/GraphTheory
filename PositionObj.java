import java.util.*;

public class PositionObj {

    public final int xPos;
    public final int yPos;
    public char heldVal;

    public PositionObj(int xPos, int yPos) {

	this.xPos = xPos;
	this.yPos = yPos;
	this.heldVal = '=';
    }

    public PositionObj(int xPos, int yPos, char heldVal) {

	this.xPos = xPos;
	this.yPos = yPos;
	this.heldVal = heldVal;
    }

    public boolean equals(PositionObj obj) {

	return (obj.xPos == this.xPos) && (obj.yPos == this.yPos); // && (this.heldVal == obj.heldVal);
    }
}
