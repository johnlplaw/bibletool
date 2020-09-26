package com.mywork.bibletool;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class ScanSigaoTxt {
	
	String[] ignoredSymbo = {"#", "&", "%", "&"};
	
	public ArrayList<VerseData> readFile(String filepath) {

		BufferedReader br = null;
		ArrayList<VerseData> lineList = new ArrayList<VerseData>();

		try {
			List<String> lines = FileUtils.readLines(new File(filepath), "UTF-8");
			
			String book = null;
			String bookName = null;

			for (String sCurrentLine : lines) {

				if (sCurrentLine.trim().length() > 0) {

					String strtxt = sCurrentLine;

					if ( StringUtils.startsWith(strtxt, "@")) {
						String[] bookNameStr =  StringUtils.substring(strtxt, 1).split(" ");
						book = bookNameStr[0];
						bookName = bookNameStr[1];
					} else if ( StringUtils.startsWithAny(strtxt, ignoredSymbo)) {
						// do nothing
					} else {
						int spcIdx = strtxt.indexOf(" ");

						if (spcIdx == -1) {

						} else {
							String verseNum = strtxt.substring(0, spcIdx);
							String[] verseChapNum = verseNum.split(":");
							
							if (! verseChapNum[1].trim().equals("")) {

								VerseData data = new VerseData();
								
								data.setBook(book);
								data.setBookName(bookName);
								data.setChapter(verseChapNum[0]);
								data.setVerse(verseChapNum[1]);
								data.setText(strtxt.substring(spcIdx + 1));
								lineList.add(data);
							}
						}

					}

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return lineList;

	}
	
}
