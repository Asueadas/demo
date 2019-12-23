package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Airplane extends FlyingObject implements Score{
	//���屣��С�л���Ҫ��ͼƬ����
	private static BufferedImage[] images;
	//��̬��,�ڼ��ر���ʱ,��ͼƬ���鸳ֵ
	static {
		images=new BufferedImage[5];
		//Ϊ����Ԫ�ظ�ֵ
		images[0]=readImage("airplane0.png");
		for(int i=1;i<images.length;i++) {
			images[i]=readImage("bom"+i+".png");
		}
	}
	//С�л�������
	
	private int step;//�ٶ�
	
	//���췽��
	public Airplane() {
		super(48,50);
		step=3;
	}
	
	
	
	//��дһ�����С�л���Ϣ�ķ���show
	public void show(){
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("�ٶ�:"+step);
	}
	int index=1;
	//��д����ĳ��󷽷�
	public BufferedImage getImage() {
		BufferedImage img=null;
		//�ж�С�л���״̬
		if(isLife()) {
			//����С�л�ͼƬ
			img=images[0];
		}else if(isDead()) {//�ж��Ƿ�����
			//���һ�ű�ըͼƬ
			img=images[index];
			//�����һ�ű�ըͼƬ
			index++;
			//��������һ��ͼƬ
			if(index>=images.length) {
				//����ǰ״̬��Ϊ�Ƴ�
				state=REMOVE;
			}
		}
		return img;
	}
	
	//���¸���ĳ��󷽷�
	public void step() {
		y+=step;
	}



	
	public int getScore() {
		//����С�л���1��
		return 1;
	}
	
	
	
	
	
	

}
