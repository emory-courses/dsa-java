# Getting Started


## Java Development Kit (JDK)

* Install the latest version of [Java SDK](http://www.oracle.com/technetwork/java/javase/downloads/) on your local machine.
  * Recommended version: **12.x.x**.


## Github

* Create a [Github](https://github.com) account if you do not already have one.


## IntelliJ IDEA

* Install the latest version of [IntelliJ](https://www.jetbrains.com/idea/download) on your local machine:
  * Recommended version: **Ultimate 2019.2**.
  * Apply for the [academic license](https://www.jetbrains.com/shop/eform/students) with your school email address to use the ultimate version.
* Launch IntelliJ.


## Gradle

* Create a new project.
  * Choose **Gradle** on the left pane.
  * For the project SDK, choose a java version **12.x.x**. If the version is not shown, add it by clicking `[New - JDK]` and selecting the `JAVA_HOME` directory.
  * Windows: `JAVA_HOME = C:\Program Files\Java\jdk-12.x.x`
  * Mac: `JAVA_HOME = /Library/Java/JavaVirtualMachines/jdk-12.0.2.jdk`
* Use the followings for the Gradle project setup:
  * GroupId: `edu.emory.cs`
  * ArtifactId: `cs253`
  * Version: `1.0-SNAPSHOT`
* Use the followings for the IntelliJ project setup:
  * Project name: `cs253`
  * Project location: `some_local_path/cs253`
* Once the project is created, configure the Java version in [`build.gradle`](../build.gradle) as follows:
  ```java
  sourceCompatibility = JavaVersion.VERSION_12
  targetCompatibility = JavaVersion.VERSION_12
  ```
* Click `[Preferences]`:
  * Go to `[Build, Execution, Deployment - Build Tools - Gradle]`.
  * Set `Gradle JVM` to a java version **12.x.x**.
* Click `[File - Project Structure]`:
  * Go to `[Project Settings - Modules - Dependencies]` and set `Module SDK` to a java version **12.x.x**.
  * Go to `[Platform Settings - SDKs]` and choose **12**.


## Version Control

* Click `[Preferences]`:
  * Choose `[Version Control - Github]` on the left pane.
  * Click `[+]` and login with your Github ID and password.
  * If you are using two-factor authentication, login with your [personal access token](https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/).
* Create [`.gitignore`](../.gitignore) under the `cs253` project and add the following contents:
  ```
  .gradle/
  .idea/
  build
  gradle
  ```
* Click `[VCS - Import into Version Control - Share Project on Github]`. 
* Create a Github repository:
  * Make sure to check **private**.
  * Repository name: `cs253`
  * Remote: `origin`
  * Description: `CS253: Data Structures and Algorithms`
* Add all files and make the initial commit.
* Check if the repository is created under your Github account: `https://github.com/your_id/cs253`.
* Go to `[Settings]` under your `cs253` Github repository and add the instructor and the TA as **collaborators** of this repository:
  * Jinho Choi: `jdchoi77`.
  * Han He: `hankcs`.


## Java Package

* Right click on the [`src/main/java`](../src/main/java) directory under the `cs253` project and create the package [`edu.emory.cs.utils`](../src/main/java/edu/emory/cs/utils).
* Right click on the `utils` package and create the Java class [`Utils`](../src/main/java/edu/emory/cs/utils/Utils.java).
  * Add the file to Git if prompted.
* Add the following methods to the `Utils` class:
   ```java
   static public int getMiddleIndex(int beginIndex, int endIndex) {
       return beginIndex + (endIndex - beginIndex) / 2;
   }
   	
   static public void main(String[] args) {
       System.out.println(getMiddleIndex(0, 10));
   }
   ```
* Run the program by clicking `[Run -> Run]`.
* If you see `5` on the output pane, your program is run successfully.


## Unit Test

* Right click on the [`src/test/java`](../src/test/java) directory under the `cs253` project and create the package [`edu.emory.cs.utils`](../src/test/java/edu/emory/cs/utils).
* Right click on the `utils` package and create the Java class [`UtilsTest`](../src/test/java/edu/emory/cs/utils/UtilsTest.java).
* Add the following method to the `UtilsTest` class:
   ```java
   @Test
   public void getMiddleIndexTest() {
       assertEquals(5, Utils.getMiddleIndex(0, 10));
   }
   ```
  * Make sure to include the [`@Test`](http://junit.sourceforge.net/javadoc/org/junit/Test.html) annotation. You must see `@Test` in red. Hover over and add `JUnit 5`.
  * Import the followings:
      ```
      import static org.junit.jupiter.api.Assertions.assertEquals;
      import org.junit.jupiter.api.Test;
      ```
* Run the test by clicking `[Run -> Run]`.
* If you see the test passed, your unit test is run successfully.


## Quiz

* Submit the address of your Github repository (e.g., https://github.com/your_id/cs253.git): https://canvas.emory.edu/courses/62873/assignments/253603



