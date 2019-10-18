package template.shooting2D;

import java.awt.Font;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTContainer;
import framework.RWT.RWTImage;
import framework.RWT.RWTLabel;
import framework.RWT.RWTVirtualController;
import framework.RWT.RWTVirtualKey;

public class StartContainer extends RWTContainer {
	private TemplateShooting2DMultiStates game;

	public StartContainer(TemplateShooting2DMultiStates game) {
		this.game = game;
	}

	@Override
	public void build(GraphicsConfiguration gc) {
		RWTImage image = new RWTImage("data\\images\\m101.jpg");
		addWidget(image);

		RWTLabel startLabel = new RWTLabel();
		startLabel.setString("�J�L���E�m�E�_�Y�̖`��");
		startLabel.setRelativePosition(0f, 0.5f);
		Font f = new Font("", Font.PLAIN, 40);
		startLabel.setFont(f);
		addWidget(startLabel);

		repaint();
	}

	@Override
	public void keyPressed(RWTVirtualKey key) {
		if (key.getVirtualKey() == RWTVirtualController.BUTTON_A) {
			game.play();
		}
	}

	@Override
	public void keyReleased(RWTVirtualKey key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(RWTVirtualKey key) {
		// TODO Auto-generated method stub

	}

}
