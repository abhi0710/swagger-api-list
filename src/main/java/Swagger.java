import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import v2.io.swagger.models.HttpMethod;
import v2.io.swagger.models.Operation;
import v2.io.swagger.models.Path;
import v2.io.swagger.parser.SwaggerParser;

public class Swagger {

    public static void main(String[] args) {

        String array[] = new String[]
             {
                  "http://131111.a.a.a/asdasdasd/v2/api-docs",
             };

        for (String res : array) {

            v2.io.swagger.models.Swagger swagger = new SwaggerParser()
                 .read(res);

            Map<String, Path> paths = swagger.getPaths();

            System.out.println("************************************ " + res + "*****************************");
            for (Entry<String, Path> path : paths.entrySet()) {

                Map<HttpMethod, Operation> operations = path.getValue().getOperationMap();

                operations.entrySet().forEach(operation -> {
                    System.out.println(
                         operation.getKey() + " " + path.getKey() + " " + " " + operation.getValue()
                              .getSummary());
                });
            }

            System.out.println("******************************************");
        }
    }
}
