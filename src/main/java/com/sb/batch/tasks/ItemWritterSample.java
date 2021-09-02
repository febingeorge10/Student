package com.sb.batch.tasks;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class ItemWritterSample implements ItemWriter <List<String>>{

	@Override
	public void write(List<? extends List<String>> studentUppercaseNames) throws Exception {
		File file=new File("D:\\studentnames.txt");
		FileWriter write=new FileWriter(file);
		for(List<String> str:studentUppercaseNames) {
			write.write(str+System.lineSeparator());
		}
		write.close();
	}

}
