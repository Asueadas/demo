package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sky extends FlyingObject{
	
	public static BufferedImage image;
	static {
		image=readImage("background0.png");
	}
	
	
	private int y1;//第二张背景图的y轴坐标
	private int step;
	
	public Sky() {
		super(400,700,0,0);
		step=1;
		y1=-700;//第二张背景图在界面上方
		
	}
	
	
	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("速度:"+step);
		System.out.println("y1:"+y1);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	//让天空图片移动切换
	public void paintObject(Graphics g) {
		//天空需要画两张图
		g.drawImage(getImage(),x,y,null);
		g.drawImage(getImage(),x,y1,null);
	}
	
	//两张背景图一起移动
	public void step() {
		y+=step;
		y1+=step;
		//如果y大于等于700
		if(y>=World.HEIGHT) {
			y=-World.HEIGHT;
		}
		//如果y1大于等于700
		if(y1>=World.HEIGHT) {
			y1=-World.HEIGHT;
		}
	}
	
	

}
