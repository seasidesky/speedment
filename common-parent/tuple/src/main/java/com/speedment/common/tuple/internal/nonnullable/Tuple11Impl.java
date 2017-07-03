/**
 * 
 * Copyright (c) 2006-2017, Speedment, Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at: 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.common.tuple.internal.nonnullable;

import com.speedment.common.tuple.Tuple11;
import com.speedment.common.tuple.Tuple;
import com.speedment.common.tuple.internal.AbstractTuple;

/**
 * An implementation class of a {@link Tuple11 }
 * 
 * @param <T0>  type of element 0
 * @param <T1>  type of element 1
 * @param <T2>  type of element 2
 * @param <T3>  type of element 3
 * @param <T4>  type of element 4
 * @param <T5>  type of element 5
 * @param <T6>  type of element 6
 * @param <T7>  type of element 7
 * @param <T8>  type of element 8
 * @param <T9>  type of element 9
 * @param <T10> type of element 10
 * 
 * @author Per Minborg
 */
public final class Tuple11Impl<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> 
extends AbstractTuple 
implements Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> {
    
    /**
     * Constructs a {@link Tuple } of type {@link Tuple11 }.
     * 
     * @param e0  element 0
     * @param e1  element 1
     * @param e2  element 2
     * @param e3  element 3
     * @param e4  element 4
     * @param e5  element 5
     * @param e6  element 6
     * @param e7  element 7
     * @param e8  element 8
     * @param e9  element 9
     * @param e10 element 10
     */
    public Tuple11Impl(
            T0 e0,
            T1 e1,
            T2 e2,
            T3 e3,
            T4 e4,
            T5 e5,
            T6 e6,
            T7 e7,
            T8 e8,
            T9 e9,
            T10 e10) {
        super(Tuple11Impl.class, e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T0 get0() {
        return ((T0) values[0]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T1 get1() {
        return ((T1) values[1]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T2 get2() {
        return ((T2) values[2]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T3 get3() {
        return ((T3) values[3]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T4 get4() {
        return ((T4) values[4]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T5 get5() {
        return ((T5) values[5]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T6 get6() {
        return ((T6) values[6]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T7 get7() {
        return ((T7) values[7]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T8 get8() {
        return ((T8) values[8]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T9 get9() {
        return ((T9) values[9]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T10 get10() {
        return ((T10) values[10]);
    }
}