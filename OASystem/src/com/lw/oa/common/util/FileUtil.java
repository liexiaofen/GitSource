package com.lw.oa.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
/**
 * *@author yuliang
 */
public class FileUtil {
	public static int checkFileExists(String filepath) {
		if (filepath == null || "".equals(filepath.trim())) {
			return -1;
		}
		File targetFile = new File(filepath);
		if (!targetFile.exists()) {
			return -1;
		}
		return 1;
	}
	/**
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copy(File srcFile, File destFile) throws IOException {
		@SuppressWarnings("resource")
		FileChannel inChannel = new FileInputStream(srcFile).getChannel();
		@SuppressWarnings("resource")
		FileChannel outChannel = new FileOutputStream(destFile).getChannel();
		int maxCount = (64 * 1024 * 1024) - (32 * 1024);
		try {
			long position = 0;
			long size = inChannel.size();
			while (position < size) {
				position += inChannel
						.transferTo(position, maxCount, outChannel);
			}
		} finally {
			if (inChannel != null) {
				inChannel.close();
			}
			if (outChannel != null) {
				outChannel.close();
			}
		}
	}
	/**
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void mkdirs(String serverPath) {
		File dir = new File(serverPath);
		if (dir.isDirectory()) {
			;
		} else {
			dir.mkdirs();
		}
	}
	/**
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */

	public static void cut(File srcFile, File destFile) {
		srcFile.renameTo(destFile);
	}	
}
