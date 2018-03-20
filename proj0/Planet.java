/** The Planet class. */
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G = 6.67e-11;
    static final String imgFolder = "images/";

    /** Constructor by specifying all variables. */
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass  = m;
        imgFileName = img;
    }

    /** Constructor by copying from an input Planet object */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel; 
        yyVel = p.yyVel;
        mass  = p.mass;
        imgFileName = p.imgFileName;
    }

    /** Calculate the distance between the current planet and the
    	supplied planet. */
    public double calcDistance(Planet p) {
    	double d_x = xxPos - p.xxPos;
    	double d_y = yyPos - p.yyPos;
    	return Math.sqrt(d_x*d_x + d_y*d_y);
    }

    /** Calculate the force exerted by an input planet on the current
    	planet. */
	public double calcForceExertedBy(Planet p) {
		double dist = calcDistance(p);
		double force = G * mass*p.mass / (dist*dist);
		return force;
	}

	/** Calculate the force exerted by an input planet in x direction
	*/
	public double calcForceExertedByX(Planet p) {
		double force = calcForceExertedBy(p);
		double dist = calcDistance(p);
		double ratio = (p.xxPos-xxPos)/dist;
		double force_x = force * ratio;
		return force_x;
	}

	/** Calculate the force exerted by an input planet in y direction
	*/
	public double calcForceExertedByY(Planet p) {
		double force = calcForceExertedBy(p);
		double dist = calcDistance(p);
		double ratio = (p.yyPos-yyPos)/dist;
		double force_y = force * ratio;
		return force_y;
	}

	/** Calculate the net force from an array of Planets in x. */
	public double calcNetForceExertedByX(Planet p[]) {
		double force_x_sum = 0.0;
		for (Planet e:p) {
			if (this.equals(e)) continue;
			force_x_sum += calcForceExertedByX(e);
		}
		return force_x_sum;
	}

	/** Calculate the net force from an array of Planets in y. */
	public double calcNetForceExertedByY(Planet p[]) {
		double force_y_sum = 0.0;
		for (Planet e:p) {
			if (this.equals(e)) continue;
			force_y_sum += calcForceExertedByY(e);
		}
		return force_y_sum;
	}

	/** Update the velocity and position of the planet according to input
		x-force and y-force during given time span. */
	public void update(double dt, double force_x, double force_y) {
		double accel_x = force_x/mass;
		double accel_y = force_y/mass;
		xxVel += accel_x * dt;
		yyVel += accel_y * dt;
		xxPos += xxVel * dt;
		yyPos += yyVel * dt;
	}

	/** Draw the planet at the canvas. */
	public void draw() {
		StdDraw.picture(xxPos, yyPos, imgFolder+imgFileName);
	}
}
