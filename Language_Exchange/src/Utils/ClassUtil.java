package Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ClassUtil {
	//클래스의 필드 네임 리스트 생성
	public static List<Field> getUsefullFields(Class<?> cls) {
		List<Field> arrFields = new ArrayList<Field>();
		Field[] fields = cls.getDeclaredFields();

		for (Field field : fields) {
			int modifier = field.getModifiers();
			if (Modifier.isFinal(modifier) == false && Modifier.isStatic(modifier) == false) {
				arrFields.add(field);
			}
		}
		return arrFields;
	}
}
