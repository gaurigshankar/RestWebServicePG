package com.gauri.indexer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Indexer implements ServletContextListener {

	private Map<String, Integer> wordOccurances = new HashMap<String, Integer>();

	public void indexAllFiles() {

		List<String> filenames = new ArrayList<String>();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sureshData");
		String resource;
		if (inputStream != null) {
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			try {
				while ((resource = br.readLine()) != null) {
					filenames.add(resource);
					System.out.println(resource);
					
				}
			} catch (IOException e) {
				// TODO Add your custom fail-over code here
				e.printStackTrace();
			}
		}
		Iterator<String> iter = filenames.listIterator();
		while(iter.hasNext()){
			String fileName = iter.next();
			System.out.println("start indexing"+fileName);
			indexFile(fileName);
		}
		printMap();
		

	}

	public void indexFile(String fileName) {
		System.out.println("Processing "+fileName);
		Reader file;
		Scanner scanner = null;
		try {
			
			file = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("sureshData/"+fileName)));
			
			scanner = new Scanner(file);
			System.out.println(scanner);
			while (scanner.hasNextLine()) {
				String[] words = scanner.nextLine().split("\\W+");
				printStringArray(words);
				for (String word : words) {
					word = word.toLowerCase();
					Integer noOfOccurances = wordOccurances.get(word);

					if (null == noOfOccurances) {
						noOfOccurances = 1;
						wordOccurances.put(word, noOfOccurances);
					} else {
						noOfOccurances = noOfOccurances + 1;
						wordOccurances.put(word, noOfOccurances);
					}
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void printMap(){
		for (Map.Entry<String, Integer> entry : wordOccurances.entrySet()) {
		    System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
	
	private void printStringArray(String[] words){
		System.out.println(Arrays.toString(words));
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		indexAllFiles();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
	
}
