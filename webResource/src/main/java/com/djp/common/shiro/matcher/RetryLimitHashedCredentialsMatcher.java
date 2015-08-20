package com.djp.common.shiro.matcher;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Created by dengjianping on 2015/8/18.
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
//        @Autowired
        private CacheManager cacheManager;
        private Ehcache passwordRetryCache;

        public CacheManager getCacheManager() {
            return cacheManager;
        }

        public void setCacheManager(CacheManager cacheManager) {
            this.cacheManager = cacheManager;
        }


        public RetryLimitHashedCredentialsMatcher() {
            if(cacheManager != null){
                passwordRetryCache = (Ehcache) cacheManager.getCache("passwordRetryCache");
            }else{
                passwordRetryCache = new net.sf.ehcache.CacheManager(this.getClass().getClassLoader().getResource("classpath:ehcache.xml")).getCache("passwordRetryCache");
            }
        }

        @Override
        public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
            String username = (String)token.getPrincipal();
            //retry count + 1
            Element element = passwordRetryCache.get(username);
            if(element == null) {
                element = new Element(username , new AtomicInteger(0));
                passwordRetryCache.put(element);
            }
            AtomicInteger retryCount = (AtomicInteger)element.getObjectValue();
            if(retryCount.incrementAndGet() > 5) {
                //if retry count > 5 throw
                throw new ExcessiveAttemptsException();
            }

            boolean matches = super.doCredentialsMatch(token, info);
            if(matches) {
                //clear retry count
                passwordRetryCache.remove(username);
            }
            return matches;
        }
}
