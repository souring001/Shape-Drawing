package pro3.shape;
import pro3.target.Target;

/** 
 *   多角形
 */
 
 
public class Polygon extends Shape{
  /** 頂点数 */
  private int n;
  /** 点1...nのx座標, y座標 */
  private int xs[], ys[];
  /** 属性 */
  private Attribute attr;

  /** 多角形を生成する
   *  @param id 識別子
   *  @param n  頂点数
   *  @param xs  点1...nのx座標の配列
   *  @param ys  点1...nのy座標の配列
   */
  public Polygon(int id, int n, int xs[], int ys[]){
    super(min(xs), max(xs), min(ys), max(ys));
    this.xs = new int[n];
    this.ys = new int[n];
    this.id=id;
    this.n = n;
    for(int i = 0; i < n; i++){
    	this.xs[i] = xs[i];
    	this.ys[i] = ys[i];
    }
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

  /** この多角形出力する
   *  @param target 出力先
   */
  @Override
  public void draw(Target target){
    target.drawPolygon(id, n, xs, ys, attr);
  }
  
  static int max(int x[]){
  	int m = Integer.MIN_VALUE;
  	for(int i = 0; i < x.length; i++) m = Math.max(m, x[i]);
  	return m;
  }
  
  static int min(int x[]){
  	int m = Integer.MAX_VALUE;
  	for(int i = 0; i < x.length; i++) m = Math.min(m, x[i]);
  	return m;
  }
}
