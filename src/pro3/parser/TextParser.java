package pro3.parser;
import java.util.Scanner;

import pro3.shape.Attribute;
import pro3.shape.Text;

class TextParser implements ShapeParser{
  TextParser(){
  }
  @Override
  public Text parse(Scanner s, int id){
    String str = s.next();
    int x = s.nextInt();
    int y = s.nextInt();
    int size = s.nextInt();
    Text ret = new Text(id,str,x,y,size);
    if(s.hasNext("Attribute")){
      Attribute attr = AttributeParser.parse(s);
      ret.setAttribute(attr);
    }
    return ret;
  }

}
