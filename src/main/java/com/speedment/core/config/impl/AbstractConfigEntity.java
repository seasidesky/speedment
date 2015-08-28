/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
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
package com.speedment.core.config.impl;

import com.speedment.api.Speedment;
import com.speedment.api.annotation.External;
import com.speedment.api.config.Project;
import com.speedment.api.config.aspects.Child;
import com.speedment.api.config.aspects.Enableable;
import com.speedment.api.config.Node;
import com.speedment.api.config.aspects.Parent;
import com.speedment.util.Trees;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 * Generic representation of a ConfigEntity.
 *
 * This class is thread safe.
 *
 * @author pemi
 */
public abstract class AbstractConfigEntity implements Node, Enableable {

    private boolean enabled;
    private String name;

    protected AbstractConfigEntity(String defaultName) {
        this.enabled   = true;
        this.name      = defaultName;
        setDefaults();
    }

    protected abstract void setDefaults();

    @Override
    public Boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @External(type = String.class)
    @Override
    public String getName() {
        return name;
    }

    @External(type = String.class)
    @Override
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("A name can't be null");
        } else if (name.contains(".")) {
            throw new IllegalArgumentException("A name can't contain a '.' character");
        } else if (name.contains(" ")) {
            throw new IllegalArgumentException("A name can't contain a space character");
        }
        
        this.name = name;
    }
    
    @Override
    public Stream<? extends Parent<?>> ancestors() {
        return asChild()
            .flatMap(c -> c.getParent())
            .map(p -> (Parent<?>) p)
            .map(parent -> Trees.walkOptional(
                parent, (Parent<?> p) -> p.asChild()
                    .flatMap(c -> c.getParent())
                    .map(p2 -> (Parent<?>) p2),
                Trees.WalkingOrder.BACKWARD
            )).orElse(Stream.empty());
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <E extends Node> Optional<E> ancestor(final Class<E> clazz) {
        return ancestors()
            .filter(p -> clazz.isAssignableFrom(p.getClass()))
            .map(p -> (E) p)
            .findFirst();
    }
    
    @Override
    public <T extends Parent<?>> String getRelativeName(final Class<T> from, Function<String, String> childMapper) {
        Objects.requireNonNull(from);
        final StringJoiner sj = new StringJoiner(".", "", ".").setEmptyValue("");
        final List<Parent<?>> ancestors = ancestors().map(p -> (Parent<?>) p).collect(toList());
        boolean add = false;
        for (final Parent<?> parent : ancestors) {
            if (from.isAssignableFrom(parent.getClass())) {
                add = true;
            }
            if (add) {
                sj.add(childMapper.apply(parent.getName()));
            }
        }
        return sj.toString() + childMapper.apply(getName());
    }

    @Override
    public String toString() {
        return getInterfaceMainClass().getSimpleName()
            + " '" + Optional.of(this)
            .filter(AbstractConfigEntity::isChildInterface)
            .map(e -> (Child<?>) e)
            .flatMap(Child::getParent)
            .map(e -> getRelativeName(Project.class))
            .orElse(getName())
            + "'";
    }
}