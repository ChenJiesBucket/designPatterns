package com.dcj.ChainOfResponsibility.v1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String str = "大家好： <Script>大家都是996工作者</script>";
        //责任链模式：将处理方法按顺序穿起来 执行
        Msg m = new Msg(str);
        FilterChain filterChain = new FilterChain();
        //链式操作
        filterChain.add(new HtmlFilter())
                        .add(new SensceFilter());
        filterChain.doFilters(m);
        System.out.println(m.getMsg());
    }
}

interface Filter{
    public boolean doFilter(Msg m);
}
class Msg{
    String msg;

    public Msg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
class HtmlFilter implements Filter{

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("<","[");
        r = r.replace(">","]");
        m.setMsg(r);
        return true;
    }
}

class SensceFilter implements Filter{

    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
       r= r.replace("996","955");
        m.setMsg(r);
        return true;
    }
}
//责任链模式 将过滤条件组合在一起
class FilterChain{
    private List<Filter> filters = new ArrayList();

    //经典的链式结构:需要将当前对象返回出来
    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    public boolean doFilters(Msg msg){
        for(Filter f :filters){
           if(!f.doFilter(msg)) return false;
        }
        return true;
    }
}