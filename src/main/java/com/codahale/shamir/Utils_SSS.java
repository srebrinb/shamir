/*
 * Copyright 2022 srebrin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codahale.shamir;

import static com.codahale.shamir.Utils.json2parts;
import static com.codahale.shamir.Utils.parts2json;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author srebrin
 */
public class Utils_SSS {

    final private int n;
    final private int k;
    final private Scheme scheme;
    HashMap<Integer, byte[]> parts;

    public Utils_SSS(int n, int k) {
        this.n = n;
        this.k = k;
        scheme = new Scheme(new SecureRandom(), this.n, this.k);
    }

    public void setSecrit(String sec) {
        byte[] secret = sec.getBytes(StandardCharsets.UTF_8);
        parts = new HashMap<>(scheme.split(secret));
    }

    public String getParts() {
        return parts2json(parts);
    }
    public HashMap<Integer, byte[]> setParts(String str) {
        Map<Integer, byte[]> tmp= json2parts(str);
        parts = new HashMap<>(tmp);
        return parts;
    }
    public String getPlan(){
        byte[] recovered = scheme.join(parts);
        return new String(recovered, StandardCharsets.UTF_8);
    }
    

}
