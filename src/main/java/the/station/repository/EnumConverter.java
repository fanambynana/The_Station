package the.station.repository;

import java.lang.reflect.Field;

public class EnumConverter {
    public static <T extends Enum<T>> T convertStringToEnum(Class<T> enumClass, String value) {
        try {
            Field[] enumFields = enumClass.getDeclaredFields();
            for (Field field : enumFields) {
                if (field.isEnumConstant()) {
                    T enumValue = Enum.valueOf(enumClass, field.getName());
                    if (value.equals(enumValue.toString())) {
                        return enumValue;
                    }
                }
            }
        } catch (IllegalArgumentException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }
}
