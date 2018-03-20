/** The NBody class*/
public class NBody {
	/** Reads the radius from given file path. */
	public static double readRadius(String filename) {
		In in = new In(filename);
		// Skip the first line.
		in.readInt();
		return in.readDouble();
	}

	/** Reads in all planets and return a list containing them. */
	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		// Skip the second line.
		in.readDouble();	
		Planet[] planets = new Planet[5];
		for (int i=0; i<N; i++) {
			Planet temp = new Planet(
				in.readDouble(),
				in.readDouble(),
				in.readDouble(),
				in.readDouble(),
				in.readDouble(),
				in.readString());
			planets[i] = temp;
		}
		return planets;
	}

	/** main */
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double universe_radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
	}
} 