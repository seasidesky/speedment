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
package com.speedment.common.tuple.internal.nonnullable.mapper;

import com.speedment.common.tuple.Tuple11;
import com.speedment.common.tuple.TupleMapper;
import com.speedment.common.tuple.Tuples;
import java.util.function.Function;
import static java.util.Objects.requireNonNull;

/**
 * An implementation class of a {@link TupleMapper } of degree 11
 * 
 * @param <T>   Type of the original object for the mapper to use when creating
 *              a {@code Tuple }
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
public final class Tuple11MapperImpl<T, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> implements TupleMapper<T, Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
    
    private final Function<T, T0> m0;
    private final Function<T, T1> m1;
    private final Function<T, T2> m2;
    private final Function<T, T3> m3;
    private final Function<T, T4> m4;
    private final Function<T, T5> m5;
    private final Function<T, T6> m6;
    private final Function<T, T7> m7;
    private final Function<T, T8> m8;
    private final Function<T, T9> m9;
    private final Function<T, T10> m10;
    
    /**
     * Constructs a {@link TupleMapper } that can create {@link Tuple11 }.
     * 
     * @param m0  mapper to apply for element 0
     * @param m1  mapper to apply for element 1
     * @param m2  mapper to apply for element 2
     * @param m3  mapper to apply for element 3
     * @param m4  mapper to apply for element 4
     * @param m5  mapper to apply for element 5
     * @param m6  mapper to apply for element 6
     * @param m7  mapper to apply for element 7
     * @param m8  mapper to apply for element 8
     * @param m9  mapper to apply for element 9
     * @param m10 mapper to apply for element 10
     */
    public Tuple11MapperImpl(
            Function<T, T0> m0,
            Function<T, T1> m1,
            Function<T, T2> m2,
            Function<T, T3> m3,
            Function<T, T4> m4,
            Function<T, T5> m5,
            Function<T, T6> m6,
            Function<T, T7> m7,
            Function<T, T8> m8,
            Function<T, T9> m9,
            Function<T, T10> m10) {
        this.m0	=	requireNonNull(m0);
        this.m1	=	requireNonNull(m1);
        this.m2	=	requireNonNull(m2);
        this.m3	=	requireNonNull(m3);
        this.m4	=	requireNonNull(m4);
        this.m5	=	requireNonNull(m5);
        this.m6	=	requireNonNull(m6);
        this.m7	=	requireNonNull(m7);
        this.m8	=	requireNonNull(m8);
        this.m9	=	requireNonNull(m9);
        this.m10	=	requireNonNull(m10);
    }
    
    @Override
    public Tuple11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> apply(T t) {
        return Tuples.of(
            m0.apply(t),
            m1.apply(t),
            m2.apply(t),
            m3.apply(t),
            m4.apply(t),
            m5.apply(t),
            m6.apply(t),
            m7.apply(t),
            m8.apply(t),
            m9.apply(t),
            m10.apply(t)
        );
    }
    
    @Override
    public int degree() {
        return 11;
    }
    
    @Override
    public Function<T, ?> get(int index) {
        switch(index){
            case 0	: return	get0();
            case 1	: return	get1();
            case 2	: return	get2();
            case 3	: return	get3();
            case 4	: return	get4();
            case 5	: return	get5();
            case 6	: return	get6();
            case 7	: return	get7();
            case 8	: return	get8();
            case 9	: return	get9();
            case 10	: return	get10();
            default : throw new IndexOutOfBoundsException();
        }
    }
    
    public Function<T, T0> get0() {
        return m0;
    }
    
    public Function<T, T1> get1() {
        return m1;
    }
    
    public Function<T, T2> get2() {
        return m2;
    }
    
    public Function<T, T3> get3() {
        return m3;
    }
    
    public Function<T, T4> get4() {
        return m4;
    }
    
    public Function<T, T5> get5() {
        return m5;
    }
    
    public Function<T, T6> get6() {
        return m6;
    }
    
    public Function<T, T7> get7() {
        return m7;
    }
    
    public Function<T, T8> get8() {
        return m8;
    }
    
    public Function<T, T9> get9() {
        return m9;
    }
    
    public Function<T, T10> get10() {
        return m10;
    }
}