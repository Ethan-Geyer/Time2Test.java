// Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.
public class Time2 {


   private int totalSeconds; //0-86,400

   // Time2 no-argument constructor:
   // initializes each instance variable to zero
   public Time2()
   {
      this(0); // invoke constructor with three arguments
   }

   // Time2 constructor: hour supplied, minute and second defaulted to 0
   public Time2(int hour)
   {

      this(hour, 0, 0); // invoke constructor with three arguments
      hour = totalSeconds / 60 / 60;
   }

   // Time2 constructor: hour and minute supplied, second defaulted to 0
   public Time2(int hour, int minute)
   {

      this(hour, minute, 0); // invoke constructor with three arguments
      minute = (hour - 12) /60;
   }

   // Time2 constructor: hour, minute and second supplied
   public Time2(int hour, int minute, int second)
   {

      // new Time2(12, 25, 42)
      if (hour < 0 || hour >= 24)
         throw new IllegalArgumentException("hour must be 0-23");

      if (minute < 0 || minute >= 60)
         throw new IllegalArgumentException("minute must be 0-59");

      if (second < 0 || second >= 60)
         throw new IllegalArgumentException("second must be 0-59");


      setHour(hour);
      setMinute(minute);
      setSecond(second);

      // this.totalSeconds += totalSeconds;
   }

   // Time2 constructor: another Time2 object supplied
   public Time2(Time2 time)
   {
      // invoke constructor with three arguments
      this(time.getHour(), time.getMinute(), time.getSecond());
   }

   // Set Methods
   // set a new time value using universal time;
   // validate the data
   public void setHour(int hour, int minute, int second)
   {
      if (hour < 0 || hour >= 24)
         throw new IllegalArgumentException("hour must be 0-23");

      if (minute < 0 || minute >= 60)
         throw new IllegalArgumentException("minute must be 0-59");

      if (second < 0 || second >= 60)
         throw new IllegalArgumentException("second must be 0-59");

      /*setHour(hour);
      setMinute(minute);
      setSecond(second);
       */

   }

   // validate and set hour
   public void setHour(int hour)
   {
      if (hour < 0 || hour >= 24)
         throw new IllegalArgumentException("hour must be 0-23");

      // totalSeconds += totalSeconds - (getHour() * 60 * 60);
      totalSeconds += totalSeconds + (hour * 60 * 60);
      //setHour(hour);
   }

   // validate and set minute
   public void setMinute(int minute)
   {
      if (minute < 0 || minute >= 60)
         throw new IllegalArgumentException("minute must be 0-59");

      // totalSeconds = totalSeconds -(getMinute() * 60 * 60);
      totalSeconds = totalSeconds +(minute * 60);
      // setMinute(minute);
   }

   // validate and set second
   public void setSecond(int second)
   {
      if (second < 0 || second >= 60)
         throw new IllegalArgumentException("second must be 0-59");

      //   totalSeconds = totalSeconds - (getSecond() * 60 * 60);
      totalSeconds += second;
      //setSecond(second);
   }

   // Get Methods
   // get hour value
   public int getHour()
   {
      int hour = (totalSeconds/60)/60;
      return hour;
   }

   // get minute value
   public int getMinute()
   {
      return totalSeconds/60%60;
   }

   // get second value
   public int getSecond()
   {

      return totalSeconds % 60;
   }

   //adding a second
   public int tick(){
      totalSeconds = (totalSeconds + 1);
      int tick = totalSeconds;
      return tick;
      //string tick = displayTime(getSecond +1);
   }

   //adding a minute
   public int incrementMinute(){

      int incrementMinute = totalSeconds + 60;
      totalSeconds = incrementMinute;
      return incrementMinute;
   }

   //adding an hour
   public int incrementHour(){

      int incrementHour = totalSeconds + (60 * 60);
      totalSeconds = incrementHour;
      return incrementHour;
   }
   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString()
   {
      return String.format(
              "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
   }

   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString()
   {
      return String.format("%d:%02d:%02d %s",
              ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
              getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
   }
} // end class Time2

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
