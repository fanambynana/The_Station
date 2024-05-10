package the.station.repository;

public class CaseConverter {
    public static String convertToSnakeCase(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : name.toCharArray()) {
            if (!stringBuilder.isEmpty()) {
                if (c.toString().toUpperCase().equals(c.toString())) {
                    stringBuilder.append("_").append(c);
                    continue;
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString().toLowerCase();
    }
}
