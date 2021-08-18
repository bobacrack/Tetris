import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> objectList = new LinkedList<GameObject>();

    public void tick(){
        for (int i = 0; i < objectList.size(); i++){
            GameObject tmpObj = objectList.get(i);
            tmpObj.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < objectList.size(); i++){
            GameObject tmpObj = objectList.get(i);
            tmpObj.render(g);
        }
    }

    public void addObject(GameObject obj){
        this.objectList.add(obj);
    }

    public void removeObj(GameObject obj){
        this.objectList.remove(obj);
    }
}
