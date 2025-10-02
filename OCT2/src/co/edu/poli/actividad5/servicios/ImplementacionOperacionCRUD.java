package co.edu.poli.actividad5.servicios;


import co.edu.poli.actividad5.model.ActividadTuristica;
import java.util.Arrays;
public class ImplementacionOperacionCRUD implements OperacionCRUD {


private ActividadTuristica[] storage;
private int size = 0; // número de elementos actualmente almacenados
private static int initialSize = 10;


public ImplementacionOperacionCRUD() {
this.storage = new ActividadTuristica[initialSize];
}
@Override
public boolean create(ActividadTuristica obj) {
if (obj == null || obj.getIdActividad() == null) return false;
// evitar duplicados por id
if (read(obj.getIdActividad()) != null) return false;
if (size == storage.length) expandStorage();
storage[size++] = obj;
return true;
}
@Override
public ActividadTuristica read(String id) {
if (id == null) return null;
for (int i = 0; i < size; i++) {
ActividadTuristica a = storage[i];
if (a != null && id.equals(a.getIdActividad())) {
return a;
}
}
return null;
}@Override
public boolean update(String id, ActividadTuristica obj) {
if (id == null || obj == null) return false;
for (int i = 0; i < size; i++) {
if (storage[i] != null && id.equals(storage[i].getIdActividad())) {
storage[i] = obj;
return true;
}
}
return false;
}
@Override
public boolean delete(String id) {
if (id == null) return false;
for (int i = 0; i < size; i++) {
if (storage[i] != null && id.equals(storage[i].getIdActividad())) {
int numMoved = size - i - 1;
if (numMoved > 0) {
System.arraycopy(storage, i + 1, storage, i, numMoved);
}
storage[--size] = null;
return true;
}
}
return false;
}
@Override
public ActividadTuristica[] listAll() {
return Arrays.copyOf(storage, size);
}
private void expandStorage() {
int newCapacity = storage.length * 2;
storage = Arrays.copyOf(storage, newCapacity);
}
public static int getInitialSize() {
return initialSize;
}public static void setInitialSize(int initialSize) {
	if (initialSize > 0) {
		ImplementacionOperacionCRUD.initialSize = initialSize;
	}
}
}