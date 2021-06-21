// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////

import com.google.zxing.MultiFormatReader;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;

// only available if test.jar is build 
//import com.google.zxing.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.Map;


public class MultiFormatDecodeFuzzer {
    public static void fuzzerTestOneInput(byte[] input) {
        Reader barcodeReader = new MultiFormatReader();
        EnumMap<DecodeHintType,Object> hints = new EnumMap<>(DecodeHintType.class);
        Map<DecodeHintType,Object> pureHints = new EnumMap<>(hints);
        pureHints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);

        BufferedImage image = null;
        Result result = null;
        InputStream is = new ByteArrayInputStream(input);

        try {
            image = ImageIO.read(is);
        } catch (IOException e) { // imageIO is buggy in many openjdk versions, catch everything to reach zxing code
            return;
        }

        if (image != null) {
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = barcodeReader.decode(bitmap, pureHints);
                result.getText();
                result.getResultMetadata();
            } catch (ReaderException e) {
                return;
            }
        }
	}
}
