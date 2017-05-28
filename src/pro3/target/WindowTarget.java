package pro3.target;
import java.awt.*; 
import java.awt.image.*;
import java.awt.event.*; 
import javax.swing.*;

import pro3.shape.Attribute;
import pro3.shape.ShapeManager;

/** 
 *  出力表示ウィンドウ 
 */
public class WindowTarget extends JFrame implements Target{
  /** 描画対象領域 */
  PanelTarget panel;

  /** 出力表示ウィンドウを生成する．
   *  @param s ウィンドウのタイトル
   *  @param width  ウィンドウの幅
   *  @param height ウィンドウの高さ
   */
  public WindowTarget(String s, int width,  int height){
    super(s);
    panel = new PanelTarget(width,height);
    add(panel);
    pack();
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        setBackground(new Color(0,0,0));
        setVisible(true);
      }
    });
  }

  /** 出力表示ウィンドウを生成する．
   *  @param s ウィンドウのタイトル
   */
  public WindowTarget(String s){
    this(s,320,240);
  }
  
  /** 図形集合の内容を削除
   *  @param sm 図形集合
   */
  @Override
  public void clear(ShapeManager sm){
    panel.clear(sm);
  }

  /** 描画領域のバッファに描画する */
  @Override
  public void draw(ShapeManager sm){
    predraw();
    panel.draw(sm);
    postdraw();
  }

  @Override
  public void draw(Target t, ShapeManager sm){
    predraw();
    panel.draw(t,sm);
    postdraw();
  }

  @Override
  public void drawCore(final ShapeManager sm){
    draw(sm);
  }

  private void predraw(){
  }
  private void postdraw(){
  }

  /** 終了作業としてウィンドウを閉じる */
  @Override
  public void finish(){
    Toolkit.getDefaultToolkit().getSystemEventQueue()
      .postEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
  }

  /**
   *  描画領域を強制的に再描画する
   */
  @Override
  public void flush(){
    panel.flush();
  }
  
  /** 
   *  円を描画する
   */
  @Override
  public void drawCircle(int id,int x, int y, int r, Attribute attr){
    panel.drawCircle(id, x, y, r, attr);
  }

  /** 
   *  矩形を描画する
   */
  @Override
  public void drawRectangle(int id, int x, int y, int w, int h, Attribute attr){
    panel.drawRectangle(id, x, y, w, h, attr);
  }
  
  /** 
   *  三角形を描画する
   */
  @Override
  public void drawTriangle(int id, int x1, int y1, int x2, int y2, int x3, int y3, Attribute attr){
    panel.drawTriangle(id, x1, y1, x2, y2, x3, y3, attr);
  }
  
  /** 
   *  多角形を描画する
   */
  @Override
  public void drawPolygon(int id, int n, int xs[], int ys[], Attribute attr){
    panel.drawPolygon(id, n, xs, ys, attr);
  }

  /** 
   *  テキストを描画する
   */
  @Override
  public void drawText(int id, String str, int x, int y, int s, Attribute attr){
    panel.drawText(id, str, x, y, s, attr);
  }

  /** 
   *  画像図形を描画する
   */
  @Override
  public void drawImage(int id,int x,int y, BufferedImage img,
      Attribute attr){
    panel.drawImage(id, x, y, img, attr);
  }

}
