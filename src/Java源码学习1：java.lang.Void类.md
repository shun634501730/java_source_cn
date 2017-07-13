#### 注释及源码
这个类的注释是这样说的：
> Void类是一个不可实例化的占位符类，它持有代表Java关键字void的Class对象引用。

源码如下：
```java
package java.lang;

/**
 * {@code Void}类是一个不可实例化的占位符类，它持有代表Java关键字void的Class对象引用。
 * <br/>译者注：这个类是final类，也就意味着其不可被继承
 * 
 * @author  unascribed
 * @since   JDK1.1
 */
public final
class Void {

    /**
     * 这个{@code Class}对象代表与关键字{@code void}一致的伪类型
     */
    @SuppressWarnings("unchecked")
    public static final Class<Void> TYPE = (Class<Void>) Class.getPrimitiveClass("void");

    /**
     * Void这个类的构造器是私有化的，所以它不能被外部实例化。<br/>
     * 译者注：其实它能实例化，通过反射API就可以做到
     */
    private Void() {}
}
```

***

#### 要点
有这样几个要点：
1. 不可实例化，可以看到源码中Void类的构造器是private。<a>但是它真的不能实例化吗？请看参考2</a>
2. 代表Java关键字void
3. 当做占位符使用，比如在容器中指定泛型类型，List<Void>

***

#### 如何实现对Void类的实例化
一般来讲，我们看到Void类的构造器是私有化的，觉得它就不能被实例化。但是，似乎有方法对其进行实例化，这个方法就是Java提供的反射API。具体代码如下：
```java
/**
 * 通过Java反射API实现对不可实例化的类Void的实例化
 * @author ThinkPad
 */
public class InstantiateVoid {

	public static void main(String[] args) {
		try {
			Constructor<Void> c = Void.class.getDeclaredConstructor();
			c.setAccessible(true);
			Void v = c.newInstance();
			System.out.println(v); // java.lang.Void@41975e01
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
```
***
#### 编写代码时，怎么样才能阻止反射API实例化那些只有私有构造器的类呢
具体方法：
1. 私有化构造器，都应该私有化
2. 构造器中抛出java.lang.IllegalAccessException异常

具体示例如下：
```java
/**
 * 用于阻止反射API调用私有化构造器的示例
 * @author ThinkPad
 *
 */
public class Person {
    // 属性age
	private int age = 0;
	
	// 私有化构造器，并抛出IllegalAccessException
	private Person() throws IllegalAccessException{
		throw new IllegalAccessException("该类不可实例化!");
	}

	// 属性age的setter/getter方法
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
```
测试方法：
```java
public static void main(String[] args) {
	try {
		Constructor<Person> constructor = Person.class.getDeclaredConstructor();
		// 修改为可访问，即public权限
		constructor.setAccessible(true);
		Person p = constructor.newInstance();
		System.out.println(p);
	} catch (NoSuchMethodException | SecurityException e) {
		e.printStackTrace();
	} catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	}
}
```
***
#### 参考
1. [java,lang.Void类](http://blog.csdn.net/u012734441/article/details/51614214)
2. [Stackoverflow：Is Void really uninstantiable?
](https://stackoverflow.com/questions/14060078/is-void-really-uninstantiable)
3. [Java编程：java.lang.Void类分析](http://blog.csdn.net/claram/article/details/52053798)
