
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
		ClassGenerator<Material>  gen = ClassGenerator.register(Material.class);
		//Generator<Material> gen = ClassGenerator.register(Material.class);
	}
}
