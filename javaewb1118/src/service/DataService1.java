package service;
//실제 알고리즘과 도메인 처리를 할 메소드 선언 
public interface DataService1 {
	//데이터를 생성하는 메소드 
	public void create();
	//데이터를 읽어주는 메소드
	public void read();
	//데이터를 수정하는 메소드
	public void update();
	//데이터를 삭제하는 메소드 
	public void delete();
}
