package spring.ch5.aop_namespace;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * Created by andrew_yashin on 5/5/17.
 */
public class MyAdviceBefore {
    public void before(JoinPoint joinPoint, int intValue){
        if(intValue == 0)
        System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName()
                + " "
                + joinPoint.getSignature().getName());
    }

    public Object around(ProceedingJoinPoint joinPoint, int intValue)
        throws Throwable{
        System.out.println("Before: " + joinPoint.getSignature().getDeclaringTypeName()
                + " "
                + joinPoint.getSignature().getName());

        Object object = joinPoint.proceed();

        System.out.println("After: " + joinPoint.getSignature().getDeclaringTypeName()
                + " "
                + joinPoint.getSignature().getName());


        return object;


    }
}
