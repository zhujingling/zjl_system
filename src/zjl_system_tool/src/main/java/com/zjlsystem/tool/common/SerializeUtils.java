/**
 * @Title: SerializeUtils.java
 * @Package com.zjlsystem.tool.common
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午8:33:52
 * @version V1.0
 */

package com.zjlsystem.tool.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @ClassName: SerializeUtils
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午8:33:52
 *
 */

public class SerializeUtils {
	public static byte[] serialize(Object value) {
		if (value == null) {
			throw new NullPointerException("Can't serialize null");
		}
		byte[] rv = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream os = null;
		try {
			bos = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bos);
			os.writeObject(value);
			os.close();
			bos.close();
			rv = bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("serialize error");
		} finally {
			close(os);
			close(bos);
		}
		return rv;
	}

	public static Object deserialize(byte[] in) {
		return deserialize(in, Object.class);
	}

	public static <T> T deserialize(byte[] in, Class<T>... requiredType) {
		Object rv = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream is = null;
		try {
			if (in != null) {
				bis = new ByteArrayInputStream(in);
				is = new ObjectInputStream(bis);
				rv = is.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deserialize error");
		} finally {
			close(is);
			close(bis);
		}
		return (T) rv;
	}

	private static void close(Closeable closeable) {
		if (closeable != null)
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("close stream error");
			}
	}
}
