/*============================================
 	Main.java
 	- main() 메소드가 포함된 테스트 클래스
=============================================*/

package com.test.spr;

public class Main
{

	public static void main(String[] args)
	{
		// [스프링이 처리하고 관리하게 될 영역 ] → 스프링 컨테이너 안에서 벌어지게될 상황
		//---------------------------------------------------------------------------------
		
		// ① RecordImpl1(Record) 객체 생성 과정
		Record rec1 = new RecordImpl1();			//-- dependency (의존 객체)
		// ② RecordImpl2(Record) 객체 생성 과정
		Record rec2 = new RecordImpl2();			//-- dependency (의존 객체)
		// ③ RecordViewImpl(Record) 객체 생성 과정
		//-- Record(의존 객체 - RecordImpl1 / RecordImpl2) 객체 필요
		RecordViewImpl view = new RecordViewImpl();
		
		// check~!!!
		// 의존 객체 주입
		//-- 의존 객체 주입 방법을 사용하게 되면
		//	 느슨한 결합을 구성할 수 있게되고
		//	 한 쪽의 변동 상황이 다른 쪽에 영향을 덜 줄 수 있게 된다.
		view.setRecord(rec1);		//--setter injection
									//	(setter 를 통한 주입)
		// view.setRecord(rec2);
				
		//---------------------------------------------------------------------------------
		
		view.input();
		view.output();

	}

}
