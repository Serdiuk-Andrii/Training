public class Exceptions {


        //----First----

        //----Correct----
        // public static void main(String[] args) throws Throwable {}

        //----Compilation error----
        // public static void main(String[] args) throws String {}

        //----Second----

        //----Correct----
        // public class App {
        //    public static void main(String[] args) {
        //        try {
        //        } catch (Throwable t) {}
        //    }
        //}

        //----Compilation error----
        //public class App {
        //    public static void main(String[] args) {
        //        try {
        //        } catch (String s) {}
        //    }
        //}

        //----Third----



        //----Correct----
        /*public class App {
            public static void main(String[] args) {
                // Error - потомок Throwable
                throw new Error();
            }
        }
        */

        //----Compilation Error----
        /*public class App {
            public static void main(String[] args) {
                throw new String("Hello!");
            }
        }
        */

        //----Runtime Error----
        /*public class App {
            public static void main(String[] args) {
                throw null;
            }
        }*/

        //----Fourth----


        //----Correct----
        /*public class App {
            public static void main(String[] args) {
                Error ref = new Error(); // создаем экземпляр
                throw ref;               // "бросаем" его
            }
        }*/





        //----Fifth----

        //----StackOverflowException----
        /*public class App {
            public static void main(String[] args) {
                f(null);
            }
            public static void f(NullPointerException e) {
                try {
                    throw e;
                } catch (NullPointerException npe) {
                    f(npe);
                }
            }
        }*/


        //----Sixth----

        //----Two outputs are possible
        //1) >> RUNTIME ERROR: Exception in thread "main" java.lang.Error
        //2) >> sout
        // or in the other order
        // ----
        /*public class App {
            public static void main(String[] args) {
                System.out.println("sout");
                throw new Error();
            }
        }*/


        //----Seventh----
        //No return statement
        /*public class App {
            public static double sqr(double arg) {
                throw new RuntimeException();
            }
        }*/

        //----Eighth----
        //Compilation error
       /*public static int area(int width, int height) {
            if (width < 0 || height < 0) {
                // у вас плохие аргументы, извините
            } else {
                return width * height;
            }
        }*/
        //Correct solution
            public static int area(int width, int height) {
                if (width < 0 || height < 0) {
                    throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
                }
             return width * height;
        }

        //----Ninth----
        //Leaving function via exception

            public static void main(String[] args) {
                System.err.println("#1.in");
                f(); // создаем фрейм, помещаем в стек, передаем в него управление
                System.err.println("#1.out"); // ПРОПУСТИЛИ!
            }

            public static void f() {
                System.err.println(".   #2.in");
                g(); // создаем фрейм, помещаем в стек, передаем в него управление
                System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
            }

            public static void g() {
                System.err.println(".   .   #3.in");
                h(); // создаем фрейм, помещаем в стек, передаем в него управление
                System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
            }

            public static void h() {
                System.err.println(".   .   .   #4.in");
                if (true) {
                    System.err.println(".   .   .   #4.THROW");
                    throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
                }
                System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
            }


            //----Tenth----
            //----Polymorphic use of exceptions----
            /*public static void main(String[] args) {
                try {
                    System.err.print(" 0");
                    if (true) {throw new RuntimeException();}
                    System.err.print(" 1");
                } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
                    System.err.print(" 2");
                }
                System.err.println(" 3");
            }*/


            //----Eleventh----
            //Throwing an exception in catch block
            /*public class App {
                public static void main(String[] args) {
                    try {
                        System.err.print(" 0");
                        if (true) {throw new RuntimeException();}
                        System.err.print(" 1");
                    } catch (RuntimeException e) {     // перехватили RuntimeException
                        System.err.print(" 2");
                        if (true) {throw new Error();} // но бросили Error
                    }
                    System.err.println(" 3");          // пропускаем - уже летит Error
                }
            }*/

            //Additional catch statement won`t work
            /* public class App {
                public static void main(String[] args) {
                    try {
                        System.err.print(" 0");
                        if (true) {throw new RuntimeException();}
                        System.err.print(" 1");
                    } catch (RuntimeException e) {     // перехватили RuntimeException
                        System.err.print(" 2");
                        if (true) {throw new Error();} // и бросили новый Error
                    } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
                        System.err.print(" 3");
                    }
                    System.err.println(" 4");
                }
             }*/




            //----Twelfth----
            //Compiltaion error
            /*public class App {
                public static void main(String[] args) {
                    try {
                    } catch (Exception e) {
                    } catch (RuntimeException e) {
                    }
                }
            }*/

            //----Thirteen----
            //finally block
            /*public class App {
                public static void main(String[] args) {
                    try {
                        return;
                    } finally {
                        System.err.println("finally");
                    }
                }
            }*/



}



