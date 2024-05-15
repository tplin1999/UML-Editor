package Mode;

import Frame.DrawPanel;
import Shape.CompositionLine;

public class CompositionMode extends LineMode {
	// constructor
	public CompositionMode(DrawPanel DP) {
		super(DP);
	}

	@Override
	public void addLine() {
		DP.getLineList().add(new CompositionLine(startObj, startPortIndex, endObj, endPortIndex));
	}
}
