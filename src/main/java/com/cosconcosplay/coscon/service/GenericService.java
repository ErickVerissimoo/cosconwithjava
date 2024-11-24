package com.cosconcosplay.coscon.service;

import java.util.List;

public interface GenericService<T, ID> {
void add(T entity) throws Exception;
T get(ID id ) throws Exception;
List<T> getAll();
void update (T entity) throws Exception;
void delete(ID id) throws Exception;
}
