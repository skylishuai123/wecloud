package com.woniu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return  "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req=ctx.getRequest();
        String url = req.getRequestURI();
        if(url.indexOf("apply")!=-1){
            return false;
        }
        if(url.indexOf("register")!=-1){
            return false;
        }

        if(url.indexOf("login")!=-1){
            return false;
        }
        if(url.indexOf("activity")!=-1){
            return false;
        }
        if(url.indexOf("static")!=-1){
            return false;
        }

        if(url.indexOf("merchat")!=-1){
            return false;
        }
        if(url.indexOf("easyLife")!=-1){
            return false;
        }
        if(url.indexOf("complaints")!=-1){
            return false;
        }
        if(url.indexOf("interaction")!=-1){
            return false;
        }
        if(url.indexOf("publish")!=-1){
            return false;
        }

        if(url.indexOf("super")!=-1){
            HttpSession session = req.getSession();
            System.out.println(session.getId()+"ZUUL");
            if(req.getSession().getAttribute("admin")!=null){
                System.out.println(req.getSession().getAttribute("admin"));
                return false;
            }
        }
        if(url.indexOf("users")!=-1){
            HttpSession session = req.getSession();
            System.out.println(session.getId()+"Z");
            if(req.getSession().getAttribute("user")!=null){

                return false;
            }
        }

        if(url.indexOf("business")!=-1){
            HttpSession session = req.getSession();
            System.out.println(session.getId()+"L");
            if(req.getSession().getAttribute("business")!=null){
                System.out.println(session.getAttribute("business"));
                return false;
            }
        }



        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse resp = ctx.getResponse();
        ctx.setSendZuulResponse(false);
        resp.setStatus(302);
        resp.setHeader("Location","/super/admin/showlogin");
        return null;
    }
}
