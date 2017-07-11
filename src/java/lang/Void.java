/*
 * Copyright (c) 1996, 2011, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package java.lang;

/**
 * {@code Void}类是一个不可实例化的占位符类，它持有代码Java关键字void的Class对象引用。
 * <p>译者注：这个类是final类，也就意味着其不可被继承
 * <p>译者注：该类的详细说明见<a href="https://github.com/shun634501730/java_source_cn/wiki/java.lang.Void%E7%B1%BB">https://github.com/shun634501730/java_source_cn/wiki/java.lang.Void%E7%B1%BB</a>
 * 
 * @author  unascribed
 * @since   JDK1.1
 */
public final
class Void {

    /**
     * 这个{@code Class}对象代表与关键字{@code void}一致的伪类型
     * <p>译者注：这个TYPE在基本数据类型的包装类里都有
     */
    @SuppressWarnings("unchecked")
    public static final Class<Void> TYPE = (Class<Void>) Class.getPrimitiveClass("void");

    /**
     * Void这个类的构造器是私有化的，所以它不能被外部实例化。
     * <p>译者注：其实它能实例化，通过反射API就可以做到
     */
    private Void() {}
}
