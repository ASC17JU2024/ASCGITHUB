:keyboard: **Lab 7 - Collections**  


:lock: **User Story** As a Flight Agency we need Customers to book tickets. Use the skeleton below to develop the requirment.

:bulb: Use the choice of your own for collection.  


:one: _Create the model_
```java
package com.gflights.model;

public class BookingModel {
    private int bookingId;
    private String source;
//  add destination, ticketClass, noOfPassengers, roundTrip
//  generate getters/ setters
//  override toString method
//  create default and parameterized constructors
}

```
:two: _Create the UI_  
```java
package com.gflights.util;

public class MainMenuUtil {
    public static int displayMainMenu(){
        System.out.println("Welcome to GFlights...");
        System.out.println("1. Book Flights");
        // Add the following
//        2. Display bookings
//        3. Search bookings by bookingId
//        4. update bookings
//        5. delete a booking

//      accept choice from user
        int choice = 1;
        return choice;
    }

}
```
```java
package com.gflights.util;

import com.gflights.model.BookingModel;

public class MenuUtil {
        public static BookingModel bookFlights() {
        System.out.println("Enter Booking Id : ");
        int bookingId = 1;
//        accept all the values, use parameterized constructor and/or getters/setters
        BookingModel bookingModel = new BookingModel();
        bookingModel.setBookingId(bookingId);
        return bookingModel;
    }
}

```
```java
package com.gflights.ui;

import com.gflights.model.BookingModel;
import com.gflights.repository.BookingRepository;
import com.gflights.util.MainMenuUtil;
import com.gflights.util.MenuUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to GFlights" );
        BookingRepository bookingRepository = new BookingRepository();
        int choice = MainMenuUtil.displayMainMenu();
        if(choice == 1) {
            BookingModel bookingModel = null;
            bookingModel = MenuUtil.bookFlights();
//          store the booking details to repository
            bookingRepository.addBooking(bookingModel);
        }
    }
}

```
:three: _Create repository_  
```java
package com.gflights.repository;

import com.gflights.model.BookingModel;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
    List<BookingModel> bookingModelList = new ArrayList<BookingModel>();
    public void addBooking(BookingModel bookingModel) {
        bookingModelList.add(bookingModel);
        System.out.println("Saved booking :  " + bookingModel);
    }

    //        2. Display bookings
    public void displayBookings() {
        // iterate through the arraylist and display the bookings.
        // iterate through a map and display details
    }Cr
//        3. Search bookings by bookingId
//        4. update bookings
//        5. delete a booking
//        6. Create and handle BookingNotFoundException for both List and Map
//        7. Create and handle DuplicateBookingException if a duplicate key is added.
}

```

:dart: **Objectives**  

1. The BookingModel
2. The menus
3. Add multiple bookings
4. Display all the bookings
5. Update bookings
6. Delete bookings
