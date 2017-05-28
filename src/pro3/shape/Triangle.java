package pro3.shape;
import pro3.target.Target;

/** 
 *   三角形
 */
public class Triangle extends Shape{
  /** 点1, 2, 3のx座標, y座標 */
  private int x1, y1, x2, y2, x3, y3;
  /** 属性 */
  private Attribute attr;

  /** 三角形を生成する
   *  @param id 識別子
   *  @param x1  点1のx座標
   *  @param y1  点1のy座標
   *  @param x2  点2のx座標
   *  @param y2  点2のy座標
   *  @param x3  点3のx座標
   *  @param y3  点3のy座標
   */
  public Triangle(int id, int x1, int y1, int x2, int y2, int x3, int y3){
    super(Math.min(x1, Math.min(x2, x3)), Math.max(x1, Math.max(x2, x3)), Math.min(y1, Math.min(y2, y3)), Math.max(y1, Math.max(y2, y3)));
    this.id=id;
    this.x1 =x1; 
    this.y1 = y1;
    this.x2 =x2; 
    this.y2 = y2;
    this.x3 =x3; 
    this.y3 = y3;
  }

  /** 属性を設定する
   *  @param a 属性
   */
  @Override
  public void setAttribute(Attribute a){
    attr = a;
  }

  /** 属性を取得する */
  @Override
  public Attribute getAttribute(){
    return attr;
  }

  /** この三角形を出力する
   *  @param target 出力先
   */
  @Override
  public void draw(Target target){
    target.drawTriangle(id, x1, y1, x2, y2, x3, y3, attr);
  }
}
