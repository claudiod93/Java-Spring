/**
 * 
 */
package com.claudioantonio.homework.spring;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author claudioantonio
 *
 */
public interface AlarmRepository {

	@Cacheable(value = "alarms")
	List<String> getAll();

	@CacheEvict(value = "alarms", allEntries = true)
	void createNew(String text);
}
