package com.gepsens.xebia.api;

public interface CrudResource<T, I> {

    T get(I id);

    public void save(T t);

    public void delete(I t);

    public T update(T t);
}
