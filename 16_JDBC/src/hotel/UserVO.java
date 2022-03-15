package hotel;

public class UserVO {
	private String name;
	private int age;
	private int gen;
	
	public UserVO() {}
	
	public UserVO(String name, int age, int gen) {
		this.name = name;
		this.age = age;
		this.gen = gen;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getGen() {
		return gen;
	}
	
	public void setGen(int gen) {
		this.gen = gen;
	}
	
	@Override
	public String toString() {
		return gen == 0 ? "User [name=" + name + ", age=" + age + ", gen=male]"
						: "User [name=" + name + ", age=" + age + ", gen=female]";
	}
	
}
