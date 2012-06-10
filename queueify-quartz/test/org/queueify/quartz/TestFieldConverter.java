/**
 * 
 */
package org.queueify.quartz;


import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.queueify.quartz.annotation.Param;

/**
 * @author bseib
 *
 */
public class TestFieldConverter {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void test1() throws QueueifyException {
		@SuppressWarnings("serial")
		HashMap<String, String> correct = new HashMap<String, String>() {{
			put("a", "true");
			put("a2", "false");
			put("b", "-1");
			put("c", "A");
			put("d", "1.2345678910293847E8");
			put("e", "9.8765434E8");
			put("f", "2147483647");
			put("g", "3000000000");
			put("h", "255");
			put("i", "hello whirled");
			put("j", "true");
			put("j2", "false");
			put("k", "-1");
			put("l", "A");
			put("m", "1.2345678910293847E8");
			put("n", "9.8765434E8");
			put("o", "2147483647");
			put("p", "3000000000");
			put("q", "255");
		}};
		HashMap<String, String> map = new HashMap<String, String>();
		
		Pig p = new Pig();
		p.init();
		Class<? extends Pig> klass = p.getClass();
		Field[] fields = klass.getDeclaredFields();
		for ( Field f : fields ) {
			if ( f.isAnnotationPresent(Param.class) ) {
				f.setAccessible(true);
				String val = FieldConverter.intoString(p, f);
				if ( val != null ) {
					assertEquals(correct.get(f.getName()), val);
					map.put(f.getName(), val);
				}
			}
		}
		
		// now test converting back to typed values.
		Pig p2 = new Pig();
		fields = p2.getClass().getDeclaredFields();
		for ( Field f : fields ) {
			if ( f.isAnnotationPresent(Param.class) ) {
				f.setAccessible(true);
				String val = map.get(f.getName());
				FieldConverter.intoField(val, p2, f);
			}
		}
		
		assertEquals(p.a, p2.a);
		assertEquals(p.a2, p2.a2);
		assertEquals(p.b, p2.b);
		assertEquals(p.c, p2.c);
		assertEquals(p.d, p2.d, 1E-16);
		assertEquals(p.e, p2.e, 1E-7);
		assertEquals(p.f, p2.f);
		assertEquals(p.g, p2.g);
		assertEquals(p.h, p2.h);
		assertEquals(p.i, p2.i);
		assertEquals(p.j, p2.j);
		assertEquals(p.j2, p2.j2);
		assertEquals(p.k, p2.k);
		assertEquals(p.l, p2.l);
		assertEquals(p.m, p2.m, 1E-16);
		assertEquals(p.n, p2.n, 1E-7);
		assertEquals(p.o, p2.o);
		assertEquals(p.p, p2.p);
		assertEquals(p.q, p2.q);
		
	}


	private class Pig {
		@Param protected boolean a;
		@Param protected boolean a2;
		@Param protected byte b;
		@Param protected char c;
		@Param protected double d;
		@Param protected float e;
		@Param protected int  f;
		@Param protected long g;
		@Param protected short h;
		@Param protected String i;
		@Param protected Boolean j;
		@Param protected Boolean j2;
		@Param protected Byte k;
		@Param protected Character l;
		@Param protected Double m;
		@Param protected Float n;
		@Param protected Integer o;
		@Param protected Long p;
		@Param protected Short q;

		public void init() {
			a = true;
			a2 = false;
			b = (byte)0xff;
			c = 'A';
			d = 123456789.1029384756d;
			e = 987654321.6574839201f;
			f = 2147483647;
			g = 3000000000l;
			h = 255;
			i = "hello whirled";
			j = new Boolean(true);
			j2 = new Boolean(false);
			k = new Byte(b);
			l = new Character(c);
			m = new Double(d);
			n = new Float(e);
			o = new Integer(f);
			p = new Long(g);
			q = new Short(h);
		}
	
	}

}
