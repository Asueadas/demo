package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class BigAirplane extends FlyingObject implements Score{
	
	private static BufferedImage[] images;
	static {
		images=new BufferedImage[5];
		images[0]=readImage("bigairplane0.png");
		for(int i=1;i<images.length;i++) {
			images[i]=readImage("bom"+i+".png");
		}
	}


	private int step;

	public BigAirplane(){
		super(66,89);
		step=3;
	}


	public void show() {
		System.out.println("¿í:"+width+",¸ß:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("ËÙ¶È:"+step);
	}
	
	int index=1;
	public BufferedImage getImage() {
		BufferedImage img=null;
		if(isLife()) {
			img=images[0];
		}else if(isDead()) {
			img=images[index];
			index++;
			if(index>=images.length) {
				state=REMOVE;
			}
		}
		return img;
	}
	
	public  void step() {
		y+=step;
	}


	
	public int getScore() {
		return 3;
	}

}
