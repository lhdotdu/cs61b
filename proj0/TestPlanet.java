public class TestPlanet {
	public static void main(String[] args) {
		Planet p1 = new Planet(0,0,0,0,1,"planet_a");
		Planet p2 = new Planet(1,0,0,0,1,"planet_b");
		Planet[] planets = {p2};
		System.out.println(p1.calcNetForceExertedByX(planets));
		System.out.println(p1.calcNetForceExertedByY(planets));
	}
}