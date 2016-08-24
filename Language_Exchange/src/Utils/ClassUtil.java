package Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class 속성, 메서드 관련 유틸
 * <pre>
 * <b>History:</b>
 *    yu, 버전점 , 2016.08.22 초기작성
 * </pre>
 *
 * @author yu
 * @version 버전관리는 팀장님이 만들어 주셈여  생성
 */
public class ClassUtil {
	/**
	 * Construct - 객체 생성 불가
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여 생성
	 */
	private ClassUtil() {
	}

	/**
	 * 클래스의 모든 필드 리스트 생성
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여 생성
	 * @param cls 클래스
	 * @return 클래스의 모든 필드 리스트
	 */
	public static List<Field> getUsefullFields(Class<?> cls) {
		List<Field> fieldList = new ArrayList<Field>();
		Field[] fields = cls.getDeclaredFields();

		for (Field field : fields) {
			int modifier = field.getModifiers();
			if (Modifier.isFinal(modifier) == false && Modifier.isStatic(modifier) == false) {
				fieldList.add(field);
			}
		}
		return fieldList;
	}

	/**
	 * 클래스의 public method 리스트 생성
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여 생성
	 * @param cls 클래스
	 * @return 클래스의 public method 리스트
	 */
	public static List<Method> getMethod(Class<?> cls) {
		List<Method> methodList = new ArrayList<Method>();

		Method[] allMethods = cls.getMethods();

		for (Method method : allMethods) {
			methodList.add(method);
		}

		return methodList;
	}

	/**
	 * 클래스의 set method 리스트 생성
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여 생성
	 * @param cls 클래스
	 * @return 클래스의 set method 리스트
	 */
	public static List<Method> getSetterMethod(Class<?> cls) {
		
		List<Method> setterList = new ArrayList<Method>();

		Method[] allMethods = cls.getMethods();

		for (Method method : allMethods) {
			if (isSetterMethod(method.getName()))
				setterList.add(method);
		}

		return setterList;
	}

	/**
	 * 클래스의 set method 와 필드를 이름으로 매칭하여 클드를 Key 메소드를 value로 구성하는 맵 생성
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여 생성
	 * @param cls 클래스
	 * @return 클래스의 필드, 메서드 맵
	 */
	public static Map<Field, Method> getSetterMethodMap(Class<?> cls) {
		Map<Field, Method> setterMap = new HashMap<Field, Method>();

		List<Field> fieldList = getUsefullFields(cls);
		List<Method> setterList = getSetterMethod(cls);

		for (Field field : fieldList) {
			String fieldName = field.getName().toUpperCase();

			for (Method method : setterList) {
				if (method.getName().substring(3).toUpperCase().equals(fieldName)) {
					setterMap.put(field, method);
					break;
				}
			}
		}

		return setterMap;
	}

	/**
	 * 클래스의 get method 리스트 생성
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여 생성
	 * @param cls 클래스
	 * @return 클래스의 get method 리스트
	 */
	public static List<Method> getGetterMethod(Class<?> cls) {
		List<Method> getterList = new ArrayList<Method>();

		Method[] allMethods = cls.getMethods();

		for (Method method : allMethods) {
			if (isGetterMethod(method.getName()))
				getterList.add(method);
		}

		return getterList;
	}

	/**
	 * 메서드 네임이 set으로 시작하는 지 여부 확인
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여 생성 
	 * @param methodName 메서드 이름
	 * @return 메서드명 확인 결과
	 */
	private static boolean isSetterMethod(String methodName) {
		String regStr = "^set";
		Pattern pattern = Pattern.compile(regStr);

		Matcher match = pattern.matcher(methodName);

		if (match.find())
			return true;
		return false;
	}

	/**
	 * 메서드 네임이 get으로 시작하는 지 여부 확인
	 * <pre>
	 * <b>History:</b>
	 *    yu, 버전점 , 2016.08.22 초기작성
	 * </pre>
	 *
	 * @author yu
	 * @version 버전관리는 팀장님이 만들어 주셈여 생성 
	 * @param methodName 메서드 이름
	 * @return 메서드명 확인 결과
	 */
	private static boolean isGetterMethod(String methodName) {
		String regStr = "^get";
		Pattern pattern = Pattern.compile(regStr);

		Matcher match = pattern.matcher(methodName);

		if (match.find())
			return true;
		return false;
	}

}
