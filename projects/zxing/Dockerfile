FROM gcr.io/oss-fuzz-base/base-builder

RUN curl -L https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip -o maven.zip && \
    unzip maven.zip -d $SRC/maven && \
    rm -rf maven.zip

ENV MVN $SRC/maven/apache-maven-3.6.3/bin/mvn

RUN git clone --depth 1 https://github.com/zxing/zxing

COPY build.sh $SRC/
COPY MultiFormatDecodeFuzzer.java MultiFormatEncodeFuzzer.java $SRC/
WORKDIR $SRC/zxing
