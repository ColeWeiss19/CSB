import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    int size = (int)(Math.random()*10);
    for(int i = 0; i < size; i++){
      list.add((int)(Math.random()*10));
    }
    System.out.println(list);
    System.out.print("[");
    for(int i = list.size()-1; i >= 0; i--){
      System.out.print(list.get(i));
      if(i != 0){
        System.out.print(", ");
      }
    }
    System.out.println("]");
    System.out.println("size = " + size);
  }
}
