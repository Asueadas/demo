package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Bullet extends FlyingObject{
	
	private static BufferedImage image;
	static {
		//��Ϊ��������,����ֱ�Ӹ�ֵ
		image=readImage("bullet.png");
	}
	
	private int step;
	
	public Bullet(int x,int y) {
		super(8,20,x,y);
		step=10;
		
	}
	
	
	
	public void show() {
		System.out.println("��:"+width+",��"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("�ٶ�:"+step);
	}
	
	public BufferedImage getImage() {
		BufferedImage img=null;
		//����ӵ����ŷ���ͼƬ
		if(isLife()) {
			img=image;
		}else if(isDead()) {
			//�ӵ��������,ֱ���Ƴ�
			state=REMOVE;
		}
		return img;
	}
	
	public void step() {
		y-=step;
	}
	
	//�ӵ�����ķ�����ͬ
	//������д�����еĳ��緽��
	public boolean outOfBounds() {
		//�ӵ���y��С�ڸ�������߶Ⱦ�Ϊ����
		return y<-height;
	}
	
	
	
	

}
