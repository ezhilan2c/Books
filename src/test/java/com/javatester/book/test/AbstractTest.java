package com.javatester.book.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.javatester.book.dao.BookService;
import com.javatester.book.parse.Parser;
import com.javatester.book.pojo1.Person;
import com.javatester.book.pojo2.Book;
import com.javatester.book.pojo2.PersonTest;
import com.javatester.book.rest.BookController;

public abstract class AbstractTest {

	private static final Random RAND = new Random();
	
	public static Object newInstance(String forClassName) {
		try {
			return Class.forName(forClassName).newInstance();
		}
		catch(Throwable t) {
			throw new ExceptionInInitializerError( "Cannot instantiate " +
					forClassName + t );
		}
	}
	
	public static int randomInt(int min, int max) {
		return RAND.ints(min, max).findFirst().getAsInt();
	}
	
	public static long randomLong(long min, long max) {
		return RAND.longs(min, max).findFirst().getAsLong();
	}
	
	public static LocalDate randomDate(int minYear, int maxYear) {
		long minDay = LocalDate.of(minYear, 1, 1).toEpochDay();
	    long maxDay = LocalDate.of(maxYear, 12, 31).toEpochDay();
	    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
	    return LocalDate.ofEpochDay(randomDay);
	}
	
	public static Book newBook() {
		return (Book)newInstance("com.javatester.book.pojo2.BookImpl");
	}
	
	public static Book newBook( String title, long isbn, Person author, int pages, 
			                    Book.Genre genre, LocalDate published ) {
		Book book = newBook();
		book.setTitle(title);
		book.setISBN(isbn);
		book.setAuthor(author);
		book.setPages(pages);
		book.setGenre(genre);
		book.setPublishedDate(published);
		return book;
	}
	
	public static Person newPerson() {
		return (Person)newInstance("com.javatester.book.pojo1.PersonImpl");
	}
	
	public static Person newPerson( String firstName, String lastName,
			                        LocalDate birthDate ) {
		Person person = newPerson();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setBirthDate(birthDate);
		return person;
	}
	
	public static BookService newBookService() {
		return (BookService)newInstance("com.javatester.book.dao.BookServiceImpl");
	}
	
	public static Parser newParser() {
		return (Parser)newInstance("com.javatester.book.parse.ParserImpl");
	}
	
	public static BookController newBookController() {
		return (BookController)newInstance("com.javatester.book.rest.BookControllerImpl");
	}
	
	public static Person randomPerson() {
		return newPerson( randomFirstName(), randomLastName(), randomDate(1950,2010) );
	}

	public static String randomFirstName() { return randName(true); }

	public static String randomLastName() { return randName(false);}
	
	private static String randName(boolean firstName) {
		final String[] first = new String[] { "Liam", "Noah", "William", "James", "Oliver", "Benjamin", "Elijah",
				"Lucas", "Mason", "Logan", "Alexander", "Ethan", "Jacob", "Michael", "Daniel", "Henry", "Jackson",
				"Sebastian", "Aiden", "Matthew", "Samuel", "David", "Joseph", "Carter", "Owen", "Wyatt", "John", "Jack",
				"Luke", "Jayden", "Dylan", "Grayson", "Levi", "Isaac", "Gabriel", "Julian", "Mateo", "Anthony", "Jaxon",
				"Lincoln", "Joshua", "Christopher", "Andrew", "Theodore", "Caleb", "Ryan", "Asher", "Nathan", "Thomas",
				"Leo", "Isaiah", "Charles", "Josiah", "Hudson", "Christian", "Hunter", "Connor", "Eli", "Ezra", "Aaron",
				"Landon", "Adrian", "Jonathan", "Nolan", "Jeremiah", "Easton", "Elias", "Colton", "Cameron", "Carson",
				"Robert", "Angel", "Maverick", "Nicholas", "Dominic", "Jaxson", "Greyson", "Adam", "Ian", "Austin",
				"Santiago", "Jordan", "Cooper", "Brayden", "Roman", "Evan", "Ezekiel", "Xavier", "Jose", "Jace",
				"Jameson", "Leonardo", "Bryson", "Axel", "Everett", "Parker", "Kayden", "Miles", "Sawyer", "Jason",
				"Declan", "Weston", "Micah", "Ayden", "Wesley", "Luca", "Vincent", "Damian", "Zachary", "Silas",
				"Gavin", "Chase", "Kai", "Emmett", "Harrison", "Nathaniel", "Kingston", "Cole", "Tyler", "Bennett",
				"Bentley", "Ryker", "Tristan", "Brandon", "Kevin", "Luis", "George", "Ashton", "Rowan", "Braxton",
				"Ryder", "Gael", "Ivan", "Diego", "Maxwell", "Max", "Carlos", "Kaiden", "Juan", "Maddox", "Justin",
				"Waylon", "Calvin", "Giovanni", "Jonah", "Abel", "Jayce", "Jesus", "Amy", "Amir", "King", "Beau", "Camden",
				"Alex", "Jasper", "Malachi", "Brody", "Jude", "Blake", "Emmanuel", "Eric", "Brooks", "Elliot",
				"Antonio", "Abraham", "Timothy", "Finn", "Rhett", "Elliott", "Edward", "August", "Xander", "Alan",
				"Dean", "Lorenzo", "Bryce", "Karter", "Victor", "Milo", "Miguel", "Hayden", "Graham", "Grant", "Zion",
				"Tucker", "Jesse", "Zayden", "Joel", "Richard", "Patrick", "Emiliano", "Avery", "Nicolas", "Brantley",
				"Dawson", "Myles", "Matteo", "River", "Steven", "Thiago", "Zane", "Matias", "Judah", "Messiah",
				"Jeremy", "Preston", "Oscar", "Kaleb", "Alejandro", "Marcus", "Mark", "Peter", "Maximus", "Barrett",
				"Jax", "Andres", "Holden", "Legend", "Charlie", "Knox", "Kaden", "Paxton", "Kyrie", "Kyle", "Griffin",
				"Josue", "Kenneth", "Beckett", "Enzo", "Adriel", "Arthur", "Felix", "Bryan", "Lukas", "Paul", "Brian",
				"Colt", "Caden", "Leon", "Archer", "Omar", "Israel", "Aidan", "Theo", "Javier", "Remington", "Jaden",
				"Bradley", "Emilio", "Colin", "Riley", "Cayden", "Phoenix", "Clayton", "Simon", "Ace", "Nash", "Derek",
				"Rafael", "Zander", "Brady", "Jorge", "Jake", "Louis", "Damien", "Karson", "Walker", "Maximiliano",
				"Amari", "Sean", "Chance", "Walter", "Martin", "Finley", "Andre", "Tobias", "Cash", "Corbin", "Arlo",
				"Iker", "Erick", "Emerson", "Gunner", "Cody", "Stephen", "Francisco", "Killian", "Dallas", "Reid",
				"Manuel", "Lane", "Atlas", "Rylan", "Jensen", "Ronan", "Beckham", "Daxton", "Anderson", "Kameron",
				"Raymond", "Amanda", "Orion", "Cristian", "Tanner", "Kyler", "Jett", "Cohen", "Ricardo", "Spencer", "Gideon",
				"Ali", "Fernando", "Jaiden", "Titus", "Travis", "Bodhi", "Eduardo", "Dante", "Ellis", "Prince", "Kane",
				"Luka", "Kash", "Hendrix", "Desmond", "Donovan", "Mario", "Atticus", "Cruz", "Garrett", "Hector",
				"Angelo", "Jeffrey", "Edwin", "Cesar", "Zayn", "Devin", "Conor", "Warren", "Odin", "Jayceon", "Romeo",
				"Julius", "Jaylen", "Hayes", "Kayson", "Muhammad", "Jaxton", "Joaquin", "Caiden", "Dakota", "Major",
				"Keegan", "Sergio", "Marshall", "Johnny", "Kade", "Edgar", "Leonel", "Ismael", "Marco", "Tyson", "Wade",
				"Collin", "Troy", "Nasir", "Conner", "Adonis", "Jared", "Rory", "Andy", "Jase", "Lennox", "Shane",
				"Malik", "Ari", "Reed", "Seth", "Clark", "Erik", "Lawson", "Trevor", "Gage", "Nico", "Malakai", "Quinn",
				"Cade", "Johnathan", "Sullivan", "Solomon", "Cyrus", "Fabian", "Pedro", "Frank", "Shawn", "Malcolm",
				"Khalil", "Nehemiah", "Dalton", "Mathias", "Jay", "Ibrahim", "Peyton", "Winston", "Kason", "Zayne",
				"Noel", "Princeton", "Matthias", "Gregory", "Sterling", "Dominick", "Elian", "Grady", "Russell",
				"Finnegan", "Ruben", "Gianni", "Porter", "Kendrick", "Leland", "Pablo", "Allen", "Hugo", "Raiden",
				"Kolton", "Remy", "Ezequiel", "Damon", "Emanuel", "Zaiden", "Otto", "Bowen", "Marcos", "Abram", "Kasen",
				"Franklin", "Royce", "Jonas", "Sage", "Philip", "Esteban", "Drake", "Kashton", "Roberto", "Harvey",
				"Alexis", "Kian", "Jamison", "Maximilian", "Jennifer", "Adan", "Milan", "Phillip", "Albert", "Dax", "Mohamed",
				"Ronin", "Kamden", "Hank", "Memphis", "Oakley", "Augustus", "Drew", "Moises", "Armani", "Rhys",
				"Benson", "Jayson", "Kyson", "Braylen", "Corey", "Gunnar", "Omari", "Alonzo", "Landen", "Armando",
				"Derrick", "Dexter", "Enrique", "Bruce", "Nikolai", "Francis", "Rocco", "Kairo", "Royal", "Zachariah",
				"Arjun", "Deacon", "Skyler", "Eden", "Alijah", "Rowen", "Pierce", "Uriel", "Ronald", "Luciano", "Tate",
				"Frederick", "Kieran", "Lawrence", "Moses", "Rodrigo", "Brycen", "Leonidas", "Nixon", "Keith",
				"Chandler", "Case", "Davis", "Asa", "Darius", "Isaias", "Aden", "Jaime", "Landyn", "Raul", "Niko",
				"Trenton", "Apollo", "Cairo", "Izaiah", "Scott", "Dorian", "Julio", "Wilder", "Santino", "Dustin",
				"Donald", "Raphael", "Saul", "Taylor", "Ayaan", "Duke", "Ryland", "Tatum", "Ahmed", "Moshe", "Edison",
				"Emmitt", "Cannon", "Alec", "Danny", "Keaton", "Roy", "Conrad", "Roland", "Quentin", "Lewis", "Samson",
				"Brock", "Kylan", "Cason", "Ahmad", "Jalen", "Nikolas", "Braylon", "Kamari", "Dennis", "Callum",
				"Justice", "Soren", "Rayan", "Aarav", "Gerardo", "Ares", "Brendan", "Jamari", "Kaison", "Yusuf",
				"Issac", "Jasiah", "Callen", "Forrest", "Makai", "Crew", "Kobe", "Bo", "Julien", "Mathew", "Braden",
				"Johan", "Marvin", "Zaid", "Stetson", "Casey", "Ty", "Ariel", "Tony", "Zain", "Callan", "Cullen",
				"Sincere", "Uriah", "Dillon", "Kannon", "Colby", "Axton", "Cassius", "Quinton", "Mekhi", "Reece",
				"Alessandro", "Jerry", "Mauricio", "Sam", "Trey", "Mohammad", "Alberto", "Gustavo", "Arturo",
				"Fletcher", "Marcelo", "Abdiel", "Hamza", "Alfredo", "Chris", "Finnley", "Curtis", "Kellan", "Quincy",
				"Kase", "Harry", "Kyree", "Wilson", "Cayson", "Hezekiah", "Kohen", "Neil", "Mohammed", "Raylan",
				"Kaysen", "Lucca", "Sylas", "Mack", "Leonard", "Lionel", "Ford", "Roger", "Rex", "Alden", "Boston",
				"Colson", "Briggs", "Zeke", "Dariel", "Kingsley", "Valentino", "Jamir", "Salvador", "Vihaan",
				"Mitchell", "Lance", "Lucian", "Darren", "Jimmy", "Alvin", "Amos", "Tripp", "Zaire", "Layton", "Reese",
				"Casen", "Colten", "Brennan", "Korbin", "Sonny", "Bruno", "Orlando", "Devon", "Huxley", "Boone",
				"Maurice", "Nelson", "Douglas", "Randy", "Gary", "Lennon", "Titan", "Denver", "Jaziel", "Noe",
				"Jefferson", "Ricky", "Lochlan", "Rayden", "Bryant", "Langston", "Lachlan", "Clay", "Abdullah", "Lee",
				"Baylor", "Leandro", "Ben", "Kareem", "Layne", "Joe", "Crosby", "Deandre", "Demetrius", "Kellen",
				"Carl", "Jakob", "Ridge", "Bronson", "Jedidiah", "Rohan", "Larry", "Stanley", "Tomas", "Shiloh",
				"Thaddeus", "Watson", "Baker", "Vicente", "Koda", "Jagger", "Nathanael", "Carmelo", "Shepherd",
				"Graysen", "Melvin", "Ernesto", "Jamie", "Yosef", "Clyde", "Eddie", "Tristen", "Grey", "Ray", "Tommy",
				"Samir", "Ramon", "Santana", "Kristian", "Marcel", "Wells", "Zyaire", "Brecken", "Byron", "Otis",
				"Reyansh", "Axl", "Joey", "Trace", "Morgan", "Musa", "Harlan", "Enoch", "Henrik", "Kristopher", "Talon",
				"Rey", "Guillermo", "Houston", "Jon", "Vincenzo", "Dane", "Terry", "Azariah", "Castiel", "Kye",
				"Augustine", "Zechariah", "Joziah", "Kamryn", "Hassan", "Jamal", "Chaim", "Bodie", "Emery", "Branson",
				"Jaxtyn", "Kole", "Wayne", "Aryan", "Alonso", "Brixton", "Madden", "Allan", "Flynn", "Jaxen", "Harley",
				"Magnus", "Sutton", "Dash", "Anders", "Westley", "Brett", "Emory", "Felipe", "Yousef", "Jadiel",
				"Mordechai", "Dominik", "Junior", "Eliseo", "Fisher", "Harold", "Jaxxon", "Kamdyn", "Maximo", "Caspian",
				"Kelvin", "Damari", "Fox", "Trent", "Hugh", "Briar", "Franco", "Keanu", "Terrance", "Yahir", "Ameer",
				"Kaiser", "Thatcher", "Ishaan", "Koa", "Merrick", "Coen", "Rodney", "Brayan", "London", "Rudy",
				"Gordon", "Bobby", "Aron", "Marc", "Van", "Anakin", "Canaan", "Dario", "Reginald", "Westin", "Darian",
				"Ledger", "Leighton", "Maxton", "Tadeo", "Valentin", "Aldo", "Khalid", "Nickolas", "Toby", "Dayton",
				"Jacoby", "Billy", "Gatlin", "Elisha", "Jabari", "Jermaine", "Alvaro", "Marlon", "Mayson", "Blaze",
				"Jeffery", "Kace", "Braydon", "Achilles", "Brysen", "Saint", "Xzavier", "Aydin", "Eugene", "Adrien",
				"Cain", "Kylo", "Nova", "Onyx", "Arian", "Bjorn", "Jerome", "Miller", "Alfred", "Kenzo", "Kyng",
				"Leroy", "Maison", "Jordy", "Stefan", "Wallace", "Benicio", "Kendall", "Zayd", "Blaine", "Tristian",
				"Anson", "Gannon", "Jeremias", "Marley", "Ronnie", "Dangelo", "Kody", "Will", "Bentlee", "Gerald",
				"Salvatore", "Turner", "Chad", "Misael", "Mustafa", "Konnor", "Maxim", "Rogelio", "Zakai", "Cory",
				"Judson", "Brentley", "Darwin", "Louie", "Ulises", "Dakari", "Rocky", "Wesson", "Alfonso", "Payton",
				"Dwayne", "Juelz", "Duncan", "Keagan", "Deshawn", "Bode", "Bridger", "Skylar", "Brodie", "Landry",
				"Avi", "Keenan", "Reuben", "Jaxx", "Rene", "Yehuda", "Imran", "Yael", "Alexzander", "Willie",
				"Cristiano", "Heath", "Lyric", "Davion", "Elon", "Karsyn", "Krew", "Jairo", "Maddux", "Ephraim",
				"Ignacio", "Vivaan", "Aries", "Vance", "Boden", "Lyle", "Ralph", "Reign", "Camilo", "Draven",
				"Terrence", "Idris", "Ira", "Javion", "Jericho", "Khari", "Marcellus", "Creed", "Shepard", "Terrell",
				"Ahmir", "Camdyn", "Cedric", "Howard", "Jad", "Zahir", "Harper", "Justus", "Forest", "Gibson", "Zev",
				"Alaric", "Decker", "Ernest", "Jesiah", "Torin", "Benedict", "Bowie", "Deangelo", "Genesis", "Harlem",
				"Kalel", "Kylen", "Bishop", "Immanuel", "Lian", "Zavier", "Archie", "Davian", "Gus", "Kabir", "Korbyn",
				"Randall" };
		final String[] last = new String[] { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller",
				"Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson",
				"Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen",
				"Young", "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez",
				"Nelson", "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans",
				"Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell",
				"Murphy", "Bailey", "Rivera", "Cooper", "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson",
				"Gray", "Ramirez", "James", "Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood",
				"Barnes", "Ross", "Henderson", "Coleman", "Jenkins", "Perry", "Powell", "Long", "Patterson", "Hughes",
				"Flores", "Washington", "Butler", "Simmons", "Foster", "Gonzales", "Bryant", "Alexander", "Russell",
				"Griffin", "Diaz", "Hayes", "Myers", "Ford", "Hamilton", "Graham", "Sullivan", "Wallace", "Woods",
				"Cole", "West", "Jordan", "Owens", "Reynolds", "Fisher", "Ellis", "Harrison", "Gibson", "Mcdonald",
				"Cruz", "Marshall", "Ortiz", "Gomez", "Murray", "Freeman", "Wells", "Webb", "Simpson", "Stevens",
				"Tucker", "Porter", "Hunter", "Hicks", "Crawford", "Henry", "Boyd", "Mason", "Morales", "Kennedy",
				"Warren", "Dixon", "Ramos", "Reyes", "Burns", "Gordon", "Shaw", "Holmes", "Rice", "Robertson", "Hunt",
				"Black", "Daniels", "Palmer", "Mills", "Nichols", "Grant", "Knight", "Ferguson", "Rose", "Stone",
				"Hawkins", "Dunn", "Perkins", "Hudson", "Spencer", "Gardner", "Stephens", "Payne", "Pierce", "Berry",
				"Matthews", "Arnold", "Wagner", "Willis", "Ray", "Watkins", "Olson", "Carroll", "Duncan", "Snyder",
				"Hart", "Cunningham", "Bradley", "Lane", "Andrews", "Ruiz", "Harper", "Fox", "Riley", "Armstrong",
				"Carpenter", "Weaver", "Greene", "Lawrence", "Elliott", "Chavez", "Sims", "Austin", "Peters", "Kelley",
				"Franklin", "Lawson", "Fields", "Gutierrez", "Ryan", "Schmidt", "Carr", "Vasquez", "Castillo",
				"Wheeler", "Chapman", "Oliver", "Montgomery", "Richards", "Williamson", "Johnston", "Banks", "Meyer",
				"Bishop", "Mccoy", "Howell", "Alvarez", "Morrison", "Hansen", "Fernandez", "Garza", "Harvey", "Little",
				"Burton", "Stanley", "Nguyen", "George", "Jacobs", "Reid", "Kim", "Fuller", "Lynch", "Dean", "Gilbert",
				"Garrett", "Romero", "Welch", "Larson", "Frazier", "Burke", "Hanson", "Day", "Mendoza", "Moreno",
				"Bowman", "Medina", "Fowler", "Brewer", "Hoffman", "Carlson", "Silva", "Pearson", "Holland", "Douglas",
				"Fleming", "Jensen", "Vargas", "Byrd", "Davidson", "Hopkins", "May", "Terry", "Herrera", "Wade", "Soto",
				"Walters", "Curtis", "Neal", "Caldwell", "Lowe", "Jennings", "Barnett", "Graves", "Jimenez", "Horton",
				"Shelton", "Barrett", "Obrien", "Castro", "Sutton", "Gregory", "Mckinney", "Lucas", "Miles", "Craig",
				"Rodriquez", "Chambers", "Holt", "Lambert", "Fletcher", "Watts", "Bates", "Hale", "Rhodes", "Pena",
				"Beck", "Newman", "Haynes", "Mcdaniel", "Mendez", "Bush", "Vaughn", "Parks", "Dawson", "Santiago",
				"Norris", "Hardy", "Love", "Steele", "Curry", "Powers", "Schultz", "Barker", "Guzman", "Page", "Munoz",
				"Ball", "Keller", "Chandler", "Weber", "Leonard", "Walsh", "Lyons", "Ramsey", "Wolfe", "Schneider",
				"Mullins", "Benson", "Sharp", "Bowen", "Daniel", "Barber", "Cummings", "Hines", "Baldwin", "Griffith",
				"Valdez", "Hubbard", "Salazar", "Reeves", "Warner", "Stevenson", "Burgess", "Santos", "Tate", "Cross",
				"Garner", "Mann", "Mack", "Moss", "Thornton", "Dennis", "Mcgee", "Farmer", "Delgado", "Aguilar", "Vega",
				"Glover", "Manning", "Cohen", "Harmon", "Rodgers", "Robbins", "Newton", "Todd", "Blair", "Higgins",
				"Ingram", "Reese", "Cannon", "Strickland", "Townsend", "Potter", "Goodwin", "Walton", "Rowe", "Hampton",
				"Ortega", "Patton", "Swanson", "Joseph", "Francis", "Goodman", "Maldonado", "Yates", "Becker",
				"Erickson", "Hodges", "Rios", "Conner", "Adkins", "Webster", "Norman", "Malone", "Hammond", "Flowers",
				"Cobb", "Moody", "Quinn", "Blake", "Maxwell", "Pope", "Floyd", "Osborne", "Paul", "Mccarthy",
				"Guerrero", "Lindsey", "Estrada", "Sandoval", "Gibbs", "Tyler", "Gross", "Fitzgerald", "Stokes",
				"Doyle", "Sherman", "Saunders", "Wise", "Colon", "Gill", "Alvarado", "Greer", "Padilla", "Simon",
				"Waters", "Nunez", "Ballard", "Schwartz", "Mcbride", "Houston", "Christensen", "Klein", "Pratt",
				"Briggs", "Parsons", "Mclaughlin", "Zimmerman", "French", "Buchanan", "Moran", "Copeland", "Roy",
				"Pittman", "Brady", "Mccormick", "Holloway", "Brock", "Poole", "Frank", "Logan", "Owen", "Bass",
				"Marsh", "Drake", "Wong", "Jefferson", "Park", "Morton", "Abbott", "Sparks", "Patrick", "Norton",
				"Huff", "Clayton", "Massey", "Lloyd", "Figueroa", "Carson", "Bowers", "Roberson", "Barton", "Tran",
				"Lamb", "Harrington", "Casey", "Boone", "Cortez", "Clarke", "Mathis", "Singleton", "Wilkins", "Cain",
				"Bryan", "Underwood", "Hogan", "Mckenzie", "Collier", "Luna", "Phelps", "Mcguire", "Allison", "Bridges",
				"Wilkerson", "Nash", "Summers", "Atkins", "Wilcox", "Pitts", "Conley", "Marquez", "Burnett", "Richard",
				"Cochran", "Chase", "Davenport", "Hood", "Gates", "Clay", "Ayala", "Sawyer", "Roman", "Vazquez",
				"Dickerson", "Hodge", "Acosta", "Flynn", "Espinoza", "Nicholson", "Monroe", "Wolf", "Morrow", "Kirk",
				"Randall", "Anthony", "Whitaker", "Oconnor", "Skinner", "Ware", "Molina", "Kirby", "Huffman",
				"Bradford", "Charles", "Gilmore", "Dominguez", "Oneal", "Bruce", "Lang", "Combs", "Kramer", "Heath",
				"Hancock", "Gallagher", "Gaines", "Shaffer", "Short", "Wiggins", "Mathews", "Mcclain", "Fischer",
				"Wall", "Small", "Melton", "Hensley", "Bond", "Dyer", "Cameron", "Grimes", "Contreras", "Christian",
				"Wyatt", "Baxter", "Snow", "Mosley", "Shepherd", "Larsen", "Hoover", "Beasley", "Glenn", "Petersen",
				"Whitehead", "Meyers", "Keith", "Garrison", "Vincent", "Shields", "Horn", "Savage", "Olsen",
				"Schroeder", "Hartman", "Woodard", "Mueller", "Kemp", "Deleon", "Booth", "Patel", "Calhoun", "Wiley",
				"Eaton", "Cline", "Navarro", "Harrell", "Lester", "Humphrey", "Parrish", "Duran", "Hutchinson", "Hess",
				"Dorsey", "Bullock", "Robles", "Beard", "Dalton", "Avila", "Vance", "Rich", "Blackwell", "York",
				"Johns", "Blankenship", "Trevino", "Salinas", "Campos", "Pruitt", "Moses", "Callahan", "Golden",
				"Montoya", "Hardin", "Guerra", "Mcdowell", "Carey", "Stafford", "Gallegos", "Henson", "Wilkinson",
				"Booker", "Merritt", "Miranda", "Atkinson", "Orr", "Decker", "Hobbs", "Preston", "Tanner", "Knox",
				"Pacheco", "Stephenson", "Glass", "Rojas", "Serrano", "Marks", "Hickman", "English", "Sweeney",
				"Strong", "Prince", "Mcclure", "Conway", "Walter", "Roth", "Maynard", "Farrell", "Lowery", "Hurst",
				"Nixon", "Weiss", "Trujillo", "Ellison", "Sloan", "Juarez", "Winters", "Mclean", "Randolph", "Leon",
				"Boyer", "Villarreal", "Mccall", "Gentry", "Carrillo", "Kent", "Ayers", "Lara", "Shannon", "Sexton",
				"Pace", "Hull", "Leblanc", "Browning", "Velasquez", "Leach", "Chang", "House", "Sellers", "Herring",
				"Noble", "Foley", "Bartlett", "Mercado", "Landry", "Durham", "Walls", "Barr", "Mckee", "Bauer",
				"Rivers", "Everett", "Bradshaw", "Pugh", "Velez", "Rush", "Estes", "Dodson", "Morse", "Sheppard",
				"Weeks", "Camacho", "Bean", "Barron", "Livingston", "Middleton", "Spears", "Branch", "Blevins", "Chen",
				"Kerr", "Mcconnell", "Hatfield", "Harding", "Ashley", "Solis", "Herman", "Frost", "Giles", "Blackburn",
				"William", "Pennington", "Woodward", "Finley", "Mcintosh", "Koch", "Best", "Solomon", "Mccullough",
				"Dudley", "Nolan", "Blanchard", "Rivas", "Brennan", "Mejia", "Kane", "Benton", "Joyce", "Buckley",
				"Haley", "Valentine", "Maddox", "Russo", "Mcknight", "Buck", "Moon", "Mcmillan", "Crosby", "Berg",
				"Dotson", "Mays", "Roach", "Church", "Chan", "Richmond", "Meadows", "Faulkner", "Oneill", "Knapp",
				"Kline", "Barry", "Ochoa", "Jacobson", "Gay", "Avery", "Hendricks", "Horne", "Shepard", "Hebert",
				"Cherry", "Cardenas", "Mcintyre", "Whitney", "Waller", "Holman", "Donaldson", "Cantu", "Terrell",
				"Morin", "Gillespie", "Fuentes", "Tillman", "Sanford", "Bentley", "Peck", "Key", "Salas", "Rollins",
				"Gamble", "Dickson", "Battle", "Santana", "Cabrera", "Cervantes", "Howe", "Hinton", "Hurley", "Spence",
				"Zamora", "Yang", "Mcneil", "Suarez", "Case", "Petty", "Gould", "Mcfarland", "Sampson", "Carver",
				"Bray", "Rosario", "Macdonald", "Stout", "Hester", "Melendez", "Dillon", "Farley", "Hopper", "Galloway",
				"Potts", "Bernard", "Joyner", "Stein", "Aguirre", "Osborn", "Mercer", "Bender", "Franco", "Rowland",
				"Sykes", "Benjamin", "Travis", "Pickett", "Crane", "Sears", "Mayo", "Dunlap", "Hayden", "Wilder",
				"Mckay", "Coffey", "Mccarty", "Ewing", "Cooley", "Vaughan", "Bonner", "Cotton", "Holder", "Stark",
				"Ferrell", "Cantrell", "Fulton", "Lynn", "Lott", "Calderon", "Rosa", "Pollard", "Hooper", "Burch",
				"Mullen", "Fry", "Riddle", "Levy", "David", "Duke", "Odonnell", "Guy", "Michael", "Britt", "Frederick",
				"Daugherty", "Berger", "Dillard", "Alston", "Jarvis", "Frye", "Riggs", "Chaney", "Odom", "Duffy",
				"Fitzpatrick", "Valenzuela", "Merrill", "Mayer", "Alford", "Mcpherson", "Acevedo", "Donovan", "Barrera",
				"Albert", "Cote", "Reilly", "Compton", "Raymond", "Mooney", "Mcgowan", "Craft", "Cleveland", "Clemons",
				"Wynn", "Nielsen", "Baird", "Stanton", "Snider", "Rosales", "Bright", "Witt", "Stuart", "Hays",
				"Holden", "Rutledge", "Kinney", "Clements", "Castaneda", "Slater", "Hahn", "Emerson", "Conrad", "Burks",
				"Delaney", "Pate", "Lancaster", "Sweet", "Justice", "Tyson", "Sharpe", "Whitfield", "Talley", "Macias",
				"Irwin", "Burris", "Ratliff", "Mccray", "Madden", "Kaufman", "Beach", "Goff", "Cash", "Bolton",
				"Mcfadden", "Levine", "Good", "Byers", "Kirkland", "Kidd", "Workman", "Carney", "Dale", "Mcleod",
				"Holcomb", "England", "Finch", "Head", "Burt", "Hendrix", "Sosa", "Haney", "Franks", "Sargent",
				"Nieves", "Downs", "Rasmussen", "Bird", "Hewitt", "Lindsay", "Le", "Foreman", "Valencia", "Oneil",
				"Delacruz", "Vinson", "Dejesus", "Hyde", "Forbes", "Gilliam", "Guthrie", "Wooten", "Huber", "Barlow",
				"Boyle", "Mcmahon", "Buckner", "Rocha", "Puckett", "Langley", "Knowles", "Cooke", "Velazquez",
				"Whitley", "Noel", "Vang" };
		if (firstName) {
			return first[randomInt(0, first.length)];
		} else {
			return last[randomInt(0, last.length)];
		}
	}
	
	public static Book randomBook() {
		return newBook( randomTitle(), randomLong(0, 999999999),
		        PersonTest.randomPerson(), randomInt(20,880), 
		        randomGenre(), randomDate(1950, 2010) );
	}
	
	public static List<Book> randomBookList(int size) {
		List<Book> l = new ArrayList<Book>(size);
		for (int i = 0; i < size; i++  ) {
			l.add( randomBook() );
		}
		return l;
	}
	
	public static Book.Genre randomGenre() {
		 Book.Genre[] g = Book.Genre.values();
		 return g[randomInt(0, g.length)];
	}
	
	public static String randomTitle() {
		final String[] nouns = new String[] { "People", "History", "Way", "Art", "World", "Information", "Map", "Two",
				"Family", "Government", "Health", "System", "Computer", "Meat", "Year", "Thanks", "Music", "Person",
				"Reading", "Method", "Data", "Food", "Understanding", "Theory", "Law", "Bird", "Literature", "Problem",
				"Software", "Control", "Knowledge", "Power", "Ability", "Economics", "Love", "Internet", "Television",
				"Science", "Library", "Nature", "Fact", "Product", "Idea", "Temperature", "Investment", "Area",
				"Society", "Activity", "Story", "Industry", "Media", "Thing", "Oven", "Community", "Definition",
				"Safety", "Quality", "Development", "Language", "Management", "Player", "Variety", "Video", "Week",
				"Security", "Country", "Exam", "Movie", "Organization", "Equipment", "Physics", "Analysis", "Policy",
				"Series", "Thought", "Basis", "Boyfriend", "Direction", "Strategy", "Technology", "Army", "Camera",
				"Freedom", "Paper", "Environment", "Child", "Instance", "Month", "Truth", "Marketing", "University",
				"Writing", "Article", "Department", "Difference", "Goal", "News", "Audience", "Fishing", "Growth",
				"Income", "Marriage", "User", "Combination", "Failure", "Meaning", "Medicine", "Philosophy", "Teacher",
				"Communication", "Night", "Chemistry", "Disease", "Disk", "Energy", "Nation", "Road", "Role", "Soup",
				"Advertising", "Location", "Success", "Addition", "Apartment", "Education", "Math", "Moment",
				"Painting", "Politics", "Attention", "Decision", "Event", "Property", "Shopping", "Student", "Wood",
				"Competition", "Distribution", "Entertainment", "Office", "Population", "President", "Unit", "Category",
				"Cigarette", "Context", "Introduction", "Opportunity", "Performance", "Driver", "Flight", "Length",
				"Magazine", "Newspaper", "Relationship", "Teaching", "Cell", "Dealer", "Finding", "Lake", "Member",
				"Message", "Phone", "Scene", "Appearance", "Association", "Concept", "Customer", "Death", "Discussion",
				"Housing", "Inflation", "Insurance", "Mood", "Woman", "Advice", "Blood", "Effort", "Expression",
				"Importance", "Opinion", "Payment", "Reality", "Responsibility", "Situation", "Skill", "Statement",
				"Wealth", "Application", "City", "County", "Depth", "Estate", "Foundation", "Grandmother", "Heart",
				"Perspective", "Photo", "Recipe", "Studio", "Topic", "Collection", "Depression", "Imagination",
				"Passion", "Percentage", "Resource", "Setting", "Ad", "Agency", "College", "Connection", "Criticism",
				"Debt", "Description", "Memory", "Patience", "Secretary", "Solution", "Administration", "Aspect",
				"Attitude", "Director", "Personality", "Psychology", "Recommendation", "Response", "Selection",
				"Storage", "Version", "Alcohol", "Argument", "Complaint", "Contract", "Emphasis", "Highway", "Loss",
				"Membership", "Possession", "Preparation", "Steak", "Union", "Agreement", "Cancer", "Currency",
				"Employment", "Engineering", "Entry", "Interaction", "Mixture", "Preference", "Region", "Republic",
				"Tradition", "Virus", "Actor", "Classroom", "Delivery", "Device", "Difficulty", "Drama", "Election",
				"Engine", "Football", "Guidance", "Hotel", "Owner", "Priority", "Protection", "Suggestion", "Tension",
				"Variation", "Anxiety", "Atmosphere", "Awareness", "Bath", "Bread", "Candidate", "Climate",
				"Comparison", "Confusion", "Construction", "Elevator", "Emotion", "Employee", "Employer", "Guest",
				"Height", "Leadership", "Mall", "Manager", "Operation", "Recording", "Sample", "Transportation",
				"Charity", "Cousin", "Disaster", "Editor", "Efficiency", "Excitement", "Extent", "Feedback", "Guitar",
				"Homework", "Leader", "Mom", "Outcome", "Permission", "Presentation", "Promotion", "Reflection",
				"Refrigerator", "Resolution", "Revenue", "Session", "Singer", "Tennis", "Basket", "Bonus", "Cabinet",
				"Childhood", "Church", "Clothes", "Coffee", "Dinner", "Drawing", "Hair", "Hearing", "Initiative",
				"Judgment", "Lab", "Measurement", "Mode", "Mud", "Orange", "Poetry", "Police", "Possibility",
				"Procedure", "Queen", "Ratio", "Relation", "Restaurant", "Satisfaction", "Sector", "Signature",
				"Significance", "Song", "Tooth", "Town", "Vehicle", "Volume", "Wife", "Accident", "Airport",
				"Appointment", "Arrival", "Assumption", "Baseball", "Chapter", "Committee", "Conversation", "Database",
				"Enthusiasm", "Error", "Explanation", "Farmer", "Gate", "Girl", "Hall", "Historian", "Hospital",
				"Injury", "Instruction", "Maintenance", "Manufacturer", "Meal", "Perception", "Pie", "Poem", "Presence",
				"Proposal", "Reception", "Replacement", "Revolution", "River", "Son", "Speech", "Tea", "Village",
				"Warning", "Winner", "Worker", "Writer", "Assistance", "Breath", "Buyer", "Chest", "Chocolate",
				"Conclusion", "Contribution", "Cookie", "Courage", "Dad", "Desk", "Drawer", "Establishment",
				"Examination", "Garbage", "Grocery", "Honey", "Impression", "Improvement", "Independence", "Insect",
				"Inspection", "Inspector", "King", "Ladder", "Menu", "Penalty", "Piano", "Potato", "Profession",
				"Professor", "Quantity", "Reaction", "Requirement", "Salad", "Sister", "Supermarket", "Tongue",
				"Weakness", "Wedding", "Affair", "Ambition", "Analyst", "Apple", "Assignment", "Assistant", "Bathroom",
				"Bedroom", "Beer", "Birthday", "Celebration", "Championship", "Cheek", "Client", "Consequence",
				"Departure", "Diamond", "Dirt", "Ear", "Fortune", "Friendship", "Funeral", "Gene", "Girlfriend", "Hat",
				"Indication", "Intention", "Lady", "Midnight", "Negotiation", "Obligation", "Passenger", "Pizza",
				"Platform", "Poet", "Pollution", "Recognition", "Reputation", "Shirt", "Sir", "Speaker", "Stranger",
				"Surgery", "Sympathy", "Tale", "Throat", "Trainer", "Uncle", "Youth", "Time", "Work", "Film", "Water",
				"Money", "Example", "While", "Business", "Study", "Game", "Life", "Form", "Air", "Day", "Place",
				"Number", "Part", "Field", "Fish", "Back", "Process", "Heat", "Hand", "Experience", "Job", "Book",
				"End", "Point", "Type", "Home", "Economy", "Value", "Body", "Market", "Guide", "Interest", "State",
				"Radio", "Course", "Company", "Price", "Size", "Card", "List", "Mind", "Trade", "Line", "Care", "Group",
				"Risk", "Word", "Fat", "Force", "Key", "Light", "Training", "Name", "School", "Top", "Amount", "Level",
				"Order", "Practice", "Research", "Sense", "Service", "Piece", "Web", "Boss", "Sport", "Fun", "House",
				"Page", "Term", "Test", "Answer", "Sound", "Focus", "Matter", "Kind", "Soil", "Board", "Oil", "Picture",
				"Access", "Garden", "Range", "Rate", "Reason", "Future", "Site", "Demand", "Exercise", "Image", "Case",
				"Cause", "Coast", "Action", "Age", "Bad", "Boat", "Record", "Result", "Section", "Building", "Mouse",
				"Cash", "Class", "Nothing", "Period", "Plan", "Store", "Tax", "Side", "Subject", "Space", "Rule",
				"Stock", "Weather", "Chance", "Figure", "Man", "Model", "Source", "Beginning", "Earth", "Program",
				"Chicken", "Design", "Feature", "Head", "Material", "Purpose", "Question", "Rock", "Salt", "Act",
				"Birth", "Car", "Dog", "Object", "Scale", "Sun", "Note", "Profit", "Rent", "Speed", "Style", "War",
				"Bank", "Craft", "Half", "Inside", "Outside", "Standard", "Bus", "Exchange", "Eye", "Fire", "Position",
				"Pressure", "Stress", "Advantage", "Benefit", "Box", "Frame", "Issue", "Step", "Cycle", "Face", "Item",
				"Metal", "Paint", "Review", "Room", "Screen", "Structure", "View", "Account", "Ball", "Discipline",
				"Medium", "Share", "Balance", "Bit", "Black", "Bottom", "Choice", "Gift", "Impact", "Machine", "Shape",
				"Tool", "Wind", "Address", "Average", "Career", "Culture", "Morning", "Pot", "Sign", "Table", "Task",
				"Condition", "Contact", "Credit", "Egg", "Hope", "Ice", "Network", "North", "Square", "Attempt", "Date",
				"Effect", "Link", "Post", "Star", "Voice", "Capital", "Challenge", "Friend", "Self", "Shot", "Brush",
				"Couple", "Debate", "Exit", "Front", "Function", "Lack", "Living", "Plant", "Plastic", "Spot", "Summer",
				"Taste", "Theme", "Track", "Wing", "Brain", "Button", "Click", "Desire", "Foot", "Gas", "Influence",
				"Notice", "Rain", "Wall", "Base", "Damage", "Distance", "Feeling", "Pair", "Savings", "Staff", "Sugar",
				"Target", "Text", "Animal", "Author", "Budget", "Discount", "File", "Ground", "Lesson", "Minute",
				"Officer", "Phase", "Reference", "Register", "Sky", "Stage", "Stick", "Title", "Trouble", "Bowl",
				"Bridge", "Campaign", "Character", "Club", "Edge", "Evidence", "Fan", "Letter", "Lock", "Maximum",
				"Novel", "Option", "Pack", "Park", "Plenty", "Quarter", "Skin", "Sort", "Weight", "Baby", "Background",
				"Carry", "Dish", "Factor", "Fruit", "Glass", "Joint", "Master", "Muscle", "Red", "Strength", "Traffic",
				"Trip", "Vegetable", "Appeal", "Chart", "Gear", "Ideal", "Kitchen", "Land", "Log", "Mother", "Net",
				"Party", "Principle", "Relative", "Sale", "Season", "Signal", "Spirit", "Street", "Tree", "Wave",
				"Belt", "Bench", "Commission", "Copy", "Drop", "Minimum", "Path", "Progress", "Project", "Sea", "South",
				"Status", "Stuff", "Ticket", "Tour", "Angle", "Blue", "Breakfast", "Confidence", "Daughter", "Degree",
				"Doctor", "Dot", "Dream", "Duty", "Essay", "Father", "Fee", "Finance", "Hour", "Juice", "Limit", "Luck",
				"Milk", "Mouth", "Peace", "Pipe", "Seat", "Stable", "Storm", "Substance", "Team", "Trick", "Afternoon",
				"Bat", "Beach", "Blank", "Catch", "Chain", "Consideration", "Cream", "Crew", "Detail", "Gold",
				"Interview", "Kid", "Mark", "Match", "Mission", "Pain", "Pleasure", "Score", "Screw", "Sex", "Shop",
				"Shower", "Suit", "Tone", "Window", "Agent", "Band", "Block", "Bone", "Calendar", "Cap", "Coat",
				"Contest", "Corner", "Court", "Cup", "District", "Door", "East", "Finger", "Garage", "Guarantee",
				"Hole", "Hook", "Implement", "Layer", "Lecture", "Lie", "Manner", "Meeting", "Nose", "Parking",
				"Partner", "Profile", "Respect", "Rice", "Routine", "Schedule", "Swimming", "Telephone", "Tip",
				"Winter", "Airline", "Bag", "Battle", "Bed", "Bill", "Bother", "Cake", "Code", "Curve", "Designer",
				"Dimension", "Dress", "Ease", "Emergency", "Evening", "Extension", "Farm", "Fight", "Gap", "Grade",
				"Holiday", "Horror", "Horse", "Host", "Husband", "Loan", "Mistake", "Mountain", "Nail", "Noise",
				"Occasion", "Package", "Patient", "Pause", "Phrase", "Proof", "Race", "Relief", "Sand", "Sentence",
				"Shoulder", "Smoke", "Stomach", "String", "Tourist", "Towel", "Vacation", "West", "Wheel", "Wine",
				"Arm", "Aside", "Associate", "Bet", "Blow", "Border", "Branch", "Breast", "Brother", "Buddy", "Bunch",
				"Chip", "Coach", "Cross", "Document", "Draft", "Dust", "Expert", "Floor", "God", "Golf", "Habit",
				"Iron", "Judge", "Knife", "Landscape", "League", "Mail", "Mess" };
		return "The " + nouns[randomInt(0, nouns.length)] + " of the " +
				nouns[randomInt(0, nouns.length)];
	}
}
