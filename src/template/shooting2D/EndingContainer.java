package template.shooting2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTContainer;
import framework.RWT.RWTLabel;
import framework.RWT.RWTVirtualController;
import framework.RWT.RWTVirtualKey;
import framework.audio.BGM3D;
import framework.audio.Sound3D;

public class EndingContainer extends RWTContainer {
	private TemplateShooting2DMultiStates game;
	private Sound3D startBGM = BGM3D.registerBGM("data\\sound\\start.wav");
	private Sound3D selectsound = new Sound3D("data\\sound\\select.wav");


	public EndingContainer(TemplateShooting2DMultiStates game) {
		this.game = game;
	}

	@Override
	public void build(GraphicsConfiguration gc) {

		RWTLabel startLabel = new RWTLabel();
		setBackground(Color.black);
		startLabel.setString("èI");
		startLabel.setColor(Color.white);
		startLabel.setRelativePosition(0f, 0.5f);
		Font f = new Font("", Font.PLAIN, 40);
		startLabel.setFont(f);
		addWidget(startLabel);
		BGM3D.playBGM(startBGM);
		repaint();
	}

	@Override
	public void keyPressed(RWTVirtualKey key) {
		if (key.getVirtualKey() == RWTVirtualController.BUTTON_A) {
			selectsound.play();
			game.restart();
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