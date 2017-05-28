package pro3.parser;
import java.util.Scanner;

import pro3.shape.Attribute;
import pro3.shape.Polygon;

class PolygonParser implements ShapeParser{
  PolygonParser(){
  }
  @Override
  public Polygon parse(Scanner s, int id){
    int n = s.nextInt();
    int xs[] = new int[n];
    int ys[] = new int[n];
    for(int i = 0; i < n; i ++){
    	xs[i] = s.nextInt();
    	ys[i] = s.nextInt();
    }
    Polygon ret = new Polygon(id,n,xs,ys);
    if(s.hasNext("Attribute")){
      Attribute attr = AttributeParser.parse(s);
      ret.setAttribute(attr);
    }
    return ret;
  }

}
