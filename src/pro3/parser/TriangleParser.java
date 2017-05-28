package pro3.parser;
import java.util.Scanner;

import pro3.shape.Attribute;
import pro3.shape.Triangle;

class TriangleParser implements ShapeParser{
  TriangleParser(){
  }
  @Override
  public Triangle parse(Scanner s, int id){
    int x1 = s.nextInt();
    int y1 = s.nextInt();
    int x2 = s.nextInt();
    int y2 = s.nextInt();
    int x3 = s.nextInt();
    int y3 = s.nextInt();
    Triangle ret = new Triangle(id,x1,y1,x2,y2,x3,y3);
    if(s.hasNext("Attribute")){
      Attribute attr = AttributeParser.parse(s);
      ret.setAttribute(attr);
    }
    return ret;
  }

}
