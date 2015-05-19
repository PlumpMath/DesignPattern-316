
class Material{

	private static int id = 0;
	public Material() {
		id++;
	}

	public String toString() {
		return "id:" + id;
	}
}

public class Test {


	public static void main(String[] args) {
		//为什么这句不能编译通过？
		//ClassGenerator<Material>  gen = ClassGenerator.register(Material.class);
		Generator<Material> gen = ClassGenerator.register(Material.class);
	}
}
