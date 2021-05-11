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

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
// import com.google.zxing.BufferedImageLuminanceSource;
import com.google.zxing.DecodeHintType;
//import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
//import org.junit.Assert;
//import org.junit.Test;

import javax.imageio.ImageIO;
// import java.awt.Graphics;
// import java.awt.geom.AffineTransform;
// import java.awt.geom.RectangularShape;
// import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.BufferedReader;
import java.io.IOException;
// import java.nio.charset.Charset;
// import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// import java.util.ArrayList;
import java.util.EnumMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Properties;
// import java.util.logging.Logger;

import java.awt.*;
import java.io.*;

import com.google.zxing.common.HybridBinarizer;

public class QRCodeFuzzer {
    public static void fuzzerTestOneInput(byte[] input) {
        Path file = Paths.get("src/test/resources/golden/qrcode/");
        Reader barcodeReader;
        BarcodeFormat expectedFormat;
        // EnumMap<DecodeHintType,Object> hints = new EnumMap<>(DecodeHintType.class);
        // Map<DecodeHintType,Object> hints = hints.clone();

        InputStream is = new ByteArrayInputStream(input);


        try {
            BufferedImage image = ImageIO.read(is);
            //BufferedImage image = ImageIO.read(file.toFile());
        //    LuminanceSource source = new BufferedImageLuminanceSource(image);
        //    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        } catch (IOException e) {
            //TODO: handle exception
        }
        
        // try {
        //     Map<DecodeHintType,Object> pureHints = new EnumMap<>(hints);
        //     pureHints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
        //     result = barcodeReader.decode(bitmap, pureHints);
        //   } catch (ReaderException re) {
        //     // continue
        //   }

	}
}
