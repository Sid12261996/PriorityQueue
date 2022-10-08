public interface PriorityImplementation<T> {
    public int compare(T entity1, T entity2);
    public String show(T entity1);
}
