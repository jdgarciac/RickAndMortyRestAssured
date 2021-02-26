package exceptions;

public class CommonExceptions extends AssertionError {

    public static final String ID_NOT_EQUAL = "The city of the server is not equals to value expected";
    public static final String STATUS_CODE_INCORRECT = "Se esperaba 200, pero el status obtenido fue otro";
    public static final String STATUS_LINE_INCORRECT = "El status line esperado no corresponde con el obtenido";

    public CommonExceptions(String message) {
        super(message);
    }

}
