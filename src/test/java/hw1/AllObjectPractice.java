package hw1;

import org.junit.jupiter.api.Test;

public class AllObjectPractice {
@Test
    public void workingWithObjects () {
    Cat CatOne = new Cat();
    CatOne.setName("Bonya");
    CatOne.setColor("Gray");
    CatOne.setCatIsFat(true);

    Cat CatTwo = new Cat();
    CatTwo.setName("Korzhik");
    CatTwo.setColor("Ginger");
    CatTwo.setCatIsFat(false);

    Book BookOne = new Book();
    BookOne.setName("Mind hunters");
    BookOne.setType("Detective");
    BookOne.setNumberOfPages(322);

    Book BookTwo = new Book();
    BookTwo.setName("Shinning");
    BookTwo.setType("Horror");
    BookTwo.setNumberOfPages(666);

    Course CourseOne = new Course();
    CourseOne.setCourseName("QA");
    CourseOne.setDateOfBeginning("01.09.2022");
    CourseOne.setStudentAmount(50);

    Course CourseTwo = new Course();
    CourseTwo.setCourseName("Java");
    CourseTwo.setDateOfBeginning("31.12.2022");
    CourseTwo.setStudentAmount(25);

        System.out.println("Eto kotiki!");
        System.out.println(CatOne.getName());
        if (CatOne.isCatIsFat() == true) {
            System.out.println("Fat");
        } else {
            System.out.println("Not Fat");
        }

        System.out.println(CatTwo.getName());
        if (CatTwo.isCatIsFat() == true) {
        System.out.println("Fat");
        } else {
        System.out.println("Not Fat");
    }


        System.out.println("Books to read:");
        System.out.println(BookOne.getName());
        System.out.println(BookTwo.getName());


        System.out.println("New courses");
        System.out.println(CourseOne.getCourseName());
        System.out.println(CourseOne.getDateOfBeginning());


        System.out.println(CourseTwo.getCourseName());
        System.out.println(CourseTwo.getDateOfBeginning());
}
}
