package com.dcj.spring.v1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        Tank t = (Tank) context.getBean("tank");
        t.move();
    }
   /* <bean id="Tank" class="com.dcj.spring.v1.Tank"></bean>
    <bean id="TankTimestamp" class="com.dcj.spring.v1.TankTimestamp"></bean>
    <aop:config><!--spring 面向切面编程-->
        <aop:aspect id="time" ref="TankTimestamp"><!--切入类-->
            <aop:pointcut id="onmove" expression="execution(void com.dcj.spring.v1.Tank.move())"></aop:pointcut><!--指定被切入方法的切入点-->
            <aop:before method="before" pointcut-ref="onmove"></aop:before><!--在该方法执行前 应当之情切入类的方法 pointcut-ref="onmove" 指向那个切入点-->
            <aop:after method="after" pointcut-ref="onmove"></aop:after><!--在该方法执行后 应当之情切入类的方法 pointcut-ref="onmove" 指向那个切入点-->
        </aop:aspect>
    </aop:config>*/
}
