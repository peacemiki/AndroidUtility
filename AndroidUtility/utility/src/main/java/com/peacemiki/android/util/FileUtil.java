package com.peacemiki.android.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class FileUtil {
	/**
	 * 디렉토리 생성
	 * 
	 * @return dir
	 */
	public static File makeDirectory(String dir_path) {
		File dir = new File(dir_path);
		if (!dir.exists()) {
			dir.mkdirs();
		} else {
			Trace.i("dir.exists");
		}

		return dir;
	}

	/**
	 * 파일 생성
	 * 
	 * @param dir
	 * @return file
	 */
	public static File makeFile(File dir, String file_path) {
		File file = null;
		boolean isSuccess = false;
		if (dir.isDirectory()) {
			file = new File(file_path);
			if (file != null && !file.exists()) {
				Trace.i("!file.exists");
				try {
					isSuccess = file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					Trace.i("파일생성 여부 = " + isSuccess);
				}
			} else {
				Trace.i("file.exists");
			}
		}
		return file;
	}

	/**
	 * (dir/file) 절대 경로 얻어오기
	 * 
	 * @param file
	 * @return String
	 */
	public static String getAbsolutePath(File file) {
		return "" + file.getAbsolutePath();
	}

	/**
	 * (dir/file) 삭제 하기
	 * 
	 * @param file
	 */
	public static boolean deleteFile(File file) {
		boolean result;
		if (file != null && file.exists()) {
			file.delete();
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * 파일여부 체크 하기
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isFile(File file) {
		boolean result;
		if (file != null && file.exists() && file.isFile()) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * 디렉토리 여부 체크 하기
	 * 
	 * @param dir
	 * @return
	 */
	public static boolean isDirectory(File dir) {
		boolean result;
		if (dir != null && dir.isDirectory()) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * 파일 존재 여부 확인 하기
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isFileExist(File file) {
		boolean result;
		if (file != null && file.exists()) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * 파일 이름 바꾸기
	 * 
	 * @param file
	 */
	public static boolean reNameFile(File file, File new_name) {
		boolean result;
		if (file != null && file.exists() && file.renameTo(new_name)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * 디렉토리에 안에 내용을 보여 준다.
	 * 
	 * @param dir
	 * @return
	 */
	public static String[] getList(File dir) {
		if (dir != null && dir.exists())
			return dir.list();
		return null;
	}

	/**
	 * 파일에 내용 쓰기
	 * 
	 * @param file
	 * @param str
	 * @return
	 */
	public static boolean writeFile(File file, String str) {
		boolean result;
		FileOutputStream fos;
		if (file != null && file.exists() && str != null) {
			try {
				fos = new FileOutputStream(file);
				try {
					BufferedWriter buw = new BufferedWriter(
							new OutputStreamWriter(fos, "UTF8"));
					buw.write(str);
					buw.close();
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * 파일 읽어 오기
	 * 
	 * @param file
	 */
	public static void readFile(File file) {
		int readcount = 0;
		if (file != null && file.exists()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				readcount = (int) file.length();
				byte[] buffer = new byte[readcount];
				fis.read(buffer);
				for (int i = 0; i < file.length(); i++) {
					Trace.d("" + buffer[i]);
				}
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 파일 복사
	 * 
	 * @param file
	 * @param save_file
	 * @return
	 */
	public static boolean copyFile(File file, String save_file) {
		boolean result;
		if (file != null && file.exists()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				FileOutputStream newfos = new FileOutputStream(save_file);
				int readcount = 0;
				byte[] buffer = new byte[1024];
				while ((readcount = fis.read(buffer, 0, 1024)) != -1) {
					newfos.write(buffer, 0, readcount);
				}
				newfos.close();
				fis.close();

				Trace.i("file copied.");
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public static void unzip(String zipFile, String location) throws IOException {
		int BUFFER_SIZE =4000; 
		int size;
		byte[] buffer = new byte[BUFFER_SIZE];
		
		try {
			if ( !location.endsWith("/") ) {
				location += "/";
			}
			File f = new File(location);
			if(!f.isDirectory()) {
				f.mkdirs();
			}
			
			ZipInputStream zin = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFile), BUFFER_SIZE));
			try {
				ZipEntry ze = null;
				while ((ze = zin.getNextEntry()) != null) {
					String path = location + ze.getName();
					File unzipFile = new File(path);
		
					if (ze.isDirectory()) {
						if(!unzipFile.isDirectory()) {
							unzipFile.mkdirs();
						}
					} else {
						//check for and create parent directories if they don't exist
						File parentDir = unzipFile.getParentFile();
						if ( null != parentDir ) {
							if ( !parentDir.isDirectory() ) {
								parentDir.mkdirs();
							}
						}
						
						//unzip the file
						FileOutputStream out = new FileOutputStream(unzipFile, false);
						BufferedOutputStream fout = new BufferedOutputStream(out, BUFFER_SIZE);
						try {
							while ( (size = zin.read(buffer, 0, BUFFER_SIZE)) != -1 ) {
								fout.write(buffer, 0, size);
							}

							zin.closeEntry();
						}
						finally {
							fout.flush();
							fout.close();
						}
					}
				}
			}
			finally {
				zin.close();
			}
		}
		catch (Exception e) {
			Trace.e("Unzip exception" + e);
		}
	}
}
