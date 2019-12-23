package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Airplane extends FlyingObject implements Score{
	//定义保存小敌机需要的图片数组
	private static BufferedImage[] images;
	//静态块,在加载本类时,对图片数组赋值
	static {
		images=new BufferedImage[5];
		//为数组元素赋值
		images[0]=readImage("airplane0.png");
		for(int i=1;i<images.length;i++) {
			images[i]=readImage("bom"+i+".png");
		}
	}
	//小敌机的属性
	
	private int step;//速度
	
	//构造方法
	public Airplane() {
		super(48,50);
		step=3;
	}
	
	
	
	//编写一个输出小敌机信息的方法show
	public void show(){
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("速度:"+step);
	}
	int index=1;
	//重写父类的抽象方法
	public BufferedImage getImage() {
		BufferedImage img=null;
		//判断小敌机的状态
		if(isLife()) {
			//返回小敌机图片
			img=images[0];
		}else if(isDead()) {//判断是否死了
			//获得一张爆炸图片
			img=images[index];
			//获得下一张爆炸图片
			index++;
			//如果是最后一张图片
			if(index>=images.length) {
				//将当前状态改为移除
				state=REMOVE;
			}
		}
		return img;
	}
	
	//重新父类的抽象方法
	public void step() {
		y+=step;
	}



	
	public int getScore() {
		//击中小敌机得1分
		return 1;
	}
	
	
	
	
	
	

}
