import java.util.concurrent.CompletableFuture;

class AsynchronousProgramming {

    public static void main(String[] args) {

        // QUESTION 1: HOW DO WE CONCURRENTLY RUN INDEPENDENT FUNCTIONS THAT REQUIRE 0 CF OBJECT?

        // NOTE: FOR FUNCTION(S) BELOW, THERE IS DELAY ONLY BEFORE FIRST PRINT STATEMENT.

        /*
        CompletableFuture<Integer> cfa = CompletableFuture.<Integer>supplyAsync(() -> doSomething(10));
        CompletableFuture<Integer> cfb = CompletableFuture.<Integer>supplyAsync(() -> doSomething(10));
        CompletableFuture<Integer> cfc = CompletableFuture.<Integer>supplyAsync(() -> doSomething(10));
        cfa.join();
        cfb.join();
        cfc.join();
        */

        // NOTE: FOR FUNCTION(S) BELOW, THERE IS DELAY BEFORE EVERY PRINT STATEMENT.

        /*
        CompletableFuture<Integer> cfa = CompletableFuture.<Integer>supplyAsync(() -> doSomething(10));
        cfa.join();
        CompletableFuture<Integer> cfb = CompletableFuture.<Integer>supplyAsync(() -> doSomething(10));
        cfb.join();
        CompletableFuture<Integer> cfc = CompletableFuture.<Integer>supplyAsync(() -> doSomething(10));
        cfc.join();
        */

        /*
        Integer a = CompletableFuture.<Integer>supplyAsync(() -> doSomething(10)).join();
        Integer b = CompletableFuture.<Integer>supplyAsync(() -> doSomething(10)).join();
        Integer c = CompletableFuture.<Integer>supplyAsync(() -> doSomething(10)).join();
        */

        // QUESTION 2: HOW DO WE CONCURRENTLY RUN INDEPENDENT FUNCTIONS THAT REQUIRE 1 CF OBJECT?

        /*
         * a -> b
         * a -> c
         * a -> d
        */

        // NOTE: FOR FUNCTION(S) BELOW, THERE IS DELAY ONLY BEFORE FIRST PRINT STATEMENT.

        /*
        CompletableFuture<Integer> cfa = CompletableFuture.completedFuture(15);
        CompletableFuture<Integer> cfb = cfa.thenApplyAsync(x -> x + doSomething(10));
        CompletableFuture<Integer> cfc = cfa.thenApplyAsync(x -> x + doSomething(10));
        CompletableFuture<Integer> cfd = cfa.thenApplyAsync(x -> x + doSomething(10));
        cfb.join();
        cfc.join();
        cfd.join();
        */

        // NOTE: FOR FUNCTION(S) BELOW, THERE IS DELAY BEFORE EVERY PRINT STATEMENT.

        /*
        CompletableFuture<Integer> cfa = CompletableFuture.completedFuture(10);
        Integer b = cfa.thenApplyAsync(x -> doSomething(10)).join();
        Integer c = cfa.thenApplyAsync(x -> doSomething(10)).join();
        Integer d = cfa.thenApplyAsync(x -> doSomething(10)).join();
        */

        // QUESTION 3: HOW DO WE CONCURRENTLY RUN CHAINED FUNCTIONS THAT REQUIRE 1 CF OBJECT?

        /*
         * a -> b
         * b -> c
         * c -> d
        */

        // NOTE: FOR FUNCTION(S) BELOW, THERE IS DELAY BEFORE EVERY PRINT STATEMENT.

        /*
        CompletableFuture<Integer> cfa = CompletableFuture.completedFuture(10);
        CompletableFuture<Integer> cfb = cfa.thenApplyAsync(x -> doSomething(10));
        CompletableFuture<Integer> cfc = cfb.thenApplyAsync(x -> doSomething(10));
        CompletableFuture<Integer> cfd = cfc.thenApplyAsync(x -> doSomething(10));
        cfd.join();
        */

        // QUESTION 4: HOW DO WE CONCURRENTLY RUN INDEPENDENT FUNCTIONS THAT TAKES IN 2 CF OBJECTS?

        /*
         * a -> c 
         * b -> c
         * a -> d
         * b -> d
         * a -> e
         * b -> e
        */

        // NOTE: FOR FUNCTION(S) BELOW, THERE IS DELAY ONLY BEFORE FIRST PRINT STATEMENT.

        /* 
        CompletableFuture<Integer> cfa = CompletableFuture.completedFuture(15);
        CompletableFuture<Integer> cfb = CompletableFuture.completedFuture(15);
        CompletableFuture<Integer> cfc = cfa.thenCombineAsync(cfb, (x, y) -> doSomething(x + y));
        CompletableFuture<Integer> cfd = cfa.thenCombineAsync(cfb, (x, y) -> doSomething(x + y));
        CompletableFuture<Integer> cfe = cfa.thenCombineAsync(cfb, (x, y) -> doSomething(x + y));
        Integer c = cfc.join();
        Integer d = cfd.join();
        Integer e = cfe.join();
        */

        // NOTE: FOR FUNCTION(S) BELOW, THERE IS DELAY BEFORE EVERY PRINT STATEMENT.

        /*
        CompletableFuture<Integer> cfa = CompletableFuture.completedFuture(15);
        CompletableFuture<Integer> cfb = CompletableFuture.completedFuture(15);
        CompletableFuture<Integer> cfc = cfa.thenCombine(cfb, (x, y) -> doSomething(x + y));
        CompletableFuture<Integer> cfd = cfa.thenCombine(cfb, (x, y) -> doSomething(x + y));
        CompletableFuture<Integer> cfe = cfa.thenCombine(cfb, (x, y) -> doSomething(x + y));
        Integer c = cfc.join();
        Integer d = cfd.join();
        Integer e = cfe.join();
        */

        /*
        CompletableFuture<Integer> cfa = CompletableFuture.completedFuture(15);
        CompletableFuture<Integer> cfb = CompletableFuture.completedFuture(15);
        Integer c = cfa.thenCombineAsync(cfb, (x, y) -> doSomething(x + y)).join();
        Integer d = cfa.thenCombineAsync(cfb, (x, y) -> doSomething(x + y)).join();
        Integer e = cfa.thenCombineAsync(cfb, (x, y) -> doSomething(x + y)).join();
        */

        // QUESTION 5: WILL THERE BE CASES WHERE FUNCTIONS ARE RE-RUN UNNECESSARILY? -- NO!
       
        /*
        CompletableFuture<Integer> cfa = CompletableFuture.completedFuture(15);
        CompletableFuture<Integer> cfb = CompletableFuture.supplyAsync(() -> doSomething(5));
        CompletableFuture<Integer> cfc = cfa.thenCombineAsync(cfb, (x, y) -> doSomething(x + y));
        System.out.println(cfb);
        cfc.join();
        System.out.println(cfb);
        cfb.join();
        System.out.println(cfb);
        */

        /*
        CompletableFuture<Integer> cfa = CompletableFuture.supplyAsync(() -> doSomething(5));
        CompletableFuture<Integer> cfb = CompletableFuture.supplyAsync(() -> doSomething(10));
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> cfa.thenCombine(cfb, (x, y) -> x + y).join());
        System.out.println(cfa);
        cf.join();
        System.out.println(cfa);
        cfa.join();
        */

        // QUESTION 6: HOW DO WE "MAP" CF? -- "THENAPPLY()"!

        /* 
        CompletableFuture<Integer> cfa = CompletableFuture.completedFuture(15); // 128: [Completed normally]
        // CompletableFuture<Integer> cfa = CompletableFuture.supplyAsync(() -> 15); // 128: [Completed normally]
        CompletableFuture<Integer> cf = foo(cfa).thenApply(x -> doSomething(x + 1));
        System.out.println(cf);
        System.out.println(cf.join());
        */

        // QUESTION 7: HOW DO WE "FLATMAP" CF? -- "THENCOMPOSE()"!

        /*
        CompletableFuture<Integer> cfa = CompletableFuture.completedFuture(15);
        CompletableFuture<Integer> cf = foo(cfa).thenCompose(x -> CompletableFuture.supplyAsync(() -> doSomething(x + 1)));
        System.out.println(cf); // [Not completed]
        // CompletableFuture<Integer> cf = foo(cfa).thenCompose(x -> CompletableFuture.completedFuture(doSomething(x + 1)));
        // System.out.println(cf); // [Completed normally]
        */
    }

    static CompletableFuture<Integer> foo(CompletableFuture<Integer> x) {
        return x;
    }

    private static int doSomething(int i) {
        try {
            Thread.sleep(i * 100);
            System.out.println(i);
        } catch (InterruptedException e) {
        } finally {
            return i;
        }
    }
}