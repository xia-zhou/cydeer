/*
 * Copyright (C), 2014-2015, 
 * FileName: UUIDGenerator.java
 * Author:   xia zhou
 * Date:     2015年6月12日 下午10:32:22
 * Description: 
 */
package com.xiazhou.base.utils.common;

import java.util.UUID;

/**
 * <pre>
 * 〈一句话是什么〉
 * 〈详细描述做什么〉
 *
 * @author xia zhou
 */
public class UUIDGenerator {
	//在标准UUID基础上去除中间4个横杠
	public static final int TYPE_DEFAULT = 0;
	//标准UUID
	public static final int TYPE_STANDARD = 1;
	//采用自定义字符的64进制短UUID
	public static final int TYPE_SHORT = 2;
	
	// ================================
	private final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
			'Z', '-', '_' };

	public static String generate(){
		return generate(TYPE_DEFAULT);
	}
	/**
	 * 
	 * @param type
	 * @return
	 */
	public static String generate(int type){
		UUID uuid = UUID.randomUUID();
		if(type != TYPE_SHORT){
			if(type == TYPE_STANDARD){
				return uuid.toString();
			}else{
				return uuid.toString().replaceAll("-", "");
			}
		}
		
		StringBuffer sf = new StringBuffer();
		sf.append(toUnsignedString(uuid.getMostSignificantBits(), 6))
			.append(toUnsignedString(uuid.getLeastSignificantBits(), 6));
		
		return sf.toString();
	}
	
	// 将一个长整型数映射为一个字符串
	private static String toUnsignedString(long i, int shift) {// 注意1<=shift<=6
		char[] buf = new char[64];
		int charPos = 64;
		int radix = 1 << shift;
		long mask = radix - 1;
		do {
			buf[--charPos] = digits[(int) (i & mask)];
			i >>>= shift;
		} while (i != 0);
		return new String(buf, charPos, (64 - charPos));
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		StringBuffer sf = new StringBuffer();
		for(int i=0; i<1000; i++){
			sf.append(generate(TYPE_STANDARD)).append("\n");
		}
		System.out.println(sf.toString());
		long time = System.currentTimeMillis() - start;
		System.out.println("耗时 : " + time + " ms");
	}
}
