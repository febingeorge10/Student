package com.sb.batch.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sb.batch.model.Student;
import com.sb.batch.tasks.ItemProcessorSample;
import com.sb.batch.tasks.ItemReaderSample;
import com.sb.batch.tasks.ItemWritterSample;
@Configuration
public class BatchConfig {
@Autowired
private ItemReaderSample itemReaderSample;

@Autowired
private ItemProcessorSample itemProcessorSample;

@Autowired
private ItemWritterSample writer;

@Autowired
private JobBuilderFactory jobs;

@Autowired
private StepBuilderFactory steps;

@Bean("step")
public Step step() {
	return steps.get("step").<List<Student>,List<String>> chunk(1)
			.reader(itemReaderSample).processor(itemProcessorSample).writer(writer)
			.build();
}
@Bean("reportJob")
public Job reportJob() {
	return jobs.get("reportjob")
			.start(step())
			.build();

}
}
