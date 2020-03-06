package com.cmbchina.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by o2o724 on 2017/11/30.
 */
@Slf4j
@Aspect
@Component
public class ControllerLogAspect {
    @Autowired
    private ObjectMapper objectMapper;

    @Around(value = "execution(* com.cmbchina..controller..*Controller.*(..))")
    public Object doAroundController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long requestStart = System.currentTimeMillis();
        HttpServletRequest request = getCurrentRequest();
        Object[] args = proceedingJoinPoint.getArgs();
        Map parameterMap = request.getParameterMap();
        if (parameterMap.isEmpty() && args.length > 0
                && RequestMethod.POST.name().equalsIgnoreCase(request.getMethod())) {
            Object object = args[0];
            log.info("{} request Paramter is : {}", request.getRequestURI(), objectMapper.writeValueAsString(object));
        }else {
            log.info("{} request Paramter is : {}", request.getRequestURI(), objectMapper.writeValueAsString(parameterMap));
        }
        Object result = proceedingJoinPoint.proceed();
        log.info("{} waste time:{}ms,response is :{}", request.getRequestURI(),System.currentTimeMillis()-requestStart,objectMapper.writeValueAsString(result));
        return result;
    }

    private HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        return sra.getRequest();
    }
}
