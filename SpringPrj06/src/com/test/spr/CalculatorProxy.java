/*=========================================
   CalculatorProxy.java
   - 프록시 클래스.
   - 보조 업무 적용 및 주 업무 호출 과정
 ==========================================*/

// ※ Proxy 클래스 만드는 여러가지 방법들 중
//    비교적 쉽고 직관적인 방법은
//    InvocationHandler 인터페이스를 구현하는 클래스를 만드는 것이다.

package com.test.spr;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

// ※ Proxy 클래스를 만드는 방법 중 비교적 쉽고 직관적인 방법은
//    InvocationHandler 인터페이스를 구현하는 클래스를 만드는 것이다.

public class CalculatorProxy implements InvocationHandler
{
	// target → 가짜가 진짜 행세를 하게 될 대상
	// ex) 물건/객체 미화
	//      ------  -----
 	private Object target;
	
	// 생성자 정의
	public CalculatorProxy(Object target)
	{
		this.target = target;
	}

	// 보조 업무 적용 및 주 업무 호출 과정 추가
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{		
		// 보조 업무(cross-cutting concern) 설정
		//-- 시간 측정(Around Advice)
		Log log = LogFactory.getLog(this.getClass()); //-- getLog() 는 static 메소드
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("처리 시간 측정 시작----------------------");
		
		// 주 업무(core concern) 실행 내용
		Object result = method.invoke(target, args); //-- target: 따라하는 대상, args: 유전적인 성질들 함께 넘김
				
		sw.stop();
		log.info("처리 시간 측정 종료---------------------");
		log.info(String.format("경과시간 : %s/1000초", sw.getTotalTimeMillis()));

		return result;
		
	}
	
	
	
}