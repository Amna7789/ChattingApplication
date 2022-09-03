package com.example.chattingapp.configurations;

import com.example.chattingapp.services.IUserService;
import com.example.chattingapp.services.impl.UserServiceImpl;
import com.example.chattingapp.shared.exception.UserException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.InputMismatchException;

@Aspect
@Component

public class ValidationAOP {
    @Autowired
    IUserService userService;


    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)||" +
            "@annotation(org.springframework.web.bind.annotation.PostMapping)||" +
            "@annotation(org.springframework.web.bind.annotation.PutMapping)||" +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public Object processAuthentication(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
       HttpServletRequest request1 =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        if(request1.getRequestURI().toString().equals("/swagger-resources/configuration/ui")
                || request1.getRequestURI().equals("/swagger-resources/configuration/security")
                || request1.getRequestURI().equals("/swagger-resources")
        ){
            return proceedingJoinPoint.proceed();
        }

        String base64Auth = request1.getHeader("Authorization").substring(6);
        String credentials = new String(Base64.getDecoder().decode(base64Auth));
        String email = credentials.split(":")[0];
        String password = credentials.split(":")[1];
        Boolean validate = userService.isValidUser(email, password);

        if (validate == false)
            throw new UserException("Invalid username/password");

        return proceedingJoinPoint.proceed();

    }
}
