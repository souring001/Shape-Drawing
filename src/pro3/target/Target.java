package pro3.target;
import pro3.shape.Attribute;
import pro3.shape.ShapeManager;
import java.awt.image.*;

/**
 *  出力装置のインタフェース
 */
public interface Target{
  /** 図形集合の内容を削除する
   *  @param sm 図形の集合
   */
  public void clear(ShapeManager sm);
  /** 出力装置のバッファに出力する
   *  @param sm 図形の集合
   */
  public void draw(ShapeManager sm);
  public void draw(Target t, ShapeManager sm);
  public void drawCore(ShapeManager sm);
  /** 出力装置を終了させる */
  public void finish();
  /** 出力装置に実際に描画する */
  public void flush();

  /** 円を出力する．
   *  @param id 円の識別子
   *  @param x  円の中心のx座標
   *  @param y  円の中心のy座標
   *  @param r  円の半径
   *  @param attr 円の属性
   */
  public void drawCircle(int id,int x, int y, int r, Attribute attr);
  
  /** 三角形を生成する
   *  @param id 識別子
   *  @param x1  点1のx座標
   *  @param y1  点1のy座標
   *  @param x2  点2のx座標
   *  @param y2  点2のy座標
   *  @param x3  点3のx座標
   *  @param y3  点3のy座標
   *  @param attr 三角形の属性
   */
  public void drawTriangle(int id, int x1, int y1, int x2, int y2, int x3, int y3, Attribute attr);

/** 多角形を生成する
   *  @param id 識別子
   *  @param n  頂点数
   *  @param xs  点1...nのx座標の配列
   *  @param ys  点1...nのy座標の配 列
   *  @param attr 三角形の属性
   */
  public void drawPolygon(int id, int n, int xs[], int ys[], Attribute attr);

  /** 矩形を出力する．
   *  @param id 矩形の識別子
   *  @param x  矩形の左上隅のx座標
   *  @param y  矩形の左上隅のy座標
   *  @param w  矩形の幅
   *  @param h  矩形の高さ
   *  @param attr 矩形の属性
   */
  public void drawRectangle(int id, int x, int y, int w, int h, Attribute attr);
  
  /** テキストを生成する
   *  @param id 識別子
   *  @param str  テキストの文字列
   *  @param x  テキストのx座標
   *  @param y  テキストのy座標
   *  @param s  文字サイズ
   */
  public void drawText(int id, String str, int x, int y, int s, Attribute attr);


  /** 画像図形を出力する．
   *  @param id 画像図形の識別子
   *  @param x  画像図形の左上隅のx座標
   *  @param y  画像図形の左上隅のy座標
   *  @param img  画像情報
   *  @param attr 画像図形の属性
   */
  public void drawImage(int id, int x, int y, BufferedImage img, Attribute attr);
}
