/*******************************************************************************
 * Copyright (c) 2016 Riguz.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.riguz.gags.io;

import static com.riguz.gags.base.Preconditions.checkNotNull;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Files {

    public static String readFirstLine(File file, Charset charset) throws IOException {
        try (Reader r = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), charset)) {
            return readFirstLine(r);
        }
    }

    public static List<String> readLines(File file, Charset charset) throws IOException {
        try (Reader r = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), charset)) {
            return readLines(r);
        }
    }

    public static <T> T readLines(File file, Charset charset, LineProcessor<T> callback) throws IOException {
        try (Reader r = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), charset)) {
            return readLines(r, callback);
        }
    }

    public static String readFirstLine(Readable readable) throws IOException {
        LineReader lineReader = new LineReader(readable);
        return lineReader.readLine();
    }

    public static List<String> readLines(Readable readable) throws IOException {
        List<String> result = new ArrayList<String>();
        LineReader lineReader = new LineReader(readable);
        String line;
        while ((line = lineReader.readLine()) != null) {
            result.add(line);
        }
        return result;
    }

    public static <T> T readLines(Readable readable, LineProcessor<T> processor) throws IOException {
        checkNotNull(readable);
        checkNotNull(processor);

        LineReader lineReader = new LineReader(readable);
        String line;
        while ((line = lineReader.readLine()) != null) {
            if (!processor.processLine(line)) {
                break;
            }
        }
        return processor.getResult();
    }

}
