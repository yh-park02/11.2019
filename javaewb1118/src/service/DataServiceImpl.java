package service;

public class DataServiceImpl implements DataService1 {
	
	//생성자를 private으로 만들어서 외부에서 객체 생성을 못하도록 한다.
	private DataServiceImpl() {}
	
	//1개만 생성할 수 있도록 하기 위해서 static 변수를 선언
	private static DataService1 dataService;
	
	//생성자 대신 객체를 생성해서 리턴하는 static 메소드를 생성
	public static DataService1 sharedInstance() {
		if(dataService == null) {
			dataService = new DataServiceImpl();
		}
		return dataService;
	}

	@Override
	public void create() {
		System.out.println("데이터 생성");
	}

	@Override
	public void read() {
		System.out.println("데이터 조회");
	}

	@Override
	public void update() {
		System.out.println("데이터 수정");
	}

	@Override
	public void delete() {
		System.out.println("데이터 삭제");
	}
}
