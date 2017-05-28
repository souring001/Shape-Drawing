package pro3.shape;
import pro3.target.Target;

/** 
 *   テキスト
 */
public class Text extends Shape{
  /** テキストの文字列 */
  private String str;
  /** テキストの座標 */
  private int x, y;
  /** テキストのサイズ */
  private int s;
  /** 属性 */
  private Attribute attr;

  /** テキストを生成する
   *  @param id 識別子
   *  @param str  テキストの文字列
   *  @param x  テキストのx座標
   *  @param y  テキストのy座標
   *  @param s  文字サイズ
   */
  public Text(int id, String str, int x, int y, int s){
    super(x, x+str.length()*s, y-s, y);
    this.str = str;
    this.id = id;
    this.x =x; 
    this.y = y;
    this.s = s;
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

  /** このテキストを出力する
   *  @param target 出力先
   */
  @Override
  public void draw(Target target){
    target.drawText(id, str, x, y, s, attr);
  }
}
