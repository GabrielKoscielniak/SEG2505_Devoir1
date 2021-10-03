public class PointCP4
{
  //Instance variables ************************************************

  private double rho;
  private double theta;
  private double x;
  private double y;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP4(char type, double xOrRho, double yOrTheta)
  {
    if(type != 'C' && type != 'P')
      throw new IllegalArgumentException();
    
    if (type == 'C') {
        x = xOrRho;
        y = yOrTheta;
        rho = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
    } else if (type == 'P') {
        rho = xOrRho;
        theta = yOrTheta;
        x = rho * Math.cos(Math.toRadians(theta));
        y = rho * Math.sin(Math.toRadians(theta));
    }
  }
	
  
  //Instance methods **************************************************
 
 
  public double getX() {return x;}
  
  public double getY() {return y;}
  
  public double getRho() {return rho;}
  
  public double getTheta() {return theta;}


  public double getDistance(PointCP4 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  public PointCP4 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP4('C',
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  public String toString()
  {
    return "Cartesian  (" + getX() + "," + getY() + ")"
       + "\n" + "Polar [" + getRho() + "," + getTheta() + "]";
  }
}