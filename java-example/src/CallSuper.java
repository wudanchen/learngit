// Copyright (c) 2015, Synopsys, Inc. All rights reserved worldwide.

public class CallSuper {

    protected Object clone() throws CloneNotSupportedException {
        // This isn't going to work in subclasses because their
        // clone methods will not be able to return an object
        // of the right type.
        // This method should instead return the reference
        // returned by calling super.clone().
        return new CallSuper();
    }
}

class CallSuper2 extends CallSuper {
    private String myData;
    protected Object clone() throws CloneNotSupportedException {
        // Unfortunately, this cast will fail.
        CallSuper2 cs = (CallSuper2) super.clone();
        // Make a new copy of myData instead of sharing.
        cs.myData = new String(this.myData);
        return cs;
    }
}
