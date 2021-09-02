package com.sb.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.sb.batch.triggers.DefaultJobTrigger;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@ComponentScan(basePackages="com.sb.batch")
public class BatchprocessingApplication implements ApplicationRunner{
	@Autowired
	DefaultJobTrigger trigger;

	public static void main(String[] args) {
		SpringApplication.run(BatchprocessingApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		trigger.triggerJob();
	}

}
