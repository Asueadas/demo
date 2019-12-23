package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
	
	private static BufferedImage[] images;
	static {
		images=new BufferedImage[2];
		images[0]=readImage("hero0.png");
		images[1]=readImage("hero1.png");
	}
	
	
	private int life;//����ֵ
	private int doubleFire;//����ֵ
	
	public Hero(){
		//152��(400/2-97/2)������
		//410����Ϸ�����м俿�µ�Y��λ��,�ǹ����
		super(97,139,152,410);
		life=3;
		//doubleFireĬ��Ϊ0,���Բ���Ĭ��ֵ		
	}
	
	
	public void show() {
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x"+x+",y:"+y);
		System.out.println("����ֵ:"+life+",����ֵ:"+doubleFire);
	}
	
	int index=0;
	//Ӣ�ۻ�����ͼƬ�л���Ч��
	public BufferedImage getImage() {
		return images[index++%images.length];
	}
	
	//Ӣ�ۻ�������ƶ�,�շ���
	public void step() {
		
	}
	
	//Ӣ�ۻ����ڷ���
	//������������һ���ڵ����������ڵ�
	public Bullet[] shoot() {
		Bullet[] bs=null;
		//����һ������,����Ӣ�ۻ���1/4��
		//������ļ���
		int w=this.width/4-2;//-2�������ӵ��Ŀ�
		int h=20;//��������ӵ��ĸ�
		//���û�л���ֵ
		if(doubleFire<=0) {
			//������
			bs=new Bullet[1];
			bs[0]=new Bullet(x+2*w,y-h);
		}else {
			//˫����
			bs=new Bullet[2];
			bs[0]=new Bullet(x+w,y-h);
			bs[1]=new Bullet(x+3*w,y-h);
			doubleFire--;//˫���ڼ�����ֵ
		}
		return bs;
	}
	
	//Ӣ�ۻ��ƶ��ķ���
	public void moveTo(int x,int y) {
		//��Ϊ����������Ӣ�ۻ�������
		//����Ӣ�ۻ���x��yҪ�������ƶ�
		//�ֱ���Ӣ�ۻ���͸ߵ�һ��
		this.x=x-this.width/2;//�Լ���x���ڴ�������x��������һ��
		this.y=y-this.height/2;//�Լ���y���ڴ�������y������ߵ�һ��
	}
	
	//Ӣ�ۻ���������
	public void addLife() {
		life++;
	}
	//Ӣ�ۻ��ӻ���
	public void addDoubleFire() {
		doubleFire+=20;
	}
	
	//Ӣ�ۻ������ֵ�÷���
	public int getLife() {
		return life;
	}
	//Ӣ�ۻ�û���ֵ�ķ���
	public int getDoubleFire() {
		return doubleFire;
	}
	
	//Ӣ�ۻ�����
	public void subLife() {
		life--;
	}
	//Ӣ�ۻ���ջ���ֵ
	public void clearDoubleFire() {
		doubleFire=0;
	}

}
