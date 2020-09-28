package com.datasource.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;
@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
	/*定义缓存数据 key 生成策略的bean
	包名+类名+方法名+所有参数
	*/
	@Bean
	public KeyGenerator wiselyKeyGenerator() {
	return new KeyGenerator() {
	@Override
	public Object generate(Object target, Method method, Object... params) {
	StringBuilder sb = new StringBuilder();
	sb.append(target.getClass().getName());
	sb.append(method.getName());
	for (Object obj : params) {
	sb.append(obj.toString());
	}
	return sb.toString();
	}
	};

	}

	/*要启用spring缓存支持,需创建一个 CacheManager的 bean，CacheManager 接口有很多实现，这里Redis 的集成，用 RedisCacheManager这个实现类
	Redis 不是应用的共享内存，它只是一个内存服务器，就像 MySql 似的，
	我们需要将应用连接到它并使用某种“语言”进行交互，因此我们还需要一个连接工厂以及一个 Spring 和 Redis 对话要用的 RedisTemplate，
	这些都是 Redis 缓存所必需的配置，把它们都放在自定义的 CachingConfigurerSupport 中
	*/
	@Bean
	public CacheManager cacheManager(
	@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
	RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
	// cacheManager.setDefaultExpiration(60);//设置缓存保留时间（seconds）
	return cacheManager;
	}

	/***
	 * 这个是springboot2的版本，上面是1
	 * @param factory
	 * @return
	 */
	/*@Bean
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
		return RedisCacheManager
				.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
				.cacheDefaults(redisCacheConfiguration).build();
	}*/
	//1.项目启动时此方法先被注册成bean被spring管理
	@Bean
	public RedisTemplate<String, String> redisTemplate(
	RedisConnectionFactory factory) {
	StringRedisTemplate template = new StringRedisTemplate(factory);
	Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
	ObjectMapper om = new ObjectMapper();
	om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	jackson2JsonRedisSerializer.setObjectMapper(om);
	template.setValueSerializer(jackson2JsonRedisSerializer);
	template.afterPropertiesSet();
	return template;
	}
/*	--------------------- 
	作者：古柏树下 
	来源：CSDN 
	原文：https://blog.csdn.net/sinat_29774479/article/details/80108534 
	版权声明：本文为博主原创文章，转载请附上博文链接！*/
}
