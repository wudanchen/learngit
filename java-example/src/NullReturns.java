// Copyright (c) 2015, Synopsys, Inc. All rights reserved worldwide.

public class NullReturns {
    String callee(char [] c) {
        if (c == null) return null;
        else return new String(c);
    }

    void caller() {
        String str = callee(null);
        System.out.println(str.toString());
    }
}
