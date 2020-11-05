package com.bkmexpress.config;

import com.bkmexpress.sim.RequestMerchantInfoEndpoint;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan(basePackages = "com.bkmexpress.sim", basePackageClasses = { RequestMerchantInfoEndpoint.class })

public class ThreadPoolTaskSchedulerConfig {

        @Bean
        public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
            ThreadPoolTaskScheduler threadPoolTaskScheduler
                    = new ThreadPoolTaskScheduler();
            threadPoolTaskScheduler.setPoolSize(5);
            threadPoolTaskScheduler.setThreadNamePrefix(
                    "ThreadPoolTaskScheduler");
            return threadPoolTaskScheduler;
        }
}