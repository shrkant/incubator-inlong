/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.tubemq.corebase.utils;

public class Tuple3<T0, T1, T2> {

    /** Field 0 of the tuple. */
    private T0 f0 = null;
    /** Field 1 of the tuple. */
    private T1 f1 = null;
    /** Field 2 of the tuple. */
    private T2 f2 = null;

    /**
     * Creates a new tuple where all fields are null.
     */
    public Tuple3() {

    }

    /**
     * Creates a new tuple and assigns the given values to the tuple's fields.
     *
     * @param value0 The value for field 0
     * @param value1 The value for field 1
     * @param value2 The value for field 2
     */
    public Tuple3(T0 value0, T1 value1, T2 value2) {
        this.f0 = value0;
        this.f1 = value1;
        this.f2 = value2;
    }

    public T0 getF0() {
        return f0;
    }

    public T1 getF1() {
        return f1;
    }

    public T2 getF2() {
        return f2;
    }
}