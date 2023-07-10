package types;

import java.util.Base64;

public class CustomBase64 {

    private static final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
    private static final Base64.Decoder decoder = Base64.getUrlDecoder();

    public static String encode(byte[] data) {
        // Note that this uses ISO-8859-1 - should be safe since Base64 uses only ASCII characters anyway
        return encoder.encodeToString(data);
    }

    public static byte[] decode(String encoded) {
        return decoder.decode(encoded);
    }

}
