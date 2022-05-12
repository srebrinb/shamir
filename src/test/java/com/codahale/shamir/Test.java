/*
 * Copyright © 2017 Coda Hale (coda.hale@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codahale.shamir;

import static com.codahale.shamir.Utils.*;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Map;

/** @author srebrin */
public class Test {

  public static void main(String[] args) {
    final Scheme scheme = new Scheme(new SecureRandom(), 5, 3);
    final byte[] secret = "hello there".getBytes(StandardCharsets.UTF_8);
    final Map<Integer, byte[]> parts = scheme.split(secret);
    printParts(parts);
    String ss = parts2json(parts);
    System.out.println("ss = " + ss);

    printParts(json2parts(ss));
    final byte[] recovered = scheme.join(parts);
    System.out.println(new String(recovered, StandardCharsets.UTF_8));
  }
}
