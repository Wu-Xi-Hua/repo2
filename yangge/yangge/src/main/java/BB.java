import java.util.ArrayList;

public class BB  implements Comparable{

    public void go(int i){
        System.out.println(i);
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(arrayList);//[]
        arrayList.add("aa");
        System.out.println(arrayList.size());//1
        arrayList.remove("aa");
        System.out.println(arrayList.size());//0
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
