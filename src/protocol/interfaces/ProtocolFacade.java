package protocol.interfaces;

public interface ProtocolFacade<T> {
    void list();
    void delete(T node);
    T update(T node);
    void insert(T node);
    void findBy(int value);
}
