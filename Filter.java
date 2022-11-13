package coolcutsPipeAndFilter;


public interface Filter<T> {
    T execute (T input);

}
