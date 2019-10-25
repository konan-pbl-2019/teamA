package template.shooting2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTContainer;
import framework.RWT.RWTImage;
import framework.RWT.RWTLabel;
import framework.RWT.RWTVirtualController;
import framework.RWT.RWTVirtualKey;
import framework.audio.BGM3D;
import framework.audio.Sound3D;

public class StartContainer extends RWTContainer {
	private TemplateShooting2DMultiStates game;
	private Sound3D startBGM = BGM3D.registerBGM("data\\sound\\start.WAV");
	private Sound3D selectsound = new Sound3D("data\\sound\\select.wav");

	public StartContainer(TemplateShooting2DMultiStates game) {
		this.game = game;
	}

	@Override
	public void build(GraphicsConfiguration gc) {
		RWTImage image = new RWTImage("data\\images\\Background_StartScreen.jpg");
		image.setSize(1000,1000);
		addWidget(image);
		RWTLabel startLabel = new RWTLabel();
		startLabel.setString("カキン・ノ・ダズの冒険");
		startLabel.setColor(Color.white);
		startLabel.setRelativePosition(0.08f, 0.5f);
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
			game.scenario1();
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
