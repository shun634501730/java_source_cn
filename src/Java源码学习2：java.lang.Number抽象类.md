第2个要学习的类就是java.lang.Number类，这个类是一个抽象类，作为所有数值类的基类。

其父类或接口为：java.lang.Object类和java.io.Serializable接口

其子类为：
1. java.lang：Byte、Short、Integer、Long、Float、Double
2. java.math：BigInteger、BigDecimal
3. java.util.concurrent.atomic：AtomicInteger、AtomicLong
4. java.util.concurrent.atomic：Striped64、DoubleAccumulator、DoubleAdder、LongAccumulator、LongAdder

这个抽象类中提供了转换为6个数值类型的方法，其中有4个是抽象方法，另外2个是普通方法。具体如下：
```java
// 4个抽象方法：将指定的数值转换为int、long、float和double，可能会进行四舍五入或者截断。
public abstract int intValue();
public abstract long longValue();
public abstract float floatValue();
public abstract double doubleValue();

// 2个普通方法（实际也是调用了上面的抽象方法）：将制定的数值转换为short和byte，可能会进行四舍五入或者截断。
// 其内部实现是这样的：先调用intValue()方法将其转换为int类型，然后将int类型的数值强制转换为short或byte类型.
public byte byteValue() {
	return (byte) intValue();
}
public short shortValue() {
	return (short) intValue();
}
```

这个类实现了Serializable接口，并提供了serialVersionUID。关于Serializable接口，后续进行介绍。