//UIUC CS125 FALL 2014 MP. File: RobotLink.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2015-04-20T07:56:24-0500.863101473
public class RobotLink {

	private RobotLink next; 	
	private final Robot robot;

	public Robot getRobot() {
		return robot;
	}
	/** Constructs this link.
	 * @param next ; the next item in the chain (null, if there are no more items).
	 * @param robot ; a single robot (never null).
	 * @author jbucio4
	 */
	public RobotLink(RobotLink next,Robot robot) {
		this.robot = robot;
		this.next = next;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int count() {
		if (next == null)
			return 1; // BASE CASE; no more recursion required!

		// Recursive case:
		return 1 + next.count();
	}
	/**
	 * Counts the number of flying robots in the linked list.
	 * Hint: robot.isFlying is useful here.
	 */
	public int countFlyingRobots() {
		if(next == null){
			return (robot.isFlying()? 1 : 0);
		}
			if(robot.isFlying()){
				return 1 + next.countFlyingRobots();
			}
				else{
					return 0 + next.countFlyingRobots();
				}
	}
	/**
	 * Counts the number of flying robots upto and excluding a sad robot.
	 * (i.e. do not count the sad robot if it is flying).
	 * If there are no sad robots this function will return the same value as countFlyingRobots().
	 * Hint: robot.isHappy() is useful.
	 */
	public int countFlyingRobotsBeforeSadRobot() {
		if(!robot.isHappy()) {
			return 0;
		}
			if(next == null){
				return (robot.isFlying()? 1 : 0);
			}
				if(robot.isFlying()){
					return 1 + next.countFlyingRobotsBeforeSadRobot();
					}
		else
			return 0 + next.countFlyingRobotsBeforeSadRobot();
	}
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param robot - the robot value of the new last link
	 */
	public void append(Robot robot) {
		if(next == null) {
			next = new RobotLink(null, robot);
		}
			else{
				next.append(robot);
			}
	}
	/**
	 * Returns the first flying unhappy robot, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getFirstFlyingUnhappyRobot() {
		boolean sadBot = !robot.isHappy() && robot.isFlying();
		
		if(next == null && !sadBot) {
			return null;
		}
		if(sadBot) {
			return this.robot;
		}
			else{
				return next.getFirstFlyingUnhappyRobot();
		}
	}
	
	/**
	 * Returns the last flying unhappy robotn the linked list, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getLastFlyingUnhappyRobot() {
		Robot normal = null;
		boolean downBot = !robot.isHappy() && robot.isFlying();
		
		if(next != null) {
			normal = next.getLastFlyingUnhappyRobot();
			}
		if(normal == null && downBot) {
			return this.robot;
		}
			return normal;
	}
	
	/**
	 * Returns a reference to the happy most distant explorer.
	 * Returns null if there are no happy robots
	 * @return reference to the most distant happy robot
	 */
	public Robot findHappyRobotFurthestFromHome() {
		Robot farAway = new Robot(0, 0, true);
		farAway = (this.robot.getDistanceFromHome() > farAway.getDistanceFromHome() ? this.robot : farAway);
		
		if(next == null){
			return farAway;
		}
			else{
				next.findHappyRobotFurthestFromHome();
			}
	return farAway;
	}
	
	/**
	 * Returns true if linked list contains the robot.
	 * Hint: Use robot.equals(other).
	 * @param robot
	 * @return
	 */
	public boolean contains(Robot other) {
		boolean leaderBot = this.robot.equals(other);
		if(next == null && !leaderBot){
			return false;
		}
			if(leaderBot) {
				return leaderBot;
		}
			else {
				return next.contains(other);
		}
	}

	
}
