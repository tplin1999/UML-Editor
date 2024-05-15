package Mode;

import Frame.DrawPanel;
import Shape.AssociationLine;

public class AssociationMode extends LineMode {
	// constructor
	public AssociationMode(DrawPanel DP) {
		super(DP);
	}

	@Override
	public void addLine() {
		DP.getLineList().add(new AssociationLine(startObj, startPortIndex, endObj, endPortIndex));
	}
}
