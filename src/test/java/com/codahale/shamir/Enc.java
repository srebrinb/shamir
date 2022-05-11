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

import static com.codahale.shamir.Utils.printParts;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Map;

/**
 *
 * @author srebrin
 */
public class Enc {
    public static void main(String[] args) {
        Utils_SSS sss=new Utils_SSS(8,3);
        sss.setSecrit("12345678900987654321");
        String str_parts=sss.getParts();
        System.out.println("str_parts = " + str_parts);
        String s_parts=str_parts;
    
        sss.setParts(s_parts);
        
        System.out.println("res="+sss.getPlan());
    }
}
