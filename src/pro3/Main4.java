package pro3;
import pro3.shape.*;
import pro3.target.*;

/** 追加機能描画デモ */
public class Main4{
  /** メインメソッド
   * @param args このプログラムでは値は使用されません
   */
  public static void main(String[] args){
    ShapeManager sm = new ShapeManager();
    Target target;
    target = new WindowTarget("DisplayShapes", 640, 360);
    //target = new TextTarget(System.out);
    
    //切り替えのタイミング
    int t1,t2,t3,t4,t5,t6,t7;
    t1 = 110;
    t2 = t1+10;
    t3 = t2+10;
    t4 = t3+10;
    t5 = t4+10;
    t6 = t5+145;
    t7 = t6+145;
    
    //回転の中心座標
    int xa,ya,xb,yb;
    
    //回転速度
    double v1 = 0.1;
    double v2 = -0.08;
    
    //黒属性
    Attribute att_black = new Attribute();
    att_black.setColor(32,32,32);
    
    //黒2
    Attribute att_black2 = new Attribute();
    att_black.setColor(0,0,0);
    
    //白
    Attribute att_white = new Attribute();
    att_white.setColor(255,255,255);
    
    //赤
    Attribute att_red = new Attribute();
    att_red.setColor(186,32,31);
    
    //図形1の性質
    int x_one[] = {279, 317, 321, 337, 340, 281, 278, 304, 304, 282};
    int y_one[] = {139, 134, 189, 190, 208, 217, 198, 196, 153, 156};
    
    //図形2の性質
    int x_two[] = {258, 322, 322, 291, 290, 335, 335, 264, 259, 300, 299, 261};
    int y_two[] = {142, 136, 191, 197, 205, 204, 227, 233, 179, 173, 155, 160};
    
    //図形3の性質
    int x_thr[] = {270, 343, 339, 269, 266, 314, 314, 268, 268, 315, 315, 268};
    int y_thr[] = {138, 138, 231, 235, 211, 200, 187, 192, 174, 169, 161, 163};
    
    //図形4の性質
    int x_fou[] = {242, 267, 274, 287, 287, 314, 313, 336, 335, 314, 314, 286, 285, 247};
    int y_fou[] = {133, 131, 176, 175, 131, 131, 174, 173, 203, 208, 229, 235, 212, 214};
    
    //フの性質
    int x_pu[] = {164,236,243,196,182,213,167};
    int y_pu[] = {131,131,155,218,209,156,158};
    
    //ロの外側の性質
    int x_ro1[] = {278,361,364,280};
    int y_ro1[] = {132,130,214,214};
    
    //ロの内側の性質
    int x_ro2[] = {302,338,344,306};
    int y_ro2[] = {155,152,190,193};
    
    //丸い物体Aの口
    int x_maru_a4[] = {78,98,118,133,135,132,132,115,94};
    int y_maru_a4[] = {211,208,219,240,255,257,247,224,213};
    
    //丸い物体Bの口
    int x_maru_b4[] = {395,383,394,416,462,478,476,454,420,397,398};
    int y_maru_b4[] = {294,247,204,174,151,153,157,161,184,230,286};
    
    //テキストを描画する前のタイムラグ防止
    Shape dummyText = new Text(1, "",0,0,1);
    dummyText.setAttribute(att_black);
    sm.put(dummyText);
    target.draw(sm);
    target.flush();
    sm.remove(1);
    
    while(true){
    	//背景
      	Shape bg = new Rectangle(0, 0, 0, 640, 360);
      	Attribute att_bg = new Attribute();
      	att_bg.setColor(255, 220,5);
      	bg.setAttribute(att_bg);
      	sm.add(bg);
      	
      	//初期化
      	xa = 102;
    	ya = 256;
    	xb = 471;
    	yb = 241;
      	
      	//作業用変数
      	int x_maru_a4_2[], y_maru_a4_2[];
      	x_maru_a4_2 = new int[9];
      	y_maru_a4_2 = new int[9];
      	int x_maru_b4_2[], y_maru_b4_2[];
      	x_maru_b4_2 = new int[11];
      	y_maru_b4_2 = new int[11];
      	int x_pu_2[], y_pu_2[];
      	x_pu_2 = new int[7];
      	y_pu_2 = new int[7];
      	int x_ro1_2[], y_ro1_2[];
      	x_ro1_2 = new int[4];
      	y_ro1_2 = new int[4];
      	int x_ro2_2[], y_ro2_2[];
      	x_ro2_2 = new int[4];
      	y_ro2_2 = new int[4];
      	int x_thr_2[], y_thr_2[];
      	x_thr_2 = new int[12];
      	y_thr_2 = new int[12];
      	
      for(int t=0; t<t7;t++){
      	
      	
      	
      	if(0<=t && t< t1){
      		
      		//回転軸をずらすことで移動してフェードアウト
      		if(t >= t1-20){
      			xa -= 12;
      			xb += 12;
      		}
      		
      		//丸い物体A
      		Shape maru_a1 = new Circle(2, xa + (int)((97-xa)*Math.cos(t*v1)-(248-ya)*Math.sin(t*v1)), ya + (int)((97-xa)*Math.sin(t*v1)+(248-ya)*Math.cos(t*v1)),78);
    		maru_a1.setAttribute(att_black2);
    		sm.put(maru_a1);
    		Shape maru_a2 = new Circle(3,xa + (int)((101-xa)*Math.cos(t*v1)-(277-ya)*Math.sin(t*v1)), ya + (int)((101-xa)*Math.sin(t*v1)+(277-ya)*Math.cos(t*v1)),8);
    		maru_a2.setAttribute(att_white);
    		sm.put(maru_a2);
    		Shape maru_a3 = new Circle(4,xa + (int)((72-xa)*Math.cos(t*v1)-(244-ya)*Math.sin(t*v1)), ya + (int)((72-xa)*Math.sin(t*v1)+(244-ya)*Math.cos(t*v1)),4);
    		maru_a3.setAttribute(att_white);
    		sm.put(maru_a3);
    		for(int i = 0; i < 9; i++){
    			x_maru_a4_2[i] = xa + (int)((x_maru_a4[i]-xa)*Math.cos(t*v1)-(y_maru_a4[i]-ya)*Math.sin(t*v1));
    			y_maru_a4_2[i] = ya + (int)((x_maru_a4[i]-xa)*Math.sin(t*v1)+(y_maru_a4[i]-ya)*Math.cos(t*v1));
    		}
    		Shape maru_a4 = new Polygon(5,9,x_maru_a4_2,y_maru_a4_2);
    		maru_a4.setAttribute(att_white);
    		sm.put(maru_a4);
    		//丸い物体B469 236
    		Shape maru_b1 = new Circle(6,xb + (int)((469-xb)*Math.cos(t*v2)-(236-yb)*Math.sin(t*v2)), yb + (int)((469-xb)*Math.sin(t*v2)+(236-yb)*Math.cos(t*v2)),155);
    		maru_b1.setAttribute(att_black2);
    		sm.put(maru_b1);
    		Shape maru_b2 = new Circle(7,xb + (int)((485-xb)*Math.cos(t*v2)-(294-yb)*Math.sin(t*v2)), yb + (int)((485-xb)*Math.sin(t*v2)+(294-yb)*Math.cos(t*v2)),23);
    		maru_b2.setAttribute(att_white);
    		sm.put(maru_b2);
    		Shape maru_b3 = new Circle(8,xb + (int)((530-xb)*Math.cos(t*v2)-(202-yb)*Math.sin(t*v2)), yb + (int)((530-xb)*Math.sin(t*v2)+(202-yb)*Math.cos(t*v2)),18);
    		maru_b3.setAttribute(att_white);
    		sm.put(maru_b3);
    		for(int i = 0; i < 11; i++){
    			x_maru_b4_2[i] = xb + (int)((x_maru_b4[i]-xb)*Math.cos(t*v2)-(y_maru_b4[i]-yb)*Math.sin(t*v2));
    			y_maru_b4_2[i] = yb + (int)((x_maru_b4[i]-xb)*Math.sin(t*v2)+(y_maru_b4[i]-yb)*Math.cos(t*v2));
    		}
    		Shape maru_b4 = new Polygon(9,11,x_maru_b4_2,y_maru_b4_2);
    		maru_b4.setAttribute(att_white);
    		sm.put(maru_b4);
      		
      	}else if(t1<=t && t <t2){
      		if(t == t1){
      			sm.remove(2);
      			sm.remove(3);
      			sm.remove(4);
      			sm.remove(5);
      			sm.remove(6);
      			sm.remove(7);
      			sm.remove(8);
      			sm.remove(9);
      		}
      		//1
      		Shape one = new Polygon(1,10, x_one, y_one);
      		one.setAttribute(att_black);
      		sm.put(one);
      	}else if(t2<=t && t <t3){
      		//2
      		Shape two = new Polygon(1,12, x_two, y_two);
      		two.setAttribute(att_black);
    		sm.put(two);
      	}else if(t3<=t && t <t4){
      		//3
      		Shape thr = new Polygon(1,12, x_thr, y_thr);
      		thr.setAttribute(att_black);
    		sm.put(thr);
      	}else if(t4<=t && t <t5){
      		//4
      		Shape fou = new Polygon(1,14, x_fou, y_fou);
      		fou.setAttribute(att_black);
    		sm.put(fou);
      	}else if(t5<=t && t <t6){
      		if(t==t5)sm.remove(1);
      		//プロ３
      		if(t%10==0){
      			//フ
      			for(int i = 0; i < 7; i++){
    				x_pu_2[i] = (int)(Math.random()*5) + x_pu[i];
    				y_pu_2[i] = (int)(Math.random()*5) + y_pu[i];
    			}
    			Shape pu = new Polygon(29,7,x_pu_2,y_pu_2);
    			pu.setAttribute(att_black);
    			sm.put(pu);
    			
  			//ロの外側
      			for(int i = 0; i < 4; i++){
    				x_ro1_2[i] = (int)(Math.random()*5) + x_ro1[i];
    				y_ro1_2[i] = (int)(Math.random()*5) + y_ro1[i];
    			}
    			Shape ro1 = new Polygon(30,4,x_ro1_2,y_ro1_2);
    			ro1.setAttribute(att_black);
    			sm.put(ro1);
    			//ロの内側
      			for(int i = 0; i < 4; i++){
    				x_ro2_2[i] = (int)(Math.random()*5) + x_ro2[i];
    				y_ro2_2[i] = (int)(Math.random()*5) + y_ro2[i];
    			}
    			Shape ro2 = new Polygon(31,4,x_ro2_2,y_ro2_2);
    			ro2.setAttribute(att_bg);
    			sm.put(ro2);
    			//3
    			for(int i = 0; i < 12; i++){
    				x_thr_2[i] = (int)(Math.random()*5) + x_thr[i] +130;
    				y_thr_2[i] = (int)(Math.random()*5) + y_thr[i] - 20;
    			}
    			Shape thr2 = new Polygon(32,12,x_thr_2,y_thr_2);
    			thr2.setAttribute(att_black);
    			sm.put(thr2);
    			//。
    			Shape po = new Circle(33,249+(int)(Math.random()*2),111+(int)(Math.random()*2),20-(int)(Math.random()*3));
    			po.setAttribute(att_black);
    			sm.put(po);
    			Shape po2 = new Circle(34,249+(int)(Math.random()*2),111+(int)(Math.random()*2),3+(int)(Math.random()*2));
    			po2.setAttribute(att_bg);
    			sm.put(po2);
    		}
    		
      	}else if(t6<=t && t<t7){
      		if(t == t6){
      			sm.remove(29);
      			sm.remove(30);
      			sm.remove(31);
      			sm.remove(32);
      			sm.remove(33);
      			sm.remove(34);
      			Shape str1 = new Text(10, "※プログラミング",-20,100,90);
      			str1.setAttribute(att_black);
      			sm.put(str1);
      			Shape str2 = new Text(11, "第三とは",-20,200,90);
      			str2.setAttribute(att_black);
      			sm.put(str2);
      		}else if(t == t6 + 15){
      			Shape str3 = new Text(12, "講義の概要とねらい",30,60,16);
      			str3.setAttribute(att_black);
      			sm.put(str3);
      			Shape str4 = new Text(13, "UNIXのシステムコールを理解してシステムプログラミングを学ぶ．さらに並行シス",30,76,16);
      			str4.setAttribute(att_black);
      			sm.put(str4);
      			Shape str5 = new Text(14, "テムのモデルであるプロセスとプロセス間通信の概念，ネットワーク通信の基礎を学",30,92,16);
      			str5.setAttribute(att_black);
      			sm.put(str5);
      			Shape str6 = new Text(15, "習し，実際のプログラミング言語によるプログラミング法を学ぶ．また，抽象データ",30,108,16);
      			str6.setAttribute(att_black);
      			sm.put(str6);
      			Shape str7 = new Text(16, "型の概念の拡張であるオブジェクト中心のソフトウェア構築法を理解し，オブジェク",30,124,16);
      			str7.setAttribute(att_black);
      			sm.put(str7);
      			Shape str8 = new Text(17, "クト指向プログラミングを学ぶ．さらに並列プログラミングの基本を学び実際のプロ",30,140,16);
      			str8.setAttribute(att_black);
      			sm.put(str8);
      			Shape str9 = new Text(18, "グラミング言語によるプログラムを行う。",30,156,16);
      			str9.setAttribute(att_black);
      			sm.put(str9);
      		}else if(t == t6 + 35){
      			Shape str10 = new Text(19, "到達目標",10,170,32);
      			str10.setAttribute(att_black);
      			sm.put(str10);
      			Shape str11 = new Text(20, "UNIXシステムコールおよびネットワーク通信，",10,202,32);
      			str11.setAttribute(att_black);
      			sm.put(str11);
      			Shape str12 = new Text(21, "同期機構を利用した並行・並列プログラムをC・",10,234,32);
      			str12.setAttribute(att_black);
      			sm.put(str12);
      			Shape str13 = new Text(22, "Javaでプログラミングできること．",10,266,32);
      			str13.setAttribute(att_black);
      			sm.put(str13);
      		}else if(t == t6 + 55){
      			Shape str14 = new Text(23, "キーワード",50,290,24);
      			str14.setAttribute(att_black);
      			sm.put(str14);
      			Shape str15 = new Text(24, "システムコール, プロセス, ソケット通信, スレッドと同期, 並列プログラミング, C, Java",50,314,24);
      			str15.setAttribute(att_black);
      			sm.put(str15);
      		}else if(t == t6 + 75){
      			Shape str16 = new Text(25, "成績評価の基準及び方法",20,344,20);
      			str16.setAttribute(att_black);
      			sm.put(str16);
      			Shape str17 = new Text(26, "演習レポートと試験により評価する．",20,364,20);
      			str17.setAttribute(att_black);
      			sm.put(str17);
      		}else if(t == t6 + 90){
      			Shape str18 = new Text(27, "（OCW",-80,200,150);
      			str18.setAttribute(att_red);
      			sm.put(str18);
      			Shape str19 = new Text(28, "より引用）",-50,350,150);
      			str19.setAttribute(att_red);
      			sm.put(str19);
      		}
      	}
      	
      	target.draw(sm);
        target.flush();
        try{
          Thread.sleep(30);
        }catch(InterruptedException e){
        }
        
      }
      target.clear(sm);
      }
  }
}
