public class CustomLinkedList<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    public CustomLinkedList(){
        this.size = 0;
        first = null;
        last = null;
    }

    /** Lab Instructions:
     *      Implement the add() method such that any number of elements can be added
     *      sequentially to this list. Elements should be added to the end of the list.
     *      Be sure to increment the size with each successful operation.
     * @param data
     */
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = null;

        if(size == 0){
            first = newNode;
            last = newNode;
            size++;
            return;
        }

        last.next = newNode;
        last = newNode;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return this.size;
    }

    private class Node<T>{
        T item;
        Node<T> next;
        Node(T item){
            this.item = item;
        }
    }
}
