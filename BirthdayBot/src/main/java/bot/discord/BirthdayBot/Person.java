package bot.discord.BirthdayBot;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String name;
    private LocalDate geburtstag;
    private int daysUntilBirthday;
    private LocalDate nextBirthday;
    private String alter;
    
    public Person() {
        // default constructor
    }
    
    public Person(String name, LocalDate geburtstag, int daysUntilBirthday, LocalDate nextBirthday, String alter) {
        this.name = name;
        this.geburtstag = geburtstag;
        this.daysUntilBirthday = daysUntilBirthday;
        this.nextBirthday = nextBirthday;
        this.alter = alter;
    }
    
    public String getName() {
        return name;
    }
    
    public LocalDate getGeburtstag() {
        return geburtstag;
    }
    
    public int getDaysUntilBirthday() {
        return daysUntilBirthday;
    }
    
    public LocalDate getNextBirthday() {
        return nextBirthday;
    }
    
    public String getAlter() {
        return alter;
    }
    
    public int getAge() {
        LocalDate now = LocalDate.now();
        return Period.between(geburtstag, now).getYears();
    }

	@Override
	public String toString() {
		return "Person [name=" + name + ", geburtstag=" + geburtstag + ", daysUntilBirthday=" + daysUntilBirthday
				+ ", nextBirthday=" + nextBirthday + ", alter=" + alter + "]";
	}
    
    
    
}

