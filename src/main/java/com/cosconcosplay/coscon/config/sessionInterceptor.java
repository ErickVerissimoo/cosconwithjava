package com.cosconcosplay.coscon.config;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.cosconcosplay.coscon.utils.Authenticated;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class sessionInterceptor implements HandlerInterceptor {
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
            if(handler instanceof HandlerMethod){
                HandlerMethod req = (HandlerMethod) handler;
                if(req.getMethod().isAnnotationPresent(Authenticated.class) || req.getBeanType().isAnnotationPresent(Authenticated.class)){
                   if( request.getSession(false) == null){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("Usuário não autenticado");
                    return false;
                }
                }
            }
            return true;
    
    
        }
}
