package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bee extends FlyingObject implements Award{
	
	private static BufferedImage[] images;
	static{
		images=new BufferedImage[5];
		images[0]=readImage("bee0.png");
		for(int i=1;i<images.length;i++) {
			images[i]=readImage("bom"+i+".png");
		}
	}
	
	
	private int xStep;//横向移动速度
	private int yStep;//纵向移动速度
	
	public Bee() {
		super(60,51);
		xStep=3;
		yStep=3;
		
	}
	
	
	
	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("x速度:"+x+",y速度:"+y);
	}
	
	int index=1;
	public BufferedImage getImage() {
		BufferedImage img=null;
		if(isLife()) {
			img=images[0];
		}else if(isDead()){
			img=images[index++];
			if(index>=images.length) {
				state=REMOVE;
			}
		}
		return img;
	}
	
	public void step() {
		y+=yStep;
		x+=xStep;
		//如果奖励机碰左侧或右侧边界
		if(x<=0 || x>=World.WIDTH-width) {
			//改变小敌机的移动方向
			xStep*=-1;
		}
	}



	//奖励
	public int getAward() {
		Random ran=new Random();
		//随机产生奖励0或1
		int num=ran.nextInt(2);
		return num;
	}
	
	
	

}
