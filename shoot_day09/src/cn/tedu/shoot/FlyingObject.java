package cn.tedu.shoot;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public abstract class FlyingObject {
	//每个飞行物都有三种状态:活着,死了和移除
	public static final int LIFE=0;
	public static final int DEAD=1;
	public static final int REMOVE=2;
	//保存当前飞行物状态的属性
	protected int state=LIFE;//初始状态为活着

	//所有子类共有的属性
	protected int width;
	protected int height;
	protected int x;
	protected int y;

	public FlyingObject() {
		// TODO Auto-generated constructor stub
	}

	//小敌机大敌机奖励机的构造
	public FlyingObject(int width,int height) {
		Random ran=new Random();
		this.width=width;
		this.height=height;
		x=ran.nextInt(400-width);
		y=-height;
	}
	//天空子弹英雄机
	public FlyingObject(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	public void show() {
		System.out.println("宽:"+width+"gao:"+height);
		System.out.println("x:"+x+"y:"+y);

	}

	//这个方法用于读取图片到java程序
	public static BufferedImage readImage(String fileName) {
		try {
			//读物硬盘上的图片到img对象
			BufferedImage img=ImageIO.read(FlyingObject.class.getResource(fileName));
			return img;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	//判断飞行物的状态是否活着
	public boolean isLife() {
		return state==LIFE;
	}
	//判断飞行物是否死了
	public boolean isDead() {
		return state==DEAD;
	}
	//判断飞行物是否移除
	public boolean isRemove() {
		return state==REMOVE;
	}

	//编写抽象方法
	//获得图片(从数组中获得)
	public abstract BufferedImage getImage();

	//绘制获得的图片
	public void paintObject(Graphics g) {
		//将获得的图片绘制到画板(g)
		g.drawImage(getImage(),x,y,null);
	}

	//编写一个抽象方法step( ) 移动方法
	public abstract void step();

	//编写小敌机,大敌机,奖励机的出界方法
	public boolean outOfBounds() {
		//y轴大于屏幕高度就是出界了
		return y>World.HEIGHT;
	}
	
	//修改当前飞行物状态为DEAD的方法
	public void goDead() {
		state=DEAD;//飞行物去死
	}
	
	//判断飞行物是否相撞的方法
	//this想象为子弹,f想象为敌机
	public boolean hit(FlyingObject f) {
		//计算左侧和右侧x坐标
		int x1=f.x-this.width;
		int x2=f.x+f.width;
		//计算上方和下方1坐标
		int y1=f.y-this.height;
		int y2=f.y+f.height;
		//判断this的x和y是不是同事在界限范围内
		return this.x>x1 && this.x<x2 && this.y>y1 && this.y<y2;
	}
	
	





}
