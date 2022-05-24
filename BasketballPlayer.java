
public class BasketballPlayer {
    protected String name;
    protected String position;
    protected String team;
    protected int height;
    protected int weight;
    protected int agility;
    protected int speed;
    protected int ballHandling;
    int value;

    //constructors
    public BasketballPlayer() {
        String name = "unknown";
        String position = "unknown";
        String team = "unknown";
        int height = 0;
        int weight = 0;
        int agility = 0;
        int speed = 0;
        int ballHandling = 0;
    }

    public BasketballPlayer(String name , String position , String team) {
        this.name = name;
        this.position = position;
        this.team = team;
        int height = 0;
        int weight = 0;
        int agility = 0;
        int speed = 0;
        int ballHandling = 0;
    }

    public BasketballPlayer(String name,String position,String team,int height,int weight,int agility,int speed,int ballHandling) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.height = height;
        this.weight = weight;
        this.agility = agility;
        this.speed = speed;
        this.ballHandling = ballHandling;
    }
    // accessors
    public String getName() {

        return name;
    }
    public String getPosition() {

        return position;
    }
    public String getTeam() {
        return team;
    }
    public int getHeight() {
        return height;
    }
    public int getWeight() {

        return weight;
    }
    public int getAgility() {
        return agility;
    }
    public int getSpeed() {
        return speed;
    }
    public int getBallHandling() {
        return ballHandling;
    }

    //toString
    public String toString() {
        return "Name: " + getName() + "\n" + "Position: " + getPosition() + "\n" + "Team: " + getTeam();
    }

    //getValue
    public int getValue() {

        if (position=="centre") {
            if (height>=82&&(weight>=220&&weight<=250)&&ballHandling>5) {
                value=10;
            } else if (height>=80&&(weight>=210&&weight<=260)&&ballHandling>5) {
                value=8;
            } else if (height >= 80&&ballHandling>4) {
                value=6;
            } else if (height >= 78&&agility > 7) {
                value=5;
            } else if (height >= 78) {
                value=4;
            } else if (height >= 76&&agility > 5) {
                value=2;
            } else {
                value=0;
            }
        }
        if (position=="forward") {
            if (height>=80&&(agility>8||speed>7)) {
                value=10;
            } else if (height>=78&&agility>6&&speed>5) {
                value=8;
            } else if (height >= 77&&agility>5) {
                value=6;
            } else if (height >= 76&&speed > 4) {
                value=5;
            } else if (height >= 75&&(agility>3||speed>3)) {
                value=3;
            } else if (height >= 74) {
                value=1;
            } else {
                value=0;
            }
        }
        if (position=="guard") {
            if (height>=78&&(agility>7||speed>7)&&ballHandling>7) {
                value=10;
            } else if (height>=76&&(agility>6||speed>6)&&ballHandling>7) {
                value=8;
            } else if (height >= 74&&ballHandling>5&&agility>5&&speed>6) {
                value=6;
            } else if (ballHandling>6&&agility>6&&speed>5) {
                value=4;
            } else if (ballHandling>4 && agility > 4) {
                value=2;
            } else {
                value=0;
            }
        }
        return value;
    }


}

class CollegeBasketballPlayer extends BasketballPlayer {
    private int eligibilityRemaining;
    private String role;

    public CollegeBasketballPlayer() {
        super();
        int eligibilityRemaining = 4;
        String role = "bench";
    }

    public CollegeBasketballPlayer(String name , String position , String team) {
        super(name,position,team);
        int eligibilityRemaining = 4;
        String role = "bench";
    }

    public CollegeBasketballPlayer(String name,String position,String team,int height,int weight,int agility, int speed,int ballHandling,int eligibilityRemaining,String role) {
        super(name,position,team,height,weight,agility,speed,ballHandling);
        this.eligibilityRemaining = eligibilityRemaining;
        this.role = role;
    }

    public int getEligibilityRemaining() {
        return eligibilityRemaining;
    }

    public String getRole() {
        return role;
    }

    public String toString() {
        return super.toString() + "\n" +"Role: "+ getRole() +"\nEligibility: "+ getEligibilityRemaining() ;
    }

    public boolean draftable() {
        if ((role=="Starter" && super.getValue()>4) || (role=="Bench" && super.getValue()>=8)) {
            // This is unnecessary , just my shobo
            System.out.println("Player is draftable");
        }
        return true;
    }
}

class ProBasketballPlayer extends BasketballPlayer {
    private String role;
    private int yearsInLeague;

    public ProBasketballPlayer() {
        super();
        int yearsInLeague = 0;
        String role = "bench";
    }

    public ProBasketballPlayer(String name , String position , String team) {
        super(name,position,team);
        int yearsInLeague = 0;
        String role = "bench";
    }

    public ProBasketballPlayer(String name,String position,String team,int height,int weight,int agility, int speed,int ballHandling,int yearsInLeague,String role) {
        super(name,position,team,height,weight,agility,speed,ballHandling);
        this.yearsInLeague = yearsInLeague;
        this.role = role;
    }

    public int getYearsInLeague() {
        return yearsInLeague;
    }

    public String getRole() {
        return role;
    }

    public String toString() {
        return super.toString() + "\n" +"Role: "+ getRole() +"\nYears on League: "+ getYearsInLeague() ;
    }

    public int newContractValue(int contractValue) {
        // Starter Role
        if(role=="Starter"){
            if(yearsInLeague>=10 && super.getValue()>8){
                contractValue=12000000;
            } else if (yearsInLeague>=8 && super.getValue()>7) {
                contractValue=10000000;
            } else if (yearsInLeague>=5 && super.getValue()>7) {
                contractValue=8000000;
            } else if (yearsInLeague>=10 && super.getValue()>5) {
                contractValue=6000000;
            } else if (yearsInLeague>=5) {
                contractValue=2000000;
            } else {
                contractValue=1000000;
            }
        } else {
            contractValue=0;
        }
        // Bench Role
        if(role=="Bench"){
            if (yearsInLeague>=10 && super.getValue()>8){
                contractValue=7500000;
            } else if (yearsInLeague>=8 && super.getValue()>7) {
                contractValue=5000000;
            } else if (yearsInLeague>=10 && super.getValue()>5) {
                contractValue=4500000;
            } else if (yearsInLeague>=7) {
                contractValue=2000000;
            } else {
                contractValue=500000;
            }
        } else {
            contractValue=0;
        }
        return contractValue;
    }
}

public class User {
    public static void main(String[] args) {
//NOTE:  data for objects is assumed to be in the following order
// "name", "position", "team", height (in inches), weight, agility, speed, ballhandling
// not all players will have the four int values
// CollegeBasketballPlayers will also have yearsOfEligibility, role and
// ProBasketballPlayers will have yearsInLeague, role
//NOTE:  data for objects is assumed to be in the following order
// "name", "position", "team", height (in inches), weight, agility, speed, ballhandling
// not all players will have the four int values
// CollegeBasketballPlayers will also have yearsOfEligibility, role and
// ProBasketballPlayers will have yearsInLeague, role
        BasketballPlayer bp1;
        CollegeBasketballPlayer bp2;
        ProBasketballPlayer bp3;
        bp1=new BasketballPlayer("Tim Duncan", "Center", "Spurs", 83, 220, 4, 5, 8);
        bp2=new CollegeBasketballPlayer("Jaylen Reynolds", "Forward", "Xavier", 82, 215, 7, 7, 3, 1, "starter");
        bp3=new ProBasketballPlayer("D'Angelo Russell", "Guard", "Lakers", 77, 190, 7, 9, 7, 1, "starter");
        System.out.println(bp1);
        System.out.println(bp1.newContractValue());//No method at BasketballPlayer named newContractValue
        System.out.println(bp2);
        System.out.println(bp2.draftable());
        System.out.println(bp3);
        System.out.println(bp3.newContractValue());//No integer parameter value in newContractValue()
        bp1=new CollegeBasketballPlayer("Troy Caupain", "Guard", "UC");
        System.out.println(bp1);
        System.out.println(bp1.draftable());//No method at BasketballPlayer named drafttable
        bp2=new CollegeBasketballPlayer("Troy Caupain", "Guard", "UC", 75, 180, 9, 6, 8, 1, "starter");
        System.out.println(bp2);
        System.out.println(bp2.draftable());
        bp1=new BasketballPlayer("J P Macura", "Guard", "Xavier", 77, 190, 8, 4, 5);
        System.out.println(bp1.getValue());
        System.out.println(bp3.getValue());
        bp3=new ProBasketballPlayer("Lebron James", "Forward", "Cavs", 81, 250, 9, 10, 5, 10, "starter");
        System.out.println(bp3);
        System.out.println(bp3.newContractValue());//No integer parameter value in newContractValue()
        bp3 = new BasketballPlayer("Matt Stainbrook", "Center", "Merlins", 82, 270, 6, 5, 6);//bp3 is limited to it's declared type, required ProBasketballPlayer instead of BasketballPlayer
        System.out.println(bp3);
        bp3 = new ProBasketballPlayer("David West", "Forward", "Spurs", 80, 215, 7, 6, 8, 10, "bench");
        System.out.println(bp3);
        System.out.println(bp3.draftable());//No method named draftable
        System.out.println(bp3.newContractValue());//No integer parameter value as been passed in newContractValue()


    }
}

