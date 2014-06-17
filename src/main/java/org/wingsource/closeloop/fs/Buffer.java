package org.wingsource.closeloop.fs;

/**
 * Created by sa on 15-06-2014.
 */
public class Buffer {
    private byte[] bytes;

    public Buffer(byte[] bytes) {
        this.bytes = bytes;
    }
    public byte[] getBytes() {
        return bytes;
    }
    public String toString() {
        return new String(this.bytes);
    }
}
