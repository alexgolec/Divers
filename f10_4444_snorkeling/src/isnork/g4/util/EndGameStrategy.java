package isnork.g4.util;

import isnork.g4.G4Diver;

import java.awt.geom.Point2D;

public class EndGameStrategy {
	
	public double distanceFromBoat(Point2D myPosition){
//		System.out.println("distanceFromBoat - " + myPosition.getX() + " , " + myPosition.getY());
//		double x = myPosition.getX();
//		double y = myPosition.getY();
//		return Math.sqrt(x*x + y*y);
		System.out.println("distanceFromBoat = " + (Point2D.distance(0, 0, myPosition.getX(), myPosition.getY())));
		return Point2D.distance(0, 0, myPosition.getX(), myPosition.getY());
	}
	
	public double fastestReturnTime(Point2D myPosition){
		
		double x = myPosition.getX();
		double y = myPosition.getY();
		// the fastest way back to the boat is to travel diagonally to a primary axis, and then to follow
		// that axis to the boat (In the same number of turns divers can also to travel parallel 
		// to an axis until they reach a primary diagonal and to take this primary diagonal to the boat) 
		double diagonalSteps = Math.min(Math.abs(x), Math.abs(y));
		double axialSteps = Math.max(Math.abs(x), Math.abs(y)) - Math.min(Math.abs(x), Math.abs(y));
		// diagonal steps take 3 turns, axial steps take 2
		return diagonalSteps*3 + axialSteps*2;
	}
	
	/*public double allowedReturnTimeRadius(double safetyMargin, Strategy strategy){
		
		int currentRound = strategy.getCurrentRound();
		int maxRounds = strategy.getMaxRounds();
		int roundsRemaining = maxRounds - currentRound;
		
		// returns the number of rounds remaining, less a safety margin
		// Returns 0.0 when the margin is greater than the remaining time
		// return Math.max(0.0, (double)(roundsRemaining) - safetyMargin);
		return (double)(roundsRemaining) - safetyMargin;
	}*/
	
public double allowedReturnTimeRadius(double safetyMargin, G4Diver g4Diver){
		
		int currentRound = g4Diver.getCurrentRound();
		int maxRounds = g4Diver.getMaxRounds();
		int roundsRemaining = maxRounds - currentRound;
		
		// returns the number of rounds remaining, less a safety margin
		// Returns 0.0 when the margin is greater than the remaining time
		// return Math.max(0.0, (double)(roundsRemaining) - safetyMargin);
		return (double)(roundsRemaining) - safetyMargin;
	}
	
}

