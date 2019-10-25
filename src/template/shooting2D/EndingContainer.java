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

public class EndingContainer extends RWTContainer {
	private TemplateShooting2DMultiStates game;
	private Sound3D endBGM = BGM3D.registerBGM("data\\sound\\ending.wav");
	private Sound3D selectsound = new Sound3D("data\\sound\\select.wav");


	public EndingContainer(TemplateShooting2DMultiStates game) {
		this.game = game;
	}

	@Override
	public void build(GraphicsConfiguration gc) {
		RWTImage image = new RWTImage("data\\images\\Background_EndingScreen.png");
		image.setSize(1000,1000);
		addWidget(image);

		RWTLabel end1Label = new RWTLabel();
		end1Label.setString("終");
		end1Label.setColor(Color.white);
		end1Label.setRelativePosition(0.76f, 0.4f);
		Font f1 = new Font("", Font.PLAIN, 40);
		end1Label.setFont(f1);
		addWidget(end1Label);

		RWTLabel end2Label = new RWTLabel();
		end2Label.setString("制作・著作");
		end2Label.setColor(Color.white);
		end2Label.setRelativePosition(0.6f, 0.5f);
		Font f2 = new Font("", Font.PLAIN, 40);
		end2Label.setFont(f2);
		addWidget(end2Label);

		RWTLabel end3Label = new RWTLabel();
		end3Label.setString("―――――――――――――――――");
		end3Label.setColor(Color.white);
		end3Label.setRelativePosition(0.6f, 0.55f);
		Font f3 = new Font("", Font.PLAIN, 40);
		end2Label.setFont(f3);
		addWidget(end3Label);

		RWTLabel end4Label = new RWTLabel();
		end4Label.setString("ＰＢＬ");
		end4Label.setColor(Color.white);
		end4Label.setRelativePosition(0.68f, 0.65f);
		Font f4 = new Font("", Font.PLAIN, 40);
		end4Label.setFont(f4);
		addWidget(end4Label);

		BGM3D.playBGM(endBGM);

		repaint();
	}

	@Override
	public void keyPressed(RWTVirtualKey key) {
		if (key.getVirtualKey() == RWTVirtualController.BUTTON_C) {
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