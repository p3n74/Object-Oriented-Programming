

public class Main{

    static int List;
    static int MAX = 10;

    public static void main(String[] args) {

        VirtualHeap VH = new VirtualHeap();

        VH.initializeHeap(VH);

        List = -1;

        VH.insertLast(VH, 'A');
        VH.insertLast(VH, 'B');
        VH.insertLast(VH, 'C');
        VH.insertLast(VH, 'D');


        VH.displayList(VH, List);



        System.out.println("Hello world!");

    }
}

class VirtualHeap extends Main{

        Node[] nodes;
        int avail;

        public VirtualHeap(){
            nodes = new Node[MAX];
            int avail = 0;
        }

    public void initializeHeap(VirtualHeap VH){

        int i;
        for(i = 0; i < MAX - 1; i++){
            VH.nodes[i] = new Node(' ', i + 1);
        }
        VH.nodes[MAX-1] = new Node(' ', -1);

    }

    public int allocSpace(VirtualHeap VH){
        int space = VH.avail;

        if(space != -1){
            VH.avail = VH.nodes[VH.avail].next;
        }

        return space;
    }

    public void insertLast(VirtualHeap VH, char elem){

        int space = allocSpace(VH);
        if(space != -1){
            VH.nodes[space].elem = elem;
            VH.nodes[space].next = -1;

            if(super.List == -1){
                super.List = space;
            } else {
                int i;
                for(i = super.List; VH.nodes[i].next != -1; i = VH.nodes[i].next){}
                VH.nodes[i].next = space;
            }


        }
    }

    public void displayList(VirtualHeap VH, int list){

            int i;
            for(i = list; i != -1 && VH.nodes[i].next != -1; i = VH.nodes[i].next){
                System.out.println(VH.nodes[i].elem + ", ");
            }
            System.out.println(VH.nodes[i].elem);
    }
}

class HeapFunctions{

}


class Node {
    char elem;
    int next;

    public Node(char elem, int next) {
        this.elem = elem;
        this.next = next;
    }
}

