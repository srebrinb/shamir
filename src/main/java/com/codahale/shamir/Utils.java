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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/** @author srebrin */
public class Utils {

  public static boolean PrettyPrinting = true;

  public static void printParts(Map<Integer, byte[]> map) {
    for (Map.Entry<Integer, byte[]> entry : map.entrySet()) {
      System.out.println(
          entry.getKey() + ":" + Base64.getEncoder().encodeToString(entry.getValue()));
    }
  }

  public static String parts2json(Map<Integer, byte[]> parts) {
    GsonBuilder gsonMapBuilder = new GsonBuilder();
    Gson gsonObject = gsonMapBuilder.create();
    if (PrettyPrinting) {
      gsonObject = new GsonBuilder().setPrettyPrinting().create();
    }
    Map<Integer, String> tmp = new HashMap<Integer, String>();
    for (Map.Entry<Integer, byte[]> entry : parts.entrySet()) {
      tmp.put(entry.getKey(), Hex.encodeHexString(entry.getValue()));
    }
    return gsonObject.toJson(tmp);
  }

  public static Map<Integer, byte[]> json2parts(String jsonString) throws DecoderException {
    Map<Integer, byte[]> res = new HashMap<Integer, byte[]>();
    Gson gson = new Gson();
    Type type = new TypeToken<Map<Integer, String>>() {}.getType();
    Map<Integer, String> map = gson.fromJson(jsonString, type);
    int i = 0;
    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      i++;
      try {
        i = Integer.valueOf(entry.getKey());
      } catch (java.lang.ClassCastException ex) {
        System.out.println("ex = " + ex);
      }
      byte[] val = Hex.decodeHex(entry.getValue());
      res.put(i, val);
    }
    return res;
  }
}
