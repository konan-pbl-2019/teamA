package template.shooting2D;

import java.awt.GraphicsConfiguration;

import framework.RWT.RWTCanvas3D;
import framework.RWT.RWTContainer;
import framework.RWT.RWTVirtualKey;

public class MainContainer extends RWTContainer {
	RWTCanvas3D canvas;

	@Override
	public void build(GraphicsConfiguration gc) {
		if (gc != null) {
			canvas = new RWTCanvas3D(gc);
		} else {
			canvas = new RWTCanvas3D();
		}
		canvas.setRelativePosition(0.0f, 0.0f);
		canvas.setRelativeSize(1.0f, 1.0f);
		addCanvas(canvas);
		repaint();
	}

	// RWT‘¤‚Å‚ÍƒCƒxƒ“ƒgˆ—‚ğ‚µ‚È‚¢
	@Override
	public void keyPressed(RWTVirtualKey key) {
	}

	@Override
	public void keyReleased(RWTVirtualKey key) {
	}

	@Override
	public void keyTyped(RWTVirtualKey key) {
	}

}
