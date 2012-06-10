package org.queueify.quartz;

import java.lang.reflect.Field;
import java.util.HashMap;

public class FieldConverter {

	@SuppressWarnings("serial")
	private static HashMap<String, FieldToString> FIELD_TO_STRING = new HashMap<String, FieldToString>() {{
		put("boolean",	new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.getBoolean(obj); } } );
		put("byte",		new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.getByte(obj); } } );
		put("char",		new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.getChar(obj); } } );
		put("double",	new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.getDouble(obj); } } );
		put("float",	new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.getFloat(obj); } } );
		put("int",		new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.getInt(obj); } } );
		put("long",		new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.getLong(obj); } } );
		put("short",	new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.getShort(obj); } } );
		put("java.lang.String",	new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.get(obj); } } );
		put("java.lang.Boolean",new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.get(obj); } } );
		put("java.lang.Byte",	new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.get(obj); } } );
		put("java.lang.Character",new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.get(obj); } } );
		put("java.lang.Double",	new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.get(obj); } } );
		put("java.lang.Float",	new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.get(obj); } } );
		put("java.lang.Integer",new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.get(obj); } } );
		put("java.lang.Long",	new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.get(obj); } } );
		put("java.lang.Short",	new FieldToString() { public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { return ""+f.get(obj); } } );
	}};
	@SuppressWarnings("serial")
	private static HashMap<String, StringToField> STRING_TO_FIELD = new HashMap<String, StringToField>() {{
		put("boolean",	new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.setBoolean(obj, Boolean.parseBoolean(val)); } } );
		put("byte",		new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.setByte(obj, Byte.parseByte(val)); } } );
		put("char",		new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.setChar(obj, val.charAt(0)); } } );
		put("double",	new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.setDouble(obj, Double.parseDouble(val)); } } );
		put("float",	new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.setFloat(obj, Float.parseFloat(val)); } } );
		put("int",		new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.setInt(obj, Integer.parseInt(val)); } } );
		put("long",		new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.setLong(obj, Long.parseLong(val)); } } );
		put("short",	new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.setShort(obj, Short.parseShort(val)); } } );
		put("java.lang.String",	new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.set(obj, val); } } );
		put("java.lang.Boolean",new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.set(obj, new Boolean(Boolean.parseBoolean(val))); } } );
		put("java.lang.Byte",	new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.set(obj, new Byte(Byte.parseByte(val))); } } );
		put("java.lang.Character",new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.set(obj, new Character(val.charAt(0))); } } );
		put("java.lang.Double",	new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.set(obj, new Double(Double.parseDouble(val))); } } );
		put("java.lang.Float",	new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.set(obj, new Float(Float.parseFloat(val))); } } );
		put("java.lang.Integer",new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.set(obj, new Integer(Integer.parseInt(val))); } } );
		put("java.lang.Long",	new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.set(obj, new Long(Long.parseLong(val))); } } );
		put("java.lang.Short",	new StringToField() { public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException { f.set(obj, new Short(Short.parseShort(val))); } } );
	}};

	private interface FieldToString {
		public String intoString(Object obj, Field f) throws IllegalArgumentException, IllegalAccessException;
	}
	private interface StringToField{
		public void intoField(String val, Object obj, Field f) throws IllegalArgumentException, IllegalAccessException;
	}

	static public String intoString(Object obj, Field field) throws QueueifyException {
		try {
			if ( null == field.get(obj) ) {
				return null;
			}
			Class<?> type = field.getType();
			FieldToString fts = FIELD_TO_STRING.get(type.getName());
			if ( null != fts ) {
				return fts.intoString(obj, field);
			}
			else if ( type.isEnum() ) {
				return ((Enum<?>)field.get(obj)).name();
			}
			else {
				throw new QueueifyException("cannot use @Param on field type "+ type.getSimpleName());				
			}
		}
		catch (IllegalArgumentException e) {
			throw new QueueifyException(e);
		}
		catch (IllegalAccessException e) {
			throw new QueueifyException(e);
		}
	}
	
	static public void intoField(String val, Object obj, Field field) throws QueueifyException {
		try {
			Class<?> type = field.getType();
			StringToField stf = STRING_TO_FIELD.get(type.getName());
			if ( null != stf ) {
				stf.intoField(val, obj, field);
			}
			else if ( type.isEnum() ) {
				@SuppressWarnings({ "unchecked", "rawtypes" })
				Enum<?> enumVal = Enum.valueOf((Class<Enum>)type, val);
				field.set(obj, enumVal);
			}
			else {
				throw new QueueifyException("cannot use @Param on field type "+ type.getSimpleName());				
			}
		}
		catch (IllegalArgumentException e) {
			throw new QueueifyException(e);
		}
		catch (IllegalAccessException e) {
			throw new QueueifyException(e);
		}
	}
}
