package com.company.sakila.db0.sakila.address.generated;

import com.company.sakila.db0.sakila.address.Address;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.core.manager.Manager;

/**
 * The generated base interface for the manager of every {@link
 * com.company.sakila.db0.sakila.address.Address} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedAddressManager extends Manager<Address> {
    
    @Override
    default Class<Address> getEntityClass() {
        return Address.class;
    }
}