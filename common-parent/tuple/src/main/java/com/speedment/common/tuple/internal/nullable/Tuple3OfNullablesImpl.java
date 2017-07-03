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
package com.speedment.common.tuple.internal.nullable;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.TupleOfNullables;
import com.speedment.common.tuple.internal.AbstractTupleOfNullables;
import com.speedment.common.tuple.nullable.Tuple3OfNullables;
import java.util.Optional;

/**
 * An implementation class of a {@link Tuple3OfNullables }
 * 
 * @param <T0> type of element 0
 * @param <T1> type of element 1
 * @param <T2> type of element 2
 * 
 * @author Per Minborg
 */
public final class Tuple3OfNullablesImpl<T0, T1, T2> 
extends AbstractTupleOfNullables 
implements Tuple3OfNullables<T0, T1, T2> {
    
    /**
     * Constructs a {@link TupleOfNullables } of type {@link Tuple3OfNullables
     * }.
     * 
     * @param e0 element 0
     * @param e1 element 1
     * @param e2 element 2
     */
    public Tuple3OfNullablesImpl(T0 e0, T1 e1, T2 e2) {
        super(Tuple3OfNullablesImpl.class, e0, e1, e2);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Optional<T0> get0() {
        return Optional.ofNullable((T0) values[0]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Optional<T1> get1() {
        return Optional.ofNullable((T1) values[1]);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Optional<T2> get2() {
        return Optional.ofNullable((T2) values[2]);
    }
}