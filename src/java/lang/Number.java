/*
 * Copyright (c) 1994, 2011, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 */

package java.lang;

/**
 * {@code Number}类是一个抽象类，它作为数值类的基类，提供了转换为各种数值类型的抽象方法。
 * <p>
 * 考虑到类型转换分为两种：
 * <ul>
 * <li>隐式转换（宽化转换）：即转换后的数值类型的取值范围更大，如int转long
 * <li>显示转换（窄化转换）：这种方式下，高精度的数值转换为低精度的数值，会导致精度丢失问，甚至是溢出的情况。如long转int
 * </ul>
 * <p>
 * 这里实现了{@code Serializable}，所以最好添加serialVersionUID。
 *
 * <p>
 * 这个类中提供了4个抽象方法和2个普通方法（内部调用的是抽象方法）。
 *
 * @author Lee Boynton
 * @author Arthur van Hoff
 * @jls 5.1.2 Widening Primitive Conversions
 * @jls 5.1.3 Narrowing Primitive Conversions
 * @since JDK1.0
 */
public abstract class Number implements java.io.Serializable {
	/**
	 * 将指定的数值转换为int，可能会进行四舍五入或者截断。
	 *
	 * @return the numeric value represented by this object after conversion to
	 *         type {@code int}.
	 */
	public abstract int intValue();

	/**
	 * 将指定的数值转换为long，可能会进行四舍五入或者截断。
	 *
	 * @return the numeric value represented by this object after conversion to
	 *         type {@code long}.
	 */
	public abstract long longValue();

	/**
	 * 将指定的数值转换为float，可能会进行四舍五入或者截断。
	 *
	 * @return the numeric value represented by this object after conversion to
	 *         type {@code float}.
	 */
	public abstract float floatValue();

	/**
	 * 将指定的数值转换为double，可能会进行四舍五入或者截断。
	 *
	 * @return the numeric value represented by this object after conversion to
	 *         type {@code double}.
	 */
	public abstract double doubleValue();

	/**
	 * 将指定的数值转换为short或byte，可能会进行四舍五入或者截断。
	 * <p>
	 * 其内部实现是这样的：先调用intValue()方法将其转换为int类型，然后将int类型的数值强制转换为short或byte类型
	 *
	 * @return the numeric value represented by this object after conversion to
	 *         type {@code byte}.
	 * @since JDK1.1
	 */
	public byte byteValue() {
		return (byte) intValue();
	}

	/**
	 * 将指定的数值转换为short或byte，可能会进行四舍五入或者截断。
	 * <p>
	 * 其内部实现是这样的：先调用intValue()方法将其转换为int类型，然后将int类型的数值强制转换为short或byte类型
	 *
	 * @return the numeric value represented by this object after conversion to
	 *         type {@code short}.
	 * @since JDK1.1
	 */
	public short shortValue() {
		return (short) intValue();
	}

	/** 从JDK 1.0.2起，开始使用serialVersionUID，主要用于提高协同工作的能力 */
	private static final long serialVersionUID = -8742448824652078965L;
}
