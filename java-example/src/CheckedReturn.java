// Copyright (c) 2015, Synopsys, Inc. All rights reserved worldwide.

import java.io.*;

public class CheckedReturn {

    public byte readInput(InputStream is) throws IOException {
        byte[] input = new byte[42];
        is.read(input);
        // Fewer than 42 bytes may have been read.
        // If we checked the return value from read(input), we would know.
        return input[41];
    }

}
