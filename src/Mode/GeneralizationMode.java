package Mode;

import Frame.DrawPanel;
import Shape.GeneralizationLine;

public class GeneralizationMode extends LineMode {
	// constructor
	public GeneralizationMode(DrawPanel DP) {
		super(DP);
	}

	@Override
	public void addLine() {
		DP.getLineList().add(new GeneralizationLine(startObj, startPortIndex, endObj, endPortIndex));
	}
}
