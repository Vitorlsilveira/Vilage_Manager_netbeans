package logics;

public class Logics {

    public String getSexFromId(String id) {

        try {
            String sexStr = id.substring(2, 5);
            int sexInt = Integer.parseInt(sexStr);
            if (sexInt < 500) {
                return "Male";
            }
            return "Female";
        } catch (Exception ex) {
            throw new RuntimeException("Invalid numbers");
        }

    }

    public String getBirthDateUsingId(String id) {
        String date = " ";

        String year = id.substring(0, 2);
        year = "19" + year;

        String numberOfDates = id.substring(2, 5);

        int num = Integer.parseInt(numberOfDates);

        if (num > 500) {
            num = num - 500;
        }

        if (num <= 31) {
            date = year + "/January/" + Integer.toString(num);
        } else if (num <= 60) {
            date = year + "/February/" + Integer.toString((num - 31));
        } else if (num <= 91) {
            date = year + "/March/" + Integer.toString((num - 60));
        } else if (num <= 121) {
            date = year + "/Aprill/" + Integer.toString((num - 91));
        } else if (num <= 152) {
            date = year + "/May/" + Integer.toString((num - 121));
        } else if (num <= 182) {
            date = year + "/June/" + Integer.toString((num - 152));
        } else if (num <= 213) {
            date = year + "/July/" + Integer.toString((num - 182));
        } else if (num <= 244) {
            date = year + "/Augest/" + Integer.toString((num - 213));
        } else if (num <= 274) {
            date = year + "/September/" + Integer.toString((num - 244));
        } else if (num <= 305) {
            date = year + "/Octomber/" + Integer.toString((num - 274));
        } else if (num <= 335) {
            date = year + "/November/" + Integer.toString((num - 305));
        } else if (num <= 366) {
            date = year + "/December/" + Integer.toString((num - 335));
        } else {
            throw new RuntimeException("Wrong Id Number");
        }
        return date;
    }
}
