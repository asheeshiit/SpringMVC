package gajju.food.utils;

import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class CRCGenerator {
	
private static final long POLY64REV = 0xd800000000000000L;

    private static final long[] LOOKUPTABLE;

    static {
        LOOKUPTABLE = new long[0x100];
        for (int i = 0; i < 0x100; i++) {
            long v = i;
            for (int j = 0; j < 8; j++) {
                if ((v & 1) == 1) {
                    v = (v >>> 1) ^ POLY64REV;
                } else {
                    v = (v >>> 1);
                }
            }
            LOOKUPTABLE[i] = v;
        }
    }

    /**
     * Calculates the CRC64 checksum for the given data array.
     *
     * @param data
     *            data to calculate checksum for
     * @return checksum value
     */
    public static long getCode(String str) {
    	byte []data = str.getBytes();
        long sum = 0;
        for (int i = 0; i < data.length; i++) {
            final int lookupidx = ((int) sum ^ data[i]) & 0xff;
            sum = (sum >>> 8) ^ LOOKUPTABLE[lookupidx];
        }
        return sum;
    }

    private CRCGenerator() {
    }

	public static long getCode32(String str){
		byte []bytes = str.getBytes();
		Checksum checksum = new CRC32();
		checksum.update(bytes,0,bytes.length);
		long val = checksum.getValue();
		return val;
	}
	


}
