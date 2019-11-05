// Copyright (c) 2015, Synopsys, Inc. All rights reserved worldwide.

import java.io.*;

public class ResourceLeak {
    public void processFiles(String... srcs) throws IOException {
        // neither this method nor copyStreams closes
        // the FileInputStream nor the FileOutputStream
        for(String src : srcs) {
            processStreams(new FileInputStream(src));
        }
    }

    OutputStream dst;
    private void processStreams(InputStream src) throws IOException {
        int b;
        while ((b = src.read()) >= 0) {
            dst.write(b);
        }
    }
}
