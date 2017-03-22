package com.util;

import java.io.File;

public class FileUtils {

	public static File createDirectory(File aDirectory, String directoryName) {
		if (aDirectory == null || org.springframework.util.StringUtils.isEmpty(directoryName)) {
			return null;
		}
		File file = new File(aDirectory, directoryName);
		if (!file.exists()) {
			file.mkdir();
		}
		return file;
	}

}
