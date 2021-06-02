package zura.tikaradze.demo;

/**
 * რეფლექციის საშუალებით მანიპულირებას ვახდენთ ობიექტზე runtime -ში.
 * რეფლექციის საშუალებით შეგვიძლია მივიღოთ სრული ინფორმაცია კლასზე, მაგალითიად კლასის სახელი, ცვლადები, მეთოდები,
 * შეგვიძლია გავიგოთ მნიშვნელობები ან შევცვალოთ მნიშვნელობები იმ შემთხვევაშიც თუ ინკაფსულირებული არიან (privat ულები )
 *
 * მინუსები : დაბალი სიჩქარე და ინკაფსულაციის დარღვევა
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ReflectionChecker reflectionChecker = new ReflectionChecker();


        Student student = new Student();
        reflectionChecker.showClassName(student);
        reflectionChecker.showClassFields(student);
        reflectionChecker.showClassMethods(student);
        reflectionChecker.showClassFieldAnnotations(student);


        reflectionChecker.fillPrivateFields(student);
        System.out.println(student.getFullName());
        System.out.println(student.getAge());


        System.out.println("------clone---");
        Student clone = (Student) reflectionChecker.createNewObject(student);
        reflectionChecker.showClassName(clone);
        reflectionChecker.showClassFields(clone);
        reflectionChecker.showClassMethods(clone);
        reflectionChecker.showClassFieldAnnotations(clone);
        System.out.println(clone.getFullName()); // მნიშვნელობები არ გადააქვს
        System.out.println(clone.getAge());// მნიშვნელობები არ გადააქვს

    }
}
