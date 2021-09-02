package com.sb.batch.tasks;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.sb.batch.model.Student;

@Component
public class ItemProcessorSample implements ItemProcessor <List<Student>,List<String>> {

	@Override
	public List<String> process(List<Student> itemList) throws Exception {
		List<String> studentnames=itemList.stream().map(student->
		student.getName().toUpperCase()
		).collect(Collectors.toList());
		
		return studentnames;
	}

}
