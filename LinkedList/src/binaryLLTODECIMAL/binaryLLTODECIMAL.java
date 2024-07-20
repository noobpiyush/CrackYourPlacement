package binaryLLTODECIMAL;

public class binaryLLTODECIMAL {

    static class Node
    {
        boolean data;
        Node next;
    };

    static int convert(Node head){
        Node temp = head;
        int res  = 0;
        while ( temp != null ){

            res = (res << 1) + (temp.data?1:0);

            temp = temp.next;
        }

        return res;
    }
}
