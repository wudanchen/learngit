// Copyright (c) 2015, Synopsys, Inc. All rights reserved worldwide.

public class UseAfterFree {
    void useAfterFreeExample() {
        android.media.MediaPlayer mp = new android.media.MediaPlayer();
        mp.release(); // Release all MediaPlayer resources.
        mp.setVolume(1, 1); // Too late to use the MediaPlayer now!
    }
}
