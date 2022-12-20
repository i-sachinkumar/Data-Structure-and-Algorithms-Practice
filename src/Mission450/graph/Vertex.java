package Mission450.graph;

import java.util.Comparator;

public class Vertex implements Comparator<Vertex>{
    int data;
    int weight;
    Vertex(int data, int weight){
        this.data = data;
        this.weight = weight;
    }

    //un-weighted graph
    Vertex(int data){
        this.data = data;
        weight = 1;
    }

    @Override
    public String toString() {
        return data +"("+ weight+")";
    }
    @Override
    public int compare(Vertex o1, Vertex o2) {
        if(o1.weight == o2.weight) return o1.data - o2.data;
        return o1.weight - o2.weight;
    }

}
