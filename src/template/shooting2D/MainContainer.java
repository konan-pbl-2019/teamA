package template.shooting2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTCanvas3D;
import framework.RWT.RWTContainer;
import framework.RWT.RWTLabel;
import framework.RWT.RWTVirtualKey;

public class MainContainer extends RWTContainer {
	RWTCanvas3D canvas;
	TemplateShooting2DMultiStates game = new TemplateShooting2DMultiStates();
	
	public MainContainer(TemplateShooting2DMultiStates game) {
		this.game = game;
	}
	
	@Override
	public void build(GraphicsConfiguration gc) {
		if (gc != null) {
			canvas = new RWTCanvas3D(gc);
		} else {
			canvas = new RWTCanvas3D();
		}
		canvas.setRelativePosition(0.0f, 0.05f);
		canvas.setRelativeSize(1.0f, 0.95f);

		RWTLabel mylife = new RWTLabel();
		mylife.setString("SCORE: "+Integer.toString(game.myShipSprite.myHP));
		mylife.setRelativePosition(0.4f, 0.05f);
		Font f = new Font("", Font.PLAIN, 20);
		mylife.setFont(f);
		mylife.setColor(Color.BLACK);
		addWidget(mylife);

		addCanvas(canvas);
		repaint();
	}

	// RWTë§Ç≈ÇÕÉCÉxÉìÉgèàóùÇÇµÇ»Ç¢
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
