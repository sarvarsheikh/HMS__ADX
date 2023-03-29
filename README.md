# HMS__ADX
Documentation of Hotel Management System:

The Hotel Management System is designed to manage the booking, cancellation, and checking out of rooms in a hotel. It uses a MySQL database to store information about rooms, guests, and bookings. The system is divided into four main Java classes: Hotel, Login_menu, Menu, and Room.

Hotel class:
The Hotel class contains the main method that starts the program by creating an instance of the Login_menu class and calling its menu method.
Login_menu class:
The Login_menu class is responsible for authenticating users before allowing them to access the system's features. It contains a menu method that takes user input for their username and password, verifies them against a pre-defined set of usernames and passwords, and then grants permission to access the system's features.
Menu class:
The Menu class is responsible for presenting the main menu of the system to the user and taking their input to access different features of the system. It contains a meu_Screen method that continuously displays the menu until the user decides to exit the system.
Room class:
The Room class is responsible for performing the actual booking, cancellation, and checking out of rooms. It contains methods for booking a room, canceling a booking, checking out a room, and searching for bookings. It also establishes a connection to the MySQL database using JDBC to perform database operations.
The Room class contains the most significant amount of functionality, and its methods are documented below:

booking() method:

This method prompts the user to enter various details about their booking, such as name, email, phone number, address, room type, number of adults and children, and number of bedrooms. It then checks the availability of the specified room and creates a new booking if the room is available. It also calculates the total price of the booking based on the room type, number of bedrooms, and number of days of stay.
remove_Detail() method:

This method allows the user to cancel a booking by specifying the booking ID. It deletes the corresponding booking record from the database.
check__out() method:

This method allows the user to check out of a room by specifying the booking ID. It calculates the total bill for the stay, updates the database to mark the room as available, and deletes the corresponding booking record.
give__detail() method:

This method allows the user to search for bookings by specifying various search criteria, such as name, email, phone number, address, and room type. It then displays the matching bookings to the user.
The Room class also establishes a connection to the MySQL database using JDBC and performs various database operations using SQL queries. It contains the following methods:

Room() constructor:

This constructor establishes a connection to the MySQL database using JDBC and sets up the necessary resources to perform database operations.
getRoomPrice() method:

This method retrieves the price of a specified room type from the database.
isRoomAvailable() method:

This method checks if a specified room is available for booking by querying the database.
createBooking() method:

This method creates a new booking record in the database for a specified room and guest.
deleteBooking() method:

This method deletes a booking record from the database for a specified booking ID.
updateRoomStatus() method:

This method updates the status of a specified room in the database to mark it as available or occupied.
searchBooking() method:

This method searches the database for booking records that match a specified set of search criteria and returns the results to the caller.
Overall, the Hotel Management System provides a basic set of features for managing hotel room bookings. While the system may be expanded to include more advanced functionality, such as room service ordering and guest feedback, it provides a solid foundation for a hotel management application.
