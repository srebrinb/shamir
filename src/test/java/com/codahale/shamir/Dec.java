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

/**
 *
 * @author srebrin
 */
public class Dec {
    public static void main(String[] args) {
        Utils_SSS sss=new Utils_SSS(5,3);

        String s_parts="{\n" +
"  \"1\": \"QWKNwYDwoDpCoTXXYlnrxU5SK+s\\u003d\",\n" +
//"  \"2\": \"QCCFMHbevg4+hmnZxNB6jUfS8+k\\u003d\",\n" +
"  \"3\": \"MHA7xcMYKQxFF2w3nr6nfT2z6jM\\u003d\",\n" +
//"  \"4\": \"oegtxXsa+JzeTdV+4A43SfhmSl0\\u003d\",\n" +
"  \"5\": \"0biTMM7cb56l3NCQumDquYIHU4c\\u003d\"\n" +
"}";
        sss.setParts(s_parts);
        System.out.println("res="+sss.getPlan());
    }
}
