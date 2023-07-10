package types;

import java.util.ArrayList;
import java.util.List;

public class ULEB128 {

    public static byte[] encodeULEB128(int number) {
        List<Byte> bytes = new ArrayList<>();

        do {
            byte b = (byte)(number & 0x7F);
            number >>= 7;
            if (number != 0) {
                b |= 0x80;
            }
            bytes.add(b);
        } while (number != 0);

        byte[] encodedBytes = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            encodedBytes[i] = bytes.get(i);
        }

        return encodedBytes;
    }

    // Декодер
    public static int decodeULEB128(byte[] bytes) {
        int number = 0;
        int shift = 0;

        for (byte b : bytes) {
            int value = b & 0x7F;
            number |= value << shift;

            if ((b & 0x80) == 0) {
                break;
            }

            shift += 7;
        }

        return number;
    }
}
