package cn.tedu.shoot;

//获得奖励的接口

public interface Award {
	
	//规定奖励对应的数值
	int DOUBLE_FIRE=0;//0奖励火力值
	int LIFE=1;//1奖励生命值
	//获得奖励类型
	public int getAward();

}
