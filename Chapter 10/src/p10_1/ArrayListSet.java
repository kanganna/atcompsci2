package p10_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ArrayListSet<E> implements Set<E>{

	private ArrayList<E> x;
	
	public ArrayListSet()
	{
		x = new ArrayList<E>();
	}
	
	@Override
	public boolean add(E e) {
		if(!x.contains(e))
		{
			x.add(e);
			return true;
		}
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for(Object a : c)
		{
			if(x.contains(a))
				return false;
			x.add((E) a);
		}
		return true;
	}

	@Override
	public void clear() {
		x.clear();
	}

	@Override
	public boolean contains(Object o) {
		return x.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return x.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return x.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return x.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return x.remove(o);
		
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return x.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return x.retainAll(c);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return x.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return x.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return x.toArray(a);
	}

}
