package com.clyao.securityjwt.config;

import com.clyao.securityjwt.pojo.Result;
import com.clyao.securityjwt.utils.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Result result = ResultUtil.error("权限不足，请联系管理员");
        result.setCode(403);
        out.write(new ObjectMapper().writeValueAsString(result));
        out.flush();
        out.close();
    }
}
