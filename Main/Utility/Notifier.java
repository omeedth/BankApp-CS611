package Main.Utility;

import java.util.Collection;
import java.util.Iterator;

public interface Notifier {
    public Collection<Listener> getListeners();
    public void addListener(Listener listener);
    public boolean removeListener(Listener listener);
    public void clearListeners();

    default void notifyListener(Listener listener, Object obj) {
        listener.update(obj);
    }

    default void notifyAllListeners(Object obj) {
        Iterator<Listener> listenerIterator = getListeners().iterator();
        while(listenerIterator.hasNext()) {
            Listener listener = listenerIterator.next();
            notifyListener(listener, obj);
        }
    }
}
