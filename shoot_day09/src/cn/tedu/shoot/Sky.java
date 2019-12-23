package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sky extends FlyingObject{
	
	public static BufferedImage image;
	static {
		image=readImage("background0.png");
	}
	
	
	private int y1;//�ڶ��ű���ͼ��y������
	private int step;
	
	public Sky() {
		super(400,700,0,0);
		step=1;
		y1=-700;//�ڶ��ű���ͼ�ڽ����Ϸ�
		
	}
	
	
	public void show() {
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("�ٶ�:"+step);
		System.out.println("y1:"+y1);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	//�����ͼƬ�ƶ��л�
	public void paintObject(Graphics g) {
		//�����Ҫ������ͼ
		g.drawImage(getImage(),x,y,null);
		g.drawImage(getImage(),x,y1,null);
	}
	
	//���ű���ͼһ���ƶ�
	public void step() {
		y+=step;
		y1+=step;
		//���y���ڵ���700
		if(y>=World.HEIGHT) {
			y=-World.HEIGHT;
		}
		//���y1���ڵ���700
		if(y1>=World.HEIGHT) {
			y1=-World.HEIGHT;
		}
	}
	
	

}
