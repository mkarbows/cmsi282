import java.util.ArrayList;

public class ArrayStack<T> extends ArrayList<T> {
    public boolean push(T obj) {
        return this.add(obj);
    }
    public T pop() {
        return this.remove(this.size()-1);
    }
    public T peek() {
        return this.get(this.size() - 1);
    }
}
