package com.dcj.ChainOfResponsibility.v2;

import java.util.ArrayList;
import java.util.List;
//问题2 ： selevet 中 控制执行顺序为 request1 request2 response2 response2  类似先进后出
//解决方法通过 递归 解决
public class servletMain {
    public static void main(String[] args) {
        Request request = new Request("大家好： <Script>大家都是996工作者</script>");
        Response response = new Response("response");
        String str = "大家好： <Script>大家都是996工作者</script>";
        //责任链模式：将处理方法按顺序穿起来 执行

        FilterChain filterChain = new FilterChain();
        //链式操作
        filterChain.add(new HtmlFilter())
                        .add(new SensceFilter());
        filterChain.doFilters(request,response,filterChain);
        System.out.println(request.request);
        System.out.println(response.response);
    }
}
class Request{
    String request;

    public Request(String request) {
        this.request = request;
    }
}
class Response{
    String response;

    public Response(String response) {
        this.response = response;
    }
}
interface Filter{
    public void doFilter(Request request,Response response,FilterChain filterChain);
}


class HtmlFilter implements Filter {

    @Override
    public void doFilter(Request request,Response response,FilterChain filterChain) {
        String r =request.request;
        r = r.replace("<","[");
        r = r.replace(">","]");
        request.request = r;
        //递归 执行下一个 request  到最后 先执行递归最深处的response
        filterChain.doFilters(request,response,filterChain);
        response.response+="---HtmlFilter";
    }
}

class SensceFilter implements Filter {

    @Override
    public void doFilter(Request request,Response response,FilterChain filterChain) {
        String r = request.request;
        r= r.replace("996","955");
        request.request = r;
        //递归
        filterChain.doFilters(request,response,filterChain);
        response.response+="---SensceFilter";
    }
}

//责任链模式 将过滤条件组合在一起
class FilterChain{
    //指定游标 表示当前运行到那一个过滤器
    private  int index =0;
    private List<Filter> filters = new ArrayList();

    //经典的链式结构:需要将当前对象返回出来
    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    public void doFilters(Request request,Response response,FilterChain filterChain){
        if(index<filters.size()){
            Filter f = filters.get(index);
            index++;
            System.out.println(index);
            f.doFilter(request,response,filterChain);
        }
    }
}