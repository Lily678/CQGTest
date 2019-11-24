import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CQGTest {
    public static void main(String[] args) throws IOException {

        String fileNameConfig = args[0];
        String fileNameSimpleText = args[1];
        List listConfig = readFile(fileNameConfig);
        List listReadFile = readFile(fileNameSimpleText);
        HashMap<String, String> resultMap = extractValue(listConfig);
        List<String> resultReplace = replaceValue(listReadFile, resultMap);
        System.out.println(resultReplace);

    }

    private static List<String> readFile(String fileNameConfig) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(fileNameConfig))) {
            result = lines.collect(Collectors.toList());
            System.out.println(result);
            return result;

        }
    }

    public static HashMap<String, String> extractValue(List<String> listConfig) {
        int listSize = listConfig.size();
        HashMap<String, String> substitutionMap = new HashMap<>();
        for (int i = 0; i < listSize; i++) {
            String[] values = listConfig.get(i).split("=");
            substitutionMap.put(values[0], values[1]);
        }
        return substitutionMap;
    }

    public static List<String> replaceValue(List<String> listFile, HashMap<String, String> mapKey) {
        int fileSize = listFile.size();
        List<String> resultReplace = new ArrayList<>();
        String value = null; 
        for (int i = 0; i < fileSize; i++) {
            value = listFile.get(i);
            for (Map.Entry<String, String> entry : mapKey.entrySet()) {
                entry.getKey();
                entry.getValue();
                value = value.replace(entry.getKey(), entry.getValue());
               
        }
            resultReplace.add(value);
        }
        for( int i = resultReplace.size() - 1 ; i >= 0 ; i--)
            System.out.println("Reverse : " + resultReplace.get(i));
        return resultReplace;
    }

}
