package co.com.bancolombia.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtil {

    public static String exceptionStackTraceToString(Exception exception){
        return ExceptionUtils.getStackTrace(exception);
    }

}
