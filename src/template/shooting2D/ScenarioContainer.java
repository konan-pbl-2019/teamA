package template.shooting2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTContainer;
import framework.RWT.RWTLabel;
import framework.RWT.RWTVirtualController;
import framework.RWT.RWTVirtualKey;

public class ScenarioContainer  extends RWTContainer {
    private TemplateShooting2DMultiStates game;

    public ScenarioContainer(TemplateShooting2DMultiStates game) {
        this.game = game;
    }

    @Override
    public void build(GraphicsConfiguration gc) {
        //RWTImage image = new RWTImage("data\\images\\Background_StartScreen.jpg");
//		addWidget(image);

        RWTLabel startLabel = new RWTLabel();
        startLabel.setString("時は2059年…");
        startLabel.setColor(Color.black);
        startLabel.setRelativePosition(0.05f, 0.3f);
        Font f = new Font("", Font.PLAIN, 20);
        startLabel.setFont(f);
        addWidget(startLabel);

        RWTLabel scenario1Label = new RWTLabel();
        scenario1Label.setString("カキン・ノ・ダズはなんやかんや金欠になって");
        scenario1Label.setColor(Color.black);
        scenario1Label.setRelativePosition(0.05f, 0.5f);
        Font a = new Font("", Font.PLAIN, 20);
        scenario1Label.setFont(a);
        addWidget(scenario1Label);

        RWTLabel scenario2Label = new RWTLabel();
        scenario2Label.setString("なんやかんや、中国最弱のマフィアの一因となった…");
        scenario2Label.setColor(Color.black);
        scenario2Label.setRelativePosition(0.05f, 0.7f);
        Font b = new Font("", Font.PLAIN, 20);
        scenario2Label.setFont(b);
        addWidget(scenario2Label);

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
