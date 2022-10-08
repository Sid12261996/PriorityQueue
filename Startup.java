public class Startup {
    public static class Pairs implements PriorityImplementation<Pairs> {
        int element;

        @Override
        public int compare(Pairs entity1, Pairs entity2) {
            return entity2.element - entity1.element;
        }

        @Override
        public String show(Pairs entity1) {
            return "" + entity1.element;
        }

        public Pairs(int element) {
            this.element = element;
        }
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue<Pairs> pq = new PriorityQueue<>();
        pq.add(new Pairs(8));
        pq.add(new Pairs(5));
        pq.add(new Pairs(9));
        pq.add(new Pairs(1));
        pq.add(new Pairs(1));
        pq.add(new Pairs(0));
        pq.add(new Pairs(1));
        pq.remove();
        pq.remove();
        System.out.println("the added element is: " + pq.peek().element);
    }
}
