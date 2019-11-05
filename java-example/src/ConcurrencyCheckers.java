// Copyright (c) 2015, Synopsys, Inc. All rights reserved worldwide.

import java.util.*;

public class ConcurrencyCheckers {

    private final Object lock = new Object();

    public synchronized void doA() {
        // TODO: Do stuff here...
    }
    public synchronized void doB() {
        synchronized(lock) {
            // TODO: Do other stuff here...
        }
    }
    public void lockInversion() {
        synchronized(lock) {
            doA();
        }
    }



    private final Object guardingLock = new Object();
    private List<Object> data = new ArrayList<Object>();

    public void addData(Object o) {
        synchronized(guardingLock) { data.add(o); }
    }
    public void removeData(Object o) {
        synchronized(guardingLock) { data.remove(o); }
    }
    public Object guardedByViolation(int i) {
        return data.get(i);
    }



    public MyVector<Object> v;
    /**
     * Remove the element just before 'o', starting at 'from'.
     */
    public void atomicity(Object o, int from) {
        int index = v.indexOf(o, from);
        if (index != -1) {
            // Unfortunately, another thread may have modified v in the meanwhile.
            v.remove(index - 1);
        }
    }

    // i is volatile because other threads should be able to access it consistently.
    public volatile int i;
    public void volatileAtomicity() {
        // Even with a volatile field, operations like increment are not atomic.
        // Consider using, for example java.util.concurrent.atomic.AtomicInteger, instead.
        i++;
    }

}


class MyVector<E> {
    //TODO: Finish implementing MyVector...
    Object[] elements;
    int len = 16;
    public MyVector () {
        elements = new Object[len];
    }
    public synchronized int indexOf(E e, int from) {
        for(int i = from; i < len; ++i) {
            if(e.equals(elements[i])) return i;
        }
        return -1;
    }
    public synchronized void remove(int i) {
        elements[i] = null;
    }
}
