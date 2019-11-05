// Copyright (c) 2015, Synopsys, Inc. All rights reserved worldwide.

public class ForwardNull {

    void example(Object o) {
        if (o != null) {
        }
        // o will be null on the 'else' case of the if.
        System.out.println(o.toString());
    }
}
