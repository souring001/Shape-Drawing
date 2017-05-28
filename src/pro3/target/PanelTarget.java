package pro3.target;
import java.awt.*; 
import java.awt.image.*;
import javax.swing.*;

import pro3.shape.Attribute;
import pro3.shape.ShapeManager;

/** 
 *  出力表示パネル
 */
public class PanelTarget extends JPanel implements Target{
  /** 描画操作に必要な情報を保持するオブジェクト（AWT で提供）*/
  private Graphics graphics;
  /** 描画用に確保された領域 */
  final BufferedImage image;
  /** パネルの幅 */
  final int width;
  /** パネルの高さ */
  final int height; 

  /** 
   *  出力表示パネルを生成する 
   *  @param width 幅
   *  @param height 高さ
   */
  public PanelTarget(int width, int height){
    this.width=width;
    this.height=height;
    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    graphics = image.getGraphics();
    graphics.setColor(new Color(255,255,255));
    graphics.fillRect(0, 0, width, height);
    setPreferredSize(new Dimension(width,height));
    setBackground(new Color(0,0,0));
  }
  
  @Override
  //  public synchronized void paintComponent(Graphics g){
  public synchronized void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null);
  }

  /** 図形集合の内容を削除
   *  @param sm 図形集合
   */
  @Override
  public synchronized void clear(final ShapeManager sm){
    sm.clear();
  }

  @Override
  public synchronized void draw(final ShapeManager sm){
  /* What is happened, when ``synchronized'' is not used */ 
    predraw();
    sm.draw(this);
    postdraw();
  }

  public synchronized void draw(final Target t, final ShapeManager sm){
  /* What is happened, when ``synchronized'' is not used */ 
    predraw();
    t.drawCore(sm);
    postdraw();
  }

  public void drawCore(final ShapeManager sm){
    draw(sm);
  }

  private void predraw(){
    Color c = graphics.getColor();
    graphics.setColor(new Color(255,255,255,255));
    graphics.fillRect(0, 0, width, height);
    graphics.setColor(c);
  }

  private void postdraw(){
  }

  @Override
  public void finish(){
  }

  @Override
  public synchronized void flush(){
    repaint();
  }

  /** 
   *  色を設定する
   */
  private void setColor(Attribute attr){
    if(attr!=null){
      int c[]=attr.getColor();
      graphics.setColor(new Color(c[0],c[1],c[2]));
    }
  }

  /** 
   *  円を描画する
   */
  @Override
  public void drawCircle(int id,int x, int y, int r, Attribute attr){
    setColor(attr);
    if(attr!=null && attr.getFill()){
      graphics.fillArc(x-r,y-r,r*2,r*2,0,360);
    }else{
      graphics.drawArc(x-r,y-r,r*2,r*2,0,360);
    }

  }

  /** 
   *  矩形を描画する
   */
  @Override
  public void drawRectangle(int id,int x,int y,int w,int h, 
      Attribute attr){
    setColor(attr);
    if(attr != null && attr.getFill()){
      graphics.fillRect(x, y, w, h); 
    }else{
      graphics.drawRect(x, y, w, h);
    }
  }

  /** 
   *  三角形を描画する
   */
  @Override
  public void drawTriangle(int id, int x1, int y1, int x2, int y2, int x3, int y3, Attribute attr){
    setColor(attr);
    int xs[] = {x1, x2, x3};
    int ys[] = {y1, y2, y3};
    if(attr != null && attr.getFill()){
      graphics.fillPolygon(xs, ys, 3); 
    }else{
      graphics.drawPolygon(xs, ys, 3);
    }
  }
  
  /** 
   *  多角形を描画する
   */
  @Override
  public void drawPolygon(int id, int n, int xs[], int ys[], Attribute attr){
    setColor(attr);
    if(attr != null && attr.getFill()){
      graphics.fillPolygon(xs, ys, n); 
    }else{
      graphics.drawPolygon(xs, ys, n);
    }
  }
  
  /** 
   *  テキストを描画する
   */
  @Override
  public void drawText(int id,String str, int x, int y, int s, Attribute attr){
    setColor(attr);
    graphics.setFont(new Font(Font.SERIF, Font.PLAIN, s));
    graphics.drawString(str,x,y);
  }

  /** 
   *  画像図形を描画する
   */
  @Override
  public void drawImage(int id, int x, int y, BufferedImage img, 
                        Attribute attr){
    setColor(attr);
    if(attr != null){
      if(attr.getFill()){
        graphics.fillRect(x, y, img.getWidth(), img.getHeight()); 
        graphics.drawImage(img,x,y,this);
        graphics.drawRect(x, y, img.getWidth(), img.getHeight()); 
      }else{
        graphics.drawImage(img,x,y,this);
        graphics.drawRect(x, y, img.getWidth(), img.getHeight()); 
      }
    }else{
      graphics.drawImage(img,x,y,this);
    } 
  }

}
