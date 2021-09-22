package lesson3_hw;

import java.util.ArrayList;
import java.util.Formattable;

public class Box<T extends Fruit>{

    private float weightBox;
    private ArrayList<T> box;

    public ArrayList<T> getBox() {
        return box;
    }

    public void setBox(ArrayList<T> box) {
        this.box = box;
    }

    public float getWeight(ArrayList<T> box) {
        weightBox = 0;
        for(int i = 0; i < box.size(); i++) {
            weightBox = weightBox + box.get(i).getWeightFruit();
        }
        return weightBox;
    }

    public boolean compare(Box box) {

        return (this.weightBox == box.weightBox);
    }

    public void changeBox(Box box) {
        ArrayList<T> ttt = this.getBox();
        ArrayList<T> rrr = box.getBox();

        for (int i = 0; i < ttt.size(); i++) {
            rrr.add(ttt.get(i));
//            ttt.set(i) = null;
        }

    }

}
