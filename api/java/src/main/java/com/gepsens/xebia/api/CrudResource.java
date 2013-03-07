package com.gepsens.xebia.api;

import java.util.Collection;

public interface CrudResource<T, I> {

    T get(I id);

    public void save(T t);

    public void delete(I t);

    public T update(T t);

    public Collection<T> paginate(I startToken, int max);
}
