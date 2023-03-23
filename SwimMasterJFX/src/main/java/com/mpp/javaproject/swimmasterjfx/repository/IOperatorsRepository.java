package com.mpp.javaproject.swimmasterjfx.repository;


import com.mpp.javaproject.swimmasterjfx.domain.Operator;

public interface IOperatorsRepository extends IRepository<Integer, Operator>{
    /**
     * Finds an operator with given username
     * @param username - the username of the operator to be found
     *           - must not be null
     * @return  - the entity with the given username if it exists
     *          - null if the operator does not exist
     */
    Operator getOneByUsername(String username);
}
