/**
 * 
 */
package com.claudioantonio.homework.spring;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author claudioantonio
 *
 */
@SuppressWarnings("restriction")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class AlarmRepositoryTest {
 
    private final String ALARM_CACHE_REGION_NAME = "alarms";
     
	@Resource
    private AlarmRepository alarmRepository;
     
	@Resource
    private CacheManager cacheManager;
     
    @Before
    public void initAlarmCache(){
        alarmRepository.getAll();
    }
     
    @Test
    public void theAlarmsMustBeInCache(){
        assertTheNumberOfObjectsInCache(ALARM_CACHE_REGION_NAME,1);
    }
     
    @Test
    public void theAlarmsMustEvictFromCacheBeInCache(){
        alarmRepository.createNew("Be careful...");
        assertTheNumberOfObjectsInCache(ALARM_CACHE_REGION_NAME,0);
    }
 
    private void assertTheNumberOfObjectsInCache(String regionName, int numberOfObjectsExpected) {
        final Cache alarmCache = cacheManager.getCache(regionName);
        Assert.assertEquals(numberOfObjectsExpected, ((net.sf.ehcache.Cache) alarmCache.getNativeCache()).getSize());
    }
}