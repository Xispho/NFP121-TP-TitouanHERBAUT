import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ListeurFabriquesStatiques implements Listeur {

    @Override
    public List<Method> getMethodes(String nomClasse) throws Exception {
        Class<?> aClass = Class.forName(nomClasse);
        List<Method> methodes = new ArrayList<>();
        for (Method methode : aClass.getDeclaredMethods()) {
            if (isStatic(methode) && isClassReturnType(methode, aClass) && !hasParametersOfClass(methode, aClass)) {
                methodes.add(methode);
            }
        }
        return methodes;
    }

    private boolean isStatic(Method methode) {
        return Modifier.isStatic(methode.getModifiers());
    }

    private boolean isClassReturnType(Method methode, Class<?> aClass) {
        return methode.getReturnType().equals(aClass);
    }

    private boolean hasParametersOfClass(Method methode, Class<?> aClass) {
        for (Class<?> paramType : methode.getParameterTypes()) {
            if (paramType.equals(aClass)) {
                return true;
            }
        }
        return false;
    }

}