/**
 * 
 */
package com.claudioantonio.homework.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author claudioantonio
 *
 */
@Service(value="alarmRepository")
public class MockAlarmRepository implements AlarmRepository {
	
	private List<String> alarms = Arrays.asList(new String[]{"Night alarm","alarm clock"});

	/* (non-Javadoc)
	 * @see com.claudioantonio.homework.spring.AlarmRepository#getAll()
	 */
	public List<String> getAll() {
		System.out.println("reading all the alarms...");
        return alarms;
	}

	/* (non-Javadoc)
	 * @see com.claudioantonio.homework.spring.AlarmRepository#createNew(java.lang.String)
	 */
	public void createNew(String text) {
		alarms = new ArrayList<String>(alarms);
        alarms.add(text);
	}

}
