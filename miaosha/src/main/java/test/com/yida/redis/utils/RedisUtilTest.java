package test.com.yida.redis.utils;

import com.yida.App;
import com.yida.redis.utils.RedisUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RedisUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 22, 2019</pre>
 */
@Component
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisUtilTest {
    @Autowired
    private RedisUtil redisUtil;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: expire(String key, long time)
     */
    @Test
    public void testExpire() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getExpire(String key)
     */
    @Test
    public void testGetExpire() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hasKey(String key)
     */
    @Test
    public void testHasKey() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: del(String... key)
     */
    @Test
    public void testDel() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: get(String key)
     */
    @Test
    public void testGet() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: set(String key, Object value)
     */
    @Test
    public void testSetForKeyValue() throws Exception {
//TODO: Test goes here...
        redisUtil.set("Hello", "Cessi");
    }

    /**
     * Method: set(String key, Object value, long time)
     */
    @Test
    public void testSetForKeyValueTime() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: incr(String key, long delta)
     */
    @Test
    public void testIncr() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: decr(String key, long delta)
     */
    @Test
    public void testDecr() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hget(String key, String item)
     */
    @Test
    public void testHget() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hmget(String key)
     */
    @Test
    public void testHmget() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hmset(String key, Map<String, Object> map)
     */
    @Test
    public void testHmsetForKeyMap() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hmset(String key, Map<String, Object> map, long time)
     */
    @Test
    public void testHmsetForKeyMapTime() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hset(String key, String item, Object value)
     */
    @Test
    public void testHsetForKeyItemValue() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hset(String key, String item, Object value, long time)
     */
    @Test
    public void testHsetForKeyItemValueTime() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hdel(String key, Object... item)
     */
    @Test
    public void testHdel() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hHasKey(String key, String item)
     */
    @Test
    public void testHHasKey() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hincr(String key, String item, double by)
     */
    @Test
    public void testHincr() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hdecr(String key, String item, double by)
     */
    @Test
    public void testHdecr() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: sGet(String key)
     */
    @Test
    public void testSGet() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: sHasKey(String key, Object value)
     */
    @Test
    public void testSHasKey() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: sSet(String key, Object... values)
     */
    @Test
    public void testSSet() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: sSetAndTime(String key, long time, Object... values)
     */
    @Test
    public void testSSetAndTime() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: sGetSetSize(String key)
     */
    @Test
    public void testSGetSetSize() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setRemove(String key, Object... values)
     */
    @Test
    public void testSetRemove() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: lGet(String key, long start, long end)
     */
    @Test
    public void testLGet() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: lGetListSize(String key)
     */
    @Test
    public void testLGetListSize() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: lGetIndex(String key, long index)
     */
    @Test
    public void testLGetIndex() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: lSet(String key, Object value)
     */
    @Test
    public void testLSetForKeyValue() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: lSet(String key, Object value, long time)
     */
    @Test
    public void testLSetForKeyValueTime() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: lUpdateIndex(String key, long index, Object value)
     */
    @Test
    public void testLUpdateIndex() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: lRemove(String key, long count, Object value)
     */
    @Test
    public void testLRemove() throws Exception {
//TODO: Test goes here... 
    }


} 
