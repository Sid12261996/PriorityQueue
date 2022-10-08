import java.util.ArrayList;

public class PriorityQueue<T extends PriorityImplementation<T>> {
    private final ArrayList<T> list = new ArrayList<>();

    //
//    private int simpleCompare(T entity1, T entity2){
//        return ;
//    }
    private int compare(int index, int parentIndex) {
        T currentItem = list.get(index);
        return currentItem.compare(currentItem, list.get(parentIndex));
    }

    private void upHeapify(int index) {
        if (index == 0) {
            return;
        }
        boolean isEven = (index % 2) == 0;
        int parentIndex = isEven ? (index - 2) / 2 : (index - 1) / 2;
        if (compare(index, parentIndex) > 0) {
            swap(index, parentIndex);
        }
        upHeapify(parentIndex);
    }

    private void swap(int fromIndex, int toIndex) {
        T fromItem = list.get(fromIndex);
        list.set(fromIndex, list.get(toIndex));
        list.set(toIndex, fromItem);
    }

    private void downHeapify(int index) {
        if (index >= list.size()) {
            return;
        }
        T root = list.get(index);
        T left = list.get((index * 2) + 1);
        T right = list.get((index * 2) + 2);
        T smallest = left.compare(left, right) > 0 ? left : right;
        smallest = smallest.compare(smallest, root) > 0 ? smallest : root;
        if (list.indexOf(smallest) != index) { // if current item is not the smallest, then swap
            swap(index, list.indexOf(smallest));
            downHeapify(list.indexOf(smallest));
        }
    }

    /**
     * steps for adding item on priority queue
     * 1. add element to the last position
     * 2. upheapify the heap
     *
     * @param entity
     */
    private boolean internalAdd(T entity) {
        try {
            list.add(entity);
            upHeapify(list.size() - 1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * steps:
     * 1. swap root and last element
     * 2. remove last element from the list
     * 3. downHeapify from root
     *
     * @return
     */
    private T internalRemove() {
        try {
            if (list.size() == 0) {
                return null;
            }
            swap(0, list.size() - 1);
            T removedElement = list.remove(list.size() - 1);
            downHeapify(0);
            return removedElement;

        } catch (Exception e) {
            return null;
        }
    }

    public void add(T entity) throws Exception {
        boolean result = internalAdd(entity);
        System.out.println(entity.show(entity) + " has" + (result ? "" : " not") + " been added to the PQ");
    }

    public T peek() throws Exception {
        System.out.println("items in the array are: [");
        for (T item : list) {
            System.out.println(item.show(item));
        }
        System.out.println("]");
        return list.get(0);
    }

    public T remove() throws Exception {
        T removedItem = internalRemove();
        if (removedItem != null) {
            System.out.println("removed item: " + removedItem.show(removedItem));
        }
        return removedItem;
    }
}
