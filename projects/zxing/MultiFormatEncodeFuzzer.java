
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;

import java.util.EnumMap;
import java.util.Map;
import com.google.zxing.WriterException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.PDF417Writer;
 
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.QRCode;

import com.google.zxing.datamatrix.encoder.HighLevelEncoder;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;


public class MultiFormatEncodeFuzzer {
	public static void fuzzerTestOneInput(FuzzedDataProvider data) {
        switch (data.consumeInt()) {
            case 1:
                AztecCode aztec = null;
                try {
                    aztec = Encoder.encode(data.consumeRemainingAsString(), 25, com.google.zxing.aztec.encoder.Encoder.DEFAULT_AZTEC_LAYERS);
                } catch (IllegalArgumentException e) {
                    return;
                }
                aztec.isCompact();
                aztec.getLayers();
                aztec.getMatrix();
                break;
            case 2:
                Map<EncodeHintType,Object> hints = new EnumMap<>(EncodeHintType.class);
                hints.put(EncodeHintType.MARGIN, 0);
                int size = 64;
                PDF417Writer writer = new PDF417Writer();

                try {
                    BitMatrix matrix = writer.encode(data.consumeRemainingAsString(), BarcodeFormat.PDF_417, size, size, hints);
                    matrix.toString();
                } catch (WriterException e) {
                }
                break;
            case 3:
                try {
                    com.google.zxing.qrcode.encoder.Encoder.chooseMode(data.consumeRemainingAsString());
                    QRCode qrCode = com.google.zxing.qrcode.encoder.Encoder.encode(data.consumeRemainingAsString(), ErrorCorrectionLevel.H);
                    qrCode.toString();
                } catch (WriterException e) {
                }
                break;
            case 4:
                try {
                    CharSequence encoded = HighLevelEncoder.encodeHighLevel(data.consumeRemainingAsString());
                } catch (IllegalArgumentException e) {
                }
                break;
        }
	}
}
