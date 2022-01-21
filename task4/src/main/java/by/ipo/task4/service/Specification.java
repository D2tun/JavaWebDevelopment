package by.ipo.task4.service;

/**
 * This is the interface of specification classes.
 * @author Pavel Isidovich
 *
 */
public interface Specification<T> {
	
	public boolean isSatisfiedBy(T object);

}
