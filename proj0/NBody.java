/** The NBody class*/
public class NBody {
	// Number of planets
	public static int N;

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
		N = in.readInt();
		// Skip the second line.
		in.readDouble();	
		Planet[] planets = new Planet[N];
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
		// Read command line arguments
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		// Read planet data
		double universe_radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		// Drawing the planets
		for (int i=0; i<N; i++) {
			planets[i].draw();
		}
		
		// Animation
		// Draw on the offscreen canvas
		StdDraw.enableDoubleBuffering();
		for (double time=0; time<=T; time+=dt) {
			// Create net force array
			double[] xForces = new double[N];
			double[] yForces = new double[N];
			for (int i=0; i<N; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			// Update each planet
			for (int i=0; i<N; i++) {
				planets[i].update(dt,xForces[i],yForces[i]);
			}

			// Draw the background
			StdDraw.setScale(-universe_radius, universe_radius);
			StdDraw.clear();
			StdDraw.picture(0, 0, "./images/starfield.jpg",2*universe_radius,2*universe_radius);

			// Draw the planets
			for (Planet e:planets) {
				e.draw();
			}

			// Show animation
			StdDraw.show();
			// Comment below to speed up animation
			StdDraw.pause(10);
		}

		// Print out the final state
		System.out.println(N);
		System.out.println(universe_radius);
		for (Planet e:planets) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
				e.xxPos, e.yyPos,
				e.xxVel, e.yyVel,
				e.mass, e.imgFileName);
		}
	}
} 