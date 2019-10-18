package template.shooting2D;


import java.util.ArrayList;

import framework.game2D.Sprite;
import framework.game2D.Velocity2D;

public class EnemySprite extends Sprite {
	// 髯ｦ譎会ｽｪ竏晄�幄楜螟ら舞邵ｺ�ｽｮBoundingSphere邵ｺ�ｽｮ陷企宦�ｽｾ�ｿｽ
	public double collisionRadius = 1.0;

	double t = 0.0;

	private int enemyHP = 10000;

	// 陟托ｽｾ陝ｷ霈費ｿｽ�ｽｮ隴幢ｿｽ陞滂ｽｧ隰ｨ�ｽｰ
	private final int MAX_DANMAKU = 32;

	// 陟托ｽｾ邵ｺ�ｽｮ騾具ｽｺ陝��ｿｽ隴弱ｅ�ｿｽ�ｽｮ隰ｨ�ｽｵ邵ｺ荵晢ｽ臥ｸｺ�ｽｮ闖ｴ蜥ｲ�ｽｽ�ｽｮ
	private final int BULLET_DISTANCE = 1;

	// 郢ｧ�ｽｲ郢晢ｽｼ郢晢ｿｽ邵ｺ�ｽｮ髯ｦ�ｽｨ驕会ｽｺ驕ｽ�ｿｽ陜暦ｽｲ邵ｺ荵晢ｽ芽�募干�ｽ狗ｸｺ阮吮�堤ｸｺ謔滂ｿｽ�ｽｺ隴夲ｽ･郢ｧ蜿･�ｽｹ�ｿｽ郢晢ｽｻ鬯ｮ蛟･�ｼ�
	int rangeWidth = TemplateShooting2D.RANGE;
	int rangeHeight = TemplateShooting2D.RANGE;

	//邨碁℃譎る俣
	public double timeenemy = 0.0;

	public EnemySprite(String imageFile) {
		super(imageFile);
	}

	// ////////////////////////////////////////////////////
	//
	// 隰ｨ�ｽｵ隶匁ｺ假ｿｽ�ｽｮ髯ｦ譎会ｽｪ竏晄�幄楜螟先悴鬨ｾ�ｽ｣郢晢ｽ｡郢ｧ�ｽｽ郢晢ｿｽ郢晢ｿｽ
	//
	// ///////////////////////////////////////////////////

	/**
	 * 髯ｦ譎会ｽｪ竏晄�幄楜螢ｹ�ｿｽ�ｽｮBounding Sphere�ｿｽ�ｽｼ莠･�ｽ｢�ｿｽ騾｡讙主ｸ･�ｿｽ�ｽｼ蟲ｨ�ｽ団ollisionRadius邵ｺ�ｽｧ髫ｪ�ｽｭ陞ｳ螢ｹ笘�郢ｧ�ｿｽ
	 *
	 * @param collisionRadius
	 *            -- BoundingSphere邵ｺ�ｽｮ陷企宦�ｽｾ�ｿｽ
	 */
	public void setCollisionRadius(double collisionRadius) {
		this.collisionRadius = collisionRadius;
	}

	/**
	 * 髯ｦ譎会ｽｪ竏晄�幄楜螢ｹ�ｿｽ�ｽｮBounding Sphere�ｿｽ�ｽｼ莠･�ｽ｢�ｿｽ騾｡讙主ｸ･�ｿｽ�ｽｼ蟲ｨ�ｿｽ�ｽｮ陷企宦�ｽｾ�ｿｽ郢ｧ螳夲ｽｿ譁絶�
	 *
	 * @return邵ｲ�ｿｽ BoundingSphere邵ｺ�ｽｮ陷企宦�ｽｾ�ｿｽ
	 */
	public double getCollisionRadius() {
		return collisionRadius;
	}

	// ////////////////////////////////////////////////////
	//
	// 隰ｨ�ｽｵ隶匁ｺ假ｿｽ�ｽｮ陟托ｽｾ郢ｧ蝣､蛹ｱ陝��ｿｽ邵ｺ蜷ｶ�ｽ狗ｹ晢ｽ｡郢ｧ�ｽｽ郢晢ｿｽ郢晢ｿｽ
	//
	// ///////////////////////////////////////////////////

	/**
	 * 陟托ｽｾ陝ｷ霈披�ｲ陷茨ｽ･邵ｺ�ｽ｣邵ｺ陂羊rayList郢ｧ螳夲ｽｿ譁絶�
	 *
	 * @return -- 陟托ｽｾ陝ｷ霈披�ｲ陷茨ｽ･邵ｺ�ｽ｣邵ｺ陂羊rayList
	 */
	public ArrayList<EnemyBullet> shootDanmaku() {
		double bulletX, bulletY;

		ArrayList<EnemyBullet> enemyBulletList = new ArrayList<EnemyBullet>();
		for (int i = 0; i < MAX_DANMAKU; i++) {
			EnemyBullet enemyBullet = new EnemyBullet("data\\images\\enemyBullet.gif");

			bulletX = BULLET_DISTANCE * (Math.cos(i * (2 * Math.PI / MAX_DANMAKU)));
			bulletY = BULLET_DISTANCE * (Math.sin(i * (2 * Math.PI / MAX_DANMAKU)));

			// 陟托ｽｾ邵ｺ�ｽｮ闖ｴ蜥ｲ�ｽｽ�ｽｮ郢ｧ螳夲ｽｨ�ｽｭ陞ｳ�ｿｽ
			enemyBullet.setPosition(this.getPosition());
			// 陟托ｽｾ邵ｺ�ｽｮ驕假ｽｻ陷崎ｼ費ｿｽ蜷ｶ縺醍ｹ晏現ﾎ晉ｹｧ螳夲ｽｨ�ｽｭ陞ｳ螢ｹ笘�郢ｧ�ｿｽ
			enemyBullet.setVelocity(new Velocity2D(bulletX * 5, bulletY * 5));

			enemyBulletList.add(enemyBullet);
		}

		return enemyBulletList;
	}

	// ////////////////////////////////////////////////////
	//
	// 隰ｨ�ｽｵ邵ｺ蠕後∴郢ｧ�ｽ｣郢晢ｽｳ郢晏ｳｨ縺郁怙�ｿｽ邵ｺ�ｽｫ邵ｺ�ｿｽ郢ｧ荵敖ｰ邵ｺ�ｽｩ邵ｺ�ｿｽ邵ｺ荵晢ｿｽ�ｽｮ郢晢ｽ｡郢ｧ�ｽｽ郢晢ｿｽ郢晢ｿｽ
	//
	// ///////////////////////////////////////////////////



	public void motion(long interval) {
		float a = 2.5f;
		t += 0.5f;

		Velocity2D vel = new Velocity2D(Math.sin(t)*a, this.getVelocity().getY());

		switch (insideX()) {
		case -1:
			vel.setX(Math.abs(this.getVelocity().getX()));
			break;
		case 1:
			vel.setX(Math.abs(this.getVelocity().getX()) * -1.0);
			break;
		}

		switch (insideY()) {
		case -1:
			vel.setY(Math.abs(this.getVelocity().getY()));
			break;
		case 1:
			vel.setY(Math.abs(this.getVelocity().getY()) * -1.0);
			break;
		}

		setVelocity(vel);
		super.motion(interval);

	}

	/**
	 * 騾包ｽｻ鬮ｱ�ｽ｢郢ｧ貉幄ｭ�ｽｹ陷ｷ莉｣竊楢怎�ｽｺ邵ｺ�ｽｦ邵ｺ�ｿｽ邵ｺ�ｽｪ邵ｺ�ｿｽ邵ｺ�ｿｽ?
	 *
	 * @return -1: X邵ｺ�ｽｮ髮具ｿｽ邵ｺ�ｽｮ隴�ｽｹ陷ｷ莉｣竊楢怎�ｽｺ邵ｺ�ｽｦ邵ｺ�ｿｽ郢ｧ�ｿｽ, 0: X隴�ｽｹ陷ｷ莉｣竊楢怎�ｽｺ邵ｺ�ｽｦ邵ｺ�ｿｽ邵ｺ�ｽｪ邵ｺ�ｿｽ, 1: X邵ｺ�ｽｮ雎�ｽ｣邵ｺ�ｽｮ隴�ｽｹ陷ｷ莉｣竊楢怎�ｽｺ邵ｺ�ｽｦ邵ｺ�ｿｽ郢ｧ�ｿｽ
	 */
	private int insideX() {
		if (this.getPosition().getX() > rangeWidth / 2.0) {
			return 1;
		} else if (this.getPosition().getX() < -rangeWidth / 2.0) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * 騾包ｽｻ鬮ｱ�ｽ｢郢ｧ轤ｭ隴�ｽｹ陷ｷ莉｣竊楢怎�ｽｺ邵ｺ�ｽｦ邵ｺ�ｿｽ邵ｺ�ｽｪ邵ｺ�ｿｽ邵ｺ�ｿｽ?
	 *
	 * @return -1: Y邵ｺ�ｽｮ髮具ｿｽ邵ｺ�ｽｮ隴�ｽｹ陷ｷ莉｣竊楢怎�ｽｺ邵ｺ�ｽｦ邵ｺ�ｿｽ郢ｧ�ｿｽ, 0: Y隴�ｽｹ陷ｷ莉｣竊楢怎�ｽｺ邵ｺ�ｽｦ邵ｺ�ｿｽ邵ｺ�ｽｪ邵ｺ�ｿｽ, 1: Y邵ｺ�ｽｮ雎�ｽ｣邵ｺ�ｽｮ隴�ｽｹ陷ｷ莉｣竊楢怎�ｽｺ邵ｺ�ｽｦ邵ｺ�ｿｽ郢ｧ�ｿｽ
	 */
	private int insideY() {
		if (this.getPosition().getY() > rangeHeight / 2.0) {
			return 1;
		} else if (this.getPosition().getY() < -rangeHeight / 2.0) {
			return -1;
		} else {
			return 0;
		}
	}

	// ////////////////////////////////////////////////////
	//
	// 隰ｨ�ｽｵ隶匁ｺ假ｿｽ�ｽｮHP鬮｢�ｽ｢鬨ｾ�ｽ｣郢晢ｽ｡郢ｧ�ｽｽ郢晢ｿｽ郢晢ｿｽ
	//
	// ///////////////////////////////////////////////////
	public boolean shootDown() {
		if (enemyHP <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public void addEnemyHP(int value) {
		enemyHP += value;
	}

	public int getEnemyHP() {
		return enemyHP;
	}

	public void setEnemyHP(int enemyHP) {
		this.enemyHP = enemyHP;
	}

}
